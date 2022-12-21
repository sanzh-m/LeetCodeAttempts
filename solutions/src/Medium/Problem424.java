package Medium;

public class Problem424 {
// Own attempt
//    public int characterReplacement(String s, int k) {
//        int left = 0, right = 0, anchor = 0, max = 0, counter = 0;
//
//        while (right < s.length()) {
//            if (s.charAt(anchor) != s.charAt(right) && counter > k) {
//                if (anchor - left < k) {
//                    anchor++;
//                    right = anchor;
//                    counter = anchor - left;
//                } else {
//                    left++;
//                    anchor = left;
//                    right = left;
//                    counter = 0;
//                }
//                continue;
//            }
//            right++;
//            if (right < s.length() && s.charAt(anchor) != s.charAt(right) && counter <= k) {
//                counter++;
//            }
//            max = Math.max(max, right - left);
//        }
//
//        return max;
//    }

    public int characterReplacement(String s, int k) {
        int left = 0, right = 0, max = 0;
        int[] charCounts = new int[26];
        charCounts[s.charAt(right) - 'A']++;

        while (right != s.length() - 1) {
            if (right - left + 1 - maxCount(charCounts) <= k) {
                max = Math.max(right - left + 1, max);
                right++;
                charCounts[s.charAt(right) - 'A']++;
            } else {
                charCounts[s.charAt(left) - 'A']--;
                left++;
            }
        }

        if (right - left + 1 - maxCount(charCounts) <= k) {
            max = Math.max(right - left + 1, max);
        }

        return max;
    }

    private int maxCount(int[] charCounts) {
        int max = Integer.MIN_VALUE;

        for (int i: charCounts)
            max = Math.max(i, max);

        return max;
    }

    public static void main(String[] args) {
        Problem424 problem424 = new Problem424();

        System.out.println(problem424.characterReplacement("ABAB", 2));
    }
}
