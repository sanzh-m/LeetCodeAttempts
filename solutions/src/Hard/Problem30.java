package Hard;

import java.util.*;

public class Problem30 {
    public List<Integer> findSubstring(String s, String[] words) {
        Map<String, int[]> wordsUsageMap = new HashMap<>();
        List<Integer> validIndexes = new ArrayList<>();
        int wordLength = words[0].length();

        for (var word: words) {
            var usage = wordsUsageMap.get(word);
            if (usage == null)
                wordsUsageMap.put(word, new int[]{0, 1});
            else
                usage[1]++;
        }

        for (int i = 0; i <= s.length() - wordLength; ++i) {
            if (validateIndex(s, i, wordsUsageMap, wordLength, words.length))
                validIndexes.add(i);
            resetUsageMap(wordsUsageMap);
        }

        return validIndexes;
    }

    private boolean validateIndex(String s, int index, Map<String, int[]> wordsUsage, int wordLength, int wordsToUse) {
        int wordsUsed = 0;

        while (index + wordLength <= s.length() && wordsUsed < wordsToUse) {
            String substring = s.substring(index, index + wordLength);
            var wordUsage = wordsUsage.get(substring);
            if (wordUsage == null || wordUsage[0] == wordUsage[1])
                return false;
            wordUsage[0]++;
            wordsUsed++;
            index += wordLength;
        }

        return wordsUsed == wordsToUse;
    }

    private void resetUsageMap(Map<String, int[]> wordsUsageMap) {
        for (var entry: wordsUsageMap.entrySet())
            entry.getValue()[0] = 0;
    }

    public static void main(String[] args) {
        Problem30 problem30 = new Problem30();
        System.out.println(Arrays.toString(problem30.findSubstring("a", new String[]{"a"}).toArray()));
    }
}
