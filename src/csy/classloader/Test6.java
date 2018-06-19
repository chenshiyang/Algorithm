/**
 * Description:
 * @author chenshiyang
 * @date Apr 2, 2016
 * @version version 1.0
 */
package csy.classloader;

/**
 *
 * Description:
 */
public class Test6 {
	public static void main(String[] args) {
		System.out.println(Child3.a);
		Child3.doSomething();
	}
}

class Parent3 {
	static int a = 3;

	static{
		System.out.println("Parent static block");
	}

	static void doSomething(){
		System.out.println("do something");
	}
}

class Child3 extends Parent3{
	static{
		System.out.println("Child static block");
	}
}
//运行结果
/*Parent static block
3
do something*/