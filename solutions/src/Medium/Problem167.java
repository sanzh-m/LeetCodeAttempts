package Medium;

import java.util.Arrays;

public class Problem167 {
    public int[] twoSum(int[] numbers, int target) {
        int sum, left = 0, right = numbers.length - 1;
        while (left < right) {
            sum = numbers[left] + numbers[right];
            if (sum == target)
                return new int[]{left + 1, right + 1};
            if (sum > target)
                right--;
            else
                left++;
        }
        return new int[]{};
    }

    public static void main(String[] args) {
        Problem167 problem167 = new Problem167();
        System.out.println(Arrays.toString(problem167.twoSum(new int[]{2,7,11,15}, 9)));
    }
}
