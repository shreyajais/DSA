package DSA.BinaryTrees.Medium;

import DSA.BinaryTrees.TreeNode;

public class SortedArrayToBinaryTree {
    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums.length==0) return null;
        return sortedArrayToBSTRecur(nums, 0, nums.length-1);
    }
    public TreeNode sortedArrayToBSTRecur(int[] nums, int start, int end){
        if(start==end) return new TreeNode(nums[start]);
        else {
            int mid = (end-start+1)/2;
            TreeNode root = new TreeNode(nums[mid]);
            root.left = sortedArrayToBSTRecur(nums, start, mid-1);
            root.right = sortedArrayToBSTRecur(nums, mid+1, end);
            return root;
        }
    }
}
