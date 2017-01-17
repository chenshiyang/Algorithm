package csy.string;

/**
 * 
 * Description: 
 */
public class StringTest1 {
	public static void main(String[] args) {
		String s1 = "Hello";
		String s2 = new String("Hello");
		String s3 = new String("Hello");
		System.out.println(s1 == s2.intern());//true
		System.out.println(s3 == s2.intern());//false
	}
}
