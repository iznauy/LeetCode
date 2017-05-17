class Solution(object): # my O(n)
    def isValidSerialization(self, preorder):
        pt = preorder.split(',')
        trees = []
        while len(pt):
            p = pt.pop()
            if p != '#':
                if len(trees) < 2:
                    return False
                trees.pop()
                trees.pop()
            trees.append(p)
        if len(trees) == 1:
            return True
        else:
            return False

class OthersExcellentSolution(object):
    def isValidSerialization(self, preorder):
        p = preorder.split(',')
        slot = 1
        for node in p:
            if slot == 0:
                return False
            elif node == '#':
                slot -= 1
            else:
                slort += 1
        return slot == 0

class WrongSolution(object):
    def isValidSerialization(self, preorder):
        """
        :type preorder: str
        :rtype: bool
        """
        pt = preorder.encode('ascii').split(',')
        trees = []
        if len(pt) == 0 or len(list(x for x in pt if x == '#')) * 2 != len(pt) + 1\
            or pt[-1] != '#' or pt[0] == '#':
            return False
        while len(pt):
            print trees
            a = pt.pop()
            if a == '#':
                b = pt.pop()
                if b == '#':
                    c = pt.pop()
                    if c == '#':
                        return False
                    else:
                        trees.append(c)
                else:
                    if len(trees) == 0:
                        return False
                    else:
                        trees.pop()
                        trees.append(b)
            else:
                if len(trees) < 2:
                    return False
                else:
                    trees.pop()
                    trees.pop()
                    trees.append(a)
        if len(trees) == 1:
            return True
        
