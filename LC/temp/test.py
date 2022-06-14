

# preorder to inorder



def preorder(node):
    vals = []
    if node:
        vals.append(str(node.val))
        preorder(node.left)
        preorder(node.right)
    preorder(root)
    return ' '.join(vals)

def deserialize(data):
    preorder = map(int, data.split())
    inorder = sorted(preorder)
    return self.buildTree(preorder, inorder)
# data = '1 2 3 4 5'
# res = map(int, data.split())
# print (res)


dp = [[5] * (3) for _ in range(4)]
print(dp)









prerequisites = [[1,0],[2,0],[3,1],[3,2]] 

import collections
neigh = collections.defaultdict(set)
dic = {i: set() for i in range(5)}
for i, j in prerequisites:
    dic[i].add(j)
    neigh[j].add(i)

queue = collections.deque([i for i in dic if not dic[i]])

# print(dic)
# print(neigh)
# print(queue)



