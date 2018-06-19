/**
 * Description:
 * @author chenshiyang
 * @date Apr 2, 2016
 * @version version 1.0
 */
package csy.classloader;

/**
 *
 * Description: 调用ClassLoader的loadClass方法加载一个类，并不是对类的主动使用，不会导致类的初始化。
 */
public class Test7 {
	public static void main(String[] args) throws Exception{
		//获得系统类加载器
		ClassLoader loader = ClassLoader.getSystemClassLoader();

		Class<?> clazz = loader.loadClass("test.classloader.CL");

		System.out.println("-------------------");
		clazz = Class.forName("test.classloader.CL");//反射
	}
}

class CL{
	static{
		System.out.println("Class CL");
	}
}
//运行结果
/*-------------------
Class CL*/