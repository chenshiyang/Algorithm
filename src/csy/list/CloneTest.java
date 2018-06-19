/**
* Description: 
* @author chenshiyang
* @date Mar 20, 2016
* @version version 1.0
*/
package csy.list;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * Description: 
 */
public class CloneTest {
	
	public static void cloneTest(){
		//测试一 ， 当ArrayList中的元素类型是基本类型时， 当原list改变后， 复制后的list会不会改变。
		ArrayList<Integer> list1 = new ArrayList<>();
		list1.add(1);
		list1.add(2);
		list1.add(3);
		
		ArrayList<Integer> list1copy = (ArrayList<Integer>) list1.clone();
		list1.set(0, -1);
		
		for(int i = 0; i < list1.size(); i ++){
			System.out.print(list1.get(i) + "\t");
		}
		System.out.println();
		
		for(int i = 0; i < list1copy.size(); i ++){
			System.out.print(list1copy.get(i) + "\t");
		}
		System.out.println();
		//结论，当ArrayList中的元素类型是基本类型时， 当原list改变后， 复制后的list不会改变。
		
		//测试二， 当ArrayList中的元素是类对象时，当原list改变后， 复制后的list会不会改变。
		ArrayList<Item> list2 = new ArrayList<>();
		Item item1 = new Item(1);
		Item item2 = new Item(2);
		Item item3 = new Item(3);
		list2.add(item1);
		list2.add(item2);
		list2.add(item3);
		
		ArrayList<Item> list2copy = (ArrayList<Item>)list2.clone();
		list2.get(0).val = -1;
		
		for(int i = 0; i < list2.size(); i ++){
			System.out.print(list2.get(i) + "\t");
		}
		System.out.println();
		
		for(int i = 0; i < list2copy.size(); i ++){
			System.out.print(list2copy.get(i) + "\t");
		}
		System.out.println();
		//结论，当ArrayList中的元素类型是对象类型时， 当原list改变后， 复制后的list会改变。
		//总结， ArrayList的clone() 实行的是浅拷贝，新复制的list内部自己维护了一个数组，但是数组
		//内部的元素是和原数组一样的。这就要牵涉到Java使用的是值引用。如果数组里元素类型是基本类型或者是不可变类型(如String)，
		//则在原list中改变了元素，并不会影响到新list中的元素。
		//如果元素类型是对象类型，由于Java的值引用，list在clone时，把原list中每个元素的引用都复制过来放在新list的内部数组中，
		//但是实际上这两组引用指向的实际对象都是同一个，因此，这是浅拷贝。
		
	}
	
	public static void main(String[] args) {
		CloneTest.cloneTest();
	}
}

class Item{
	int val;
	
	public Item(int val){
		this.val = val;
	}
	
	public String toString(){
		return this.val + "";
	}
}
