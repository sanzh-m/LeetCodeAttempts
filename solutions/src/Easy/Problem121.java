package Easy;

public class Problem121 {
    public int maxProfit(int[] prices) {
        int max = 0, maxRight = 0;

        for (int i = prices.length - 1; i > -1; --i) {
            max = Math.max(max, maxRight - prices[i]);
            maxRight = Math.max(prices[i], maxRight);
        }

        return max;
    }

    public static void main(String[] args) {
        Problem121 problem121 = new Problem121();

        System.out.println(problem121.maxProfit(new int[]{7,1,5,3,6,4}));
    }
}
