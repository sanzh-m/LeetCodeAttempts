package Medium;

import Util.ListNode;

public class Problem2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0, temp;
        ListNode head = l1;

        while (l1.next != null && l2.next != null) {
            temp = l1.val + l2.val + carry;
            carry = 0;
            if (temp > 9) {
                carry = temp / 10;
                temp = temp % 10;
            }
            l1.val = temp;
            l1 = l1.next;
            l2 = l2.next;
        }

        temp = l1.val + l2.val + carry;
        carry = 0;
        if (temp > 9) {
            carry = temp / 10;
            temp = temp % 10;
        }
        l1.val = temp;

        if (l1.next == null && l2.next == null) {
            if (carry != 0)
                l1.next = new ListNode(carry, null);
            return head;
        }

        if (l1.next == null)
            l1.next = l2.next;

        l1 = l1.next;

        while (carry != 0 && l1.next != null) {
            temp = l1.val + carry;
            carry = 0;
            if (temp > 9) {
                carry = temp / 10;
                temp = temp % 10;
            }
            l1.val = temp;
            l1 = l1.next;
        }

        if (carry != 0) {
            temp = l1.val + carry;
            carry = 0;
            if (temp > 9) {
                carry = temp / 10;
                temp = temp % 10;
            }
            l1.val = temp;
        }

        if (carry != 0)
            l1.next = new ListNode(carry, null);

        return head;
    }

    public static void main(String[] args) {
        Problem2 problem2 = new Problem2();
        ListNode three1 = new ListNode(6, null);
        ListNode two1 = new ListNode(3, three1);
        ListNode one1 = new ListNode(2, two1);
        
        ListNode four2 = new ListNode(1, null);
        ListNode three2 = new ListNode(5, four2);
        ListNode two2 = new ListNode(8, three2);
        ListNode one2 = new ListNode(9, two2);

        ListNode head = problem2.addTwoNumbers(one1, one2);
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }

        three1 = new ListNode(6, null);
        two1 = new ListNode(3, three1);
        one1 = new ListNode(2, two1);
       
        three2 = new ListNode(5, null);
        two2 = new ListNode(8, three2);
        one2 = new ListNode(9, two2);
        head = problem2.addTwoNumbers(one1, one2);
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }
}