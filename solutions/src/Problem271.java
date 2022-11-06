// Credit: https://github.com/neetcode-gh/leetcode/blob/main/python/271-Encode-and-Decode-Strings.py
// I wanted to implement base64 at first but thought that it's an overkill for this situation so this solution seemed much easier

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem271 {
    public String encode(String[] strs) {
        StringBuilder result = new StringBuilder();

        for (String str: strs)
            result.append(str.length()).append('#').append(str);

        return result.toString();
    }

    public List<String> decode(String str) {
        List<String> result = new ArrayList<>();
        int i = 0, j, sublen;

        while (i < str.length()) {
            j = i;
            while (str.charAt(j) != '#')
                j++;
            sublen = Integer.parseInt(str.substring(i, j));
            result.add(str.substring(j + 1, j + 1 + sublen));
            i = j + 1 + sublen;
        }

        return result;
    }

    public static void main(String[] args) {
        Problem271 problem271 = new Problem271();
        String encoded = problem271.encode(new String[]{
                "I",
                "might",
                "buy",
                "LeetCode",
                "premium",
                "but",
                "probably",
                "later"
        });
        System.out.println(encoded);
        System.out.println(Arrays.toString(problem271.decode(encoded).toArray()));
    }
}
