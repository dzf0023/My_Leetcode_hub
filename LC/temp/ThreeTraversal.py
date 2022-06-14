class TreeNode(object):
	"""docstring for TreeNode"""
	def __init__(self, x):
		self.val = x
		self.left = None
		self.right = None
		


def preorderTraversal(root):
	res, stack = [],[]
	stack.append(root)
	while stack:
		cur = stack.pop()
		if cur:
			res.append(cur.val)
			stack.append(cur.right)
			stack.append(cur.left)

	return res

def inorderTraversal(root):
	stack = []
	current = root
	res = []
	done = 1
	while done:
		if current:
			stack.append(current)
			current = current.left
		else:
			if stack:
				node= stack.pop()
				current = node.right
				res.append(node.val)
			else:
				done = 0
	return res

def postTraversal(root):
	stack = [root]
	stack1=[]
	res = []
	while stack:
		node = stack.pop()
		if not node:
			continue
		res.append(node.val)
		stack.append(node.left)
		stack.append(node.right)
	while res:
		stack2.append(res.pop())
	return stack2




def postorderTraversal(root):
    """
    :type root: TreeNode
    :rtype: List[int]
    """
    stack, res = [], []
    while root or stack:
        if root:
            res.insert(0, root.val)
            stack.append(root)
            root = root.right
        else:
            node = stack.pop()
            root = node.left
    return res




def postorder_helper(self, root, val_list):
    if not root:
        return
    if not root.left and not root.right:
        val_list.append(root.val)
        return
    self.postorder_helper(root.left, val_list)
    self.postorder_helper(root.right, val_list)
    val_list.append(root.val)
    return
    
def postorderTraversal(self, root):
    """
    :type root: TreeNode
    :rtype: List[int]
    """
    result_list = []
    self.postorder_helper(root, result_list)
    return result_list
