import java.util.*;

public class Problem1 {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> numMap = new HashMap<>();

        Integer num;
        for (int i = 0; i < nums.length; ++i) {
            num = numMap.get(target - nums[i]);
            if (num != null)
                return new int[]{i, num};
            else
                numMap.put(nums[i], i);
        }

        return null;
    }

    public static void main(String[] args) {
        Problem1 problem1 = new Problem1();
        System.out.println(Arrays.toString(problem1.twoSum(new int[]{2, 7, 11, 15}, 9)));
    }
}
