package leetcode.list;

/**
 * 采用归并排序对链表排序
 */
public class SortList {
    public ListNode sortList(ListNode head) {
        return mergeSort(head);
    }

    private ListNode mergeSort(ListNode head) {
        if(null == head || head.next == null) {
            return head;
        }
        ListNode mid = getMidNode(head);
        ListNode rightHead = mid.next;
        mid.next = null;
        head = mergeSort(head);
        rightHead = mergeSort(rightHead);

        return merge(head, rightHead);

    }

    private ListNode merge(ListNode head, ListNode rightHead) {
        ListNode resultHead = new ListNode(0);
        ListNode node = resultHead;
        while(head != null || rightHead != null) {
            if(head == null) {
                node.next = rightHead;
                break;
            } else if(rightHead == null) {
                node.next = head;
                break;
            } else {
                if(head.val < rightHead.val) {
                    node.next = head;
                    node = node.next;
                    head = head.next;
                } else {
                    node.next = rightHead;
                    node = node.next;
                    rightHead = rightHead.next;
                }
            }
        }
        return resultHead.next;
    }

    private ListNode getMidNode(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while(null != fast) {
            fast = fast.next;
            if(null == fast || null == fast.next) {
                break;
            }
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }

    public void printList(ListNode node) {
        while(null != node) {
            System.out.print(node.val + "=>");
            node = node.next;
        }
    }

    public static void main(String[] args) {
        SortList so = new SortList();
        ListNode node1 = new ListNode(4);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(1);
        ListNode node4 = new ListNode(3);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        ListNode newHead = so.sortList(node1);
        so.printList(newHead);
    }
}
