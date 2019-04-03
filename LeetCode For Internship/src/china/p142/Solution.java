package china.p142;

/**
 * Created on 14/03/2019.
 * Description:
 *
 * @author iznauy
 */
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}

public class Solution {
    public ListNode detectCycle(ListNode head) {
        if (head == null)
            return null;
        ListNode slow = head;
        ListNode faster = head;
        while (faster != null && faster.next != null) {
            faster = faster.next.next;
            slow = slow.next;
            if (faster == slow)
                break;
        }

        if (faster == null || faster.next == null)
            return null;

        faster = head;

        while (slow != faster) {
            slow = slow.next;
            faster = faster.next;
        }
        return slow;
    }
}