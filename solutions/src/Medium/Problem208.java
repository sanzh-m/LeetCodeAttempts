package Medium;

public class Problem208 {
    static
    class Trie {
        Node root;

        public Trie() {
            //dummy char for root
            root = new Node();
        }

        public void insert(String word) {
            Node curr = root;
            for (char a: word.toCharArray()) {
                curr = curr.getOrPutIfMissing(a);
            }
            curr.setWordEnd();
        }

        public boolean search(String word) {
            Node curr = root;
            for (char a: word.toCharArray()) {
                curr = curr.get(a);
                if (curr == null)
                    return false;
            }
            return curr.isWordEnd();
        }

        public boolean startsWith(String prefix) {
            Node curr = root;
            for (char a: prefix.toCharArray()) {
                curr = curr.get(a);
                if (curr == null)
                    return false;
            }
            return true;
        }

        private static class Node {
            private final Node[] children;
            private boolean wordEnd;

            public Node() {
                wordEnd = false;
                children = new Node[26];
            }

            public Node get(char a) {
                return children[a - 'a'];
            }

            public Node getOrPutIfMissing(char a) {
                Node node = get(a);
                if (node != null)
                    return node;
                node = new Node();
                children[a - 'a'] = node;
                return node;
            }

            public boolean isWordEnd() {
                return wordEnd;
            }

            public void setWordEnd() {
                wordEnd = true;
            }
        }
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("apple");
        System.out.println(trie.search("apple"));   // return True
        System.out.println(trie.search("app"));     // return False
        System.out.println(trie.startsWith("app")); // return True
        trie.insert("app");
        System.out.println(trie.search("app"));     // return True

        trie.insert("hotdog");
        System.out.println(trie.startsWith("dog"));
    }
}
