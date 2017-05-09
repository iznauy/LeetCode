class FailedSolution1(object):
    def longestPalindrome(self, s):
        if s == '':
            return None
        palSub = s[0]
        for i in range(len(s)):
            for j in range(i+1, len(s)):
                if j <= i + len(palSub) - 1:
                    continue
                isSame = True
                for k in range(i, (i+j+1)/2):
                    if s[k] != s[j+i-k]:
                        isSame = False
                        break
                if isSame:
                    palSub = s[i:j+1]
        return palSub
# O(n^3) readlly horrible
# i cann't do it in expected time, so i found some possible solutions
class Solution:
    def longestPalindrome(self, s):
        if len(s) == 0:
            return 0
        maxLen = 1
        start = 0
        for i in range(len(s)):
            if maxLen + 1 <= i and s[i-maxLen-1:i+1] == s[i-maxLen-1:i+1][::-1]:
                start = i - maxLen - 1
                maxLen += 2
                continue
            if maxLen <= i and s[i-maxLen:i+1] == s[i-maxLen:i+1][::-1]:
                start = i - maxLen
                maxLen += 1
        return s[start:start+maxLen]
