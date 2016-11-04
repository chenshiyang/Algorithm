package csy.jvm;

import java.io.Serializable;

/**
 * 
 * Description: Comment some methods to see how the output changes.
 */
public class OverloadTest {
//	public static void sayHello(Object arg) {
//		System.out.println("hello Object");
//	}
	
//	public static void sayHello(int arg) {
//		System.out.println("hello int");
//	}
	
//	public static void sayHello(Integer arg) {
//		System.out.println("hello Integer");
//	}
	
//	public static void sayHello(long arg) {
//		System.out.println("hello long");
//	}
	
	public static void sayHello(Character arg) {
		System.out.println("hello Character");
	}
	
	public static void sayHello(short arg) {
		System.out.println("hello short");
	}
	
//	public static void sayHello(char arg) {
//		System.out.println("hello char");
//	}
	
//	public static void sayHello(char... arg) {
//		System.out.println("hello char...");
//	}
	
//	public static void sayHello(Serializable arg) {
//		System.out.println("hello Serializable");
//	}
	
//	public static void sayHello(Comparable<Character> arg) {
//		System.out.println("hello Comparable");
//	}
	
	public static void main(String[] args) {
		sayHello('a');
	}
}
