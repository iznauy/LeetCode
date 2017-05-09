# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution(object):
    def addTwoNumbers(self, l1, l2):
        """
        :type l1: ListNode
        :type l2: ListNode
        :rtype: ListNode
        """
        p, rList = None, None
        render = 0
        while l1 is not None or l2 is not None:
            var1, var2 = 0, 0
            if l1 is None:
                var2 = l2.val
                l2 = l2.next
            elif l2 is None:
                var1 = l1.val
                l1 = l1.next
            else:
                var1, var2 = l1.val, l2.val
                l1, l2 = l1.next, l2.next
            sum = var1 + var2 + render
            if sum >= 10:
                render = 1
                sum -= 10
            else:
                render = 0
            if rList is None:
                rList = ListNode(sum)
                p = rList
            else:
                p.next = ListNode(sum)
                p = p.next
        
        if render == 1:
            p.next = ListNode(1)
        
        return rList

class Solution2:
    def addTwoNumbers(self, l1, l2):
        carry = 0
        root = n = ListNode(0)
        while l1 or l2 or carry:
            if l1:
                carry, l1 = carry + l1.val, l1.next
            if l2:
                carry, l2 = carry + l2.val, l2.next
            carry, sum = divmod(carry, 10)
            n.next = n = ListNode(sum)
            """
            n.next = n = ListNode(sum) equals:
            n.next = ListNode(sum)
            n = n.next
            because
                n.next = n = ListNode(val) means first n.next = ListNode(val) then n point to the same address
                n = n.next = ListNode(val) means first n = ListNode(val) ,
                now the n is ListNode(val), then n.next point to the address
                ListNode(val) which means point to itself!!!
            """
        return root.next
