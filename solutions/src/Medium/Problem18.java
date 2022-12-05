package Medium;

import java.util.*;

public class Problem18 {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Map<Integer, List<String>> pairsMap = new HashMap<>();
        List<List<Integer>> result = new ArrayList<>();
        Set<String> existing = new HashSet<>();
        Integer[] cleanNums = cleanUpNums(nums, target);

        for (int i=0; i < cleanNums.length - 1; ++i) {
            for (int j=i+1; j < cleanNums.length; ++j) {
                int sum = cleanNums[i] + cleanNums[j];
                List<String> sumOptions = pairsMap.computeIfAbsent(sum, k -> new ArrayList<>());
                sumOptions.add(String.valueOf(i)+'/'+j);
            }
        }

        for (Integer firstPartKey: pairsMap.keySet()) {
            List<String> secondPartOptions = pairsMap.get(target - firstPartKey);
            if (secondPartOptions != null) {
                List<String> firstPartOptions = pairsMap.get(firstPartKey);
                for (String firstPair: firstPartOptions) {
                    String[] firstNumbers = firstPair.split("/");
                    int first = Integer.parseInt(firstNumbers[0]);
                    int second = Integer.parseInt(firstNumbers[1]);
                    for (String secondPair: secondPartOptions) {
                        String[] secondNumbers = secondPair.split("/");
                        int third = Integer.parseInt(secondNumbers[0]);
                        int fourth = Integer.parseInt(secondNumbers[1]);
                        if (first == third || first == fourth || second == third || second == fourth)
                            continue;
                        int[] values = new int[]{cleanNums[first], cleanNums[second], cleanNums[third], cleanNums[fourth]};
                        Arrays.sort(values);
                        String setRepresentation = String.join(".", Arrays.stream(values).mapToObj(String::valueOf).toArray(String[]::new));
                        if (!existing.contains(setRepresentation)) {
                            existing.add(setRepresentation);
                            result.add(List.of(cleanNums[first], cleanNums[second], cleanNums[third], cleanNums[fourth]));
                        }
                    }
                }
            }
        }

        return result;
    }

    private Integer[] cleanUpNums(int[] nums, int target) {
        Map<Integer, Integer> occurrences = new HashMap<>();
        List<Integer> listNums = new ArrayList<>();
        for (int i: nums) {
            Integer count = occurrences.get(i);
            if (count != null) {
                if (i != target / 4 && count < 3 || i == target / 4 && count < 4)
                    occurrences.put(i, count + 1);
            }
            else
                occurrences.put(i, 1);
        }
        for (Map.Entry<Integer, Integer> numCount: occurrences.entrySet()) {
            for (int i=0; i < numCount.getValue(); ++i) {
                listNums.add(numCount.getKey());
            }
        }
        return listNums.toArray(Integer[]::new);
    }

    public static void main(String[] args) {
        Problem18 problem18 = new Problem18();
        List<List<Integer>> result = problem18.fourSum(new int[]{2,2,2,2}, 8);
        for (List<Integer> list: result) {
            System.out.println(list.toString());
        }
    }
}
