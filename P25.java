package others;

/**
 * Created on 25/04/2019.
 * Description:
 *
 * @author iznauy
 */
public class P25 {

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummyHead = new ListNode(0);
        ListNode curr = head, tail = dummyHead;
        int length = 0;
        while (curr != null) {
            length++;
            curr = curr.next;
        }
        for (int i = 0; i < length / k; i++) {
            curr = null;
            ListNode prev;
            ListNode currTail = null;
            for (int j = 0; j < k; j++) {
                prev = curr;
                curr = head;
                head = head.next;
                curr.next = prev;
                if (j == 0)
                    currTail = curr;
            }
            tail.next = curr;
            tail = currTail;
        }
        tail.next = head;
        return dummyHead.next;
    }

}
