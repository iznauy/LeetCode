package china.p29;

/**
 * Created on 14/03/2019.
 * Description:
 *
 * @author iznauy
 */
public class Solution {
    public int divide(int dividend, int divisor) {
        if (dividend == -2147483648 && divisor == -1)
            return 2147483647;
        boolean positive = (dividend >= 0 && divisor > 0) || (dividend < 0 && divisor < 0);
        long dividendAbs = Math.abs((long) dividend);
        long divisorAbs = Math.abs((long) divisor);
        long left = 0, right = dividendAbs;
        long mid;
        while (left <= right) {
            mid = (left + right) / 2;
            if (divisorAbs * mid <= dividendAbs)
                left = mid + 1;
            else
                right = mid - 1;
        }
        return (int)(left - 1) * (positive ? 1 : -1);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.divide(-2147483648, 1));
    }
}
