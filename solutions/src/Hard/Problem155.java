package Hard;

import java.util.Stack;

public class Problem155 {
    // added static here so that MinStack is the same as on LeetCode but still easy to be referenced from my main method
    static
    class MinStack {
        static class IntPair {
            int a, b;

            public IntPair(int a, int b) {
                this.a = a;
                this.b = b;
            }
        }

        Stack<IntPair> stack = new Stack<>();
        int min = Integer.MAX_VALUE;

        public MinStack() {

        }

        public void push(int val) {
            min = Math.min(min, val);
            stack.push(new IntPair(val, min));
        }

        public void pop() {
            stack.pop();
            if (stack.isEmpty())
                min = Integer.MAX_VALUE;
            else
                min = Math.max(stack.peek().b, min);
        }

        public int top() {
            return stack.peek().a;
        }

        public int getMin() {
            return stack.peek().b;
        }
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();

        minStack.push(2147483646);
        minStack.push(2147483646);
        minStack.push(2147483647);
        System.out.println(minStack.top());
        minStack.pop();
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.getMin());
        minStack.pop();
        minStack.push(2147483647);
        System.out.println(minStack.top());
        System.out.println(minStack.getMin());
        minStack.push(-2147483648);
        System.out.println(minStack.top());
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.getMin());
    }
}
