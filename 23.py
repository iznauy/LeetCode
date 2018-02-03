# Definition for singly-linked list.
class ListNode(object):
    def __init__(self, x):
        self.val = x
        self.next = None

class Solution(object):
    
    def mergeKLists(self, lists):
        """
        :type lists: List[ListNode]
        :rtype: ListNode
        """
        if len(lists) == 0:
        	return []
        while len(lists) > 1:
        	temp = []
        	while len(lists) >= 2:
        		l1 = lists.pop()
        		l2 = lists.pop()
        		temp.append(self.mergeTwoLists(l1, l2))
        	if len(lists) == 1:
        		temp.append(lists[0])
        	lists = temp
        return lists[0]
    
    def mergeTwoLists(self, list1, list2):
	    head = ListNode(-1)
	    current = head
	    while list1 and list2:
		    if list1.val < list2.val:
			    current.next = list1
			    list1 = list1.next
		    else:
			    current.next = list2
			    list2 = list2.next
		    current = current.next
	    if not list1:
		    current.next = list2
	    else:
		    current.next = list1
	    return head.next

