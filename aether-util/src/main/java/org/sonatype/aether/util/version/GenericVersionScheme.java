package org.sonatype.aether.util.version;

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

import org.sonatype.aether.version.InvalidVersionSpecificationException;
import org.sonatype.aether.version.Version;
import org.sonatype.aether.version.VersionConstraint;
import org.sonatype.aether.version.VersionRange;
import org.sonatype.aether.version.VersionScheme;

/**
 * A version scheme using a generic version syntax.
 * 
 * @author Benjamin Bentmann
 * @author Alin Dreghiciu
 */
public class GenericVersionScheme
    implements VersionScheme
{

    public Version parseVersion( final String version )
        throws InvalidVersionSpecificationException
    {
        return new GenericVersion( version );
    }

    public VersionRange parseVersionRange( final String range )
        throws InvalidVersionSpecificationException
    {
        return new GenericVersionRange( range );
    }

    public VersionConstraint parseVersionConstraint( final String constraint )
        throws InvalidVersionSpecificationException
    {
        GenericVersionConstraint result = new GenericVersionConstraint();

        String process = constraint;

        while ( process.startsWith( "[" ) || process.startsWith( "(" ) )
        {
            int index1 = process.indexOf( ")" );
            int index2 = process.indexOf( "]" );

            int index = index2;
            if ( index2 < 0 || ( index1 >= 0 && index1 < index2 ) )
            {
                index = index1;
            }

            if ( index < 0 )
            {
                throw new InvalidVersionSpecificationException( constraint, "Unbounded version range " + constraint );
            }

            VersionRange range = parseVersionRange( process.substring( 0, index + 1 ) );
            result.addRange( range );

            process = process.substring( index + 1 ).trim();

            if ( process.length() > 0 && process.startsWith( "," ) )
            {
                process = process.substring( 1 ).trim();
            }
        }

        if ( process.length() > 0 && !result.getRanges().isEmpty() )
        {
            throw new InvalidVersionSpecificationException( constraint, "Invalid version range " + constraint
                + ", expected [ or ( but got " + process );
        }

        if ( result.getRanges().isEmpty() )
        {
            result.setVersion( parseVersion( constraint ) );
        }

        return result;
    }

    @Override
    public boolean equals( final Object obj )
    {
        if ( this == obj )
        {
            return true;
        }

        return obj != null && getClass().equals( obj.getClass() );
    }

    @Override
    public int hashCode()
    {
        return getClass().hashCode();
    }

}
