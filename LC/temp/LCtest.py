# -*- coding: UTF-8 -*-
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None
from collections import deque
from collections import defaultdict
import collections
class Solution:
    def verticalOrder(self, root) :
        """
                  0
            /             \
          -1                 1
      /       \            /     \
    -2         0          0        2
    /  \      /  \      /   \     /   \
  -3  -2    -1    1    -1     1   1    3
  / \ / \   / \  / \   / \   / \  / \  / \
-4 -3-3 -2 -2 -1 0  2 -2  0 0   2 0  2 2  4

        """
        if root is None: return[]
        q = deque([(root,0)]) # (n0,0)
        d = defaultdict()
        minimum = 0
        while q:
            n,l = q.popleft() # n=n0,l=0; n= n1,l=-1
            if l < minimum:
                minimum = l
            if l not in d:# d[0]=[n0] d[-1] =n1
                d[l] = [n.val]
            else:
                d[l].append(n.val)
            if n.left:       #n1 
                q.append((n.left,l-1)) #(n1,-1)
            if n.right:#n2
                q.append((n.right,l+1))#(n2,1)


        res = []
        level = minimum
        while level in d:
            res.append(d[level])
            level += 1
        return res



S = [('a', 1), ('a',2), ('b',3),('b',4),('c',1)]
d=collections.defaultdict(list)
for k, v, in S:
	d[k].append(v)
# print (list(d.items())) #[('a', [1, 2]), ('c', [1]), ('b', [3, 4])]



order = "hlabcdefgijkmnopqrstuvwxyz"
order_index = {c: i for i, c in enumerate(order)}
# print (order_index)
index={b:d for b,d in enumerate(order)}
print (index)

print ("==========")
print(order_index)






