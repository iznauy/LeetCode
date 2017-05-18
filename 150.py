class Solution(object):
    def evalRPN(self, tokens):
        """
        :type tokens: List[str]
        :rtype: int
        """
        st, signs = [], "+-*/"
        for t in tokens:
            if t in signs:
                b, a = st.pop(), st.pop()
                if t == '+':
                    st.append(a + b)
                elif t == '-':
                    st.append(a - b)
                elif t == '*':
                    st.append(a * b)
                else:
                    st.append(int(float(a) / b))
            else:
                st.append(int(t))
        return st[-1]
