import java.util.*;


class TreeNode{
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x){
		this.val = x;
	} 
}

class NodeData{
	double sum;
	double average;
	int count;

	NodeData(double sum, double average, int count){
		this.sum = sum;
		this.average = average;
		this.count = count;
	}
}




public class isAllAverage{


	static boolean isAllAverage = true;


// https://stackoverflow.com/questions/2559527/non-static-variable-cannot-be-referenced-from-a-static-context
	static TreeNode buildTree(int[] arr){
		TreeNode root = new TreeNode(arr[0]);
		Deque<TreeNode> q = new ArrayDeque<>();

		q.addFirst(root);
		int idx = 1;
		while(!q.isEmpty()){
			int size = q.size();

			for(int i = 0; i < size; i++){
				TreeNode cur = q.pollLast();
				if(idx < arr.length - 1){
					cur.left = new TreeNode(arr[idx]);
					q.addFirst(cur.left);
					idx+= 1;
					cur.right = new TreeNode(arr[idx++]);
					q.addFirst(cur.right);
				}
				
			}
		}
		return root;

	}



	static boolean check(TreeNode root){
		NodeData node = dfs(root);
		return isAllAverage;
	}


	static NodeData dfs(TreeNode node){
		if(node == null){
			return new NodeData(0.0,0.0,0);
		}


		NodeData leftNode = dfs(node.left);
		NodeData rightNode = dfs(node.right);

		double curSubAverage = 0.0;
		if(leftNode.count != 0 || rightNode.count != 0){
			curSubAverage = (leftNode.sum + rightNode.sum) / (leftNode.count + rightNode.count);
			if(curSubAverage != node.val){
				System.out.println(curSubAverage + node.val);
				isAllAverage = false;
			}
		}

		double curNodeSum = leftNode.sum + rightNode.sum + node.val;
		int curCount = leftNode.count + rightNode.count + 1;

		return new NodeData(curNodeSum, curSubAverage, curCount);


	}

	public static void main(String[] args){
		int[] arr = new int[]{2,2,2,2, 1,3};

		
		TreeNode root = buildTree(arr);

		// System.out.println(root.val);
		// System.out.println(root.left.val);
		// System.out.println(root.right.val);

		boolean res = check(root);

		System.out.println(res);





	}
}