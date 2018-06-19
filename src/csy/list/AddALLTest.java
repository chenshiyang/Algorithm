/**
* Description: 
* @author chenshiyang
* @date Mar 21, 2016
* @version version 1.0
*/
package csy.list;

import java.util.ArrayList;

/**
 * 
 * Description: 
 */
public class AddALLTest {
	/**
	* Description:测试把自己作为参数，调用addAll（）方法会有什么后果。
	*/
	public static void addAllTest(){
		ArrayList<Integer> list1 = new ArrayList<>();
		list1.add(1);
		list1.add(2);
		list1.add(3);
		boolean res = list1.addAll(list1);
		System.out.println(res);
		for(int i = 0; i < list1.size(); i ++){
			System.out.println(list1.get(i));
		}
	}
	
	public static void main(String[] args) {
		AddALLTest.addAllTest();
	}
}
