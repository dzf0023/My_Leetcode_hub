class Solution {
    public int maximumSwap(int num) {
        char[] numChars = String.valueOf(num).toCharArray();
        int[] lastIdx = new int[10];
        
        for(int i = 0; i < numChars.length; i++){
            lastIdx[numChars[i] - '0'] = i;
        }
        System.out.println(Arrays.toString(lastIdx));
        
        for(int i = 0; i < numChars.length; i++){
            for(int j = 9;  j >numChars[i] - '0'; j--){
                if(lastIdx[j] > i){
                    swap(numChars, lastIdx[j], i );
                    return Integer.valueOf(String.valueOf(numChars));
                }
            }
        }
        return num;
    }
    
    private void swap(char[] numChar, int i, int j){
        char temp = numChar[i];
        numChar[i] = numChar[j];
        numChar[j] = temp;
    }
}




class Node{
	public int val;
	public Node left;
	public Node right;
	public Node parent;
}


class Solution {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        TreeNode node = root;
        while(node != null){
            if(val > node.val){
                if(node.right == null){
                    node.right = new TreeNode(val);
                    return root;
                }else{
                    node = node.right;
                }
            }else{
                if(node.left == null){
                    node.left = new TreeNode(val);
                    return root;
                }else{
                    node = node.left;
                }
            }
        }
        return new TreeNode(val);
    }
}





class MedianFinder {

    public MedianFinder() {
        
    }
    
    public void addNum(int num) {
        
    }
    
    public double findMedian() {
        
    }
}



class SparseVector {
    
    Map<Integer, Integer> mapping;
    
    SparseVector(int[] nums) {
        mapping = new HashMap<>();
        
        for(int i = 0; i < nums.length; i++){
            if(nums[i] != 0){
                mapping.put(i, nums[i]);
            }
        }
    }
    
	// Return the dotProduct of two sparse vectors
    public int dotProduct(SparseVector vec) {
        int res = 0;
        
        for(int i: this.mapping.keySet()){
            if(vec.mapping.containsKey(i)){
                res += this.mapping.get(i) * vec.mapping.get(i);
            }
        }
        return res;
    }
}


class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        int[] orderMap = new int[26];
        for (int i = 0; i < order.length(); i++){
            orderMap[order.charAt(i) - 'a'] = i;
        }

        for (int i = 0; i < words.length - 1; i++) {

            for (int j = 0; j < words[i].length(); j++) {
                // If we do not find a mismatch letter between words[i] and words[i + 1],
                // we need to examine the case when words are like ("apple", "app").
                if (j >= words[i + 1].length()) return false;

                if (words[i].charAt(j) != words[i + 1].charAt(j)) {
                	int currentWordChar = words[i].charAt(j) - 'a';
                	int nextWordChar = words[i + 1].charAt(j) - 'a';
                    if (orderMap[currentWordChar] > orderMap[nextWordChar]) return false;
                    // if we find the first different letter and they are sorted,
                    // then there's no need to check remaining letters
                    else break;
                }
            }
        }

        return true;
    }
}



class Solution {
    public boolean isPalindrome(String s) {
        int i = 0, j = s.length() - 1;
        
        while(i < j){
            while(i < j && !Character.isLetterOrDigit(s.charAt(i))){
                i++;
            }
            while(i < j && !Character.isLetterOrDigit(s.charAt(j))){
                j--;
            }
            
            if(i< j && Character.toLowerCase(s.charAt(i)) !=Character.toLowerCase(s.charAt(j)) ){
                return false;
            }
            
            i++;
            j--;
        }
        return true;
    }
}


class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m - 1;
        int p2 = n - 1;
        
        for(int i = m + n - 1; i >= 0;i--){
            if(p2 < 0) break;
            
            if(p1 >= 0 && nums1[p1] > nums2[p2]){
                nums1[i] = nums1[p1--];
            }else{
                nums1[i] = nums2[p2--];
            }
        }
    }
}


