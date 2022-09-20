import java.util.HashSet;
import java.util.Set;

public class Problem217 {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> numsSet = new HashSet<>();

        for (int i: nums)
            if (!numsSet.add(i))
                return true;

        return false;
    }

    public static void main(String[] args) {
        Problem217 problem217 = new Problem217();
        System.out.println(problem217.containsDuplicate(new int[]{1,2,3,1}));
    }
}
