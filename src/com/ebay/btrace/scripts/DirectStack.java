/**
 * 
 */
package com.ebay.btrace.scripts;

import static com.sun.btrace.BTraceUtils.print;
import static com.sun.btrace.BTraceUtils.println;

import com.sun.btrace.BTraceUtils;
import com.sun.btrace.BTraceUtils.Strings;
import com.sun.btrace.annotations.BTrace;
import com.sun.btrace.annotations.OnMethod;
import com.sun.btrace.annotations.ProbeClassName;
import com.sun.btrace.annotations.ProbeMethodName;

/**
 * @author liasu
 *
 */
@BTrace
public class DirectStack {

	@OnMethod(clazz = "/java\\.nio\\.ByteBuffer/", method = "/allocateDirect/")
	public static void m(@ProbeClassName String probeClass, @ProbeMethodName String probeMethod) {
		print(Strings.strcat("entered ", probeClass));
		println(Strings.strcat(".", probeMethod));
		BTraceUtils.jstack();
		println();
	}

}
