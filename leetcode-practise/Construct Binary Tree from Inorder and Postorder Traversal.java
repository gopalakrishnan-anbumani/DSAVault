//106. Construct Binary Tree from Inorder and Postorder Traversal
//https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/description/
//LeetCode - Daily challenge


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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        Map<Integer,Integer> hm = new HashMap<>();
        for(int i=0;i<inorder.length;i++){
            hm.put(inorder[i], i);
        }
        TreeNode root = tree(inorder, postorder, 0, inorder.length-1, 0, postorder.length-1, hm);
        return root;
    }
    public TreeNode tree(int[] io, int[] po, int is, int ie, int ps, int pe, Map<Integer,Integer> hm){
        if(ps > pe || is > is){
            return null;
        }
        TreeNode root = new TreeNode(po[pe]);
        int index = hm.get(po[pe]);
        int numLeft = index - is;
        root.left = tree(io, po, is, index-1, ps, ps + numLeft -1  , hm);
        root.right = tree(io, po, index+1, ie, ps+numLeft, pe-1, hm);
        return root;

    }
}
