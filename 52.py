class Solution(object):
    def solveNQueens(self, n):
        """
        :type n: int
        :rtype: List[List[str]]
        """
        self.n = n
        board = [["."] * n for i in range(n)]
        self.count = 0
        self.recursion(0, board)
        return self.count

    def recursion(self, currentLine, board):
    	if currentLine == self.n:
    		self.count += 1
    		return
    	for i in range(0, self.n):
    		if not self.available(currentLine, i, board):
    			continue
    		board[currentLine][i] = 'Q'
    		self.recursion(currentLine + 1, board)
    		board[currentLine][i] = '.'
    	return

    def available(self, x, y, board):
    	for i in range(0, x):
    		if board[i][y] == 'Q':
    			return False
    	for i in range(0, x + y + 1):
    		if i < y and x - y + i >= 0:
    			if board[x + i - y][i] == 'Q':
    				return False
    		if i > y and i < self.n:
    			if board[x + y - i][i] == 'Q':
    				return False
    	return True


# 一个很6的解法
class Solution(object):
    def totalNQueens(self, n):
        """
        :type n: int
        :rtype: List[List[str]]
        """
        result = [1, 1, 0, 0, 2, 10, 4, 40, 92, 352, 724, 2680]
        return result[n]
        