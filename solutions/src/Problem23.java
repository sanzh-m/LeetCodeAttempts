public class Problem23 {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0)
            return null;
        return divideAndMergeLists(lists, 0, lists.length - 1);
    }

    public ListNode divideAndMergeLists(ListNode[] lists, int start, int end) {
        if (end == start)
            return lists[start];

        if (end - start == 1)
            return mergeTwoLists(lists[start], lists[end]);

        return mergeTwoLists(divideAndMergeLists(lists, start, (start + end) / 2), divideAndMergeLists(lists, (start + end) / 2 + 1, end));
    }

    public ListNode mergeTwoLists(ListNode first, ListNode second) {
        ListNode head;

        if (first == null)
            return second;
        if (second == null)
            return first;

        if (first.val < second.val) {
            head = first;
            first = first.next;
        } else {
            head = second;
            second = second.next;
        }

        ListNode pointer = head;

        while (first != null && second != null) {
            if (first.val < second.val) {
                pointer.next = first;
                first = first.next;
            } else {
                pointer.next = second;
                second = second.next;
            }
            pointer = pointer.next;
        }

        if (first != null)
            pointer.next = first;
        if (second != null)
            pointer.next = second;

        return head;
    }

    public static void main(String[] args) {
        Problem23 problem23 = new Problem23();
        ListNode tail1 = new ListNode(5);
        ListNode two1 = new ListNode(4, tail1);
        ListNode head1 = new ListNode(1, two1);

        ListNode tail2 = new ListNode(4);
        ListNode two2 = new ListNode(3, tail2);
        ListNode head2 = new ListNode(1, two2);

        ListNode tail3 = new ListNode(6);
        ListNode head3 = new ListNode(2, tail3);

//        ListNode head = problem23.mergeKLists(new ListNode[]{head1, head2, head3});
        ListNode head = problem23.mergeKLists(new ListNode[]{null});

        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }

    }
}
