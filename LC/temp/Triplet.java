/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Triplet<F,S,T>{
    public final F first;
    public final S second;
    public final T third;
    
    public Triplet(F first, S second, T third){
        this.first = first;
        this.second = second;
        this.third = third;
    }
}


class Solution {
    List<Triplet<Integer, Integer, Integer>> nodeList = new ArrayList<>();
    
    private void BFS(TreeNode root){
        Queue<Triplet<TreeNode, Integer, Integer>> queue = new ArrayDeque();
        int row = 0,  column = 0;
        queue.offer(new Triplet(root, row, column));
        
        while(!queue.isEmpty()){
            Triplet<TreeNode, Integer, Integer> triplet = queue.poll();
            root = triplet.first;
            row = triplet.second;
            column = triplet.third;
            
            if(root != null){
                this.nodeList.add(new Triplet(column, row, root.val));
                queue.offer(new Triplet(root.left, row + 1, column - 1));
                queue.offer(new Triplet(root.right, row + 1, column + 1));
            }
        }
    }
    
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> output = new ArrayList();
        if(root == null){
            return output;
        }
        
        BFS(root);
        
        Collections.sort(this.nodeList,  new Comparator<Triplet<Integer, Integer, Integer>>(){
            @Override
            public int compare(Triplet<Integer, Integer, Integer> t1,
                    Triplet<Integer, Integer, Integer> t2) {
                if(t1.first.equals(t2.first))
                    if(t1.second.equals(t2.second))
                        return t1.third - t2.third;
                    else
                        return t1.second - t2.second;
                else
                    return t1.first - t2.first;
            }
        });
        
        List<Integer> currColumn = new ArrayList();
        Integer currColumnIndex = this.nodeList.get(0).first;
        
        for(Triplet<Integer, Integer, Integer> triplet: this.nodeList){
            Integer column = triplet.first, value = triplet.third;
            if(column == currColumnIndex){
                currColumn.add(value);
            }else{
                output.add(currColumn);
                currColumnIndex = column;
                currColumn = new ArrayList();
                currColumn.add(value);
            }
        }
        output.add(currColumn);
        return output;
    }
}













