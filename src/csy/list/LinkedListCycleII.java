package csy.list;

/**
 * 给定一个链表, 如果链表存在环,找出环的入口节点.否则返回null
 */
public class LinkedListCycleII {
    public ListNode detectCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        if(null == head || null == head.next) {
            return null;
        }
        while(null != slow && null != fast && null != fast.next) {
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast) {//存在环
                System.out.println("相遇点为" + slow.val);
                //寻找入口
                ListNode entrance = findEntrance(head, slow);
                System.out.println("环的入口为" + entrance.val);
                //计算环的长度
                int circle = measureCircle(slow, fast);
                System.out.println("环的周长为" + circle);
                return entrance;
            }
        }
        //没有环
        return null;
    }

    /**
     * 两个slow,一个从起点出发,一个从之前与fast的相遇点出发,这两个相遇点即为环的入口
     *
     * @param head
     * @param pos
     * @return
     */
    private ListNode findEntrance(ListNode head, ListNode pos) {
        while(head != pos) {
            head = head.next;
            pos = pos.next;
        }
        return head;//返回相遇时的节点,即为环的入口
    }

    /**
     * 计算环的周长
     * 从相同地点出发,当fast再次追上slow时,slow走过的即为环的周长
     *
     * @param slow
     * @param fast
     * @return
     */
    private int measureCircle(ListNode slow, ListNode fast) {
        int c = 0;
        //使用do while是为了让两个指针先各走一回合,防止while循环条件未走就满足
        do {
            slow = slow.next;
            fast = fast.next.next;
            c++;
        } while (slow != fast);
        return c;
    }

    public static void main(String[] args) {
        LinkedListCycleII so = new LinkedListCycleII();
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(6);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node3;
        System.out.println(so.detectCycle(node1));
        node6.next = null;
        System.out.println(so.detectCycle(node1));
    }
}
