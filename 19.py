# Definition for singly-linked list.
class ListNode(object):
    def __init__(self, x):
         self.val = x
         self.next = None

class Solution(object):
    def removeNthFromEnd(self, head, n):
        """
        :type head: ListNode
        :type n: int
        :rtype: ListNode
        """
        lst = []
        p = head
        while p:
            lst.append(p)
            print lst
            p = p.next
        print len(lst)
        if len(lst) == 1:
            return None
        elif n == len(lst):
            return head.next
        elif n == 1:
            lst[-2].next = None
        else:
            lst[-n-1].next = lst[-n+1]
        return head

class GreatSolution(object):
    def removeNthFromEnd(self, head, n):
        pre = ListNode(0)
        pre.next = head
        fast, slow = pre
        for i in range(n+1):
            fast = fast.next
        while fast:
            slow, fast = slow.next, fast.next
        slow.next = slow.next.next
        return pre.next
