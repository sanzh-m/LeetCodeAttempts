package Medium;

import Util.ListNode;

public class Problem19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int count = 1;
        ListNode pointer = head;
        while (pointer.next != null) {
            pointer = pointer.next;
            count++;
        }

        int toRemove = count - n + 1;

        if (toRemove == 1)
            return head.next;
        int countToRemoval = 1;
        pointer = head;
        while (countToRemoval < toRemove - 1) {
            assert pointer != null;
            pointer = pointer.next;
            countToRemoval++;
        }

        assert pointer != null;
        if (count == toRemove)
            pointer.next = null;
        else {
            assert pointer.next != null;
            ListNode temp = pointer.next.next;
            pointer.next.next = null;
            pointer.next = temp;
        }

        return head;
    }

    public static void main(String[] args) {
        ListNode tail = new ListNode(5);
        ListNode four = new ListNode(4, tail);
        ListNode three = new ListNode(3, four);
        ListNode two = new ListNode(2, three);
        ListNode head = new ListNode(1, two);

        Problem19 problem19 = new Problem19();
        head = problem19.removeNthFromEnd(head, 2);

        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }
}
