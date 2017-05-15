# O(n^2)
class Solution(object):
    def canJump(self, nums):
        nums[-1] = 1
        if nums[0] == 0 and len(nums) > 1:
            return False
        for i in range(1, len(nums) - 1):
            if nums[i] == 0 and nums[i+1] != 0:
                for j in range(i-1, -1, -1):
                    nums[-1] = 0
                    if nums[j] > i - j:
                        nums[-1] = 1
                        break
                if nums[-1] == 0:
                    return False
        return True
                        
class MyOriginalSolution(object): # exceed 98.05%
    def canJump(self, nums):
        if len(nums) == 1:
            return True
        elif nums[0] == 0:
            return False
        a, s = 0, -1
        for i in range(len(nums)):
            if nums[i] == 0:
                if s == -1:
                    a, s = 1, i - 1
                else:
                    a += 1
            else:
                if s >= 0:
                    for j in range(s, -1, -1):
                        a += 1
                        if nums[j] > a - 1:
                            a, s = 0, -1
                    if a != 0:
                        return False
                else:
                    a, s = 0, -1
        if s >= 0:
            for i in range(s, -1, -1):
                a += 1
                if nums[i] > a - 2:
                    a, s = 0, -1
            if a != 0:
                return False
        return True
                            
                    

class MyTLESolution(object):
    def canJump(self, nums):
        """
        :type nums: List[int]
        :rtype: bool
        """
        hasExp = [0] * len(nums)
        def canJ(start):
            if nums[start] >= len(nums) - start - 1 or start == len(nums) - 1:
                return True
            else:
                for i in range(1, nums[start] + 1):
                    if hasExp[start+i] == 0:
                        hasExp[start+i] = canJ(start+i)
                    if hasExp[start+i]:
                        return True
                return False
        return canJ(0)


# really NB, i am a cai ji
# O(n)
class GreatestSolutions(object):
    def canJumps1(self, nums):
        n = 0
        for i, j in enumerate(nums):
            if i > m:
                return False
            n = max(n, i + j)
        return True

    # difficult to understand
    def canJumps2(self, nums): 
        return reduce(lambda n, (i, j): max(n, i + j) * (i <= m), enumerate(nums, 1), 1) > 0

    def canJump3(self, nums):
        goal = len(nums) - 1
        for i in range(len(nums))[::-1]:
            if i + nums[i] >= goal:
                goal = i
        return not goal
