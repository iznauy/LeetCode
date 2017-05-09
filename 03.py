class Solution(object): #I need to learn KMP... O(n) 
    def lengthOfLongestSubstring(self, s):
        """
        :type s: str
        :rtype: int
        """
        if s == '':
            return 0
        maxL = p = e = 0
        buff = dict()
        for p in range(len(s)):
            if s[p] in buff and buff[s[p]] >= e:
                maxL = max(maxL, p-e)
                e = buff[s[p]] + 1
            buff[s[p]] = p
        return max(p-e+1, maxL)

class FailedSolution(object):# O(n^2) very bad
    def lengthOfLongestSubstring(self, s):
        length = p = 0
        while p < len(s):
            buff = dict()
            for i in range(p, len(s)):
                if s[i] in buff:
                    p = buff[s[i]]
                    break
                else:
                    buff[s[i]] = p
            length = max(len(buff), length)
            p += 1
        return length
