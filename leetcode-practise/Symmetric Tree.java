//101. Symmetric Tree
//https://leetcode.com/problems/symmetric-tree/description/
//Leet Code Daily Challenge - 10-03-2023

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
class Solution {
    public boolean isSymmetric(TreeNode root) {
        return isMirror(root, root);
    }

    public boolean isMirror(TreeNode root1, TreeNode root2) {
        if(root1 == null && root2 == null){
            return true;
        }

        if(root1 != null && root2 != null && root1.val == root2.val){
            return isMirror(root1.left, root2.right) && isMirror(root1.right, root2.left);
        }

        return false;
    }
}
