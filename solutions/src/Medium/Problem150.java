package Medium;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class Problem150 {
    public int evalRPN(String[] tokens) {
        Stack<Integer> numbers = new Stack<>();
        Set<String> operators = new HashSet<>();
        operators.add("+");
        operators.add("-");
        operators.add("*");
        operators.add("/");
        int operand1, operand2, result;

        for (String expPart : tokens) {
            if (operators.contains(expPart)) {
                operand2 = numbers.pop();
                operand1 = numbers.pop();
                switch (expPart) {
                    case "+":
                        result = operand1 + operand2;
                        break;
                    case "-":
                        result = operand1 - operand2;
                        break;
                    case "*":
                        result = operand1 * operand2;
                        break;
                    case "/":
                        result = operand1 / operand2;
                        break;
                    default:
                        result = 0;
                }
                numbers.push(result);
            }
            else 
                numbers.push(Integer.valueOf(expPart));
        }
        return numbers.pop();
    }

    public static void main(String[] args) {
        Problem150 problem150 = new Problem150();
        System.out.println(problem150.evalRPN(new String[]{"2","1","+","3","*"}));
    }
}