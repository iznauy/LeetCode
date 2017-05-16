class MagicSolution(object):
    def find132pattern(self, nums):
        s, st = - float('inf'), []
        for i in range(len(nums) - 1, -1, -1):
            if nums[i] < s:
                return True
            else:
                while st and nums[i] > st[-1]:
                    s = st.pop()
                st.append(nums[i])
        return False



class Solution(object):
    def find132pattern(self, nums):
        st = []
        for x in nums:
            if len(st) == 0 or x < st[-1][0]:
                st.append([x, x])
            elif x > st[-1][0]:
                p = st.pop()
                if x < p[1]:
                    return True
                else:
                    p[1] = x
                    while len(st) != 0 and x >= st[-1][1]:
                        st.pop()
                    if len(st) != 0 and st[-1][0] < x:
                        return True
                    st.append(p)
        return False

class AnotherWrongSolution(object):
    def find132pattern(self, nums):
        if len(nums) < 3:
            return False
        st = [nums[0]]
        for x in nums:
            print st
            if len(st) == 1:
                if st[0] >= x:
                    st[0] = x
                else:
                    st.append(x)
                continue
            if len(st) % 2 == 0:
                eq = False
                for i in range(0, len(st), 2):
                    if st[i] < x < st[i+1]:
                        return True
                    elif st[i] == x or st[i+1] == x:
                        eq = True
                        break
                if not eq:
                    st.append(x)
            else:
                eq = False
                for i in range(0, len(st) - 1, 2):
                    if st[i] < x < st[i+1]:
                        return True
                    elif st[i] == x or st[i+1] == x:
                        eq = True
                        break
                if not eq:
                    if st[-1] > x:
                        st[-1] = x
                    elif st[-1] < x:
                        st.append(x)
        return False
                        

class WrongSolution(object):
    def find132pattern(self, nums):
        """
        :type nums: List[int]
        :rtype: bool
        """
        if len(nums) < 3:
            return False
        st = [nums[0]]
        a, b, w = nums[0], nums[0], True
        for x in nums:
            print x
            print st
            if len(st) == 1:
                print 'in while'
                if st[0] >= x:
                    st[0] = x
                else:
                    st.append(x)
                    a, b = st[0], st[1]
                continue
            if w:
                print 'in w'
                print a, b, x
                if x >= b:
                    st[-1] = x
                    b = x
                elif x < a:
                    st.append(x)
                    w = False
                elif x == a:
                    continue
                else:
                    return True
            else:
                if x < st[-1]:
                    st[-1] = x
                elif x >= b:
                    st.append(x)
                    a, b, w = st[-2], st[-1], True
                elif st[-1] <= x <= a:
                    continue
                else:
                    return True
        return False
