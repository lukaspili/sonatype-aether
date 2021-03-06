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

/**
 * Selects a proxy for a given remote repository.
 * 
 * @author Benjamin Bentmann
 */
public interface ProxySelector
{

    /**
     * Selects a proxy for the specified remote repository.
     * 
     * @param repository The repository for which to select a proxy, must not be {@code null}.
     * @return The selected proxy or {@code null} if none.
     */
    Proxy getProxy( RemoteRepository repository );

}
