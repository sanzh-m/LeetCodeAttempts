package Medium;

import java.util.Arrays;

public class Problem33 {
    public int search(int[] nums, int target) {
        if (nums.length == 1)
            return nums[0] == target ? 0 : -1;

        if (nums[0] < nums[nums.length - 1]) {
            int result = Arrays.binarySearch(nums, target);
            return result >= 0 ? result : -1;
        }

        int min = findMinIndex(nums), result;
        if (target > nums[nums.length - 1])
            result = Arrays.binarySearch(nums, 0, min, target);
        else
            result = Arrays.binarySearch(nums, min, nums.length, target);

        return result >= 0 ? result : -1;
    }

    public int findMinIndex(int[] nums) {
        if (nums[0] < nums[nums.length - 1])
            return 0;
        return binaryFindMin(nums, 0, nums.length);
    }

    private int binaryFindMin(int[] nums, int start, int end) {
        if (end - start == 1)
            return end != nums.length && nums[start] > nums[end] ? end : start;
        int mid = (start + end) / 2;
        if (nums[mid] > nums[start])
            return binaryFindMin(nums, mid, end);
        else
            return binaryFindMin(nums, start, mid);
    }

    public static void main(String[] args) {
        Problem33 problem33 = new Problem33();
        System.out.println(problem33.search(new int[]{1,2,3,4,5,6,7,8,9}, 8));
        System.out.println(problem33.search(new int[]{3,1}, 0));
        System.out.println(problem33.search(new int[]{4,5,6,7,0,1,2}, 0));
        System.out.println(problem33.search(new int[]{4,5,6,7,0,1,2}, 5));
        System.out.println(problem33.search(new int[]{4,5,7,8,0,1,2}, 6));
        System.out.println(problem33.search(new int[]{4,5,7,8,0,1,2}, 3));
    }
}
