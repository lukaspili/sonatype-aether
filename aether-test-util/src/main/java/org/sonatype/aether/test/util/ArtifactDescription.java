package org.sonatype.aether.test.util;

/*******************************************************************************
 * Copyright (c) 2010-2011 Sonatype, Inc.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Apache License v2.0 which accompanies this distribution.
 * The Eclipse Public License is available at
 *   http://www.eclipse.org/legal/epl-v10.html
 * The Apache License v2.0 is available at
 *   http://www.apache.org/licenses/LICENSE-2.0.html
 * You may elect to redistribute this code under either of these licenses.
 *******************************************************************************/

import java.util.List;

import org.sonatype.aether.artifact.Artifact;
import org.sonatype.aether.graph.Dependency;
import org.sonatype.aether.repository.RemoteRepository;

/**
 * @author Benjamin Hanzelmann
 *
 */
public class ArtifactDescription
{

    private List<RemoteRepository> repositories;

    private List<Dependency> managedDependencies;

    private List<Dependency> dependencies;

    private List<Artifact> relocations;

    ArtifactDescription( List<Artifact> relocations, List<Dependency> dependencies,
                                List<Dependency> managedDependencies, List<RemoteRepository> repositories )
    {
        this.relocations = relocations;
        this.dependencies = dependencies;
        this.managedDependencies = managedDependencies;
        this.repositories = repositories;
    }

    public List<Artifact> getRelocations()
    {
        return relocations;
    }

    public List<RemoteRepository> getRepositories()
    {
        return repositories;
    }

    public List<Dependency> getManagedDependencies()
    {
        return managedDependencies;
    }

    public List<Dependency> getDependencies()
    {
        return dependencies;
    }

}
