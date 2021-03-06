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

package com.ning.metrics.collector.hadoop.writer;

import com.google.inject.Binder;
import com.google.inject.Module;
import com.ning.metrics.collector.hadoop.processing.HadoopWriterFactory;
import com.ning.metrics.collector.hadoop.processing.PersistentWriterFactory;
import com.ning.metrics.serialization.hadoop.FileSystemAccess;
import org.weakref.jmx.guice.ExportBuilder;
import org.weakref.jmx.guice.MBeanModule;

/**
 * This module provides the wiring for the back-end writers to Hadoop
 */
public class HdfsModule implements Module
{
    @Override
    public void configure(final Binder binder)
    {
        final ExportBuilder builder = MBeanModule.newExporter(binder);

        binder.bind(PersistentWriterFactory.class).to(HadoopWriterFactory.class);
        builder.export(HadoopWriterFactory.class).as("com.ning.metrics.collector:name=HDFSWriter");

        // HDFS raw access
        binder.bind(FileSystemAccess.class).toProvider(FileSystemAccessProvider.class).asEagerSingleton();
    }
}
