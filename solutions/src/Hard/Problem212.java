package Hard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Problem212 {
    static class Trie {
        Node root;

        public Trie() {
            //dummy char for root
            root = new Node(null, '\0');
        }

        public void insert(String word) {
            Node curr = root;
            for (char a : word.toCharArray()) {
                curr = curr.getOrPutIfMissing(a);
            }
            curr.setWordEnd(true);
        }

        public boolean tryRemove(String word) {
            Node curr = root;

            for (char a : word.toCharArray()) {
                curr = curr.get(a);
                if (curr == null) return false;
            }

            if (!curr.isWordEnd()) return false;

            //If we got to this place, means word existed in Trie
            if (curr.getCount() != 0) {
                curr.setWordEnd(false);
                return true;
            }

            Node temp;
            while (curr != root) {
                temp = curr.parent;
                temp.children.remove(curr.letter);
                if (temp.getCount() != 0 || temp.isWordEnd()) return true;
                curr = temp;
            }

            return true;
        }

        public boolean startsWith(String prefix) {
            Node curr = root;
            for (char a : prefix.toCharArray()) {
                curr = curr.get(a);
                if (curr == null) return false;
            }
            return true;
        }

        private static class Node {
            private final HashMap<Character, Node> children;
            private final Node parent;
            private final char letter;
            private boolean wordEnd;

            public Node(Node parent, char letter) {
                wordEnd = false;
                children = new HashMap<>();
                this.parent = parent;
                this.letter = letter;
            }

            public Node get(char a) {
                return children.get(a);
            }

            public Node getOrPutIfMissing(char a) {
                Node node = get(a);
                if (node != null) return node;
                node = new Node(this, a);
                children.put(a, node);
                return node;
            }

            public boolean isWordEnd() {
                return wordEnd;
            }

            public void setWordEnd(boolean wordEnd) {
                this.wordEnd = wordEnd;
            }

            public int getCount() {
                return children.size();
            }
        }
    }

    public List<String> findWords(char[][] board, String[] words) {
        Trie trie = new Trie();
        for (String word : words)
            trie.insert(word);

        List<String> result = new ArrayList<>();

        for (int i = 0; i < board.length; ++i) {
            for (int j = 0; j < board[i].length; ++j) {
                checkCoordinate(trie, board, i, j, "", result);
            }
        }

        return result;
    }

    private boolean checkCoordinateIsInvalid(char[][] board, int i, int j) {
        return i < 0 || i > board.length - 1 || j < 0 || j > board[0].length - 1;
    }

    private void checkCoordinate(Trie trie, char[][] board, int i, int j, String curr, List<String> result) {
        if (checkCoordinateIsInvalid(board, i, j) || board[i][j] < 'a') return;
        String test = curr + board[i][j];
        if (!trie.startsWith(test)) return;
        else if (trie.tryRemove(test)) result.add(test);

        board[i][j] -= 'a';

        checkCoordinate(trie, board, i - 1, j, test, result);
        checkCoordinate(trie, board, i + 1, j, test, result);
        checkCoordinate(trie, board, i, j - 1, test, result);
        checkCoordinate(trie, board, i, j + 1, test, result);
        board[i][j] += 'a';
    }

    public static void main(String[] args) {
        Problem212 problem212 = new Problem212();
        char[][] board = {{'o', 'a', 'a', 'n'}, {'e', 't', 'a', 'e'}, {'i', 'h', 'k', 'r'}, {'i', 'f', 'l', 'v'}};
        String[] words = {"oath", "pea", "eat", "rain"};
        List<String> result = problem212.findWords(board, words);
        //Expect oath, eat
        for (String word : result)
            System.out.println(word);

        System.out.println();

        String[] words1 = {"oath", "pea", "eat", "rain", "oathi", "oathk", "oathf", "oate", "oathii", "oathfi", "oathfii"};
        result = problem212.findWords(board, words1);
        //Expect oath,oathk,oathf,oathfi,oathfii,oathi,oathii,oate,eat
        for (String word : result)
            System.out.println(word);
    }
}