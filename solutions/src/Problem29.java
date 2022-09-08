public class Problem29 {
    public int divide(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE && divisor == -1)
            return Integer.MAX_VALUE;
        if (divisor == 1)
            return dividend;
        if (divisor == -1)
            return -dividend;
        boolean sign = dividend < 0 ^ divisor < 0;
        long newDividend = Math.abs((long) dividend);
        long newDivisor = Math.abs((long) divisor);
        long result = 1, sum = newDivisor, totalResult = 0, totalSum = 0, prevSum = 0, prevResult = 0;
        while (totalSum > newDividend || totalSum + newDivisor <= newDividend) {
            while (totalSum + sum <= newDividend) {
                prevResult = result;
                prevSum = sum;
                sum = sum + sum;
                result = result + result;
            }
            sum = newDivisor;
            result = 1;
            totalSum = totalSum + prevSum;
            totalResult = totalResult + prevResult;
            prevSum = 0;
            prevResult = 0;
        }
        return sign ? (int) -totalResult : (int) totalResult;
    }

    public static void main(String[] args) {
        Problem29 problem29 = new Problem29();
        System.out.println(problem29.divide(-2147483648, 2));
    }
}
