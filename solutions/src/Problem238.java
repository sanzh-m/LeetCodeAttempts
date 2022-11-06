// Credit: https://github.com/neetcode-gh/leetcode/blob/main/python/238-Product-of-array-except-self.py

import java.util.Arrays;

public class Problem238 {
    public int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];
        Arrays.fill(result, 1);

        int prefix = 1, postfix = 1, i;
        for (i = 0; i < nums.length; ++i) {
            result[i] = prefix;
            prefix *= nums[i];
        }
        for (i = nums.length - 1; i >= 0; --i) {
            result[i] *= postfix;
            postfix *= nums[i];
        }


        return result;
    }

    public static void main(String[] args) {
        Problem238 problem238 = new Problem238();
        System.out.println(Arrays.toString(problem238.productExceptSelf(new int[]{1,2,3,4})));
    }
}
