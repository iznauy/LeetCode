package others;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Stack;

/**
 * Created on 26/04/2019.
 * Description:
 *
 * @author iznauy
 */
public class P32 {

    public int longestValidParentheses(String s) {
        char[] str = s.toCharArray();
        Stack<Integer> stack = new Stack<>();
        List<int[]> segments = new ArrayList<>();
        for (int i = 0; i < str.length; i++) {
            char c = str[i];
            if (c == '(')
                stack.push(i);
            else {
                // c = ')'
                if (!stack.empty()) {
                    int index = stack.pop();
                    segments.add(new int[]{ index, i + 1 });
                }
            }
        }
        segments.sort(Comparator.comparingInt(o -> o[0]));
        int maxLen = 0;
        int[] prevSeg = null;
        for (int[] seg: segments) {
            if (prevSeg == null) {
                prevSeg = seg;
                maxLen = seg[1] - seg[0];
            } else {
                if (seg[0] <= prevSeg[1] && seg[1] > prevSeg[1]) { // 可以合并
                    prevSeg[1] = seg[1];
                } else if (seg[0] > prevSeg[1]) {
                    prevSeg = seg;
                }
                maxLen = Math.max(maxLen, prevSeg[1] - prevSeg[0]);
            }
        }
        return maxLen;
    }

}

class AnoterSolution {

    public int longestValidParentheses(String s) {
        char[] chars = s.toCharArray();
        return Math.max(calc(chars, 0, 1, chars.length, '('),
                calc(chars, chars.length - 1, -1, -1, ')'));
    }

    private static int calc(char[] chars, int from, int step, int end, char target) {
        int max = 0, sum = 0, currLen = 0, validLen = 0;
        for (int i = from; i != end; i += step) {
            sum += (chars[i] == target ? 1 : -1);
            currLen++;
            if (sum < 0) {
                max = max > validLen ? max : validLen;
                sum = currLen = validLen = 0;
            } else if (sum == 0) {
                validLen = currLen;
            }
        }
        return max > validLen ? max : validLen;
    }

}
