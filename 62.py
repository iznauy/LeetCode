class Solution(object):
    def uniquePaths(self, m, n):
        """
        :type m: int
        :type n: int
        :rtype: int
        """
        result = [[0] * n for i in range(m)]
        result[0] = [1] * n
        for i in range(1, m):
        	for j in range(n):
        		if j == 0:
        			result[i][j] = result[i - 1][j]
        		else:
        			result[i][j] = result[i - 1][j] + result[i][j - 1]
        return result[m - 1][n - 1]


# 空间开销更少的算法
class Solution(object):
    def uniquePaths(self, m, n):
        """
        :type m: int
        :type n: int
        :rtype: int
        """
        result = [1] * n # 每个元素的值只需要他左边和上边进行计算，因此可以复用
        for i in range(1, m):
        	for j in range(1, n):
        		result[j] += result[j - 1]
        return result[-1]


# 纯数学解法
class Solution(object):
    def uniquePaths(self, m, n):
        """
        :type m: int
        :type n: int
        :rtype: int
        """
        return math.factorial(m + n - 2) / math.factorial(n - 1) / math.factorial(m - 1)