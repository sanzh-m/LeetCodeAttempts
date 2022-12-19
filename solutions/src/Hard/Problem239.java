package Hard;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Arrays;

public class Problem239 {
    // Shamelessly used this code: https://github.com/neetcode-gh/leetcode/blob/main/python/239-Sliding-Window-Maximum.py
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> integerDeque = new ArrayDeque<>();
        int[] result = new int[nums.length - k + 1];
        int left = 0, right = 0;

        while (right < nums.length) {
            while (!integerDeque.isEmpty() && nums[integerDeque.getLast()] < nums[right])
                integerDeque.removeLast();
            integerDeque.addLast(right);

            if (!integerDeque.isEmpty() && integerDeque.getFirst() < left)
                integerDeque.removeFirst();

            if (right + 1 >= k) {
                result[left] = nums[integerDeque.getFirst()];
                left++;
            }

            right++;
        }

        return result;
    }

    public static void main(String[] args) {
        Problem239 problem239 = new Problem239();
        System.out.println(Arrays.toString(problem239.maxSlidingWindow(new int[]{1,-1}, 1)));
    }
}
