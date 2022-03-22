class SegmentTreeNode{
	int start; 
	int end;
	int sum;
	SegmentTreeNode left;
	SegmentTreeNode right;

	SegmentTreeNode(int start, int end, int sum){
		this.start = start;
		this.end = end;
		this.sum = sum;

	}

	SegmentTreeNode(int start, int end, int sum, SegmentTreeNode left, SegmentTreeNode right){
		this.start = start;
		this.end = end;
		this.sum = sum;
		this.left = left;
		this.right = right;
	}

}

public class SegmentTree{

	// static SegmentTreeNode root;

	static SegmentTreeNode buildTree(int start, int end, int[] vals){
		if(start == end){
			return new SegmentTreeNode(start, end, vals[start]);
		}

		int mid = start + (end - start) / 2;

		SegmentTreeNode leftNode = buildTree(start, mid, vals);
		SegmentTreeNode rightNode = buildTree(mid+1, end, vals);

		return new SegmentTreeNode(start, end, leftNode.sum + rightNode.sum, leftNode, rightNode);

	}




	static void update(SegmentTreeNode root, int idx, int val){
		if(root.start == root.end){
			if(root.start == val){
				root.sum = val;
				return;
			}
		}


		int mid = root.start + (root.end - root.start) / 2;
		if(idx <= mid){
			update(root.left, idx, val);
		}else{
			update(root.right,idx, val);
		}

		root.sum = root.left.sum + root.right.sum;

	}


	static int querySum(SegmentTreeNode root, int i, int j){
		if(root.start == i && root.end == j){
			return root.sum;
		}

		int mid = root.start + (root.end - root.start) / 2;

		if(j <= mid){
			return querySum(root.left, i , j);
		}else if(i > mid){
			return querySum(root.right, i , j);
		}else{
			return querySum(root.left,i, mid) + querySum(root.right, mid, j);
		
		}
	}

	
	public static void main(String args[]){

		int[] vals = new int[]{2,1,5,3,4};
		int start = 0;
		int end = 4;

		// root = new SegmentTreeNode();
		SegmentTreeNode  root = buildTree(start, end, vals);
		System.out.println(root.sum);


		int sum1 = querySum(root, 0, 2);
		System.out.println("sum of node 0 is " + sum1);

	}






}





