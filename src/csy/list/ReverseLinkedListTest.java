/**
 * Description:
 * @author chenshiyang
 * @date Mar 26, 2016
 * @version version 1.0
 */
package csy.list;

/**
 *
 * Description: 反转一个链表，这道题在Leetcode OJ里也有...
 */
public class ReverseLinkedListTest {
    public Node reverseList(Node head){
        if(null == head || null == head.next){
            return head;
        }

        Node last = null;
        Node current = head;
        while(current != null){
            Node temp = current.next;
            current.next = last;
            last = current;
            current = temp;
        }

        return last;
    }

    public void display(Node node){
        while(node != null){
            System.out.print(node.val + "->");
            node = node.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        ReverseLinkedListTest so = new ReverseLinkedListTest();
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;

        so.display(so.reverseList(n1));
    }
}
