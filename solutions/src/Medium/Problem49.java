package Medium;

import java.util.*;

public class Problem49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> anagramMapping = new HashMap<>();

        for (String s: strs) {
            String sortedString = sortString(s);
            List<String> list = anagramMapping.computeIfAbsent(sortedString, k -> new ArrayList<>());
            list.add(s);
        }

        return new ArrayList<>(anagramMapping.values());
    }

    private String sortString(String s) {
        char[] temp = s.toCharArray();

        Arrays.sort(temp);

        return new String(temp);
    }

    public static void main(String[] args) {
        Problem49 problem49 = new Problem49();
        System.out.println(Arrays.toString(problem49.groupAnagrams(new String[]{"eat","tea","tan","ate","nat","bat"}).toArray()));
    }
}
