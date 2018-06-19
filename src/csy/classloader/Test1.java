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
public class Test1 {
	public static void main(String[] args) {
		System.out.println(FinalTest.x);
	}
}

class FinalTest{
	public static final int x = 6 / 3;//x的值在编译时即可确定，x是个编译时常量，对编译时常量的使用不会导致类被初始化。

	static{
		System.out.println("FinalTest static code block.");
	}

}