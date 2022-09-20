// Referenced this video for algorithm https://www.youtube.com/watch?v=8g78yfzMlao

public class HProblem41 {
    public int firstMissingPositive(int[] nums) {
        int len = nums.length;
        for (int i = 0; i < len; ++i)
            if (nums[i] < 0)
                nums[i] = 0;

        int current;
        for (int i = 0; i < len; ++i) {
            current = Math.abs(nums[i]);
            if (current != 0 && current <= len) {
                if (nums[current - 1] > 0)
                    nums[current - 1] = -nums[current - 1];
                else if (nums[current - 1] == 0)
                    nums[current - 1] = -len - 1;
            }
        }

        for (int i = 0; i < len; ++i)
            if (nums[i] >= 0)
                return i + 1;

        return len + 1;
    }

    public static void main(String[] args) {
        HProblem41 hProblem41 = new HProblem41();
        System.out.println(hProblem41.firstMissingPositive(new int[]{1,2,0}));
    }
}
