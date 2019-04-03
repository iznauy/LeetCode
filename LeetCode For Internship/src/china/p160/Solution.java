package china.p160;

/**
 * Created on 16/03/2019.
 * Description:
 *
 * @author iznauy
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        if (headA == null || headB == null)
            return null;
        if (headA == headB)
            return headA;
        ListNode pushA = getIntersectionNode(headA.next, headB);
        if (pushA != null)
            return pushA;
        return getIntersectionNode(headA, headB.next);
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int val) {
        this.val = val;
    }
}