package org.sonatype.aether.impl;

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

import org.sonatype.aether.RepositorySystem;
import org.sonatype.aether.RepositorySystemSession;
import org.sonatype.aether.installation.InstallRequest;
import org.sonatype.aether.installation.InstallResult;
import org.sonatype.aether.installation.InstallationException;

/**
 * @author Benjamin Bentmann
 */
public interface Installer
{

    /**
     * Installs a collection of artifacts and their accompanying metadata to the local repository.
     * 
     * @param session The repository session, must not be {@code null}.
     * @param request The installation request, must not be {@code null}.
     * @return The installation result, never {@code null}.
     * @throws InstallationException If any artifact/metadata from the request could not be installed.
     * @see RepositorySystem#install(RepositorySystemSession, InstallRequest)
     */
    InstallResult install( RepositorySystemSession session, InstallRequest request )
        throws InstallationException;

}
