class MyQueue(object):

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self._data, self._stack = [], []
        

    def push(self, x):
        """
        Push element x to the back of queue.
        :type x: int
        :rtype: void
        """
        self._data.append(x)
        

    def pop(self):
        """
        Removes the element from in front of queue and returns that element.
        :rtype: int
        """
        for i in range(len(self._data)):
            self._stack.append(self._data.pop())
        d = self._stack.pop()
        for i in range(len(self._stack)):
            self._data.append(self._stack.pop())
        return d
        
        

    def peek(self):
        """
        Get the front element.
        :rtype: int
        """
        for i in range(len(self._data)):
            self._stack.append(self._data.pop())
        d = self._stack.pop()
        self._data.append(d)
        for i in range(len(self._stack)):
            self._data.append(self._stack.pop())
        return d
        

    def empty(self):
        """
        Returns whether the queue is empty.
        :rtype: bool
        """
        return len(self._data) == 0
        


# Your MyQueue object will be instantiated and called as such:
# obj = MyQueue()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.peek()
# param_4 = obj.empty()
