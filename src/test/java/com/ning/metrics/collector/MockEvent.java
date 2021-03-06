/*
 * Copyright 2010-2011 Ning, Inc.
 *
 * Ning licenses this file to you under the Apache License, version 2.0
 * (the "License"); you may not use this file except in compliance with the
 * License.  You may obtain a copy of the License at:
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.  See the
 * License for the specific language governing permissions and limitations
 * under the License.
 */

package com.ning.metrics.collector;

import com.ning.metrics.serialization.event.StubEvent;
import com.ning.metrics.serialization.thrift.hadoop.TBooleanWritable;

public class MockEvent extends StubEvent
{
    private String outputPath = "/var/tmp/mock-event";

    @Override
    public String getOutputDir(final String prefix)
    {
        return outputPath;
    }

    public void setOutputPath(final String s)
    {
        outputPath = s;
    }

    /**
     * The basic StubEvent returns a String - which the Hadoop writer won't understand.
     *
     * @return stupid payload
     */
    @Override
    public Object getData()
    {
        return new TBooleanWritable(true);
    }
}