class Solution(object):
    def solveNQueens(self, n):
        """
        :type n: int
        :rtype: List[List[str]]
        """
        self.n = n
        board = [["."] * n for i in range(n)]
        self.result = []
        self.recursion(0, board)
        return self.result

    def recursion(self, currentLine, board):
    	if currentLine == self.n:
    		self.result.append(["".join(x) for x in board])
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


