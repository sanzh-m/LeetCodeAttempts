package Medium;

public class Problem38 {
    public String countAndSay(int n) {
        return countAndSayIteration("", 0, n);
    }

    private String countAndSayIteration(String string, int count, int target) {
        count++;
        String result = countAndSayFromString(string);
        if (count == target)
            return result;
        return countAndSayIteration(result, count, target);
    }

    private String countAndSayFromString(String input) {
        if (input.equals(""))
            return "1";
        int pointer = 0, lastPointer = 0;
        char digit = input.charAt(0);
        StringBuilder output = new StringBuilder();
        while (pointer != input.length()) {
            while (pointer != input.length() && digit == input.charAt(pointer))
                pointer++;
            output.append(pointer - lastPointer).append(digit);
            if (pointer < input.length()) {
                digit = input.charAt(pointer);
                lastPointer = pointer;
            }
        }
        return output.toString();
    }

    public static void main(String[] args) {
        Problem38 problem38 = new Problem38();
        System.out.println(problem38.countAndSay(4));
    }
}
