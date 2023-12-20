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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> in = new ArrayList<>();
        inHelper(root,in);
        return in;
    }
    public void inHelper(TreeNode root, List<Integer> in) {
        if(root==null) return;
        inHelper(root.left,in);
        in.add(root.val);
        inHelper(root.right,in);
    }
}