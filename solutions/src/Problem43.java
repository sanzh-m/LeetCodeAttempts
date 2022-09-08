import java.util.ArrayList;
import java.util.List;

public class Problem43 {
    int ASCII_DIGIT_OFFSET = 48;

    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }

        if (num1.length() < num2.length()) {
            String temp = num1;
            num1 = num2;
            num2 = temp;
        }

        List<String> steps = new ArrayList<>();
        int maxLength = 0;
        for (int i = 0; i < num2.length(); ++i) {
            String step = multiplyStep(num1, num2.charAt(num2.length() - i - 1) - ASCII_DIGIT_OFFSET) + "0".repeat(i);
            steps.add(step);
            if (step.length() > maxLength)
                maxLength = step.length();
        }

        StringBuilder result = new StringBuilder();
        int carry = 0;
        for (int i = 0; i < maxLength; ++i) {
            int sum = 0;
            for (var step: steps) {
                if (i >= step.length())
                    continue;
                sum += step.charAt(step.length() - i - 1) - ASCII_DIGIT_OFFSET;
            }
            int add = sum % 10 + carry % 10;
            result.insert(0, add % 10);
            carry = carry / 10 + sum / 10 + add / 10;
        }

        if (carry > 0)
            result.insert(0, carry);

        return result.toString();
    }

    private String multiplyStep(String number, int digit) {
        int carry = 0;
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < number.length(); ++i) {
            int steppie = (number.charAt(number.length() - i - 1) - ASCII_DIGIT_OFFSET) * digit;
            int add = steppie % 10 + carry;
            result.insert(0, add % 10);
            carry = steppie / 10 + add / 10;
        }
        if (carry > 0)
            result.insert(0, carry);
        return result.toString();
    }

    public static void main(String[] args) {
        Problem43 problem43 = new Problem43();
        System.out.println(problem43.multiply("140", "721"));
    }
}
