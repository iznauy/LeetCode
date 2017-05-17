class Solution(object): # O(n)
    def decodeString(self, s):
        st, s = [], s.encode('ascii')
        for x in s:
            if x == ']':
                p = st.pop()
                st.pop()
                p = int(st.pop()) * p
                while len(st) and str.isalpha(st[-1]):
                    p = ''.join([st.pop(), p])
                st.append(p)
            elif str.isdigit(x):
                if len(st) and str.isdigit(st[-1]):
                    st.append(''.join([st.pop(), x]))
                else:
                    st.append(x)
            elif str.isalpha(x):
                if len(st) and str.isalpha(st[-1]):
                    st.append(''.join([st.pop(), x]))
                else:
                    st.append(x)
            else:
                st.append(x)
        return st[0]
