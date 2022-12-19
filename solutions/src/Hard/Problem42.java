package Hard;

public class Problem42 {

//    My kind bad solution - seems to be O(log n), didn't analyse properly
//    public int trap(int[] height) {
//        if (height.length == 0 || height.length == 1)
//            return 0;
//
//        int max = 0, secMax = 0;
//
//        for (int i = 0; i < height.length; ++i) {
//            if (height[i] > height[max]) {
//                secMax = max;
//                max = i;
//            } else if (height[i] == height[max])
//                secMax = i;
//        }
//
//        int left = Math.min(max, secMax), right = Math.max(max, secMax);
//
//        return calcLeft(left, height) + countWater(left, right, height) + calcRight(right, height);
//    }
//
//    private int countWater(int left, int right, int[] height) {
//        int sum = 0;
//        int min = Math.min(height[left], height[right]);
//
//        for (int h = left + 1; h < right; ++h)
//            sum += min - height[h];
//
//        return sum;
//    }
//
//    private int calcLeft(int right, int[] height) {
//        if (right == 1 || right == 0)
//            return 0;
//
//        int max = 0;
//
//        for (int i = 1; i < right; ++i)
//            if (height[i] > height[max])
//                max = i;
//
//        return countWater(max, right, height) + calcLeft(max, height);
//    }
//
//    private int calcRight(int left, int[] height) {
//        if (left == height.length - 2 || left == height.length - 1)
//            return 0;
//
//        int max = height.length - 1;
//
//        for (int i = height.length - 2; i > left; --i)
//            if (height[i] > height[max])
//                max = i;
//
//        return countWater(left, max, height) + calcRight(max, height);
//    }

    //https://github.com/neetcode-gh/leetcode/blob/main/java/42-Trapping-Rain-Water.java
    public int trap(int[] heights) {
        if (heights.length == 0) return 0;

        int l = 0, r = heights.length - 1;
        int leftMax = heights[l], rightMax = heights[r];
        int res = 0;

        while (l < r) {
            if (leftMax < rightMax) {
                l++;
                leftMax = Math.max(leftMax, heights[l]);
                res += leftMax - heights[l];
            } else {
                r--;
                rightMax = Math.max(rightMax, heights[r]);
                res += rightMax - heights[r];
            }
        }

        return res;
    }

    public static void main(String[] args) {
        Problem42 problem42 = new Problem42();

        System.out.println(problem42.trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1}));
    }
}
