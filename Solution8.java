package top.iznauy;

/**
 * Created on 25/01/2019.
 * Description:
 *
 * @author iznauy
 */
public class Solution8 {
    public int myAtoi(String str) {
        Long value = 0L;
        boolean overflow = false;
        boolean negative = false, begin = true;
        for (char c : str.toCharArray()) {
            if (begin) {
                if (c == ' ')
                    continue;
                else if (c == '+') {
                    begin = false;
                    continue;
                }
                else if (c == '-') {
                    begin = false;
                    negative = true;
                    continue;
                } else if ((c < '0') || (c > '9'))
                    break;
                begin = false; // 遇到了数字
            }
            if (!begin) {
                if ((c < '0') || (c > '9'))
                    break;
                value = value * 10 + c - '0';
                if ((negative && - value < Integer.MIN_VALUE) ||(!negative && value > Integer.MAX_VALUE)) {
                    overflow = true;
                    break;
                }
            }
        }
        return overflow ? (negative ? Integer.MIN_VALUE : Integer.MAX_VALUE) : (negative? - value.intValue() : value.intValue());
    }

}
