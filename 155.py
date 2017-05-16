class MinStack(object):

    def __init__(self):
        """
        initialize your data structure here.
        """
        self._data = []
        self._min = None

    def push(self, x):
        """
        :type x: int
        :rtype: void
        """
        self._data.append(x)
        if self._min is None or self._min > x:
            self._min = x
        

    def pop(self):
        """
        :rtype: void
        """
        d = self._data.pop()
        self._min = min(self._data) if len(self._data) > 0 else None
        

    def top(self):
        """
        :rtype: int
        """
        return self._data[-1]


    def getMin(self):
        """
        :rtype: int
        """
        return self._min


# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(x)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()
