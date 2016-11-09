package csy.jvm;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 
 * Description: -Xms100m -Xmx100m -XX:+UseSerialGC
 */
public class MemoryMonitoringTest {
	static class OOMObject {
		public byte[] placeholder = new byte[64 * 1024];
	}
	
	public static void fillHeap(int num) throws InterruptedException {
		List<OOMObject> list = new ArrayList<>();
		for(int i = 0; i < num; ++ i) {
			Thread.sleep(50);
			list.add(new OOMObject());
		}
		System.gc();
	}
	
	public static void main(String[] args) throws InterruptedException {
		Scanner reader = new Scanner(System.in);
		String s = reader.nextLine();
		fillHeap(1000);
		reader.next();
	}
}
