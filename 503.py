class Solution(object):# i was originally just wrong a bit..
    def nextGreaterElements(self, nums):
        """
        :type nums: List[int]
        :rtype: List[int]
        """
        nums *= 2
        st, ans = [], [-1] * (len(nums) / 2)
        for i in range(len(nums)):
            while len(st) and nums[st[-1]] < nums[i]:
                t = st.pop()
                if t < len(nums) / 2:
                    ans[t] = nums[i]
            st.append(i)
        return ans

class WrongSolution1(object): # if without duplication, this is a right answer
    def nextGreaterElements(self, nums):
        """
        :type nums: List[int]
        :rtype: List[int]
        """
        st, ans, d = [], [], {}
        nums *= 2
        for x in nums:
            while len(st) and st[-1] < x:
                t = st.pop()
                if d.get(t, -1) == -1:
                    d[t] = x
            st.append(x)
        for i in range(len(nums) / 2):
            ans.append(d.get(nums[i], -1))
        return ans


class TLESolution(object):
    def nextGreaterElements(self, nums):
        """
        :type nums: List[int]
        :rtype: List[int]
        """
        ans = []
        for i in range(len(nums)):
            for j in range(i+1, i+len(nums)):
                if nums[j % len(nums)] > nums[i]:
                    ans.append(nums[j % len(nums)])
                    break
            if len(ans) == i:
                ans.append(-1)
        return ans

class WrongSolution0(object):
    def nextGreaterElements(self, nums):
        """
        :type nums: List[int]
        :rtype: List[int]
        """
        ans, d, st1, st2 = [], {}, [], []
        for x in nums:
            while len(st1) and st1[-1] < x:
                d[st1.pop()] = x
            st1.append(x)
        nums.reverse()
        for x in nums:
            print nums
            while len(st2) and st2[-1] < x:
                d[st2.pop()] = x if d.get(st2[-1], -1) == -1 else d[st2[-1]]
            st2.append(x)
        nums.reverse()
        for i in nums:
            ans.append(d.get(i, -1))
        return ans
