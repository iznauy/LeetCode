class Solution(object):
    def isValidSudoku(self, board):
        """
        :type board: List[List[str]]
        :rtype: bool
        """
        for i in range(9):
        	if not self.validCol(board, i) or not self.validRow(board, i):
        		return False
        for i in range(3):
        	for j in range(3):
        		if not self.validBlog(board, i * 3, j * 3):
        			return False
        return True

    def validCol(self, board, j):
    	s = [0] * 10
    	for i in range(9):
    		if board[i][j] != '.':
    			c = int(board[i][j])
    			if s[c] > 0:
    				return False
    			else:
    				s[c] = 1
    	return True

    def validRow(self, board, i):
    	s = [0] * 10
    	for j in range(9):
    		if board[i][j] != '.':
    			c = int(board[i][j])
    			if s[c] > 0:
    				return False
    			else:
    				s[c] = 1
    	return True

    def validBlog(self, board, x, y):
    	s = [0] * 10
    	for i in range(x, x + 3):
    		for j in range(y, y + 3):
    			if board[i][j] != '.':
    				c = int(board[i][j])
    				if s[c] > 0:
    					return False
    				else:
    					s[c] = 1
    	return True
