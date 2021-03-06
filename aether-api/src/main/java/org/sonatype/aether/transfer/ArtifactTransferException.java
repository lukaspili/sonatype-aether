package org.sonatype.aether.transfer;

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

import org.sonatype.aether.RepositoryException;
import org.sonatype.aether.artifact.Artifact;
import org.sonatype.aether.repository.RemoteRepository;

/**
 * @author Benjamin Bentmann
 */
public class ArtifactTransferException
    extends RepositoryException
{

    private final Artifact artifact;

    private final RemoteRepository repository;

    static String getString( String prefix, RemoteRepository repository )
    {
        if ( repository == null )
        {
            return "";
        }
        else
        {
            return prefix + repository.getId() + " (" + repository.getUrl() + ")";
        }
    }

    public ArtifactTransferException( Artifact artifact, RemoteRepository repository, String message )
    {
        super( message );

        this.artifact = artifact;
        this.repository = repository;
    }

    public ArtifactTransferException( Artifact artifact, RemoteRepository repository, Throwable cause )
    {
        super( "Could not transfer artifact " + artifact + getString( " from/to ", repository )
            + getMessage( ": ", cause ), cause );

        this.artifact = artifact;
        this.repository = repository;
    }

    public ArtifactTransferException( Artifact artifact, RemoteRepository repository, String message, Throwable cause )
    {
        super( message, cause );

        this.artifact = artifact;
        this.repository = repository;
    }

    public Artifact getArtifact()
    {
        return artifact;
    }

    public RemoteRepository getRepository()
    {
        return repository;
    }

}
