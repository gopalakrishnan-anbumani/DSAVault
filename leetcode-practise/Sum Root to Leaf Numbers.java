//129. Sum Root to Leaf Numbers
//https://leetcode.com/problems/sum-root-to-leaf-numbers/
//Leetcode Daily Challenge - 14-03-2023


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
    int total = 0;
    public int sumNumbers(TreeNode root) {
        getNumber(root, 0);
        return total;
    }
    public void getNumber(TreeNode node, int num) {
        if(node == null){
            return;
        }
        num = (num * 10) + node.val;
        if(node.left == null && node.right == null){
            total += num;
            return;
        }
        getNumber(node.left, num);
        getNumber(node.right, num);
    }
}
