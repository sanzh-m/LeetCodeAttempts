package Medium;

import java.util.HashSet;
import java.util.Set;

public class Problem128 {
    public int longestConsecutive(int[] nums) {
        Set<Integer> numSet = new HashSet<>();

        for (int num: nums)
            numSet.add(num);

        int max = 0, currLen;
        for (int num: nums) {
            if (numSet.contains(num - 1))
                continue;
            currLen = 1;
            while (numSet.contains(num + currLen)) {
                currLen++;
            }
            if (max < currLen)
                max = currLen;
        }

        return max;
    }

    public static void main(String[] args) {
        Problem128 problem128 = new Problem128();
        System.out.println(problem128.longestConsecutive(new int[]{100, 4, 200, 1, 3, 2}));
    }
}
