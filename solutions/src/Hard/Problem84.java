package Hard;

import java.util.Stack;

public class Problem84 {
    public class Pair<K, V> {
        public Pair (K first, V second) {
            this.first = first;
            this.second = second;
        }

        K first;
        V second;
    }

    public int largestRectangleArea(int[] heights) {
        int max = 0;
        Stack<Pair<Integer, Integer>> stack = new Stack<>();

        for (int i = 0; i < heights.length; ++i) {
            Pair<Integer, Integer> pair = null;
            while (!stack.isEmpty() && stack.peek().second > heights[i]) {
                pair = stack.pop();
                max = Math.max(max, (i - pair.first) * pair.second);
            }
            stack.push(new Pair<>(pair == null ? i : pair.first, heights[i]));
        }

        while (!stack.isEmpty()) {
            Pair<Integer, Integer> pair = stack.pop();
            max = Math.max(max, (heights.length - pair.first) * pair.second);
        }

        return max;
    }

    public static void main(String[] args) {
        Problem84 problem84 = new Problem84();
        System.out.println(problem84.largestRectangleArea(new int[]{2,1,5,6,2,3}));
        System.out.println(problem84.largestRectangleArea(new int[]{2,4}));
    }
}