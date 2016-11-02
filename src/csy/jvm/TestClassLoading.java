package csy.jvm;

/**
 * 
 * Description: a instance of passive reference
 * 
 * use subclass to reference superclass's static field, only trigger the initialization
 * of superclass, not the subclass.
 */
public class TestClassLoading {
	
	static {
		System.out.println("TestClassLoading init");
	}
	
	public static void main(String[] args) {
		System.out.println(SubClass.val);
	}
}


class SuperClass {
	static {
		System.out.println("Super Class init");
	}
	public static int val = 5;
}

class SubClass extends SuperClass {
	static {
		System.out.println("Sub Class init");
	}
}