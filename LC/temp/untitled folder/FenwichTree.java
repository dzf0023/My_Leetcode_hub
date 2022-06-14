class FenwichTree{
	int sums_[];
	public FenwichTree(int n){
		sums_ = new int[n+1];
	}

	public void update(int i, int delta){
		while(i < sums_.length){
			sums_[i] += delta;
			i += i & -i;
		}
	}


	public int query(int i){
		int sum = 0;
		while(i > 0){
			sum += sums_[i];
			i -= i & -i;
		}
		return sum;
	}
}