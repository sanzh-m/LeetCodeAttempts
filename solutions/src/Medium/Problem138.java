package Medium;

import Util.ListNode;
// import Util.Node;
import java.util.Map;
import java.util.HashMap;

public class Problem138 {
    static class Node {
        int val;
        Node next;
        Node random;
    
        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
    
    public Node copyRandomList(Node head) {
        Map<Node, Node> originalToCopy = new HashMap<>();

        Node cur = head;

        while (cur != null) {
            Node newNode = new Node(cur.val);
            originalToCopy.put(cur, newNode);
            cur = cur.next;
        }

        cur = head;

        while (cur != null) {
            Node curNew = originalToCopy.get(cur);
            curNew.next = originalToCopy.get(cur.next);
            curNew.random = originalToCopy.get(cur.random);
            cur = cur.next;
        }

        return originalToCopy.get(head);
    }

    public static void main(String[] args) {
        Problem138 problem138 = new Problem138();
        Node five = new Node(5);
        Node four = new Node(4);
        Node three = new Node(3);
        Node two = new Node(2);
        Node one = new Node(1);
        one.next = two;
        two.next = three;
        three.next = four;
        four.next = five;
        one.random = five;
        two.random = one;
        three.random = two;
        four.random = three;
        five.random = four;

        Node newOne = problem138.copyRandomList(one);

        while (newOne != null) {
            System.out.println(newOne.val + ", " + newOne.random.val);
            newOne = newOne.next;
        }
    }
}