class Solution(object):
    def convert(self, s, numRows):
        """
        :type s: str
        :type numRows: int
        :rtype: str
        """
        if numRows == 1:
        	return s
        lines = ["" for i in range(numRows)]
        i = 0
        while i < len(s):
        	j = i % (2 * numRows - 2)
        	if j >= numRows:
        		j = numRows - (j - numRows) - 2
        	lines[j] += s[i]
        	i += 1
        return "".join(lines)