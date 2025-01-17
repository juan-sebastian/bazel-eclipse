/**
 * Copyright (c) 2019, Salesforce.com, Inc. All rights reserved.
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
package com.salesforce.bazel.eclipse.mock;

import java.io.InputStream;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.eclipse.core.internal.resources.ProjectDescription;
import org.eclipse.core.resources.IBuildConfiguration;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFilterMatcherDescriptor;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IPathVariableManager;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.resources.IProjectNatureDescriptor;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceChangeListener;
import org.eclipse.core.resources.IResourceRuleFactory;
import org.eclipse.core.resources.ISaveParticipant;
import org.eclipse.core.resources.ISavedState;
import org.eclipse.core.resources.ISynchronizer;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.IWorkspaceDescription;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.IWorkspaceRunnable;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.ICoreRunnable;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Plugin;
import org.eclipse.core.runtime.jobs.ISchedulingRule;

@SuppressWarnings("restriction")
public class MockIWorkspace implements IWorkspace {
    private static final String UOE_MSG =
            "MockIWorkspace is pay as you go, you have hit a method that is not implemented.";

    private final MockResourceHelper resourceHelper;
    private final List<IResourceChangeListener> changeListeners = new ArrayList<>();

    public MockIWorkspace(MockResourceHelper resourceHelper) {
        this.resourceHelper = resourceHelper;
    }

    // IMPLEMENTED METHODS

    @Override
    public IWorkspaceRoot getRoot() {
        return resourceHelper.getEclipseWorkspaceRoot();
    }

    @Override
    public IProjectDescription newProjectDescription(String projectName) {
        ProjectDescription desc = new ProjectDescription();
        desc.setComment("");
        desc.setName(projectName);
        return desc;
    }

    @Override
    public void addResourceChangeListener(IResourceChangeListener listener) {
        changeListeners.add(listener);
    }

    @Override
    public void addResourceChangeListener(IResourceChangeListener listener, int eventMask) {
        changeListeners.add(listener);
    }

    // UNIMPLEMENTED METHODS
    // Please move implemented methods, in alphabetical order, above this line if you implement a method.

    @Override
    public <T> T getAdapter(Class<T> adapter) {
        throw new UnsupportedOperationException(UOE_MSG);
    }

    @Override
    public ISavedState addSaveParticipant(Plugin plugin, ISaveParticipant participant) throws CoreException {
        throw new UnsupportedOperationException(UOE_MSG);
    }

    @Override
    public ISavedState addSaveParticipant(String pluginId, ISaveParticipant participant) throws CoreException {
        throw new UnsupportedOperationException(UOE_MSG);
    }

    @Override
    public void build(int kind, IProgressMonitor monitor) throws CoreException {
        throw new UnsupportedOperationException(UOE_MSG);
    }

    @Override
    public void build(IBuildConfiguration[] buildConfigs, int kind, boolean buildReferences, IProgressMonitor monitor)
            throws CoreException {
        throw new UnsupportedOperationException(UOE_MSG);
    }

    @Override
    public void checkpoint(boolean build) {
        throw new UnsupportedOperationException(UOE_MSG);
    }

    @Override
    public IProject[][] computePrerequisiteOrder(IProject[] projects) {
        throw new UnsupportedOperationException(UOE_MSG);
    }

    @Override
    public ProjectOrder computeProjectOrder(IProject[] projects) {
        throw new UnsupportedOperationException(UOE_MSG);
    }

    @Override
    public IStatus copy(IResource[] resources, IPath destination, boolean force, IProgressMonitor monitor)
            throws CoreException {
        throw new UnsupportedOperationException(UOE_MSG);
    }

    @Override
    public IStatus copy(IResource[] resources, IPath destination, int updateFlags, IProgressMonitor monitor)
            throws CoreException {
        throw new UnsupportedOperationException(UOE_MSG);
    }

    @Override
    public IStatus delete(IResource[] resources, boolean force, IProgressMonitor monitor) throws CoreException {
        throw new UnsupportedOperationException(UOE_MSG);
    }

    @Override
    public IStatus delete(IResource[] resources, int updateFlags, IProgressMonitor monitor) throws CoreException {
        throw new UnsupportedOperationException(UOE_MSG);
    }

    @Override
    public void deleteMarkers(IMarker[] markers) throws CoreException {
        throw new UnsupportedOperationException(UOE_MSG);
    }

    @Override
    public void forgetSavedTree(String pluginId) {
        throw new UnsupportedOperationException(UOE_MSG);
    }

    @Override
    public IFilterMatcherDescriptor[] getFilterMatcherDescriptors() {
        throw new UnsupportedOperationException(UOE_MSG);
    }

    @Override
    public IFilterMatcherDescriptor getFilterMatcherDescriptor(String filterMatcherId) {
        throw new UnsupportedOperationException(UOE_MSG);
    }

    @Override
    public IProjectNatureDescriptor[] getNatureDescriptors() {
        throw new UnsupportedOperationException(UOE_MSG);
    }

    @Override
    public IProjectNatureDescriptor getNatureDescriptor(String natureId) {
        throw new UnsupportedOperationException(UOE_MSG);
    }

    @Override
    public Map<IProject, IProject[]> getDanglingReferences() {
        throw new UnsupportedOperationException(UOE_MSG);
    }

    @Override
    public IWorkspaceDescription getDescription() {
        throw new UnsupportedOperationException(UOE_MSG);
    }

    @Override
    public IResourceRuleFactory getRuleFactory() {
        throw new UnsupportedOperationException(UOE_MSG);
    }

    @Override
    public ISynchronizer getSynchronizer() {
        throw new UnsupportedOperationException(UOE_MSG);
    }

    @Override
    public boolean isAutoBuilding() {
        throw new UnsupportedOperationException(UOE_MSG);
    }

    @Override
    public boolean isTreeLocked() {
        throw new UnsupportedOperationException(UOE_MSG);
    }

    @Override
    public IProjectDescription loadProjectDescription(IPath projectDescriptionFile) throws CoreException {
        throw new UnsupportedOperationException(UOE_MSG);
    }

    @Override
    public IProjectDescription loadProjectDescription(InputStream projectDescriptionFile) throws CoreException {
        throw new UnsupportedOperationException(UOE_MSG);
    }

    @Override
    public IStatus move(IResource[] resources, IPath destination, boolean force, IProgressMonitor monitor)
            throws CoreException {
        throw new UnsupportedOperationException(UOE_MSG);
    }

    @Override
    public IStatus move(IResource[] resources, IPath destination, int updateFlags, IProgressMonitor monitor)
            throws CoreException {
        throw new UnsupportedOperationException(UOE_MSG);
    }

    @Override
    public IBuildConfiguration newBuildConfig(String projectName, String configName) {
        throw new UnsupportedOperationException(UOE_MSG);
    }

    @Override
    public void removeResourceChangeListener(IResourceChangeListener listener) {
        throw new UnsupportedOperationException(UOE_MSG);
    }

    @Override
    public void removeSaveParticipant(Plugin plugin) {
        throw new UnsupportedOperationException(UOE_MSG);
    }

    @Override
    public void removeSaveParticipant(String pluginId) {
        throw new UnsupportedOperationException(UOE_MSG);
    }

    @Override
    public void run(ICoreRunnable action, ISchedulingRule rule, int flags, IProgressMonitor monitor)
            throws CoreException {
        throw new UnsupportedOperationException(UOE_MSG);
    }

    @Override
    public void run(ICoreRunnable action, IProgressMonitor monitor) throws CoreException {
        throw new UnsupportedOperationException(UOE_MSG);
    }

    @Override
    public void run(IWorkspaceRunnable action, ISchedulingRule rule, int flags, IProgressMonitor monitor)
            throws CoreException {
        throw new UnsupportedOperationException(UOE_MSG);
    }

    @Override
    public void run(IWorkspaceRunnable action, IProgressMonitor monitor) throws CoreException {
        throw new UnsupportedOperationException(UOE_MSG);
    }

    @Override
    public IStatus save(boolean full, IProgressMonitor monitor) throws CoreException {
        throw new UnsupportedOperationException(UOE_MSG);
    }

    @Override
    public void setDescription(IWorkspaceDescription description) throws CoreException {
        throw new UnsupportedOperationException(UOE_MSG);
    }

    @Override
    public String[] sortNatureSet(String[] natureIds) {
        throw new UnsupportedOperationException(UOE_MSG);
    }

    @Override
    public IStatus validateEdit(IFile[] files, Object context) {
        throw new UnsupportedOperationException(UOE_MSG);
    }

    @Override
    public IStatus validateFiltered(IResource resource) {
        throw new UnsupportedOperationException(UOE_MSG);
    }

    @Override
    public IStatus validateLinkLocation(IResource resource, IPath location) {
        throw new UnsupportedOperationException(UOE_MSG);
    }

    @Override
    public IStatus validateLinkLocationURI(IResource resource, URI location) {
        throw new UnsupportedOperationException(UOE_MSG);
    }

    @Override
    public IStatus validateName(String segment, int typeMask) {
        throw new UnsupportedOperationException(UOE_MSG);
    }

    @Override
    public IStatus validateNatureSet(String[] natureIds) {
        throw new UnsupportedOperationException(UOE_MSG);
    }

    @Override
    public IStatus validatePath(String path, int typeMask) {
        throw new UnsupportedOperationException(UOE_MSG);
    }

    @Override
    public IStatus validateProjectLocation(IProject project, IPath location) {
        throw new UnsupportedOperationException(UOE_MSG);
    }

    @Override
    public IStatus validateProjectLocationURI(IProject project, URI location) {
        throw new UnsupportedOperationException(UOE_MSG);
    }

    @Override
    public IPathVariableManager getPathVariableManager() {
        throw new UnsupportedOperationException(UOE_MSG);
    }

}
