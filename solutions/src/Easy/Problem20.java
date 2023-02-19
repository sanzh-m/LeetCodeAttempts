package Easy;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Problem20 {
    public boolean isValid(String s) {
        Stack<Character> characterStack = new Stack<>();
        Map<Character, Character> parMap = new HashMap<>();
        parMap.put(')', '(');
        parMap.put('}', '{');
        parMap.put(']', '[');

        for (char c: s.toCharArray()) {
            // c in leftSet
            if (c == '(' || c == '[' || c == '{')
                characterStack.push(c);
            else if (characterStack.isEmpty() || characterStack.pop() != parMap.get(c))
                return false;
        }

        return characterStack.isEmpty();
    }

    public static void main(String[] args) {
        Problem20 problem20 = new Problem20();
        System.out.println(problem20.isValid("()[]{}"));
    }
}
