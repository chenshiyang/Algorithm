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
public class Test2 {
	public static void main(String[] args) {
		System.out.println(FinalTest2.x);
	}
}

class FinalTest2{
	//	public static final int x = new Random().nextInt(100);//x不再是个编译时常量，x的值要运行时才能最终确定。
	public static final int x = 6 / 3;
	static{
		System.out.println("FinalTest static code block.");
	}
}