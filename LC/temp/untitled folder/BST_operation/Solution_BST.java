public class TreeNode{
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) {val = x;}
}


class Solution_BST{
	public int successor(TreeNode root){
		root = root.right;
		while(root.left != null) root = root.left;
		return root.val;
	}

	public int predecessor(TreeNode root){
		root = root.left;
		while(root.right != null) root = root.right;
		return root.val;
	}

	public TreeNode deleteNode(TreeNode root, int key){
		if(root == null) return null;

		if(key > root.val) root.right = deleteNode(root.right, key);
		else if(key < root.val) root.left = deleteNode(root.left, key);
		else{
			if(root.left == null && root.right == null) root = null;
			else if(root.left != null){
				root.val = predecessor(root);
				root.left = deleteNode(root.left, root.val);
			}else{
				root.val = successor(root);
				root.right = deleteNode(root.right, root.val);
			}
		}
		return root;
	}
//  no duplicate
	public TreeNode insertNodeBST(TreeNode root, int val){
		TreeNode node = root;
		while(node != null){
			if(val > node.val){
				if(node.right == null){
					node.right = new TreeNode(val);
					return root;
				}
				else node = node.right;
			}else{
				if(node.left == null){
					node.left = new TreeNode(val);
					return root;
				}
				else{
					node = node.left;
				}
			}
		}
		return new TreeNode(val);    //  not return root, since if root == null,  we just return new node 
	}


	public TreeNode searchBST(TreeNode root, int val){
		while(root != null && val != root.val){
			root = val < root.val ? root.left : root.right;
		}
		return root;
	}



}