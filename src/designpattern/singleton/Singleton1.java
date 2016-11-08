/**
* Description: 
* @author chenshiyang
* @date Mar 25, 2016
* @version version 1.0
*/
package designpattern.singleton;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * 
 * Description: 使用static field实现单例模式,实现线程安全，clone安全，序列化安全，反射安全。
 */
public class Singleton1 implements Serializable, Cloneable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private volatile static Singleton1 instance;//volatile prevent instruction reorder
	
	private Singleton1() throws Exception{//not allow to create instance using reflection.
		if(instance != null){
			throw new Exception("Can not initiate another instance.");
		}
	}
	
	@Override
	protected Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		throw new CloneNotSupportedException("Can not clone this class");
	}

	public static Singleton1 getInstance() throws Exception{
		if(null == instance){
			synchronized(Singleton1.class){//make sure the creation of instance is synchronized
				if(null == instance){
					instance = new Singleton1();
				}
			}
		}
		return instance;
	}
	
	public Object readResolve(){//not allowed to create new instance using serialization.
		return this.instance;
	}
	
	public static void main(String[] args) throws Exception{
		Singleton1.getInstance();
		
		//Using reflection
//		Class cls = Class.forName("designpattern.singleton.Singleton1");
//		cls.newInstance();//throw "Can not initiate another instance"
		
		//Using clone.
//		Singleton1 ano = (Singleton1)Singleton1.getInstance().clone();// Can not clone this class.
		
		//Using serialization
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("test2.obj"));
		oos.writeObject(Singleton1.getInstance());
		oos.close();
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream("test2.obj"));
		System.out.println(ois.readObject() == Singleton1.getInstance());//should be equal.
		ois.close();
	}
}
