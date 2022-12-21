package Hard;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Problem76 {
    public String minWindow(String s, String t) {
        int[] charCounts = new int[150];

        Set<Character> chars = new HashSet<>();
        Arrays.fill(charCounts, -1);

        for (char c: t.toCharArray()) {
            chars.add(c);
            if (charCounts[c] == -1)
                charCounts[c] = 1;
            else
                charCounts[c]++;
        }

        int left = 0, right = 0, minLeft = -1, minRight = -1, min = Integer.MAX_VALUE;

        while (right != s.length() && left != s.length()) {
            while (left != s.length() && (!chars.contains(s.charAt(left)) || charCounts[s.charAt(left)] < 0)) {
                if (chars.contains(s.charAt(left)))
                    charCounts[s.charAt(left)]++;
                left++;
            }
            if (left == s.length())
                break;
            while (right != s.length() && !chars.contains(s.charAt(right))) {
                right++;
            }
            if (right == s.length())
                break;
            if (charCounts[s.charAt(right)] <= 0 && s.charAt(left) == s.charAt(right)) {
                charCounts[s.charAt(left)]++;
                left++;
            } else {
                charCounts[s.charAt(right)]--;
                right++;
                if (allContained(charCounts) && right - left < min) {
                    minLeft = left;
                    minRight = right;
                    min = right - left;
                }
            }
        }

        if (minLeft == -1)
            return "";
        return s.substring(minLeft, minRight);
    }

    boolean allContained(int[] charCounts) {
        for (int i: charCounts)
            if (i > 0)
                return false;
        return true;
    }

    public static void main(String[] args) {
        Problem76 problem76 = new Problem76();
        System.out.println(problem76.minWindow("bba", "ab"));
    }
}
