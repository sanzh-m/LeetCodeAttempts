package Medium;

import Util.ListNode;

public class Problem143 {
    public void reorderList(ListNode head) {
        if (head.next == null)
            return;
        ListNode one = head, two = head, prev = null, temp;
        while (two != null && two.next != null) {
            two = two.next;
            if (two.next == null)
                break;
            two = two.next;
            one = one.next;
        }

        prev = one;
        one = one.next;
        prev.next = null;
        prev = null;
        
        while (one.next != null) {
            temp = one.next;
            one.next = prev;
            prev = one;
            one = temp;
        }

        one.next = prev;
        
        two = head;  
        while (two != null && one != null) {
            temp = two.next;
            two.next = one;
            one = one.next;
            two.next.next = temp;
            two = temp;
        }
    }

    public static void main(String[] args) {
        Problem143 problem143 = new Problem143();
        ListNode five = new ListNode(5, null);
        ListNode four = new ListNode(4, five);
        ListNode three = new ListNode(3, four);
        ListNode two = new ListNode(2, three);
        ListNode one = new ListNode(1, two);
        problem143.reorderList(one);
        while (one != null) {
            System.out.println(one.val);
            one = one.next;
        }
        four = new ListNode(4, null);
        three = new ListNode(3, four);
        two = new ListNode(2, three);
        one = new ListNode(1, two);
        problem143.reorderList(one);
        while (one != null) {
            System.out.println(one.val);
            one = one.next;
        }
    }
}