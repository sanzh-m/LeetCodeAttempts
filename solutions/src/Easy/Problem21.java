package Easy;

import Util.ListNode;

public class Problem21 {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null)
            return list2;
        if (list2 == null)
            return list1;
        ListNode head = list1.val > list2.val ? list2 : list1;

        ListNode curr1 = head;
        ListNode curr2 = list1.val <= list2.val ? list2 : list1;
        ListNode temp;

        while (curr1.next != null) {
            if (curr1.next.val > curr2.val) {
                temp = curr1.next;
                curr1.next = curr2;
                curr2 = temp;
            } else {
                curr1 = curr1.next;
            }
        }

        curr1.next = curr2;

        return head;
    }

    public static void main(String[] args) {
        Problem21 problem21 = new Problem21();
        ListNode six = new ListNode(6, null);
        ListNode five = new ListNode(5, null);
        ListNode four = new ListNode(4, six);
        ListNode three = new ListNode(3, five);
        ListNode two = new ListNode(2, four);
        ListNode one = new ListNode(1, three);
        ListNode head = problem21.mergeTwoLists(one, two);
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }
}