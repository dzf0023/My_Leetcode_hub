class SolutionInterv{
	public int[][] intervalIntersection(int[][] A, int[][] B){
		int i = 0, j=0;
		List<int[]> res = new ArrayList<>();
			while(i< A.length && j < B.length){
				int[] common = getCommon(A[i],B[j]);
				if (common != null ){
					res.add(common);
				}
				if (A[i][1] <= B[j][1]){
					i++;
				}
				else{
					j++;
				}
		int[][] ans = new int[res.size()[2]];
		for (i = 0;i< ans.length ;i++ ){
			ans[i] = res.get(i);
		}
		return ans;

			}

	private int[] getCommon(int[]a, int[] b){
		if(b[0]> a[1] || a[0]> b[1]){
			return null;
		}
		return new int[]{Math.max(a[0],b[0]), Math.min(a[1],b[1])};
	}
	
	}
}




// public List<String> letterCombinations(String digits){
// 	LinkedList<String> ans = new LinkedList<String>();
// 	if(digits.isEmpty()) return ans;
// 	String[] mapping = new String[] {"0","1","abd","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
// 	ans.add("");
// 	for(int i = 0; i< digits.length();i++){
// 		int x = Character.getNumericValue(digits.charAt(i));
// 		while (ans.peek().length() ==i ) {
// 			String t = ans.remove();
// 			for (char s: mapping[x].toCharArray) {
// 				ans.add(t+s);
// 			}
// 		}
// 	return ans;
// 	}
// }