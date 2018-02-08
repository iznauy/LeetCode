# Definition for a binary tree node.
class TreeNode(object):
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

class Solution(object):
    def isValidBST(self, root):
        """
        :type root: TreeNode
        :rtype: bool
        """
        def getMax(root):
        	while root.right:
        		root = root.right
        	return root.val

        def getMin(root):
        	while root.left:
        		root = root.left
        	return root.val

        def valid(root):
        	if root is None:
        		return True
        	if root.left:
        		if not valid(root.left) or getMax(root.left) >= root.val:
        			return False
        	if root.right:
        		if not valid(root.right) or getMin(root.right) <= root.val:
        			return False
        	return True

        return valid(root)
        		