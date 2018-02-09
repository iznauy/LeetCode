class Solution(object):
    def getPermutation(self, n, k):
        """
        :type n: int
        :type k: int
        :rtype: str
        """
        result = []
        dic = [0] * 10
        
        def recursion(n, current, k, result, dic):
        	if current == 0:
        		return
        	for i in range(1, n + 1):
        		if dic[i] == 1:
        			continue
        		if k >= 1 and k <= math.factorial(current - 1):
        			dic[i] = 1
        			result.append(str(i))
        			recursion(n, current - 1, k, result, dic)
        			return
        		else:
        			k -= math.factorial(current - 1)

        recursion(n, n, k, result, dic)
        return "".join(result)
