# Definition for singly-linked list.
class ListNode(object):
    def __init__(self, x):
        self.val = x
        self.next = None

class Solution(object):
    def rotateRight(self, head, k):
        """
        :type head: ListNode
        :type k: int
        :rtype: ListNode
        """
        if head == None:
        	return head
        lens = 0
        current = head
        while current != None:
        	lens += 1
        	current = current.next
        k %= lens
        if k == 0:
            return head
        current = head
        while lens != k + 1:
        	current = current.next
        	lens -= 1
        result = current.next
        current.next = None
        current = result
        while current.next != None:
        	current = current.next
        current.next = head
        return result

