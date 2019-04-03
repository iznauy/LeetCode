package algorithm;

/**
 * Created on 14/03/2019.
 * Description:
 *
 * @author iznauy
 */
public class BitOperations {

    public static int add(int a, int b) {
        int s, c;
        while (b != 0) {
            s = a ^ b;
            c = (a & b) << 1;
            a = s;
            b = c;
        }
        return a;
    }

    public static int multiply(int a, int b) {
        boolean flag = !(getSign(a) == getSign(b));

        a = toPositive(a);
        b = toPositive(b);

        int ans = 0;
        while (b != 0) {
            if ((b & 1) != 0)
                ans = add(ans, a);
            a = a << 1;
            b = b >> 1;
        }
        return flag ? negative(ans) : ans;
    }

    public static int divide(int dividend, int divisor) {
        boolean flag = !(getSign(dividend) == getSign(divisor));
        dividend = toPositive(dividend);
        divisor = toPositive(divisor);
        int ans = 0, i = 31;
        while (i >= 0) {
            if ((dividend >> i) >= divisor) {
                ans = add(ans, 1 << i);
                dividend = subtract(dividend, divisor << i);
            }
            i = subtract(i, 1);
        }
        return flag ? negative(ans) : ans;
    }

    public static int subtract(int a, int b) {
        return add(a, negative(b));
    }

    private static int negative(int i) {
        return add(~i, 1);
    }

    private static int getSign(int i) {
        return i >> 31;
    }

    private static int toPositive(int i) {
        if ((i >> 31) == 1)
            return negative(i);
        else
            return i;
    }

}
