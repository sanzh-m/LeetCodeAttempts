import java.util.Arrays;

public class Problem33 {
    public int search(int[] nums, int target) {
        if (nums.length == 1)
            return nums[0] == target ? 0 : -1;

        if (nums[0] < nums[nums.length - 1]) {
            int result = Arrays.binarySearch(nums, target);
            return result >= 0 ? result : -1;
        }

        return searchRange(nums, target, 0, nums.length - 1);
    }

    private int searchRange(int[] nums, int target, int left, int right) {
        if (right - left == 1) {
            if (nums[left] == target)
                return left;
            if (nums[right] == target)
                return right;
            return -1;
        }
        int centre = (left + right) / 2;
        if (target == nums[centre])
            return centre;
        if (target == nums[right])
            return right;
        if (target == nums[left])
            return left;
        if (nums[centre] < nums[right] && (target > nums[centre] && target > nums[right] || target < nums[centre]))
            return searchRange(nums, target, left, centre);
        if (nums[centre] < nums[right] && target > nums[centre] && target < nums[right]) {
            int result = Arrays.binarySearch(nums, centre, right, target);
            return result > 0 ? result : -1;
        }
        if (nums[centre] > nums[right] && (target > nums[centre] && target > nums[right] || target < nums[centre] && target < nums[right]))
            return searchRange(nums, target, centre, right);
        if (nums[centre] > nums[right] && target < nums[centre]) {
            int result = Arrays.binarySearch(nums, left, centre, target);
            return result > 0 ? result : -1;
        }
        return -1;
    }

    public static void main(String[] args) {
        Problem33 problem33 = new Problem33();
        System.out.println(problem33.search(new int[]{3,1}, 0));
    }
}
