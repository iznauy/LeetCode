class Solution(object):
    def threeSumClosest(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: int
        """
        result = nums[0] + nums[1] + nums[2]
        deviate = abs(result - target)
        print result, deviate
        nums.sort()
        print nums
        for i in range(len(nums)-2):
            l, r = i + 1, len(nums) - 1
            while l < r:
                print i, l, r
                temp = nums[i] + nums[l] + nums[r]
                print temp
                temp_deviate = abs(temp - target)
                print temp_deviate
                if temp == target:
                    return target
                elif temp < target:
                    if temp_deviate < deviate:
                        result = temp
                        deviate = temp_deviate
                    l += 1
                elif temp > target:
                    if temp_deviate < deviate:
                        result = temp
                        deviate = temp_deviate
                    r -= 1
        return result
                    
