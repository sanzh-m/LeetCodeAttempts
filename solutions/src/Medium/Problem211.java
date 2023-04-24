package Medium;

public class Problem211 {
    static
    class WordDictionary {
        Node root;

        public WordDictionary() {
            root = new Node();
        }

        public void addWord(String word) {
            Node curr = root;
            for (char a: word.toCharArray()) {
                curr = curr.getOrPutIfMissing(a);
            }
            curr.setWordEnd();
        }

        public boolean search(String word) {
            return search(word, 0, root);
        }

        private boolean search(String word, int index, Node curr) {
            char c;
            while (index < word.length()) {
                c = word.charAt(index);
                if (c != '.' && curr.get(c) == null)
                    return false;
                else if (c == '.' && index == word.length() - 1) {
                    for (Node child: curr.getChildren())
                        if (child != null && child.isWordEnd())
                            return true;
                    return false;
                } else if (c == '.') {
                    for (Node child: curr.getChildren())
                        if (child != null && search(word, index + 1, child))
                            return true;
                    return false;
                }
                curr = curr.get(c);
                if (curr == null)
                    return false;
                index++;
            }
            return curr.isWordEnd();
        }

        static class Node {
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

            public Node[] getChildren() {
                return children;
            }
        }
    }

    public static void main(String[] args) {
        WordDictionary wordDictionary = new WordDictionary();
        wordDictionary.addWord("bad");
        wordDictionary.addWord("dad");
        wordDictionary.addWord("mad");
        wordDictionary.addWord("at");
        System.out.println(wordDictionary.search("pad")); // return False
        System.out.println(wordDictionary.search("bad")); // return True
        System.out.println(wordDictionary.search("bad")); // return True
        System.out.println(wordDictionary.search(".ad")); // return True
        System.out.println(wordDictionary.search("b..")); // return True
        System.out.println(wordDictionary.search("."));
    }
}
