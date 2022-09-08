import java.util.Arrays;

public class Problem34 {
    public int[] searchRange(int[] nums, int target) {
        int[] result = new int[]{-1, -1};
        if (nums.length == 0)
            return result;
        int leftBorder = binarySearchInsertionPoint(nums, target - 0.5) - 1;
        if (leftBorder == nums.length - 1 || nums[leftBorder + 1] != target)
            return result;
        result[0] = leftBorder + 1;
        int rightBorder = binarySearchInsertionPoint(nums, target + 0.5);
        result[1] = rightBorder - 1;
        return result;
    }

    // Adopted version of binarySearch0 from Arrays.java
    public int binarySearchInsertionPoint(int[] nums, double target) {
        int low = 0;
        int high = nums.length - 1;

        while (low <= high) {
            int mid = (low + high) >>> 1;
            int midVal = nums[mid];

            if (midVal < target)
                low = mid + 1;
            else if (midVal > target)
                high = mid - 1;
        }
        return low;
    }

    public static void main(String[] args) {
        Problem34 problem34 = new Problem34();
        int[] nums = new int[]{0,0,1,2,3,3,4};
        System.out.println(Arrays.toString(problem34.searchRange(nums, 2)));
    }
}
