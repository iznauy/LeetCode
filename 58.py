class Solution(object):
    def lengthOfLastWord(self, s):
        """
        :type s: str
        :rtype: int
        """
        lst = s.strip().split(" ")
        return 0 if len(lst) == 0 else len(lst[-1])