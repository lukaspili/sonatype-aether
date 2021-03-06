package org.sonatype.aether.util.graph.manager;

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

import org.sonatype.aether.collection.DependencyCollectionContext;
import org.sonatype.aether.collection.DependencyManagement;
import org.sonatype.aether.collection.DependencyManager;
import org.sonatype.aether.graph.Dependency;

/**
 * A dependency manager that does not do any dependency management.
 * 
 * @author Benjamin Bentmann
 */
public class NoopDependencyManager
    implements DependencyManager
{

    public static final DependencyManager INSTANCE = new NoopDependencyManager();

    public DependencyManager deriveChildManager( DependencyCollectionContext context )
    {
        return this;
    }

    public DependencyManagement manageDependency( Dependency dependency )
    {
        return null;
    }

    @Override
    public boolean equals( Object obj )
    {
        if ( this == obj )
        {
            return true;
        }
        else if ( null == obj || !getClass().equals( obj.getClass() ) )
        {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode()
    {
        return getClass().hashCode();
    }

}
