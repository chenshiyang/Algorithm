package csy.jvm;

/**
 * 
 * Description: 
 */
public class IllegalForwardReference {
	static {
		i = 0;//compile pass.
//		System.out.println(i);//Cannot reference a field before it is defined
	}
	static int i = 1;
	
	public static void main(String[] args) {
		
	}
}
