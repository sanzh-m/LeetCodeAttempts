public class Problem45 {
    public int jump(int[] nums) {
        return jumpFrom(nums, 0);
    }

    private int jumpFrom(int[] nums, int pos) {
        int maxDist = 0, maxPos = pos;
        if (pos == nums.length - 1)
            return 0;
        if (pos + nums[pos] >= nums.length - 1)
            return 1;

        for (int i = 1; i <= nums[pos]; ++i) {
            int jump = i + nums[pos + i];
            if (jump + pos >= nums.length - 1)
                return 2;
            if (jump > maxDist) {
                maxDist = jump;
                maxPos = pos + i;
            }
        }

        return 1 + jumpFrom(nums, maxPos);
    }

    public static void main(String[] args) {
        Problem45 problem45 = new Problem45();
        System.out.println(problem45.jump(new int[]{1,2}));
    }
}
