package china.p557;
import java.util.*;
import java.io.*;
import java.math.BigDecimal;

/**
 * Created on 17/03/2019.
 * Description:
 *
 * @author iznauy
 */
public class Solution {

    public String reverseWords(String s) {
        StringBuilder builder = new StringBuilder(s.length());
        StringBuilder tempBuilder = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c != ' ')
                tempBuilder.append(c);
            else {
                builder.append(tempBuilder.reverse().toString());
                builder.append(c);
                tempBuilder.delete(0, tempBuilder.length());
            }
        }
        builder.append(tempBuilder.reverse().toString());
        return builder.toString();
    }

    public static void main(String[] args) {
        String s = "Let's take LeetCode contest";
        Solution solution = new Solution();
        System.out.println(solution.reverseWords(s));
    }

}
