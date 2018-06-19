/**
 * Description:
 * @author chenshiyang
 * @date Mar 18, 2016
 * @version version 1.0
 */
package csy.multithread;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 * Description:
 */
public class ProducerAndConsumerTest {

	public void test() {
		new Thread(new Runnable() {
			public void run() {
				while (true) {
					synchronized (Stock.stock) {
						if (Stock.count >= Stock.CAPACITY) {
							System.out.println("Stock is full.");
						}
						else{
							Random rand = new Random();
							int num = rand.nextInt(5);
							for(int i = 0; i < num && Stock.count < Stock.CAPACITY; i ++){
								Stock.stock.add(new Integer(1));
								Stock.count++;
								System.out.println("Procude one item. Now have "
										+ Stock.count + " items.");
							}
						}
						try {
							Thread.sleep(2000);
						} catch (InterruptedException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						Stock.stock.notify();
						try {
							Stock.stock.wait();
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
				}
			}
		}).start();

		new Thread(new Runnable() {

			@Override
			public void run() {
				while (true) {
					synchronized (Stock.stock) {
						if (Stock.count <= 0) {
							System.out.println("Stock is empty");
						}
						else {
							Stock.stock.remove(Stock.stock.size() - 1);
							Stock.count--;
							System.out.println("Consume one item. Now have "
									+ Stock.count + " items.");
						}
						try {
							Thread.sleep(2000);
						} catch (InterruptedException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						Stock.stock.notify();
						try {
							Stock.stock.wait();
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
				}
			}

		}).start();
	}


	public static void main(String[] args){
		ProducerAndConsumerTest so = new ProducerAndConsumerTest();
		so.test();
	}
}

class Stock{
	static List<Integer> stock = new ArrayList<Integer>();
	static final int CAPACITY = 10;
	static int count = 0;

}
