package week131;

import java.util.Stack;

/**
 * Created on 20/04/2019.
 * Description:
 *
 * @author iznauy
 */
public class P1021 {

    public String removeOuterParentheses(String S) {
        Stack<Character> stack = new Stack<>();
        StringBuilder resultBuilder = new StringBuilder();
        char[] array = S.toCharArray();
        int from = -1;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == '(') {
                stack.push('(');
                if (from == -1)
                    from = i;
            } else {
                stack.pop();
                if (stack.size() == 0) { // 一个原语结束了
                    resultBuilder.append(S.substring(from + 1, i)); // not include i
                    from = -1;
                }
            }
        }
        return resultBuilder.toString();
    }

}
