/**
 * Description:
 * @author chenshiyang
 * @date Apr 3, 2016
 * @version version 1.0
 */
package csy.polymorphism;

/**
 *
 * Description:
 */
public class A {
	public String show(D obj){
		return "A and D";
	}

	public String show(A obj){
		return "A and A";
	}

	public static void main(String[] args) {
		A a1 = new A();
		A a2 = new B();
		B b = new B();
		C c = new C();
		D d = new D();

		System.out.println(a1.show(b));//A and A
		System.out.println(a1.show(c));//A and A
		System.out.println(a1.show(d));//A and D
		System.out.println(a2.show(b));//B and A *
		System.out.println(a2.show(c));//B and A *
		System.out.println(a2.show(d));//A and D *
		System.out.println(b.show(b));//B and B
		System.out.println(b.show(c));//B and B
		System.out.println(b.show(d));//A and D *
	}
}

/*1.实例对象为A，参数为对象B，B为A的子类。执行A.class中show(A obj)
2.同上
3.实例对象为A，参数为对象D，执行A.class中show(D obj)
4.实例对象依然为A，参数为B，本应执行A.class中show(A obj)，但是，B.class重写了show(A obj),所以执行B.class show(A obj)
5.同上
6.执行A.class show(D obj) B中并没有重写。
7，8.实例对象为B，参数为B或者B的子类，执行show(B obj)
9.实例对象为B，参数为D，因为B继承自A，也可以执行A中的show(D obj)

上面第4条有误。
A a2 = new B();
栈中的引用变量是A，堆中的实例变量是B。
将子类的实例，赋值给父类的引用。就是向上转型。
向上转型，在运行时，会遗忘子类对象中与父类对象中不同的方法。也会覆盖与父类中相同的方法--重写。（方法名，参数都相同）
所以a2,可以调用的方法就是，A中有的，但是B中没有的方法，和B中的重写A的方法。


其实我也困惑了很久，给几条tip
1 首先重写和重载的定义要非常清楚
重写是子类重写父类的方法，要求方法签名相同，也就是方法名字和参数列表相同。B重写了A的 public String show(A obj){
return ("B and A");
}
然后B中重载了该方法 public String show(B obj){
return ("B and B");
}
2 对于向上造型
能够点出来什么看类型，但如果子类重写了父类的方法，那么不论是子类引用还是父类引用都将是调用子类重写后的方法
3 继承
当B继承A之后，实际上B中有3个方法
public String show(B obj){
return ("B and B");
}
public String show(A obj){
return ("B and A");
}
public String show(D obj){
return ("A and D");
}
*
*/

class B extends A{
	public String show(B obj){
		return "B and B";
	}

	public String show(A obj){
		return "B and A";
	}
}

class C extends B{

}

class D extends B{

}