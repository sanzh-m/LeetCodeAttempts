package Easy;

public class Problem704 {
    public int search(int[] nums, int target) {
        return binarySearch(nums, target, 0, nums.length);
    }

    public int binarySearch(int[] nums, int target, int start, int end) {
        if (end - start == 1)
            return target == nums[start] ? start : -1;
        int mid = (start + end) / 2, valMid = nums[mid];
        if (target == valMid)
            return (start + end) / 2;
        if (target > valMid)
            return binarySearch(nums, target, mid, end);
        else
            return binarySearch(nums, target, start, mid);
    }

    public static void main(String[] args) {
        Problem704 problem704 = new Problem704();
        System.out.println(problem704.search(new int[]{-1,0,3,5,9,12}, 9));
        System.out.println(problem704.search(new int[]{-1,0,3,5,9,12}, 2));
    }
}
