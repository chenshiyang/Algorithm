package csy.jvm;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 
 * Description: 
 */
public class AtomicTest {
	public static AtomicInteger race = new AtomicInteger(0);
	
	public static void increase() {
		race.incrementAndGet();
	}
	
	private static final int THREADS_COUNT = 20;
	
	public static void main(String[] args) throws InterruptedException {
		Thread[] threads = new Thread[THREADS_COUNT];
		for(int i = 0; i < THREADS_COUNT; ++ i) {
			threads[i] = new Thread(new Runnable() {

				@Override
				public void run() {
					for(int i = 0; i < 10000; ++ i) {
						increase();
					}
				}
				
			});
			threads[i].start();
		}
		
		while(Thread.activeCount() > 1) {
			Thread.yield();
		}
		System.out.println(race);
	}
}
