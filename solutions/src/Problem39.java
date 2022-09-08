import java.util.*;

public class Problem39 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> combinations = new ArrayList<>();
        Set<String> existing = new HashSet<>();
        Arrays.sort(candidates);

        for (int i = 0; i < candidates.length; ++i) {
            var results = combinationSumStartingFrom(candidates, target, i);
            for (var result: results) {
                if (existing.add(Arrays.toString(result.toArray())))
                    combinations.add(result);
            }
        }

        return combinations;
    }

    public List<List<Integer>> combinationSumStartingFrom(int[] candidates, int target, int begin) {
        List<List<Integer>> combinations = new ArrayList<>();

        if (target == 0) {
            combinations.add(new ArrayList<>());
            return combinations;
        }

        if (begin == candidates.length || candidates[begin] > target)
            return combinations;
        int current = candidates[begin];

        for (int i = 0; i <= target / current; ++i) {
            var results = combinationSumStartingFrom(candidates, target - i * current, begin + 1);
            for (var result: results) {
                for (int j = 0; j < i; ++j)
                    result.add(current);
            }
            combinations.addAll(results);
        }

        return combinations;
    }

    public static void main(String[] args) {
        Problem39 problem39 = new Problem39();
        var results = problem39.combinationSum(new int[]{3,5,8}, 11);

        for (var result: results) {
            System.out.println(Arrays.toString(result.toArray()));
        }
    }
}
