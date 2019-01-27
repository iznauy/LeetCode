package top.iznauy;

import java.util.HashMap;
import java.util.Map;

/**
 * Created on 26/01/2019.
 * Description:
 *
 * @author iznauy
 */
public class Solution13 {

    private static Map<Character, Integer> symbol2Value = new HashMap<>();

    static {
        symbol2Value.put('I', 1);
        symbol2Value.put('V', 5);
        symbol2Value.put('X', 10);
        symbol2Value.put('L', 50);
        symbol2Value.put('C', 100);
        symbol2Value.put('D', 500);
        symbol2Value.put('M', 1000);
    }

    public int romanToInt(String s) {

        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            int currValue = symbol2Value.get(s.charAt(i));
            if (i == s.length() - 1) // 没有下个字符了，所以这个一定是正的
                result += currValue;
            else {
                int nextValue = symbol2Value.get(s.charAt(i + 1));
                if (nextValue > currValue)
                    result -= currValue;
                else
                    result += currValue;
            }
        }

        return result;
    }
}
