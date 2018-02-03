class Solution(object):
	# 依靠剪枝暴力水过
    def badMaxArea(self, height):
        """
        :type height: List[int]
        :rtype: int
        """
        m, pre = 0, 0
        for i in range(len(height) - 1):
        	if pre < height[i]:
        		interval = max(1, m / (1 + height[i]))
        		for j in range(i + interval, len(height)):
        			m = max(m, (j - i) * min(height[i], height[j]))
        	pre = height[i]
        return m

    #标准答案
    def maxArea(self, height):
    	"""
        :type height: List[int]
        :rtype: int
        """
        m, l, r = 0, 0, len(height) - 1
        while l < r:
        	m = max(m, (r - l) * min(height[r], height[l]))
        	if height[r] > height[l]:
        		l += 1
        	else:
        		r -= 1
        return m