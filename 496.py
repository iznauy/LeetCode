class Solution(object): #O(n)
    def nextGreaterElement(self, findNums, nums):
        d, st, ans = {}, [], []
        for x in nums:
            while len(st) and st[-1] < x:
                d[st.pop()] = x
            st.append(x)
        for x in findNums:
            ans.append(d.get(x, -1))
        return ans

class MyBadSolution(object): # O(n^2)
    def nextGreaterElement(self, findNums, nums):
        """
        :type findNums: List[int]
        :type nums: List[int]
        :rtype: List[int]
        """
        result = []
        for i in range(len(findNums)):
            for j in range(len(nums)):
                if nums[j] != findNums[i]:
                    continue
                else:
                    r = -1
                    for k in range(j+1, len(nums)):
                        if nums[k] > nums[j]:
                            r = nums[k]
                            break
                    result.append(r)
                    break
        return result

