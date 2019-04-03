package china.p237;

/**
 * Created on 16/03/2019.
 * Description:
 *
 * @author iznauy
 */
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

public class Solution {
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
