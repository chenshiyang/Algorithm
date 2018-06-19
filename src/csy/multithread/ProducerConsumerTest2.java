/**
 * Description:
 * @author chenshiyang
 * @date Mar 23, 2016
 * @version version 1.0
 */
package csy.multithread;

import java.util.ArrayList;

/**
 *
 * Description:
 */
public class ProducerConsumerTest2 {
	public static void main(String[] args) {
		Stock2 stock = new Stock2();
		Thread producer = new Thread(new Runnable(){

			@Override
			public void run() {
				if(stock.put()){
					System.out.println("Producer produces an item."
							+ "Now has " + stock.size() + " items");
				}
				else{
					System.out.println("stock is full");
				}
			}

		});
		producer.start();

		Thread comsumer = new Thread(new Runnable(){

			@Override
			public void run() {
				if(stock.get() != -1){
					System.out.println("Comsumer consumes an item."
							+ "Now has " + stock.size() + " items");
				}
				else{
					System.out.println("stock is empty");
				}
			}

		});
		comsumer.start();
	}
}

class Stock2{
	private ArrayList<Integer> stock = new ArrayList<>();
	private final int capacity = 10;

	public boolean isFull(){
		return stock.size() == capacity;
	}

	public boolean isEmpty(){
		return stock.size() == 0;
	}

	public int size(){
		return stock.size();
	}

	public synchronized boolean put(){
		if(isFull()){
			return false;
		}
		else{
			stock.add(1);
			return true;
		}
	}

	public synchronized int get(){
		if(isEmpty()){
			return -1;
		}
		else{
			return stock.remove(stock.size() - 1);
		}
	}
}