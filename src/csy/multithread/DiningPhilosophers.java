/**
 * Description:
 * @author chenshiyang
 * @date Mar 24, 2016
 * @version version 1.0
 */
package csy.multithread;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 *
 * Description: 哲学家就餐问题，测试产生死锁。
 */
public class DiningPhilosophers{
	public static void main(String[] args) throws Exception{
		int ponder = 1;//thinking factor.
		int size = 3;//number fo chopsitcks or philosopher.

		Chopstick[] chopsticks = new Chopstick[size];
		for(int i = 0; i < size; i ++){
			chopsticks[i] = new Chopstick();
		}

		ExecutorService exec = Executors.newCachedThreadPool();
		for(int i = 0; i < size; i ++){
			exec.execute(new Philosopher(chopsticks[i], chopsticks[(i + 1) % size], i, ponder));
		}

		System.out.println("Press 'Enter' to quit");
		System.in.read();
		exec.shutdownNow();
	}
}

class Philosopher implements Runnable{
	private Chopstick left;
	private Chopstick right;
	private final int id;
	private final int ponderFactor;
	private Random rand = new Random(47);

	private void pause() throws InterruptedException{
		if(0 == ponderFactor){
			return;
		}
		Thread.sleep(rand.nextInt(ponderFactor * 250));
	}

	public Philosopher(Chopstick left, Chopstick right, int id, int ponderFactor){
		this.left = left;
		this.right = right;
		this.id = id;
		this.ponderFactor = ponderFactor;
	}

	/* (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {
		try{
			// TODO Auto-generated method stub
			while(!Thread.interrupted()){
				System.out.println(this + " is thinking");
				pause();
				System.out.println(this + " grabs left");
				left.take();
				System.out.println(this + " grabs right");
				right.take();
				System.out.println(this + " is dining");
				pause();
				System.out.println(this + " drop chopsticks");
				left.drop();
				right.drop();
			}
		}
		catch(InterruptedException e){
			System.out.println(this + " exit via interrupt");
		}
	}

	public String toString(){
		return "Philosopher" + id;
	}
}

class Chopstick{
	private boolean taken = false;
	public synchronized void take() throws InterruptedException{
		while(taken){
			wait();
		}
		taken = true;
	}

	public synchronized void drop(){
		taken = false;
		notifyAll();
	}
}