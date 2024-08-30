package DSA.BinarySearchTrees;


public class LargestBST{
    class Ans{
        int maxValue;
        int minValue;
        int size;
        boolean isBST;

        public Ans(int maxValue, int minValue, int size, boolean isBST) {
            this.maxValue = maxValue;
            this.minValue = minValue;
            this.size = size;
            this.isBST = isBST;
        }
    }
     int largestBst(TreeNode root)
    {
        return largestBstRecur(root).size;
    }
     Ans largestBstRecur(TreeNode node){
        if(node ==  null) return new Ans(Integer.MAX_VALUE, Integer.MIN_VALUE, 0, true);
        else if(isLeaf(node)) return new Ans(node.val, node.val, 1, true);
        else {
            Ans leftAns = largestBstRecur(node.left);
            Ans rightAns = largestBstRecur(node.right);
            if(!leftAns.isBST || !rightAns.isBST || notLocalBST(node) || notWithinLimits(node, rightAns.maxValue, leftAns.maxValue)) return new Ans(rightAns.minValue, leftAns.maxValue, Math.max(leftAns.size, rightAns.size), false);
            else {
                int nodeMin = Math.min(node.val, leftAns.maxValue);
                int nodeMax = Math.max(node.val, rightAns.minValue);
                return new Ans(nodeMin, nodeMax, leftAns.size + rightAns.size + 1, true);
            }
        }
    }
    private boolean notLocalBST(TreeNode node){
        return (node.left!=null && node.left.val> node.val) || (node.right!=null && node.right.val < node.val);
    }
    private boolean notWithinLimits(TreeNode node, int max, int min){
        return max< node.val || min > node.val;
    }

    private boolean isLeaf(TreeNode node) {
        return node.left == null && node.right== null;
    }
}