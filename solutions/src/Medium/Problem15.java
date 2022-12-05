package Medium;

import java.util.*;

public class Problem15 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> set = new ArrayList<>();
        Set<String> existing = new HashSet<>();
        Arrays.sort(nums);
        System.out.println(Arrays.toString(nums));
        int pointer = 1;

        while(pointer != nums.length - 1) {
            int leftPointer = pointer - 1, rightPointer = pointer + 1;
            while (leftPointer != -1 && rightPointer != nums.length) {
                int sum = nums[leftPointer] + nums[pointer] + nums[rightPointer];
                if (sum == 0)
                    addDistinct(set, existing, nums[leftPointer], nums[pointer], nums[rightPointer]);
                if (sum >= 0)
                    leftPointer--;
                else
                    rightPointer++;
            }
            pointer++;
        }

        return set;
    }

    private void addDistinct(List<List<Integer>> set, Set<String> existing, int a, int b, int c){
        String s = String.valueOf(a) + '/' + b + '/' + c;
        if (!existing.contains(s)){
            set.add(List.of(a,b,c));
            existing.add(s);
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-1,0,1,2,-1,-4};
        Problem15 problem15 = new Problem15();
        List<List<Integer>> set = problem15.threeSum(nums);
        for (List<Integer> list: set) {
            System.out.println(Arrays.toString(list.toArray()));
        }
    }
}
