// LC 297 Serialize and Deserialize Binary Tree

/**

 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {
    private static String SP = ">";
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return "";
        }
        StringBuilder res = new StringBuilder();
        serializeHelper(root, res);
        System.out.println(res);
        return res.toString();
    }
    
    private void serializeHelper(TreeNode root, StringBuilder res) {
        if (root == null) {
            res.append(SP);
            return;
        }
        res.append(root.val).append(SP);
        serializeHelper(root.left, res);
        serializeHelper(root.right, res);
        
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null || data.length() == 0) {
            return null;
        }
        System.out.println(Arrays.asList(data.split(SP)));
        Deque<String> tokens = new ArrayDeque<>(Arrays.asList(data.split(SP)));
        return deserializeHelper(tokens);
    }
    
    private TreeNode deserializeHelper(Deque<String> tokens) {
        if (tokens.size() == 0) {
            return null;
        }
        String curValue = tokens.pollFirst();
        // System.out.println(curValue + "XXX");
        if (curValue == "") {
            return null;
        }
        TreeNode root = new TreeNode(Integer.valueOf(curValue));
        root.left = deserializeHelper(tokens);
        root.right = deserializeHelper(tokens);
        return root;
        
        
    }
}




// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));
