package Medium;

public class Problem424 {
    public int characterReplacement(String s, int k) {
        int left = 0, right = 0, anchor = 0, max = 0, counter = 0;

        while (right < s.length()) {
            if (s.charAt(anchor) != s.charAt(right) && counter > k) {
                if (anchor - left < k) {
                    anchor++;
                    right = anchor;
                    counter = anchor - left;
                } else {
                    left++;
                    anchor = left;
                    right = left;
                    counter = 0;
                }
                continue;
            }
            right++;
            if (right < s.length() && s.charAt(anchor) != s.charAt(right) && counter <= k) {
                counter++;
            }
            max = Math.max(max, right - left);
        }

        return max;
    }

    public static void main(String[] args) {
        Problem424 problem424 = new Problem424();

        System.out.println(problem424.characterReplacement("AABABBA", 1));
    }
}
