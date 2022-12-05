package Medium;

import Util.ListNode;

public class Problem24 {
    public ListNode swapPairs(ListNode head) {
        ListNode current = head, previous = null, temp;

        while (current != null && current.next != null) {
            if (previous != null) {
                previous.next = current.next;
            } else {
                head = current.next;
            }
            temp = current.next;
            current.next = temp.next;
            temp.next = current;
            previous = current;
            current = current.next;
        }

        return head;
    }

    public static void main(String[] args) {
        Problem24 problem24 = new Problem24();
//        Util.ListNode tail = new Util.ListNode(4);
//        Util.ListNode three = new Util.ListNode(3, tail);
//        Util.ListNode two = new Util.ListNode(2, three);
//        Util.ListNode head = new Util.ListNode(1, two);
        ListNode head = new ListNode(1);
        head = problem24.swapPairs(head);

        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }
}
