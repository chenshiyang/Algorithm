package csy.jvm;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;

/**
 * 
 * Description: 
 */
public class MethodHandleTest {
	static class ClassA {
		public void println(String s) {
			System.out.println("Class A: " + s);
		}
	}
	
	public static void main(String[] args) throws Throwable {
		Object obj = new ClassA();
		
		getPrintlnMH(obj).invokeExact("hello, world");
		new ClassA().println("hello.");
	}
	
	private static MethodHandle getPrintlnMH(Object reveiver) throws Throwable {
		MethodType mt = MethodType.methodType(void.class, String.class);
		
		return MethodHandles.lookup().findVirtual(reveiver.getClass(), "println", mt).bindTo(reveiver);
	}
}
