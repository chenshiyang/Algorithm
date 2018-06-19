/**
 * Description:
 * @author chenshiyang
 * @date Apr 2, 2016
 * @version version 1.0
 */
package csy.classloader;

/**
 *
 * Description: 子类静态变量的调用会导致子类被初始化，子类的初始化又导致父类先于子类被初始化。 Test4是启动类，因此会最先被加载。
 */
public class Test4 {

	static{
		System.out.println("Test static block.");
	}

	public static void main(String[] args) {
		System.out.println(Child.b);
	}
}

class Parent{
	public static int a = 3;

	static{
		System.out.println("Parent static block.");
	}
}

class Child extends Parent{
	public static int b = 4;
	static{
		System.out.println("Child static block.");
	}
	//输出结果
/*	 Test static block.
	 Parent static block.
	 Child static block.
	 4*/
}