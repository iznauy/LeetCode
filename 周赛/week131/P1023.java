package week131;

import java.util.ArrayList;
import java.util.List;

/**
 * Created on 20/04/2019.
 * Description:
 *
 * @author iznauy
 */
public class P1023 {

    public List<Boolean> camelMatch(String[] queries, String pattern) {
        List<Boolean> resultList = new ArrayList<>();
        for (String query : queries) resultList.add(match(query, pattern));
        return resultList;
    }

    private boolean match(String string, String pattern) {
        char[] array = string.toCharArray();
        char[] patternArray = pattern.toCharArray();
        int ptr1 = 0, ptr2 = 0;
        while (ptr1 < string.length() && ptr2 < pattern.length()) {
            if (array[ptr1] == patternArray[ptr2]) {
                ptr1++;
                ptr2++;
            } else if (!Character.isLowerCase(array[ptr1])) { // 大写字母的话，就当出错了
                return false;
            } else {
                ptr1++;
            }
        }
        if (ptr2 != pattern.length())
            return false;
        while (ptr1 != string.length()) {
            if (!Character.isLowerCase(array[ptr1]))
                return false;
            ptr1++;
        }
        return true;
    }

}