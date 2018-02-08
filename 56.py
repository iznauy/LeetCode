# Definition for an interval.
class Interval(object):
    def __init__(self, s=0, e=0):
        self.start = s
        self.end = e

class Solution(object):
    def merge(self, intervals):
        """
        :type intervals: List[Interval]
        :rtype: List[Interval]
        """
        if len(intervals) == 0:
        	return []
    	intervals = sorted(intervals, key=lambda x: x.start)
    	result = [intervals[0]]
    	for interval in intervals[1:]:
    		current = result[-1]
    		if current.end >= interval.start:
    			current.end = max(current.end, interval.end)
    		else:
    			result.append(interval)
    	return result

