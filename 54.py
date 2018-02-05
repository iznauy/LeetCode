class Solution(object):
    def spiralOrder(self, matrix):
        """
        :type matrix: List[List[int]]
        :rtype: List[int]
        """
        if len(matrix) == 0:
            return []
        self.result = []
        self.matrix = matrix
        self.recursion(0, 0, len(self.matrix[0]) - 1, len(self.matrix) - 1)
        return self.result

    def recursion(self, left, top, right, down):
    	while left <= right and top <= down:
    		if left == right:
    			for i in range(top, down + 1):
    				self.result.append(self.matrix[i][left])
    			return
    		elif top == down:
    			for i in range(left, right + 1):
    				self.result.append(self.matrix[top][i])
    			return
    		else:
    			for i in range(left, right):
    				self.result.append(self.matrix[top][i])
    			for i in range(top, down):
    				self.result.append(self.matrix[i][right])
    			for i in range(right, left, -1):
    				self.result.append(self.matrix[down][i])
    			for i in range(down, top, -1):
    				self.result.append(self.matrix[i][left])
    			left +=1
    			right -= 1
    			top += 1
    			down -= 1