/**
* Description: 
* @author chenshiyang
* @date Mar 22, 2016
* @version version 1.0
*/
package csy.jvm;

/**
 * 
 * Description: volatile�޷���֤�߳�ͬ�����ӽ�����Կ����Ͳ�����1000.
 */
public class VolatileTest {
	public static int count = 0;
	
	public  static void inc(){
		try{
			Thread.sleep(1);
		}
		catch(InterruptedException e){
			e.printStackTrace();
		}
		count ++;
	}
	
	public static void main(String[] args) {
		for(int i = 0; i < 1000; i ++){
			new Thread(new Runnable(){
	
				@Override
				public void run() {
					VolatileTest.inc();
				}
				
			}).start();
		}
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(VolatileTest.count);
	}
}
