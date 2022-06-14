public class UnionFind{
	public UnionFind(int size) {}
	public int find(int x) {}
	public void union(int x, int y) {}
	public boolean connected(int x, int y) {}


	public int find(int x){
		while(x != root[x]){
			x = root[x];
		}
		return x;
	}

	// public int findOpt(int x){
	// 	if(x == root[x]){
	// 		return x;
	// 	}

	// 	return root[x] = findOpt(root[x]);
	// }


	public void union(int x, int y){
		int rootX = find(x);
		int rootY = find(y);

		if(rootX != rootY){
			root[rootY] = rootX;
		}
	}

	// public void unionOpt(int x, int y){
	// 	int rootX = find(x);
	// 	int rootY = find(y);
	// 	if(rootX != rootY){
	// 		if(rank[rootX] > rank[rootY]){
	// 			root[rootY] = rootX;
	// 		}else if (rank[rootX] < rank[rootY]){
	// 			root[rootX] = rootY;
	// 		}else{
	// 			root[rootY] = rootX;
	// 			rank[rootX] += 1;
	// 		}
	// 	}
	// }

	public boolean connected(int x, int y){
		return find(x) == find(y);
	}


}