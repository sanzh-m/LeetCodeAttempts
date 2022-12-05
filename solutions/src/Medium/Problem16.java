package Medium;

import java.util.Arrays;

public class Problem16 {
    public int threeSumClosest(int[] nums, int target) {
        int result = nums[0] + nums[1] + nums[2], diff = result - target, len = nums.length;
        Arrays.sort(nums);
        for (int i=0; i < len - 2; ++i) {
            int left = i + 1, right = len - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right], curDiff = sum - target;
                if (curDiff == 0)
                    return sum;
                if (Math.abs(curDiff) < Math.abs(diff)) {
                    result = sum;
                    diff = curDiff;
                }
                if (curDiff < 0)
                    left++;
                else
                    right--;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Problem16 problem16 = new Problem16();
        System.out.println(problem16.threeSumClosest(new int[]{-100,-98,-2,-1}, -101));
    }
}
