package Medium;

public class Problem875 {
    public int minEatingSpeed(int[] piles, int h) {
        int max = 0;

        for (int i: piles)
            max = Math.max(max, i);

        return binarySearchEatingSpeed(piles, h, 1, max);
    }

    private boolean checkEatingSpeed(int[] piles, int h, int speed) {
        int count = 0;

        for (int i: piles)
            count += i / speed + (i % speed != 0 ? 1 : 0);

        return count <= h;
    }

    private int binarySearchEatingSpeed(int[] piles, int h, int start, int end) {
        int mid = (start + end) / 2;
        if (end - start == 1)
            if (checkEatingSpeed(piles, h, start))
                return start;
            else
                return end;
        if (checkEatingSpeed(piles, h, mid))
            return binarySearchEatingSpeed(piles, h, start, mid);
        else
            return binarySearchEatingSpeed(piles, h, mid, end);
    }

    public static void main(String[] args) {
        Problem875 problem875 = new Problem875();
        System.out.println(problem875.minEatingSpeed(new int[]{3,6,7,11}, 8));
    }
}
