package com.salesforce.bazel.eclipse.command.mock.type;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import com.salesforce.bazel.eclipse.command.mock.MockCommand;
import com.salesforce.bazel.eclipse.command.mock.MockCommandSimulatedOutput;
import com.salesforce.bazel.eclipse.command.mock.MockCommandSimulatedOutputMatcher;
import com.salesforce.bazel.eclipse.test.TestBazelWorkspaceFactory;

/**
 * Simulates a "bazel build //a/b/c" command
 */
public class MockBuildCommand extends MockCommand {

    public MockBuildCommand(List<String> commandTokens, Map<String, String> testOptions, TestBazelWorkspaceFactory testWorkspaceFactory) {
        super(commandTokens);
        
        if (commandTokens.size() < 3) {
            // this is just 'bazel build' without a target, which is not valid, blow up here as there is something wrong in the calling code
            throw new IllegalArgumentException("The plugin issued the command 'bazel build' without a third arg. This is not a valid bazel command.");
        }

        List<MockCommandSimulatedOutput> simulatedOutputLines = new ArrayList<>();
        
        // stdout is used to print diagnostics, and stderr is a line per path to an aspect json file
        outputLines = Arrays.asList(new String[] { "INFO: Analyzed 19 targets (0 packages loaded, 1 target configured).", "INFO: Found 19 targets...",
                "INFO: Elapsed time: 0.146s, Critical Path: 0.00s", "INFO: Build completed successfully, 1 total action" });
        
        /**
         * When the aspect build is run, the output lists the paths to all of the aspect files written
         * to disk. To simulate the aspect command output, the MockBuildCommand needs to know the list of aspect file paths
         * that are in the workspace. 
         * <p>
         * We need to use a Set of paths because the same aspect (ex. slf4j-api) will be used by multiple
         * mock bazel packages, so we need to make sure we only list each once
         */
        // add Aspect build lines
        if (commandTokens.get(2).contains("local_eclipse_aspect")) {
            // build command looks like: bazel build --override_repository=local_eclipse_aspect=/tmp/bef/bazelws/bazel-workspace/tools/aspect ...
            MockCommandSimulatedOutputMatcher aspectCommandMatcher1 = new MockCommandSimulatedOutputMatcher(1, "build");
            MockCommandSimulatedOutputMatcher aspectCommandMatcher2 = new MockCommandSimulatedOutputMatcher(2, ".*local_eclipse_aspect.*");
            
            for (String packagePath : testWorkspaceFactory.workspaceDescriptor.aspectFileSets.keySet()) {
                // the last arg is the package path with the wildcard target (//projects/libs/javalib0:*)
                String wildcardTarget = "//"+packagePath+":.*"; // TODO this is returning the same set of aspects for each target in a package
                MockCommandSimulatedOutputMatcher aspectCommandMatcher3 = new MockCommandSimulatedOutputMatcher(7, wildcardTarget);
    
                List<MockCommandSimulatedOutputMatcher> matchers = new ArrayList<>();
                Collections.addAll(matchers, aspectCommandMatcher1, aspectCommandMatcher2, aspectCommandMatcher3);
        
                List<String> aspectFilePathsList = new ArrayList<>();
                aspectFilePathsList.addAll(testWorkspaceFactory.workspaceDescriptor.aspectFileSets.get(packagePath));
                String nameForLog = "Aspect file set for target: "+wildcardTarget;
                MockCommandSimulatedOutput aspectOutput = new MockCommandSimulatedOutput(nameForLog, outputLines, aspectFilePathsList, matchers);
                simulatedOutputLines.add(aspectOutput);
            }
            // TODO this aspect code here is indirect, it should just populate out/err lines directly
            // TODO clean up "Problem adding jar to project" errors seen when running tests from Eclipse, seems to be during aspect phase
        } 
        
        // TODO derive build output from test workspace structure
        // TODO allow testOptions to determine that a package build should fail
        // TODO fail if passed package is not in test workspace
        for (MockCommandSimulatedOutput candidateOutput: simulatedOutputLines) {
            if (candidateOutput.doesMatch(commandTokens)) {
                // the output is targeted to this command
                outputLines = candidateOutput.outputLines;
                errorLines = candidateOutput.errorLines;
                break;
            }
        }
    }
    
}
