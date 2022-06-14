public class average {
    // AverageOfEachSubtreeExcludingNode
    public static void main(String[] args) {
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(9);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(6);
        System.out.println("Input: [12, 7, 8, 9, null, 10, 6]");   // true
        maximumAverageSubtree(root);
        System.out.println("Output: " + isAverageSameasNode);
    }

    static boolean isAverageSameasNode;

    private static boolean maximumAverageSubtree(TreeNode root) {
        NodeData nodeData = maximumAverageRecursive(root);
        return isAverageSameasNode;
    }



    private static NodeData maximumAverageRecursive(TreeNode currNode) {
        if (currNode == null) {
            return new NodeData(0.0, 0.0, 0);
        }
        
        // recursively get left node/subtree data
        NodeData leftNodeData = maximumAverageRecursive(currNode.left);

        // recursively get right node/subtree data
        NodeData rightNodeData = maximumAverageRecursive(currNode.right);
        
        double currSubTreeAvg = 0.0;
        if(leftNodeData.count != 0 || rightNodeData.count != 0) {
            currSubTreeAvg = (leftNodeData.sum + rightNodeData.sum) / (leftNodeData.count + rightNodeData.count);
            if(currSubTreeAvg == currNode.val) {
                System.out.println(currSubTreeAvg + "      " +  currNode.val);
                isAverageSameasNode = true;
            }
        }

        // current node sum is sum of current node value and left + right subtree
        double currNodeSum = leftNodeData.sum + rightNodeData.sum + currNode.val;

        // current node count is current node + left + right count
        int currNodeCount = leftNodeData.count + rightNodeData.count + 1;

        // we return node data with new maxAvg
        return new NodeData(currNodeSum, currSubTreeAvg, currNodeCount);
    }

    private static class NodeData {
        double sum;
        double avg;
        int count;

        NodeData(double sum, double avg, int count) {
            this.sum = sum;
            this.avg = avg;
            this.count = count;
        }
    }


    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

}