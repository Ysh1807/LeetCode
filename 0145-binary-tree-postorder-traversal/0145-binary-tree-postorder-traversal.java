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
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> pre = new ArrayList<>();
        postHelper(root,pre);
        return pre;
    }
    public void postHelper(TreeNode root, List<Integer> pre) {
        if(root==null) return;
        postHelper(root.left,pre);
        postHelper(root.right,pre);
        pre.add(root.val);
    }
}