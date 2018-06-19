/**
 * Description:
 * @author chenshiyang
 * @date Mar 24, 2016
 * @version version 1.0
 */
package csy.multithread;

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 *
 * Description:
 */
public class ProducerConsumerTest4 {
	public static void main(String[] args){
		ExecutorService exec = Executors.newCachedThreadPool();
		Bag bag = new Bag();

		Producer2 p1 = new Producer2(bag);
		Consumer2 c1 = new Consumer2(bag);
		exec.execute(c1);
		exec.execute(p1);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		exec.shutdownNow();
	}
}

class Producer2 implements Runnable{
	public Bag bag;

	public Producer2(Bag bag){
		this.bag = bag;
	}

	/* (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try{
			while(!Thread.interrupted()){
				synchronized(bag){
					while(bag.isFull()){
						System.out.println("Bag is full.");
						bag.wait();
					}
					Random rand = new Random();
					int i = rand.nextInt();
					bag.add(i);
					System.out.println("P1 Produces : " + i + " , now has "
							+ bag.count() + " items.");
					Thread.sleep(500);
					bag.notifyAll();
				}
			}
		}
		catch(InterruptedException e){
			System.out.println("P1 interrupted.");
		}
	}

}

class Consumer2 implements Runnable{
	public Bag bag;

	public Consumer2(Bag bag){
		this.bag = bag;
	}

	/* (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try{
			while(!Thread.interrupted()){
				synchronized(bag){
					while(bag.isEmpty()){
						System.out.println("Bag is empty.");
						bag.wait();
					}
					int i = bag.remove();
					System.out.println("C1 consumes : " + i +
							" , now has " + bag.count() + " items.");
					Thread.sleep(500);
					bag.notifyAll();
				}
			}
		}
		catch(InterruptedException e){
			System.out.println("C1 interrupted.");
		}
	}

}

class Bag{
	private ArrayList<Integer> bag = new ArrayList<>();
	private final int CAPACITY = 8;

	public boolean isFull(){
		return bag.size() == CAPACITY;
	}

	public boolean isEmpty(){
		return bag.size() == 0;
	}

	public int count(){
		return bag.size();
	}

	public boolean add(Integer i){
		bag.add(i);
		return true;
	}

	public int remove(){
		return bag.remove(0);
	}
}