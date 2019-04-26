package others;

/**
 * Created on 26/04/2019.
 * Description:
 *
 * @author iznauy
 */
public class P28 {

    public int strStr(String haystack, String needle) {
        int[] next = calcNext(needle);
        int ptrP = 0, ptrS = 0;
        while (ptrP < needle.length() && ptrS < haystack.length()) {
            if (ptrP == -1 || needle.charAt(ptrP) == haystack.charAt(ptrS)) {
                ptrP++;
                ptrS++;
            } else
                ptrS = next[ptrS];
        }
        return ptrP == needle.length() ? ptrS - needle.length() : -1;
    }

    private int[] calcNext(String pattern) {
        int[] next = new int[pattern.length()];
        next[0] = -1;
        for (int i = 1; i < next.length; i++) {
            int j = next[i - 1];
            while (j != -1 && pattern.charAt(i - 1) != pattern.charAt(j))
                j = next[j];
            next[i] = j + 1;
        }
        return next;
    }

}
