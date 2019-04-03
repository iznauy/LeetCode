package china.p141;

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
    public boolean hasCycle(ListNode head) {
        ListNode faster = head;
        ListNode slow = head;
        while (faster != null && faster.next != null) {
            faster = faster.next.next;
            slow = slow.next;
            if (faster == slow)
                return true;
        }
        return false;
    }
}