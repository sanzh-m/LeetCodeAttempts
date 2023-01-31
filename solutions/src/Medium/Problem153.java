package Medium;

public class Problem153 {
    public int findMin(int[] nums) {
        if (nums[0] < nums[nums.length - 1])
            return nums[0];
        return binaryFindMin(nums, 0, nums.length);
    }

    private int binaryFindMin(int[] nums, int start, int end) {
        if (end - start == 1)
            return end != nums.length && nums[start] > nums[end] ? nums[end] : nums[start];
        int mid = (start + end) / 2;
        if (nums[mid] > nums[start])
            return binaryFindMin(nums, mid, end);
        else
            return binaryFindMin(nums, start, mid);
    }

    public static void main(String[] args) {
        Problem153 problem153 = new Problem153();
        System.out.println(problem153.findMin(new int[]{4,5,6,7,0,1,2}));
        System.out.println(problem153.findMin(new int[]{11,13,15,17}));
    }
}
