//337. House Robber III
//https://leetcode.com/problems/house-robber-iii/description/

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
    public int rob(TreeNode root) {
        int[] res = recRob(root);
        return Math.max(res[0], res[1]);
    }
    public int[] recRob(TreeNode root){
        int[] res = new int[2];
        if(root == null) return res;
        int[] resLeft = recRob(root.left);
        int[] resRight = recRob(root.right);
        int childIncluded = resRight[0] + resLeft[0];
        int childNotIncluded = resRight[1] + resLeft[1];
        res[0] = root.val+childNotIncluded;
        int childLeftOnly = resLeft[0] + resRight[1];
        int childRightOnly = resRight[0] + resLeft[1];
        int temp = Math.max(childLeftOnly,childRightOnly);
        temp = Math.max(childNotIncluded,temp);
        res[1] = Math.max(childIncluded,temp);

        return res;
    }
}
