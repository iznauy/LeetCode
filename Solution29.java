package top.iznauy;

/**
 * Created on 27/01/2019.
 * Description:
 *
 * @author iznauy
 */
public class Solution29 {

    private Long positiveDivide(Long dividend, Long divisor) {
        Long result = 0L;
        while (dividend >= divisor) {
            String dividendString = dividend.toString();
            String divisorString = divisor.toString();
            int shift = dividendString.length() - divisorString.length();
            String dividendPrefix = dividendString.substring(0, dividendString.length() - shift);
            if (dividendPrefix.compareTo(divisorString) < 0) { // 字符串小于，实际上也就是数字小于
                shift -= 1;
                dividendPrefix = dividendString.substring(0, dividendString.length() - shift);
            }
            Long prefixValue = Long.valueOf(dividendPrefix);
            int factor = 0;
            while (divisor <= prefixValue) {
                factor++;
                prefixValue -= divisor;
            }
            String nextDividendString = prefixValue.toString() + dividendString.substring(dividendString.length() - shift);
            dividend = Long.valueOf(nextDividendString);
            result += factor * (long) Math.pow(10, shift);
        }
        return result;
    }


    public int divide(int dividend, int divisor) {
        if (divisor == -1 && dividend == Integer.MIN_VALUE) // 只有一种情况会溢出
            return Integer.MAX_VALUE;
        boolean negative = false;
        if ((dividend < 0 && divisor > 0) || (dividend > 0 && divisor < 0))
            negative = true;
        Long result = positiveDivide(Math.<Long>abs(Long.valueOf(dividend)),
                Math.<Long>abs(Long.valueOf(divisor)));
        return negative ? - result.intValue() : result.intValue();
    }

    public static void main(String... args) {
        Solution29 solution29 = new Solution29();
        System.out.println(solution29.divide(1823, 17));
    }

}

class AnotherSolution29 {

    public int divide(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE && divisor == -1)
            return Integer.MAX_VALUE;
        int a = Math.abs(dividend), b = Math.abs(divisor);
        int result = 0;
        for (int x = 31; x >= 0; x--)
            if ((a >>> x) - b >= 0) {
                result += 1 << x;
                a -= b << x;
            }

        return (dividend > 0) == (divisor > 0) ? result : -result;
    }

}
