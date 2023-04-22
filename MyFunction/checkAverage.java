// [Q?: Check if each node in a binary tree is the average of all its descendents]
// ==== Returns Yes ====
//         2
//        / \
//       2   2 
//      /   / \
//     2   1   3       
// =====================

// ==== Returns No ====
//         3
//        / \
//       2   4 
//      /   / \
//     2   3   5       
// =====================

class Solution {
    public boolean checkAverage(TreeNode root){
        if(root == null) return false;
        
        return isSumValid(root)
    }
  
//         2
//        / \
//       2   2 
//      /   / \
//     2   1   3 
  
    public helper isSumValid(TreeNode node){
      
        int left_node = 0;
        int right_node = 0;
      
        if(node == null || node.left == null && node.right == null){
            return 1;
        }else{
          if(node.left != null){
              left_node = node.left.val;
          }
          
          if(node.right != null){
              right_node = node.right.val;
          }
          
          if((node.val == left_node + right_node) && (isSumValid(node.left) != 0 ) && && (isSumValid(node.right) != 0)){
            return 1;
          }
          
          
          return 0;
        
        }
      
        helper left_tree = isSumValid(node.left);
        helper right_tree = isSumValid(node.right);
      
        int sum = left_tree.sum + right_tree.sum;
        int res = sum % (left_tree.numberOfNode + right_tree.numberOfNode);
        boolean isValid = res == 0 ? true : false;
      
        return 
    
    }
}


class helper
{
  
  int sum;
  int numberOfNode;
  boolean isValid;
  
  public helper(int sum, int numberOfNode){
    this.sum;
    this.numberOfNode;
    this.isValid;
  
  }

}
