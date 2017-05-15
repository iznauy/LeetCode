class Solution(object):
    def complexNumberMultiply(self, a, b):
        """
        :type a: str
        :type b: str
        :rtype: str
        """
        a, b = a.split('+'), b.split('+')
        a1, a2 = int(a[0]), int(a[1][0:-1])
        b1, b2 = int(b[0]), int(b[1][0:-1])
        r1 = a1 * b1 - a2 * b2
        r2 = a1 * b2 + a2 * b1
        return str(r1) + '+' + str(r2) + 'i'

class Solution1(object):
    def complexNumberMultiply(self, a, b):
        a1, a2 = map(int, a[:-1].split('+'))
        b1, b2 = map(int, b[:-1].split('+'))
        return '{}+{}i'.format(a1 * b1 - a2 * b2, a1 * b2 + a2 * b1)

    
