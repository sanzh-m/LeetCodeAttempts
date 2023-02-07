package Easy;

import Util.ListNode;

public class Problem206 {
    public ListNode reverseList(ListNode head) {
        if (head == null)
            return head;
        ListNode prev = null, cur = head, temp;
        while (cur.next != null) {
            temp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = temp;
        }
        cur.next = prev;
        return cur;
    }

    public static void main(String[] args) {
        Problem206 problem206 = new Problem206();
        ListNode five = new ListNode(5, null);
        ListNode four = new ListNode(4, five);
        ListNode three = new ListNode(3, four);
        ListNode two = new ListNode(2, three);
        ListNode one = new ListNode(1, two);
        ListNode rev = problem206.reverseList(one);
        while (rev != null) {
            System.out.println(rev.val);
            rev = rev.next;
        }
    }
}