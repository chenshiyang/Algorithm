/**
 * Description:
 * @author chenshiyang
 * @date Apr 4, 2016
 * @version version 1.0
 */
package csy.polymorphism;

/**
 *
 * Description:
 */
public class OverrideTest {
	public static void main(String[] args) {
		Base base = new Sub();
//		base.doSomething();//无法执行
		((Sub)base).doSomething();
		Sub sub = new Sub();
		sub.doSomething();
	}
}

class Base{
	public void show(){
		System.out.println("Base method.");
	}
}

class Sub extends Base{
	public void show(){
		System.out.println("Sub method");
	}

	public void doSomething(){
		System.out.println("Sub do something");
	}
}