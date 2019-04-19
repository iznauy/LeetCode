import java.util.Stack;

/**
 * Created on 19/04/2019.
 * Description:
 *
 * @author iznauy
 */
public class P86 {

    private static final class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode partition(ListNode head, int x) {
        Stack<ListNode> stack1 = new Stack<>();
        Stack<ListNode> stack2 = new Stack<>();
        ListNode curr = head;
        while (curr != null) {
            if (curr.val < x)
                stack1.push(curr);
            else
                stack2.push(curr);
            curr = curr.next;
        }
        while (!stack2.empty()) {
            ListNode temp = stack2.pop();
            temp.next = curr;
            curr = temp;
        }
        while (!stack1.empty()) {
            ListNode temp = stack1.pop();
            temp.next = curr;
            curr = temp;
        }
        return curr;
    }
}
