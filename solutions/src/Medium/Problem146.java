package Medium;

import Util.Node;

import java.util.HashMap;
import java.util.Map;

public class Problem146 {
    static
    class LRUCache {
        private class CacheNode {
            int key;
            int val;
            CacheNode next;
            CacheNode prev;

            public CacheNode(int key, int val) {
                this.key = key;
                this.val = val;
            }
        }
        final private int capacity;
        final private Map<Integer, CacheNode> map;
        private CacheNode head;

        public LRUCache(int capacity) {
            this.capacity = capacity;
            map = new HashMap<>();
        }

        public int get(int key) {
            CacheNode node = map.get(key);
            if (node == null)
                return -1;
            if (head != node) {
                squizeOutANode(node);
                replaceHead(node);
            }

            return node.val;
        }

        public void put(int key, int value) {
            CacheNode node = map.get(key);
            if (node == null)
                node = new CacheNode(key, value);
            else {
                if (head != node)
                    squizeOutANode(node);
                node.val = value;
            }
            map.put(key, node);
            if (head != node)
                replaceHead(node);
            if (capacity < map.size()) {
                removeLRU();
            }
        }

        private void replaceHead(CacheNode newHead) {
            if (head == null) {
                head = newHead;
                return;
            }
            if (head.next == null) {
                newHead.next = head;
                newHead.prev = head;
                head.next = newHead;
                head.prev = newHead;
                head = newHead;
                return;
            }
            head.prev.next = newHead;
            newHead.prev = head.prev;
            head.prev = newHead;
            newHead.next = head;
            head = newHead;
        }

        private void squizeOutANode(CacheNode node) {
            if (node.next == null)
                return;
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }

        private void removeLRU() {
            map.remove(head.prev.key);
            head.prev.prev.next = head;
            head.prev = head.prev.prev;
        }
    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);
        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.get(1));
        cache.put(3, 3);
        System.out.println(cache.get(2));
        cache.put(4, 4);
        System.out.println(cache.get(1));
        System.out.println(cache.get(3));
        System.out.println(cache.get(4));

        System.out.println("--------------");

        cache = new LRUCache(2);
        cache.put(2, 1);
        cache.put(3, 2);
        System.out.println(cache.get(3));
        System.out.println(cache.get(2));
        cache.put(4, 3);
        System.out.println(cache.get(2));
        System.out.println(cache.get(3));
        System.out.println(cache.get(4));
    }
}
