/**
* Description: 
* @author chenshiyang
* @date Apr 3, 2016
* @version version 1.0
*/
package csy.queue;

import java.util.Stack;

/**
 *
 * Description: 用栈实现 min deque. 这个想法有点错误：
 * 在于 从头部放入3 5 4 6.
 * 然后要pollLast。 这时候应该是把leftStack的都倒入rightStack.
 * 问题就出在leftStack.stack2 倒入rightStack.stack2时，存储最小值的栈中最小元素不再是在栈顶。
 */

public class MinDeque<T extends Comparable> {
	MinStack<T> leftStack = new MinStack();
	MinStack<T> rightStack = new MinStack();
	
	public boolean addFirst(T e){
		if(e == null){
			return false;
		}
		
		leftStack.push(e);
		return true;
	}
	
	public boolean addLast(T e){
		if(e == null){
			return false;
		}
		rightStack.push(e);
		return true;
	}
	
	public T pollFirst(){
		adjustToLeft();
		return leftStack.pop();
	}
	
	public T pollLast(){
		adjustToRight();
		return rightStack.pop();
	}
	
	private void adjustToLeft(){
		if(leftStack.isEmpty()){
			while(!rightStack.isEmpty()){
				leftStack.push(rightStack.pop());
			}
		}
	}
	
	private void adjustToRight(){
		if(rightStack.isEmpty()){
			while(!leftStack.isEmpty()){
				rightStack.push(leftStack.pop());
			}
		}
	}
	
	public T getMin(){
		T lmin = leftStack.getMin();
		T rmin = rightStack.getMin();
		return lmin == null || (rmin != null && lmin.compareTo(rmin) > 0)? rmin : lmin;
	}
	
	public boolean isEmpty(){
		return leftStack.isEmpty() && rightStack.isEmpty();
	}
	
	public static void main(String[] args) {
		//test min stack.
		MinStack<Integer> minStack = new MinStack<Integer>();
		minStack.push(3);
		minStack.push(5);
		minStack.push(4);
		minStack.push(4);
		minStack.push(2);
		System.out.println(minStack.peek());
		System.out.println(minStack.getMin());
		minStack.pop();
		System.out.println(minStack.peek());
		System.out.println(minStack.getMin());
		
		System.out.println("===============================");
		
		//test min deque.
		MinDeque<Integer> minDeque = new MinDeque<Integer>();
		minDeque.addFirst(4);
		minDeque.addFirst(5);
		minDeque.addFirst(3);
		minDeque.addFirst(2);
		System.out.println(minDeque.getMin());
		minDeque.pollFirst();
		System.out.println(minDeque.getMin());
		System.out.println(minDeque.pollLast());
		
	}
}

class MinStack<T extends Comparable>{
	Stack<T> stack1 = new Stack<T>();
	Stack<T> stack2 = new Stack<T>();
	
	public boolean push(T e){
		if(e == null){
			return false;
		}
		if(stack2.isEmpty() || e.compareTo(stack2.peek()) <= 0){
			stack2.push(e);
		}
		stack1.push(e);
		return true;
	}
	
	public T pop(){
		if(stack1.isEmpty()){
			return null;
		}
		T e = stack1.pop();
		if(e == stack2.peek()){
			stack2.pop();
		}
		return e;
	}
	
	public T getMin(){
		return stack2.isEmpty()? null : stack2.peek();
	}
	
	public T peek(){
		return stack1.isEmpty()? null : stack1.peek();
	}
	
	public boolean isEmpty(){
		return stack1.isEmpty();
	}
	
	public String toString(){
		return stack1.toString() + "||" + stack2.toString();
	}
}