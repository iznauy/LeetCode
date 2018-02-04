class Solution(object):
    def combinationSum(self, candidates, target):
        """
        :type candidates: List[int]
        :type target: int
        :rtype: List[List[int]]
        """
        self.lens = len(candidates)
        if self.lens == 0:
        	return []
        candidates.sort(reverse=True)
        self.candidates = candidates
        self.result = []
        self.recursive(0, [], target)
        return self.result

     def recursive(self, index, current, last):
     	if last == 0:
     		self.result.append(current)
     	while index < self.lens and self.candidates[index] > last:
     		index += 1
     	if index == self.lens:
     		return
     	
     	sub1 = current[:]
     	sub1.append(self.candidates[index])
     	self.recursive(index, sub1, last - self.candidates[index])

     	sub2 = current[:]
     	self.recursive(index + 1, sub2, last)
