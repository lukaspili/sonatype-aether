package org.sonatype.aether.test.util.impl;

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

import org.sonatype.aether.version.Version;

/**
 * Version ordering by {@link String#compareToIgnoreCase(String)}.
 * 
 * @author Benjamin Hanzelmann
 */
public final class StubVersion
    implements Version
{

    private String version;

    public StubVersion( String version )
    {
        super();
        this.version = version == null ? "" : version;
    }

    public int compareTo( Version o )
    {
        return version.compareTo( o.toString());
    }

    @Override
    public int hashCode()
    {
        final int prime = 31;
        int result = 1;
        result = prime * result + ( ( version == null ) ? 0 : version.hashCode() );
        return result;
    }

    @Override
    public boolean equals( Object obj )
    {
        if ( this == obj )
            return true;
        if ( obj == null )
            return false;
        if ( getClass() != obj.getClass() )
            return false;
        StubVersion other = (StubVersion) obj;
        if ( version == null )
        {
            if ( other.version != null )
                return false;
        }
        else if ( !version.equals( other.version ) )
            return false;
        return true;
    }

    @Override
    public String toString()
    {
        return version;
    }

}
