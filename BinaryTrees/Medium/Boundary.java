package DSA.BinaryTrees.Medium;

import DSA.BinaryTrees.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Boundary {
    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        if(root==null) return new ArrayList<>();
        if(isLeaf(root)){
            ArrayList<Integer> ans = new ArrayList<>();
            ans.add(root.val);
            return ans;
        }
        //left boundary
        ArrayList<Integer> leftSide = new ArrayList<>();
        getLeftSide(root.left, leftSide);
        // right boundary
        ArrayList<Integer> rightSide = new ArrayList<>();
        getRightSide(root.right, rightSide);
        // leaves
        ArrayList<Integer> leaves = new ArrayList<>();
        getLeaves(root, leaves);
        return generateBoundary(leftSide, rightSide, leaves);
    }

    private List<Integer> generateBoundary(ArrayList<Integer> leftSide, ArrayList<Integer> rightSide, ArrayList<Integer> leaves) {
        List<Integer> ans = new ArrayList<>();
        ans.addAll(leftSide);
        ans.addAll(leaves);
        Collections.reverse(rightSide);
        ans.addAll(rightSide);
        return ans;
    }

    private void getLeaves(TreeNode root, ArrayList<Integer> leaves) {
        if(root==null) return;
        if(isLeaf(root)){
            leaves.add(root.val);
            return;
        }
        getLeaves(root.left, leaves);
        getLeaves(root.right, leaves);
    }

    private void getRightSide(TreeNode root, ArrayList<Integer> rightSide) {
        if(root == null || isLeaf(root)) return;
        rightSide.add(root.val);
        if(root.right != null){
            getRightSide(root.right, rightSide);
        } else {
            getRightSide(root.left, rightSide);
        }
    }

    private void getLeftSide(TreeNode root, ArrayList<Integer> leftSide) {
        if(root == null || isLeaf(root)) return;
        leftSide.add(root.val);
        if(root.left != null){
            getLeftSide(root.left, leftSide);
        } else {
            getLeftSide(root.right, leftSide);
        }
    }

    private boolean isLeaf(TreeNode node){
        return node.left == null && node.right == null;
    }


}


/**
 * Missing Root Node in Left Boundary:
 * The root node should be included in the left boundary. However, in your current implementation, the root node is not being added to the leftSide list explicitly.
 * Handling Leaves:
 * You are correctly collecting all leaves, but you should make sure to skip the root node in the getLeaves method to avoid adding it twice.*/