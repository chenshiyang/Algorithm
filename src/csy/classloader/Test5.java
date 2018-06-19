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
public class Test5 {
	static{
		System.out.println("Test5 static block");
	}

	public static void main(String[] args) {
		Parent2 parent;
		System.out.println("---------------------------");
		parent = new Parent2();
		System.out.println(Parent2.a);
		System.out.println(Child2.b);
	}
}

class Parent2 {
	static int a = 3;

	static{
		System.out.println("Parent static block");
	}
}

class Child2{
	static int b = 4;
	static{
		System.out.println("Child static block");
	}
}


//运行结果
/*Test5 static block
---------------------------
Parent static block
3
Child static block
4*/
