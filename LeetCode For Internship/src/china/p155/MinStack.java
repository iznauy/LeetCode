package china.p155;

import java.util.Stack;

/**
 * Created on 16/03/2019.
 * Description:
 *
 * @author iznauy
 */
public class MinStack {

    private Stack<Integer> stack;

    /** initialize your data structure here. */
    public MinStack() {
        stack = new Stack<>();
    }

    public void push(int x) {
        if (stack.empty()) {
            stack.push(x);
            stack.push(x);
        } else {
            int min = Math.min(getMin(), x);
            stack.push(min);
            stack.push(x);
        }
    }

    public void pop() {
        stack.pop();
        stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return stack.get(stack.size() - 2);
    }
}
