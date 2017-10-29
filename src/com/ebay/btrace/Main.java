/**
 * 
 */
package com.ebay.btrace;

import java.lang.management.BufferPoolMXBean;
import java.lang.management.ManagementFactory;
import java.nio.ByteBuffer;
import java.util.List;

/**
 * @author liasu
 *
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		// Test JMX Bean & btrace calls

		System.out.println("wait for 1minutes to start");
		Thread.sleep(60 * 100);

		List<BufferPoolMXBean> bufferMxBeans = ManagementFactory.getPlatformMXBeans(BufferPoolMXBean.class);
		int i = -1;
		int MAX_LENGTH = 100;
		ByteBuffer[] b = new ByteBuffer[MAX_LENGTH];
		while (i++ < MAX_LENGTH) {
			b[i] = ByteBuffer.allocateDirect(1024 * 1024);// 1 kilobyte
			Thread.sleep(1000);
			printMxBean(bufferMxBeans);
		}

		Thread.sleep(5000);
	}

	private static void printMxBean(List<BufferPoolMXBean> bufferMxBeans) {
		for (final BufferPoolMXBean bufferMxBean : bufferMxBeans) {
			StringBuilder sb = new StringBuilder(bufferMxBean.getName().toUpperCase()).append(":");
			sb.append(" Count: ").append(bufferMxBean.getCount());
			sb.append(" MemoryUsed: ").append(bufferMxBean.getMemoryUsed());
			sb.append(" TotalCapacity: ").append(bufferMxBean.getTotalCapacity());
			sb.append("\n");
			System.out.println(sb);
		}
	}

}
