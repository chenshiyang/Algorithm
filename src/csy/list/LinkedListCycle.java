package csy.list;

public class LinkedListCycle {
    public boolean hasCycle(ListNode head) {
        if(null == head || null == head.next) {
            return false;
        }
        ListNode fast = head;
        ListNode slow = head;
        while(null != fast && null != fast.next && null != slow) {
            slow = slow.next;//slow每次前进一步
            fast = fast.next.next;//fast每次前进两步
            if(slow == fast) {//如果fast追上slow说明有环
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        LinkedListCycle so = new LinkedListCycle();
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(1);
        ListNode node3 = new ListNode(1);
        ListNode node4 = new ListNode(1);
        ListNode node5 = new ListNode(1);
        ListNode node6 = new ListNode(1);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node3;
        System.out.println(so.hasCycle(node1));
        node6.next = null;
        System.out.println(so.hasCycle(node1));
    }
}
