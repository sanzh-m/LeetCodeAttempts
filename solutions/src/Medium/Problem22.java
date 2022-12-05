package Medium;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Problem22 {
    private static class Trio {
        Trio (String parentheses, int used, int unclosed) {
            this.parentheses = parentheses;
            this.used = used;
            this.unclosed = unclosed;
        }

        String parentheses;
        int used;
        int unclosed;
    }

    public List<String> generateParenthesis(int n) {
        List<Trio> first = new ArrayList<>();
        first.add(new Trio("(", 1, 1));
        List<Trio> second = new ArrayList<>();

        for (int i=1; i < 2*n; ++i) {
            List<Trio> copyFrom, copyTo;
            if (i % 2 == 0) {
                copyFrom = second;
                copyTo = first;
            } else {
                copyFrom = first;
                copyTo = second;
            }

            for (Trio trio: copyFrom) {
                if (trio.used < n)
                    copyTo.add(new Trio(trio.parentheses + "(", trio.used + 1, trio.unclosed + 1));
                if (trio.unclosed > 0)
                    copyTo.add(new Trio(trio.parentheses + ")", trio.used, trio.unclosed - 1));
            }

            copyFrom.clear();
        }

        return second.stream().map(x -> x.parentheses).collect(Collectors.toList());
    }

    public static void main(String[] args) {
        Problem22 problem22 = new Problem22();
        System.out.println(problem22.generateParenthesis(4));
    }
}
