package org.sonatype.aether.util.repository;

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

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * @author Benjamin Bentmann
 */
public class DefaultProxySelectorTest
{

    private boolean isNonProxyHosts( String host, String nonProxyHosts )
    {
        return DefaultProxySelector.isNonProxyHosts( host, nonProxyHosts );
    }

    @Test
    public void testIsNonProxyHosts()
    {
        assertFalse( isNonProxyHosts( "www.sonatype.org", null ) );
        assertFalse( isNonProxyHosts( "www.sonatype.org", "" ) );

        assertTrue( isNonProxyHosts( "www.sonatype.org", "*" ) );
        assertTrue( isNonProxyHosts( "www.sonatype.org", "*.org" ) );
        assertTrue( isNonProxyHosts( "www.sonatype.org", "www.*" ) );
        assertTrue( isNonProxyHosts( "www.sonatype.org", "www.*.org" ) );

        assertFalse( isNonProxyHosts( "www.sonatype.org", "www.sonatype.com" ) );
        assertFalse( isNonProxyHosts( "www.sonatype.org", "*.com" ) );
        assertFalse( isNonProxyHosts( "www.sonatype.org", "sonatype.org" ) );

        assertTrue( isNonProxyHosts( "www.sonatype.org", "*.com|*.org" ) );
    }

}
