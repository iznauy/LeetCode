package all.p2;

/**
 * Created on 13/03/2019.
 * Description:
 *
 * @author iznauy
 */
public class Solution {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int cin = 0;
        ListNode head = new ListNode(0); // not include
        ListNode curr = head;
        while (l1 != null && l2 != null) {
            int val = l1.val + l2.val + cin;
            cin = val / 10;
            val = val % 10;
            curr.next = new ListNode(val);
            curr = curr.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        if (l1 == null && l2 == null && cin != 0) {
            curr.next = new ListNode(cin);
        } else {
            ListNode last = l1 == null ? l2 : l1;
            while (last != null) {
                int val = last.val + cin;
                cin = val / 10;
                val = val % 10;
                curr.next = new ListNode(val);
                curr = curr.next;
                last = last.next;
            }
            if (cin != 0)
                curr.next = new ListNode(cin);
        }
        return head.next;
    }

}

class ListNode {
    int val;
    ListNode next;
    ListNode(int val) {
        this.val = val;
    }
}