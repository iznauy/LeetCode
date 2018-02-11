class Solution(object): # 和最好的答案差了大概8倍 应该是剪枝不到位 复杂度是O(n^3)
    def fourSum(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[List[int]]
        """
        res = []
        nums.sort()
        for i in range(len(nums) - 3):
        	if i > 0 and nums[i - 1] == nums[i]:
        		continue
        	if target < nums[i] * 4:
        		return res
        	for j in range(i + 1, len(nums) - 2):
        		if target < nums[i] + nums[j] * 3:
        			break
        		if j != i + 1 and nums[j] == nums[j - 1]:
        			continue
        		l, r = j + 1, len(nums) - 1
        		while l < r:
        			s = nums[i] + nums[j] + nums[l] + nums[r]
        			if s < target:
        				l += 1
        			elif s > target:
        				r -= 1
        			else:
        				res.append([nums[i], nums[j], nums[l], nums[r]])
        				while l < r and nums[l] == nums[l + 1]:
        					l += 1
        				while l < r and nums[r] == nums[r - 1]:
        					r -= 1
        				l, r = l + 1, r - 1

        return res