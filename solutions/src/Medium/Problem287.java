package Medium;

public class Problem287 {
    public int findDuplicate(int[] nums) {
        int slow = 0, fast = 0;

        while (slow == 0 || slow != fast) {
            slow = nums[slow];
            fast = nums[nums[fast]];
        }

        int slow2 = 0;

        while (slow != slow2) {
            slow = nums[slow];
            slow2 = nums[slow2];
        }

        return slow;
    }

    public static void main(String[] args) {
        Problem287 problem287 = new Problem287();
        System.out.println(problem287.findDuplicate(new int[]{3,1,3,4,2}));
    }
}
