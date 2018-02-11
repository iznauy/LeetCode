class Solution(object):
    def letterCombinations(self, digits):
        """
        :type digits: str
        :rtype: List[str]
        """
        results = []
        ctoi = {2: 'a', 3: 'd', 4: 'g', 5: 'j', 6: 'm', 7: 'p', 8: 't', 9: 'w', 10: chr(ord('z') + 1)}

        def recursion(digits, results, index, current, ctoi):
        	if index == len(digits):
        		if index == 0:
        			return
        		results.append(current)
        	else:
        		num = int(digits[index])
        		for i in range(ord(ctoi[num]), ord(ctoi[num + 1])):
        			recursion(digits, results, index + 1, current + chr(i), ctoi)

        recursion(digits, results, 0, "", ctoi)
        return results

# 围观神技！！！
# 高能预警！！！
class Solution(object):
    def letterCombinations(self, digits):
        """
        :type digits: str
        :rtype: List[str]
        """
        keyMap = {'2':'abc', '3':'def', '4':'ghi', '5':'jkl', '6':'mno', '7':'pqrs', '8':'tuv', '9':'wxyz'}
        if len(digits) == 0:
            return []
        return reduce(lambda acc, digit: [x + y for x in acc for y in keyMap[digit]], digits, [''])
