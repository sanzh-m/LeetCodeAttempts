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
//        ListNode tail = new ListNode(4);
//        ListNode three = new ListNode(3, tail);
//        ListNode two = new ListNode(2, three);
//        ListNode head = new ListNode(1, two);
        ListNode head = new ListNode(1);
        head = problem24.swapPairs(head);

        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }
}
