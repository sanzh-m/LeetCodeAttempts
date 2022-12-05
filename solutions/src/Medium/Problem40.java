package Medium;

import java.util.*;

public class Problem40 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> combinations = new ArrayList<>();
        Set<String> existing = new HashSet<>();
        Map<Integer, Integer> candidateMap = new HashMap<>();

        for (int candidate: candidates) {
            Integer count = candidateMap.get(candidate);
            candidateMap.put(candidate, count == null ? 1 : count + 1);
        }

        List<Map.Entry<Integer, Integer>> candidateCount = new ArrayList<>(candidateMap.entrySet());

        for (int i = 0; i < candidateCount.size(); ++i) {
            var results = combinationSumStartingFrom(candidateCount, target, i);
            for (var result: results) {
                if (existing.add(Arrays.toString(result.toArray())))
                    combinations.add(result);
            }
        }

        return combinations;
    }

    public List<List<Integer>> combinationSumStartingFrom(List<Map.Entry<Integer, Integer>> candidateCount, int target, int begin) {
        List<List<Integer>> combinations = new ArrayList<>();

        if (target == 0) {
            combinations.add(new ArrayList<>());
            return combinations;
        }

        if (begin == candidateCount.size() || candidateCount.get(begin).getKey() > target)
            return combinations;
        int current = candidateCount.get(begin).getKey();

        for (int i = 0; i <= target / current && i <= candidateCount.get(begin).getValue(); ++i) {
            var results = combinationSumStartingFrom(candidateCount, target - i * current, begin + 1);
            for (var result: results) {
                for (int j = 0; j < i; ++j)
                    result.add(current);
            }
            combinations.addAll(results);
        }

        return combinations;
    }

    public static void main(String[] args) {
        Problem40 problem40 = new Problem40();
        var results = problem40.combinationSum2(new int[]{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1}, 27);
        for (var result: results) {
            System.out.println(Arrays.toString(result.toArray()));
        }
    }
}
