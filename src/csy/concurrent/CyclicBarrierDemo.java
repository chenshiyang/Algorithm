package csy.concurrent;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * 
 * Description: A demo for CyclicBarrier.
 */
public class CyclicBarrierDemo {
	public static void main(String[] args) {
		final int N = 10;
		Thread[] students = new Thread[N];
		boolean flag = false;
		CyclicBarrier cyclic = new CyclicBarrier(N, new BarrierAction(flag));
		
		System.out.println("It's examing day.");
		for(int i = 0; i < N; i ++) {
			students[i] = new Thread(new Student(String.valueOf(i), cyclic));
			students[i].start();
		}
	}
}

/**
* 
* Description: 
*/
class Student implements Runnable {

	String name;
	final CyclicBarrier cyclic;
	
	public Student(String name, CyclicBarrier cyclic) {
		this.name = name;
		this.cyclic = cyclic;
	}
	
	@Override
	public void run() {
		try {
			System.out.println("student" + name + " enter the classroom.");
			cyclic.await();//wait for all student to enter classromm.
			doExam();
			cyclic.await();//wait for all student to finish exam.
		} catch (InterruptedException | BrokenBarrierException e) {
			e.printStackTrace();
		}
	}
	
	void doExam() {
		try {
			Thread.sleep(new Random().nextInt(100) * 10);
			System.out.println("Student " + name + " has finished the exam");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

/**
* 
* Description: Action to take when barrier finish.
*/
class BarrierAction implements Runnable {
	
	boolean flag;
	
	public BarrierAction(boolean flag) {
		this.flag = flag;
	}
	
	@Override
	public void run() {
		if(!flag) {
			System.out.println("The exam begins.");
			flag = true;
		} else {
			System.out.println("The exam ends.");
		}
	}
}