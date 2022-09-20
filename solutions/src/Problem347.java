import java.util.*;

public class Problem347 {
    public int[] topKFrequent(int[] nums, int k) {
        int[] result = new int[k];
        Map<Integer, Integer> countNums = new HashMap<>();

        for (int num: nums)
            countNums.put(num, countNums.getOrDefault(num, 0) + 1);

        List<List<Integer>> freq = new ArrayList<>(nums.length);

        for (int i = 0; i <= nums.length; ++i)
            freq.add(null);

        for (var countNum: countNums.entrySet()) {
            var list = freq.get(countNum.getValue());
            if (list == null) {
                list = new ArrayList<>();
                freq.set(countNum.getValue(), list);
            }
            list.add(countNum.getKey());
        }

        int count = 0, pointer = nums.length;

        while (count < k) {
            var list = freq.get(pointer);
            pointer--;
            if (list == null)
                continue;
            for (var val: list) {
                result[count] = val;
                count++;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Problem347 problem347 = new Problem347();
        System.out.println(Arrays.toString(problem347.topKFrequent(new int[]{5,2,5,3,5,3,1,1,3}, 2)));
    }
}
