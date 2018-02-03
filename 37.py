class Solution(object):
    def solveSudoku(self, board):
        """
        :type board: List[List[str]]
        :rtype: void Do not return anything, modify board in-place instead.
        """
        self.unsolved = []
        for i in range(9):
        	for j in range(9):
        		if board[i][j] == '.':
        		    self.unsolved.append((i, j))

        self.v_blogs = []
        for i in range(3):
        	s = []
        	for j in range(3):
        		v_blog = [x for x in range(1, 10)]
        		for a in range(3 * i, 3 * i + 3):
        			for b in range(3 * j, 3 * j + 3):
        				if board[a][b] != '.':
        					v_blog.remove(int(board[a][b]))
        		s.append(v_blog)
        	self.v_blogs.append(s)

        self.rows = []
        for i in range(9):
        	v_row = [x for x in range(1, 10)]
        	for j in range(9):
        		if board[i][j] != '.':
        			v_row.remove(int(board[i][j]))
        	self.rows.append(v_row)

        self.cols = []
        for j in range(9):
        	v_col = [x for x in range(1, 10)]
        	for i in range(9):
        		if board[i][j] != '.':
        			v_col.remove(int(board[i][j]))
        	self.cols.append(v_col)

        self.solve(board)

    def solve(self, board):
    	if len(self.unsolved) == 0:
    		return True
    	x, y = self.unsolved.pop()
    	b_x, b_y = x / 3, y / 3
    	p1 = self.rows[x]
    	p2 = self.cols[y]
    	p3 = self.v_blogs[b_x][b_y]
    	poss = [t for t in p1 if t in p2 and t in p3]
    	while len(poss) > 0:
    		value = poss.pop()
    		p1.remove(value)
    		p2.remove(value)
    		p3.remove(value)
    		board[x][y] = str(value)
    		if self.solve(board):
    			return True
    		p1.append(value)
    		p2.append(value)
    		p3.append(value)
    		board[x][y] = '.'
    	self.unsolved.append((x, y))
    	return False






