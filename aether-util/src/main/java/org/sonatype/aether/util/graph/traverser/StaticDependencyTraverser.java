package org.sonatype.aether.util.graph.traverser;

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
import org.sonatype.aether.collection.DependencyTraverser;
import org.sonatype.aether.graph.Dependency;

/**
 * A dependency traverser with always or never traverses children.
 * 
 * @author Benjamin Bentmann
 */
public class StaticDependencyTraverser
    implements DependencyTraverser
{

    private final boolean traverse;

    /**
     * Creates a new traverser with the specified traversal behavior.
     * 
     * @param traverse {@code true} to traverse all dependencies, {@code false} to never traverse.
     */
    public StaticDependencyTraverser( boolean traverse )
    {
        this.traverse = traverse;
    }

    public boolean traverseDependency( Dependency dependency )
    {
        return traverse;
    }

    public DependencyTraverser deriveChildTraverser( DependencyCollectionContext context )
    {
        return this;
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

        StaticDependencyTraverser that = (StaticDependencyTraverser) obj;
        return traverse == that.traverse;
    }

    @Override
    public int hashCode()
    {
        int hash = getClass().hashCode();
        hash = hash * 31 + ( traverse ? 1 : 0 );
        return hash;
    }

}