/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
      Map<TreeNode, List<TreeNode>> map = new HashMap();

      public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
            List<Integer> res = new ArrayList<Integer> ();
            if (root == null || K < 0) return res;

            buildMap(root, null); 

            if (!map.containsKey(target)) return res;
            Set<TreeNode> visited = new HashSet<TreeNode>();
            Queue<TreeNode> q = new LinkedList<TreeNode>();
            q.add(target);
            visited.add(target);
            while (!q.isEmpty()) {
                int size = q.size();
                if (K == 0) {
                    for (int i = 0; i < size ; i++) 
                    	res.add(q.poll().val);
                    return res;
                }
                for (int i = 0; i < size; i++) {
                    TreeNode node = q.poll();
                    for (TreeNode next : map.get(node)) {
                        if (visited.contains(next)) continue;
                        visited.add(next);
                        q.add(next);
                    }
                }
                K--;
            }
            return res;
        }

        private void buildMap(TreeNode node, TreeNode parent) {
            if (node == null) return;
            if (!map.containsKey(node)) {
                map.put(node, new ArrayList<TreeNode>());
                if (parent != null) { 
                	map.get(node).add(parent); 
                	map.get(parent).add(node); 
                }
                buildMap(node.left, node);
                buildMap(node.right, node);
            }
    }    

}




class BSTIterator{
	Deque<TreeNode> stack;

	public BSTIterator(TreeNode root){
		this.stack = new ArrayDeque<>();
		this.inorder(root);
	}

	public void inorder(TreeNode node){
		while(node != null){
			stack.addFirst(node);
			node = node.left;
		}
	}

	public int next(){
		TreeNode node = stack.pollFirst();
		if(node.right != null){
			this.inorder(node.right);
		}
		return node.val;
	}


	public boolean hasNext(){
		return stack.size() > 0;
	}


}







class Solution {
    public String removeDuplicates(String s, int k) {
        StringBuilder sb = new StringBuilder(s);
        Stack<Integer> counts = new Stack<>();
        for (int i = 0; i < sb.length(); ++i) {
            if (i == 0 || sb.charAt(i) != sb.charAt(i - 1)) {
                counts.push(1);
            } else {
                int incremented = counts.pop() + 1;
                if (incremented == k) {
                    sb.delete(i - k + 1, i + 1);
                    i = i - k;
                } else {
                    counts.push(incremented);
                }
            }
        }
        return sb.toString();
    }
}

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
      Map<TreeNode, List<TreeNode>> map = new HashMap();
    
      public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
            List<Integer> res = new ArrayList<Integer> ();
            if (root == null || K < 0) return res;
          
            buildMap(root, null); 
          
            if (!map.containsKey(target)) return res;
            Set<TreeNode> visited = new HashSet<TreeNode>();
            Queue<TreeNode> q = new LinkedList<TreeNode>();
            q.add(target);
            visited.add(target);
            while (!q.isEmpty()) {
                int size = q.size();
                if (K == 0) {
                    for (int i = 0; i < size ; i++) res.add(q.poll().val);
                    return res;
                }
                for (int i = 0; i < size; i++) {
                    TreeNode node = q.poll();
                    for (TreeNode next : map.get(node)) {
                        if (visited.contains(next)) continue;
                        visited.add(next);
                        q.add(next);
                    }
                }
                K--;
            }
            return res;
        }

        private void buildMap(TreeNode node, TreeNode parent) {
            if (node == null) return;
            if (!map.containsKey(node)) {
                map.put(node, new ArrayList<TreeNode>());
                if (parent != null){ 
                    map.get(node).add(parent); 
                    map.get(parent).add(node); 
                }
                buildMap(node.left, node);
                buildMap(node.right, node);
            }
    }    

}






class Solution {
    Node first = null;
    Node last = null;
    
    public Node treeToDoublyList(Node root) {
            
        if(root == null) return null;
        
        helper(root);
        
        first.left = last;
        last.right = first;
        
        return first;
    }
    
