package Medium;

public class Problem567 {
    public boolean checkInclusion(String s1, String s2) {
        int[] charCounts = new int[26];

        for (char s: s1.toCharArray())
            charCounts[s - 'a']++;

        int left = 0, right = 0, remaining = s1.length();

        while (right != s2.length()) {
            if (charCounts[s2.charAt(right) - 'a'] == 0) {
                charCounts[s2.charAt(left) - 'a']++;
                remaining++;
                left++;
            } else {
                charCounts[s2.charAt(right) - 'a']--;
                remaining--;
                right++;
                if (remaining == 0)
                    return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        Problem567 problem567 = new Problem567();
        System.out.println(problem567.checkInclusion("ab", "eidboaooo"));
    }
}
