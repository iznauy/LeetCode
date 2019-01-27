package top.iznauy;

/**
 * Created on 26/01/2019.
 * Description: 题目很简单，但是有一位老哥提出了这个非常有创造性的算法
 *
 * @author iznauy
 */
public class Solution14 {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0)
            return "";
        String max = strs[0], min = strs[0];
        for (String str: strs) {
            if (str.compareTo(min) < 0)
                min = str;
            if (str.compareTo(max) > 0)
                max = str;
        }
        StringBuilder resultBuilder = new StringBuilder();
        for (int i = 0; i < min.length(); i++) {
            if (max.length() == i || min.charAt(i) != max.charAt(i))
                break;
            resultBuilder.append(min.charAt(i));
        }
        return resultBuilder.toString();
    }
}
