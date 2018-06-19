package csy.stack;

import java.util.Stack;

/**
 * 使用两个栈 实现一个最小栈
 *
 * @param <T>
 */
public class MinStack<T extends Comparable> {
    Stack<T> mainStack = new Stack<>();
    Stack<T> minStack = new Stack<>();

    /**
     * 判断最小栈是否为空
     *
     * @return
     */
    public boolean isEmpty() {
        return mainStack.isEmpty() && minStack.isEmpty();
    }

    /**
     * 获得栈中的最小元素，不会将元素弹出栈
     *
     * @return
     */
    public T getMin() {
        if(minStack.isEmpty()) {
            return null;
        }
        return minStack.peek();
    }

    /**
     * 向最小栈中压入一个元素
     *
     * @param e
     * @return
     */
    public boolean push(T e) {
        if(e == null) {
            return false;
        }
        mainStack.push(e);
        if(minStack.isEmpty() || e.compareTo(minStack.peek()) <= 0) {
            minStack.push(e);
        }
        return true;
    }

    /**
     * 从最小栈中弹出一个元素
     *
     * @return
     */
    public T pop() throws Exception {
        if(mainStack.isEmpty()) {
            throw new Exception("Stack is currently empty.");
        }
        T e = mainStack.pop();
        if(e.compareTo(minStack.peek()) == 0) {
            minStack.pop();
        }
        return e;
    }

    public static void main(String[] args) throws Exception {
        MinStack<Integer> minStack = new MinStack<>();
        minStack.push(2);
        minStack.push(1);
        System.out.println(minStack.getMin());
        minStack.pop();
        minStack.push(4);
        System.out.println(minStack.getMin());
    }
}
