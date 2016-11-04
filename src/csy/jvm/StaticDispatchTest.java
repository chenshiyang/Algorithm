package csy.jvm;

/**
 * 
 * Description: Understanding the JVM p247
 */
public class StaticDispatchTest {
	static  class Human {
		
		public void say() {
			System.out.println("I am a human");
		}
		
	}
	
	static class Man extends Human {
		public void say() {
			System.out.println("I am a man");
		}
		
	}
	
	static class Woman extends Human {
		public void say() {
			System.out.println("I am a woman");
		}
	}
	
	public void sayHello(Human guy) {
		System.out.println("hello, guy.");
	}
	
	public void sayHello(Man man) {
		System.out.println("hello, gentleman.");
	}
	
	public void sayHello(Woman woman) {
		System.out.println("hello, lady.");
	}
	
	public static void main(String[] args) {
		Human man = new Man();
		Human woman = new Woman();
		StaticDispatchTest so = new StaticDispatchTest();
		so.sayHello(man);
		so.sayHello(woman);
		
		//result:
		//hello, guy.
		//hello, guy.
		
		man.say();
		woman.say();
		
	}
}
