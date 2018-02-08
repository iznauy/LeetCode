class Solution(object):
    def uniquePathsWithObstacles(self, obstacleGrid):
        """
        :type obstacleGrid: List[List[int]]
        :rtype: int
        """
        m, n = len(obstacleGrid), len(obstacleGrid[0])
        vec = [[0] * (n + 1) for i in range(m + 1)]
        vec[0][1] = 1
        for i in range(1, m + 1):
        	for j in range(1, n + 1):
        		if obstacleGrid[i - 1][j - 1] == 1:
        			vec[i][j] = 0
        		else:
        			vec[i][j] = vec[i - 1][j] + vec[i][j - 1]
        return vec[m][n]

class Solution(object):
    def uniquePathsWithObstacles(self, obstacleGrid):
        """
        :type obstacleGrid: List[List[int]]
        :rtype: int
        """
        m, n = len(obstacleGrid), len(obstacleGrid[0])
        vec = [0] * n
        vec[0] = 1
        for i in range(m):
        	if obstacleGrid[i][0] == 1:
        		vec[0] = 0
        	for j in range(1, n):
        		if obstacleGrid[i][j] == 1:
        			vec[j] = 0
        		else:
        			vec[j] += vec[j - 1]
        return vec[-1]