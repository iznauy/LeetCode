class Solution(object): # O(n)
    def removeKdigits(self, num, k):
        out = []
        for d in num:
            while k and out and out[-1] > d:
                out.pop()
                k -= 1
            out.append(d)
        return ''.join(out[: -k or None]).lstrip('0') or '0'

class TLESolution(object): # O(m * n)
    def removeKdigits(self, num, k):
        """
        :type num: str
        :type k: int
        :rtype: str
        """
        if len(num) == k:
            return "0"
        st, i = [], 0
        while i < len(num) - k:
            m, n = 9, i
            for j in range(i, i+k+1):
                if int(num[j]) < m:
                    m, n = int(num[j]), j
            if len(st) != 0 or m != 0:
               st.append(m)
            k = k - n + i
            i = n + 1
        ans = ''
        for x in st:
            ans += str(x)
        return ans if ans != '' else '0'
