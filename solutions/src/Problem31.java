import java.util.Arrays;

public class Problem31 {
    public void nextPermutation(int[] nums) {
        if (nums.length == 1)
            return;
        int index;

        for (index = nums.length - 1; index >= 1; --index) {
            if (nums[index] > nums[index - 1])
                break;
        }

        if (index == 0) {
            // Max permutation
            Arrays.sort(nums);
        } else if (index == nums.length - 1) {
            int temp = nums[nums.length - 1];
            nums[nums.length - 1] = nums[nums.length - 2];
            nums[nums.length - 2] = temp;
        } else {
            int replaceIndex = index + 1;
            while (replaceIndex < nums.length && nums[replaceIndex] > nums[index - 1])
                replaceIndex++;
            int temp = nums[index - 1];
            nums[index - 1] = nums[replaceIndex - 1];
            nums[replaceIndex - 1] = temp;
            Arrays.sort(nums, index, nums.length);
        }
    }

    public static void main(String[] args) {
        Problem31 problem31 = new Problem31();
        int[] arr = new int[]{5,4,7,5,3,2};
        problem31.nextPermutation(arr);
        System.out.println(Arrays.toString(arr));
    }
}
