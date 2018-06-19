/**
 * Description:
 * @author chenshiyang
 * @date Mar 24, 2016
 * @version version 1.0
 */
package csy.multithread;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

/**
 *
 * Description:
 */
public class ProducerConsumerTest3 {
	public static void main(String[] args) {
		Queue<Integer> stock = new LinkedList<Integer>();
		int maxSize = 1;
		Thread producer = new Producer(stock, maxSize, "P1");
		Thread consumer = new Consumer(stock, maxSize, "C1");

		producer.start();
		consumer.start();
	}
}

class Producer extends Thread{
	private Queue<Integer> stock;
	private int maxSize;

	public Producer(Queue<Integer> stock, int maxSize, String name){
		super(name);
		this.stock = stock;
		this.maxSize = maxSize;
	}

	@Override
	public void run() {
		while(true){
			synchronized(stock){
				while(stock.size() == maxSize){//Notice: Here we use while(condition)  rather than if(condition)
					try {
						System.out.println("Stock is full,"
								+ "Producer " + this.getName() + " is waiting for"
								+ "consumer to take some thing from stock.");
						stock.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}

				Random rand = new Random();
				int i = rand.nextInt();
				System.out.println("Producer " + this.getName() + " produces : " + i);
				stock.add(i);
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				stock.notifyAll();
			}
		}
	}
}

class Consumer extends Thread{
	private Queue<Integer> stock;
	private int maxSize;

	public Consumer(Queue<Integer> stock, int maxSize, String name){
		super(name);
		this.stock = stock;
		this.maxSize = maxSize;
	}

	@Override
	public void run() {
		while(true){
			synchronized(stock){
				while(stock.isEmpty()){
					try{
						System.out.println("Stock is empty."
								+ "Consumer " + this.getName() + " is waiting for"
								+ "producer to produce");
						stock.wait();
					}
					catch(InterruptedException e){
						e.printStackTrace();
					}
				}

				System.out.println("Consumer " + this.getName() + " comsumes : " + stock.remove());
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				stock.notifyAll();
			}
		}
	}
}