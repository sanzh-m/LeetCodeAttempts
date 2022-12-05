package Hard;

import java.util.Stack;

public class Problem32 {

//    This approach is O(n^2), so I had to find something better. Although from runtime on LeetCode it seems to be O(n^3)
//    public int longestValidParentheses(String s) {
//        int max = 0;
//
//        for (int i = 0; i < s.length(); ++i) {
//            int length = longestValidParenthesesStartingFromIndex(s, i);
//            if (length > max)
//                max = length;
//        }
//
//        return max;
//    }
//
//    private int longestValidParenthesesStartingFromIndex(String s, int index) {
//        int balance = 0, maxValid = 0;
//
//        for (int i = index; i < s.length(); ++i) {
//            balance += s.charAt(i) == '(' ? 1 : -1;
//            if (balance < 0)
//                return i - index;
//            if (balance == 0)
//                maxValid = i - index + 1;
//        }
//
//        return maxValid;
//    }

    // Used general idea from here: https://www.youtube.com/watch?v=VdQuwtEd10M

    public int longestValidParentheses(String s) {
        Stack<Integer> st = new Stack<>();
        st.push(-1);
        int max = 0;

        for (int i = 0; i < s.length(); ++i) {
            if (s.charAt(i) == '(')
                st.push(i);
            else {
                st.pop();
                if (st.isEmpty())
                    st.push(i);
                else {
                    int len = i - st.peek();
                    max = Math.max(max, len);
                }
            }
        }

        return max;
    }

    public static void main(String[] args) {
        Problem32 problem32 = new Problem32();
        System.out.println(problem32.longestValidParentheses(")()())"));
    }
}
