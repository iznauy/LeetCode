class Solution(object):
    def isPalindrome(self, x):
        """
        :type x: int
        :rtype: bool
        """
        if x < 0:
            return False
        
        t = 1
        while x / t >= 10:
            t *= 10
        p = t    
        while True:
            if t * t <= p:
                return True
            else:
                left = (x / t) % 10
                right = (x % (p * 10 / t)) / (p / t)
                if left != right:
                    return False
                t /= 10

class Solution1(object): # don't allow
    def isPalindrome(self, s):
        return str(s) == str(s)[::-1]


class Solution2(object):
    def isPalindrome(self, x):
        if x < 0 or (x != 0 and x % 10 == 0): # necessary
            return False
        else:
            t = 0
            while x > t:
                t = 10 * t + x % 10
                x /= 10
            return x == t or x == (t / 10) 
