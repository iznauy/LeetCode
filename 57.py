# Definition for an interval.
class Interval(object):
    def __init__(self, s=0, e=0):
        self.start = s
        self.end = e

class Solution(object):
    def insert(self, intervals, newInterval):
        """
        :type intervals: List[Interval]
        :type newInterval: Interval
        :rtype: List[Interval]
        """
        if len(intervals) == 0:
        	return [newInterval]
        result = []
        for interval in intervals:
        	if newInterval != None:
        		if interval.start <= newInterval.start:
        			result.append(interval)
        			continue
        		else:
        			if len(result) == 0 or result[-1].end < newInterval.start:
        				result.append(newInterval)
        			else:
        				result[-1].end = max(result[-1].end, newInterval.end)
        			newInterval = None
        	if interval.start <= result[-1].end:
        		result[-1].end = max(result[-1].end, interval.end)
        	else:
        		result.append(interval)
        if newInterval != None:
        	if result[-1].end < newInterval.start:
        		result.append(newInterval)
        	else:
        		result[-1].end = max(result[-1].end, newInterval.end)
        return result