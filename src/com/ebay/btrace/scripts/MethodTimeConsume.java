/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.ebay.btrace.scripts;

import static com.sun.btrace.BTraceUtils.println;

import com.sun.btrace.BTraceUtils.Strings;
import com.sun.btrace.annotations.BTrace;
import com.sun.btrace.annotations.Duration;
import com.sun.btrace.annotations.OnMethod;
import com.sun.btrace.annotations.ProbeClassName;
import com.sun.btrace.annotations.ProbeMethodName;

/**
 * @since Feb 6, 2018
 *
 */
@BTrace
public class MethodTimeConsume {

    @OnMethod(clazz = "/io\\.sherlock\\.capabilities\\.es\\.client\\.ESWriteClientPool/", method = "/submitTask/")
    public static void m(@ProbeClassName String probeClass, @ProbeMethodName String probeMethod, @Duration long time) {
        println(Strings.strcat("ESWriteClientPool.submitTask costtime : ", probeClass));
    }

}
