public class Problem11 {
    public int maxArea(int[] height) {
        int left = 0, right = height.length - 1, max = 0;

        while (left < right) {
            int curArea = (right-left)*Math.min(height[left], height[right]);
            if (max < curArea)
                max = curArea;
            if (height[left] < height[right])
                left++;
            else
                right--;
        }

        return max;
    }
}
