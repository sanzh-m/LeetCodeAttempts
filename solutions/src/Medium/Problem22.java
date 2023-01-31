package Medium;

import java.util.List;
import java.util.ArrayList;
import java.util.Stack;
import java.util.stream.Collectors;

public class Problem23 {
    // Idea from here: https://youtu.be/s9fokUqJ76A
    public List<String> generateParenthesis(int n) {
        backtrack(0, 0, n);
        return res;
    }

    Stack<Character> stack = new Stack<>();
    List<String> res = new ArrayList<>();

    public void backtrack(int left, int right, int n) {
        if (left == right && left == n) {
            res.add(stack.stream().map(String::valueOf).collect(Collectors.joining()));
        }
        if (left < n) {
            stack.push('(');
            backtrack(left + 1, right, n);
            stack.pop();
        }
        if (right < left) {
            stack.push(')');
            backtrack(left, right + 1, n);
            stack.pop();
        }
    }

    // My original solution, runs same time, worse memory
    // private static class Trio {
    //     Trio (String parentheses, int used, int unclosed) {
    //         this.parentheses = parentheses;
    //         this.used = used;
    //         this.unclosed = unclosed;
    //     }

    //     String parentheses;
    //     int used;
    //     int unclosed;
    // }

    // public List<String> generateParenthesis(int n) {
    //     List<Trio> first = new ArrayList<>();
    //     first.add(new Trio("(", 1, 1));
    //     List<Trio> second = new ArrayList<>();

    //     for (int i=1; i < 2*n; ++i) {
    //         List<Trio> copyFrom, copyTo;
    //         if (i % 2 == 0) {
    //             copyFrom = second;
    //             copyTo = first;
    //         } else {
    //             copyFrom = first;
    //             copyTo = second;
    //         }

    //         for (Trio trio: copyFrom) {
    //             if (trio.used < n)
    //                 copyTo.add(new Trio(trio.parentheses + "(", trio.used + 1, trio.unclosed + 1));
    //             if (trio.unclosed > 0)
    //                 copyTo.add(new Trio(trio.parentheses + ")", trio.used, trio.unclosed - 1));
    //         }

    //         copyFrom.clear();
    //     }

    //     return second.stream().map(x -> x.parentheses).collect(Collectors.toList());
    // }

    public static void main(String[] args) {
        Problem23 problem23 = new Problem23();
        for (String parenthesis: problem23.generateParenthesis(3)) {    
            System.out.println(parenthesis);  
        }
    }
}