package org.sonatype.aether.repository;

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

import java.util.Collection;
import java.util.Collections;

import org.sonatype.aether.RepositorySystemSession;
import org.sonatype.aether.artifact.Artifact;

/**
 * A request to register an artifact within the local repository. Certain local repository implementations can refuse to
 * serve physically present artifacts if those haven't been previously registered to them.
 * 
 * @author Benjamin Bentmann
 * @see LocalRepositoryManager#add(RepositorySystemSession, LocalArtifactRegistration)
 */
public class LocalArtifactRegistration
{

    private Artifact artifact;

    private RemoteRepository repository;

    private Collection<String> contexts = Collections.emptyList();

    /**
     * Creates an uninitialized registration.
     */
    public LocalArtifactRegistration()
    {
        // enables default constructor
    }

    /**
     * Creates a registration request for the specified (locally built) artifact.
     * 
     * @param artifact The artifact to register, may be {@code null}.
     */
    public LocalArtifactRegistration( Artifact artifact )
    {
        setArtifact( artifact );
    }

    /**
     * Creates a registration request for the specified (remotely resolved) artifact.
     * 
     * @param artifact The artifact to register, may be {@code null}.
     * @param repository The remote repository from which the artifact was resolved or {@code null} if the artifact was
     *            locally built.
     * @param contexts The resolution contexts, may be {@code null}.
     */
    public LocalArtifactRegistration( Artifact artifact, RemoteRepository repository, Collection<String> contexts )
    {
        setArtifact( artifact );
        setRepository( repository );
        setContexts( contexts );
    }

    /**
     * Gets the artifact to register.
     * 
     * @return The artifact or {@code null} if not set.
     */
    public Artifact getArtifact()
    {
        return artifact;
    }

    /**
     * Sets the artifact to register.
     * 
     * @param artifact The artifact, may be {@code null}.
     * @return This request for chaining, never {@code null}.
     */
    public LocalArtifactRegistration setArtifact( Artifact artifact )
    {
        this.artifact = artifact;
        return this;
    }

    /**
     * Gets the remote repository from which the artifact was resolved.
     * 
     * @return The remote repositories or {@code null} if the artifact was locally built.
     */
    public RemoteRepository getRepository()
    {
        return repository;
    }

    /**
     * Sets the remote repository from which the artifact was resolved.
     * 
     * @param repository The remote repository or {@code null} if the artifact was locally built.
     * @return This request for chaining, never {@code null}.
     */
    public LocalArtifactRegistration setRepository( RemoteRepository repository )
    {
        this.repository = repository;
        return this;
    }

    /**
     * Gets the resolution contexts in which the artifact is available.
     * 
     * @return The resolution contexts in which the artifact is available, never {@code null}.
     */
    public Collection<String> getContexts()
    {
        return contexts;
    }

    /**
     * Sets the resolution contexts in which the artifact is available.
     * 
     * @param contexts The resolution contexts, may be {@code null}.
     * @return This request for chaining, never {@code null}.
     */
    public LocalArtifactRegistration setContexts( Collection<String> contexts )
    {
        if ( contexts != null )
        {
            this.contexts = contexts;
        }
        else
        {
            this.contexts = Collections.emptyList();
        }
        return this;
    }

}
