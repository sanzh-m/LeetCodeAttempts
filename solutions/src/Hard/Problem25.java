package Hard;

import Util.ListNode;

public class Problem25 {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (k == 1)
            return head;

        ListNode start = head, end = null, pointer = head, next, prev = null;
        int length = 0;
        boolean headReassigned = false;

        while (pointer != null) {
            length++;
            pointer = pointer.next;
        }

        pointer = head;

        for (int i = 0; i < length / k; ++i) {
            for (int j = 0; j < k - 1; ++j) {
                next = pointer.next;
                pointer.next = prev;
                prev = pointer;
                pointer = next;
            }
            next = pointer.next;
            pointer.next = prev;
            if (!headReassigned) {
                headReassigned = true;
                head = pointer;
            } else {
                end.next = pointer;
            }
            start.next = next;
            prev = start;
            end = start;
            start = next;
            pointer = next;
        }
        return head;
    }

    public static void main(String[] args) {
        Problem25 problem25 = new Problem25();
        ListNode tail = new ListNode(9);
        ListNode eight = new ListNode(8, tail);
        ListNode seven = new ListNode(7, eight);
        ListNode six = new ListNode(6, seven);
        ListNode five = new ListNode(5, six);
        ListNode four = new ListNode(4, five);
        ListNode three = new ListNode(3, four);
        ListNode two = new ListNode(2, three);
        ListNode head = new ListNode(1, two);

        head = problem25.reverseKGroup(head, 4);

        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }
}
