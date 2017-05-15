class Solution(object):
    def isValid(self, s):
        """
        :type s: str
        :rtype: bool
        """
        lst = []
        sign = "(){}[]"
        frontsign = '([{'
        match = {')':'(', '}':'{', ']':'['}
        for i in range(len(s)):
            if s[i] in sign:
                if s[i] in frontsign:
                    lst.append(s[i])
                else:
                    if len(lst) < 1 or match[s[i]] != lst.pop():
                        return False
        if len(lst) == 0:
            return True
        else:
            return False
        
