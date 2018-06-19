package csy.queue;

import csy.stack.MinStack;

/**
 * 使用两个最小栈实现一个最小队列
 *
 * @author csy
 *
 */
public class MinQueue<T extends Comparable> {
    MinStack<T> tail = new MinStack<T>();
    MinStack<T> head = new MinStack<T>();

    /**
     * 判断队列是否为空
     *
     * @return
     */
    public boolean isEmpty() {
        return tail.isEmpty() && head.isEmpty();
    }

    /**
     * 向队列尾添加也给元素
     *
     * @param e
     * @return
     */
    public boolean offer(T e) {
        return tail.push(e);
    }

    /**
     * 从队列头取出一个元素
     *
     * @return
     * @throws Exception
     */
    public T poll() throws Exception {
        adjust();
        try {
            return head.pop();
        } catch (Exception e) {
            throw new Exception("Queue is currently empty");
        }
    }

    /**
     * 获取队列中的最小元素
     *
     * @return
     */
    public T getMin() {
        T tmin = tail.getMin();
        T hmin = head.getMin();
        if(tmin == null || (hmin != null) && tmin.compareTo(hmin) > 0) {
            return hmin;
        } else {
            return tmin;
        }
    }

    /**
     * 调整队列
     * 将tail栈中的元素弹出放入head栈中
     *
     */
    private void adjust() throws Exception {
        if(head.isEmpty()) {
            while(!tail.isEmpty()) {
                head.push(tail.pop());
            }
        }
    }

    public static void main(String[] args) {
        MinQueue<Integer> minQueue = new MinQueue<>();
        System.out.println("初始队列为空?" + minQueue.isEmpty());
        minQueue.offer(2);
        minQueue.offer(5);
        System.out.println("当前队列最小元素为" + minQueue.getMin());
        minQueue.offer(3);
        minQueue.offer(1);
        System.out.println("当前队列最小元素为" + minQueue.getMin());
    }
}


