package Easy;

import java.util.HashMap;
import java.util.Map;

public class Problem242 {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length())
            return false;
        Map<Character, Integer> charCount = new HashMap<>();

        int i;
        char c;
        Integer counter;
        for (i = 0; i < s.length(); ++i) {
            c = s.charAt(i);
            counter = charCount.get(c);

            if (counter == null)
                counter = 1;
            else
                counter++;

            charCount.put(c, counter);
        }

        for (i = 0; i < t.length(); ++i) {
            c = t.charAt(i);
            counter = charCount.get(c);

            if (counter == null)
                return false;
            else if (counter == 1)
                charCount.remove(c);
            else
                charCount.put(c, --counter);
        }

        return charCount.size() == 0;
    }

    public static void main(String[] args) {
        Problem242 problem242 = new Problem242();
        System.out.println(problem242.isAnagram("anagram", "nagarat"));
    }
}
