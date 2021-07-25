/**
 * Copyright (c) 2021, Salesforce.com, Inc. All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without modification, are permitted provided that the
 * following conditions are met:
 *
 * 1. Redistributions of source code must retain the above copyright notice, this list of conditions and the following
 * disclaimer.
 *
 * 2. Redistributions in binary form must reproduce the above copyright notice, this list of conditions and the
 * following disclaimer in the documentation and/or other materials provided with the distribution.
 *
 * 3. Neither the name of Salesforce.com nor the names of its contributors may be used to endorse or promote products
 * derived from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES,
 * INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL,
 * SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
 * SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY,
 * WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package com.salesforce.bazel.sdk.project.structure;

import java.util.ArrayList;
import java.util.List;

import com.salesforce.bazel.sdk.model.BazelLabel;

/**
 * Value object that holds the layout of source directories in a Bazel project.
 * <p>
 * TODO merge this with BazelProject?
 */
public class ProjectStructure {

    /**
     * The relative file system path, starting at the root of the workspace, to the directories containing the source
     * files. For languages like Java that use directories to organize files by Java package (com.salesforce.foo), the
     * path will be to the base of the package (the directory that contains the "com" directory).
     * <p>
     * Example: projects/libs/apple/apple-api/src/main/java
     */
    public final List<String> packageSourceCodeFSPaths = new ArrayList<>();

    /**
     * The list of Bazel targets enabled for this project.
     * <p>
     * Example: //projects/foo:foo, //projects/foo:foo_tests
     */
    public final List<BazelLabel> bazelTargets = new ArrayList<>();


    public List<String> getPackageSourceCodeFSPaths() {
        return packageSourceCodeFSPaths;
    }

    @Deprecated // this should be coming from somewhere else
    public List<BazelLabel> getBazelTargets() {
        return bazelTargets;
    }

}