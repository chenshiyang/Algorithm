package csy.jvm;

/**
 * 
 * Description: 
 * An instance of passive reference to class.
 * Use an array definition to reference superclass, will not trigger its initialization.
 */
public class TestClassLoading2 {
	public static void main(String[] args) {
		SuperClass[] sca = new SuperClass[10];
	}
}