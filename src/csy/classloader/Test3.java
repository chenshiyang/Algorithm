/**
 * Description:
 * @author chenshiyang
 * @date Apr 2, 2016
 * @version version 1.0
 */
package csy.classloader;

/**
 *
 * Description: 测试类的接口在什么情况下会被初始化
 */
public class Test3 implements Interface1{
	public static void main(String[] args) {
		System.out.println(Interface1.x);
	}
}


interface Interface1{
	public static final int x = 5;

/*	static{

	}*/
}