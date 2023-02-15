package Easy;

import Util.ListNode;

public class Problem141 {
    public boolean hasCycle(ListNode head) {
        ListNode fast = head, slow = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow)
                return true;
        }

        return false;
    }

    public static void main(String[] args) {
        Problem141 problem141 = new Problem141();
        ListNode five = new ListNode(5);
        ListNode four = new ListNode(4, five);
        ListNode three = new ListNode(3, four);
        ListNode two = new ListNode(2, three);
        ListNode one = new ListNode(1, two);
        five.next = three;
        System.out.println(problem141.hasCycle(one));
    }
}