    public void helper(Node node){
        if(node != null){
            helper(node.left);
            
            if(last != null){
                last.right = node;
                node.left = last;
            }else{
                first = node;
            }
            last = node;
            
            helper(node.right);
        }
    }
}





class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int n = arr.length - 1;
        int l = 0, r = n;
        
        
        while(r - l >= k){
            if(Math.abs(arr[l]- x) > Math.abs(arr[r]-x)){
                l+=1;
            }else{
                r -= 1;
            }
        }
        List<Integer> res = new ArrayList<>();
        
        for(int i = l; i <= r; i++){
            res.add(arr[i]);
        }
        return res;
    }
}

class Solution {
	//  if the size of island is larger than some number, then its an island

    int[][] dirs = new int[][]{{0,1} , {0, -1}, {1, 0}, {-1,0}};
    int size;
    public int numIslands(char[][] grid) {
        int res = 0;
        if(grid == null || grid[0].length == 0) return 0;
        
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == '1'){
                    size = 0;
                    dfs(grid, i, j, res);
                    if(size >= 2){
                        res += 1;
                    }
                    System.out.println(size);   
                }
            }
        }
        return res;
    } 
    public void dfs(char[][] grid, int x, int y, int res){
        grid[x][y] = '0';
        size += 1;
        for(int[] dir: dirs){
            int newX = x + dir[0];
            int newY = y + dir[1];
            
            if(newX < 0 || newX >= grid.length || newY < 0 || newY >= grid[0].length || grid[newX][newY] == '0'){
                continue;
            }
            
            dfs(grid, newX, newY,res);
        }
        return ;
    }
}


/**
 * // This is the BinaryMatrix's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface BinaryMatrix {
 *     public int get(int row, int col) {}
 *     public List<Integer> dimensions {}
 * };
 */

class Solution {
    public int leftMostColumnWithOne(BinaryMatrix binaryMatrix) {
        int rows = binaryMatrix.dimensions().get(0);
        int cols = binaryMatrix.dimensions().get(1);
        int curRow = 0;
        int curCol = cols - 1;
        
        while(curRow < rows && curCol >= 0){
            if(binaryMatrix.get(curRow, curCol) == 0){
                curRow++;
            }else{
                curCol--;
            }
        }
            
            
            
        return curCol == cols - 1 ? -1: curCol+1;
    }
}








class Solution {
    private List<String> ans;
    private char[] num;
    private char[] exp;         // buffer 
    private int target;
    
    public List<String> addOperators(String num, int target) {
        this.num = num.toCharArray();
        this.ans = new ArrayList<>();
        this.target = target;
        this.exp = new char[num.length() * 2];  // maximum is add operator between each two numbers , is  (2 * n - 1),  so 2n is enough 
        dfs(0,0,0,0);
        return ans;
    }
                                // len is for buffer length
    private void dfs(int pos, int len, long prev, long curr){
        if(pos == num.length){
            if(curr == target)
                ans.add(new String(exp, 0, len));
            return;
        }
        
        int s = pos;
        int l = len;    // l 放op
        if(s != 0) ++len;   // s!=0, means not the first one  ,++len 放数字
        
        long n = 0;
        while(pos < num.length){
            if(num[s] == '0' && pos - s > 0) break;   //0xxx
            n = n * 10 + (int)(num[pos] - '0');
            if(n > Integer.MAX_VALUE) break;
            exp[len++] = num[pos++];        // this copy is O(1) 
            if(s == 0){     // means first one 
                dfs(pos, len, n, n);
                continue;
            }

            // space from O(n^2) ==> O(n)  do not copy the string 
            exp[l] = '+';  dfs(pos, len, n, curr + n);
            exp[l] = '-';  dfs(pos, len, -n, curr - n);
            exp[l] = '*';  dfs(pos, len, prev * n, curr - prev + prev * n);
        }
    }
}





