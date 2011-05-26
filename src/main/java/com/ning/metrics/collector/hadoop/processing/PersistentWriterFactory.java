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

package com.ning.metrics.collector.hadoop.processing;

import com.ning.metrics.serialization.event.EventSerializer;
import com.ning.metrics.serialization.writer.EventWriter;

public interface PersistentWriterFactory
{
    /**
     * Create an EventWriter specific to events sharing the same serialization format
     * and ending in the same directory in HDFS.
     * In practice, this means that all events of a certain type and serialization type share the same writer, i.e.
     * all ClickEvent Thrift events during an hour will use the same writer.
     *
     * @param stats stats object to count flushes
     * @param serializer serializer to use
     * @param localPath local destination path (only really relevant for serialization library...)
     * @param hdfsPath destination path (only really relevant for hadoop...)
     * @return eventWriter specific to an event type and serialization type
     */
    EventWriter createPersistentWriter(final WriterStats stats, final EventSerializer serializer, final String localPath, final String hdfsPath);
}
