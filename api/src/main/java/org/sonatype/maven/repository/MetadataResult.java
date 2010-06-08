package org.sonatype.maven.repository;

/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

/**
 * @author Benjamin Bentmann
 */
public class MetadataResult
{

    private final MetadataRequest request;

    private Exception exception;

    private boolean updated;

    public MetadataResult( MetadataRequest request )
    {
        if ( request == null )
        {
            throw new IllegalArgumentException( "metadata request has not been specified" );
        }
        this.request = request;
    }

    public MetadataRequest getRequest()
    {
        return request;
    }

    public MetadataResult setException( Exception exception )
    {
        this.exception = exception;
        return this;
    }

    public Exception getException()
    {
        return exception;
    }

    public MetadataResult setUpdated( boolean updated )
    {
        this.updated = updated;
        return this;
    }

    public boolean isUpdated()
    {
        return updated;
    }

}