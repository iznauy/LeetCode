class Solution(object):
    def generateMatrix(self, n):
        """
        :type n: int
        :rtype: List[List[int]]
        """
        self.matrix = [[0] * n for i in range(n)] #init
        self.index = 1
        self.recursion(0, 0, n - 1, n - 1)
        return self.matrix

    def recursion(self, left, top, right, down):
    	while left <= right and top <= down:
    		if left == right:
    			for i in range(top, down + 1):
    				self.matrix[i][left] = self.index
    				self.index += 1
    			return
    		elif top == down:
    			for i in range(left, right + 1):
    				self.matrix[top][i] = self.index
    				self.index += 1
    			return
    		else:
    			for i in range(left, right):
    				self.matrix[top][i] = self.index
    				self.index += 1
    			for i in range(top, down):
    				self.matrix[i][right] = self.index
    				self.index += 1
    			for i in range(right, left, -1):
    				self.matrix[down][i] = self.index
    				self.index += 1
    			for i in range(down, top, -1):
    				self.matrix[i][left] = self.index
    				self.index += 1
    			left +=1
    			right -= 1
    			top += 1
    			down -= 1
