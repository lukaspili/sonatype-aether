package org.sonatype.aether;

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
 * A container for data that is specific to a repository system session. Both components within the repository system
 * and clients of the system may use this storage to associate arbitrary data with a session. Unlike a cache, this
 * session data is not subject to purging. For this same reason, session data should also not be abused as a cache (i.e.
 * for storing values that can be re-calculated) to avoid memory exhaustion. <strong>Note:</strong> Actual implementations
 * must be thread-safe.
 * 
 * @author Benjamin Bentmann
 * @see RepositorySystemSession#getData()
 */
public interface SessionData
{

    /**
     * Associates the specified session data with the given key.
     * 
     * @param key The key under which to store the session data, must not be {@code null}.
     * @param value The data to associate with the key, may be {@code null} to remove the mapping.
     */
    void set( Object key, Object value );

    /**
     * Gets the session data associated with the specified key.
     * 
     * @param key The key for which to retrieve the session data, must not be {@code null}.
     * @return The session date associated with the key or {@code null} if none.
     */
    Object get( Object key );

}
