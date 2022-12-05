package Medium;

import java.util.*;

public class Problem17 {
    private static final Map<Character, String[]> digitMapping = generateDigitMapping();

    public List<String> letterCombinations(String digits) {
        List<String> results = new ArrayList<>();

        for (char c: digits.toCharArray()) {
            results = processOneDigit(c, results);
        }

        return results;
    }

    private List<String> processOneDigit(char c, List<String> strings) {
        if (strings.isEmpty()) {
            strings.addAll(Arrays.asList(digitMapping.get(c)));
            return strings;
        } else {
            List<String> newResult = new ArrayList<>();
            for (String str : strings) {
                for (String s: digitMapping.get(c)) {
                    newResult.add(str + s);
                }
            }
            return newResult;
        }
    }

    private static Map<Character, String[]> generateDigitMapping() {
        Map<Character, String[]> mapping = new HashMap<>();

        mapping.put('2', new String[]{"a", "b", "c"});
        mapping.put('3', new String[]{"d", "e", "f"});
        mapping.put('4', new String[]{"g", "h", "i"});
        mapping.put('5', new String[]{"j", "k", "l"});
        mapping.put('6', new String[]{"m", "n", "o"});
        mapping.put('7', new String[]{"p", "q", "r", "s"});
        mapping.put('8', new String[]{"t", "u", "v"});
        mapping.put('9', new String[]{"w", "x", "y", "z"});

        return mapping;
    }

    public static void main(String[] args) {
        Problem17 problem17 = new Problem17();
        System.out.println(problem17.letterCombinations("23").toString());
    }
}
