package top.iznauy;

/**
 * Created on 25/01/2019.
 * Description:
 *
 * @author iznauy
 */
public class Solution7 {
    public int reverse(int x) {
        String integer = Integer.toString(x);
        Long num = 0L;
        boolean negative = false;
        if (integer.charAt(0) == '-') {
            negative = true;
            integer = integer.substring(1);
        }
        for (int i = integer.length() - 1; i >= 0; i--)
            num = num * 10 + integer.charAt(i) - '0';
        if (num > Integer.MAX_VALUE)
            return 0;
        return negative ? - num.intValue() : num.intValue();
    }
}
