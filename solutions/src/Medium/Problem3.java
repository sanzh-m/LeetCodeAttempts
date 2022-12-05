package Medium;

public class Problem3 {
    public int lengthOfLongestSubstring(String s) {
        boolean[] chars = new boolean[150];
        int left = 0, right = 0, max = 0;

        while (right < s.length()) {
            if (!chars[s.charAt(right)]) {
                chars[s.charAt(right)] = true;
                right++;
                if (right - left > max)
                    max = right - left;
            } else {
                chars[s.charAt(left)] = false;
                left++;
            }
        }

        return max;
    }

    public static void main(String[] args) {
        Problem3 problem3 = new Problem3();

        System.out.println(problem3.lengthOfLongestSubstring("pwwkew"));
    }
}
