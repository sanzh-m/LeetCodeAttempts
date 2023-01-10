package Medium;

import java.util.Arrays;
import java.util.Stack;

public class Problem739 {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> temps = new Stack<>();
        int[] res = new int[temperatures.length];

        for (int i = temperatures.length - 1; i >= 0; --i) {
            while (!temps.isEmpty() && temperatures[temps.peek()] <= temperatures[i])
                temps.pop();
            if (!temps.isEmpty())
                res[i] = temps.peek() - i;
            temps.push(i);
        }

        return res;
    }

    public static void main(String[] args) {
        Problem739 problem739 = new Problem739();
        System.out.println(Arrays.toString(problem739.dailyTemperatures(new int[]{73, 74, 75, 71, 69, 72, 76, 73})));
    }
}
