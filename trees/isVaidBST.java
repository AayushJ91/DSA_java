//Problem: determine whether the root given is valid BST or not
//link: https://leetcode.com/problems/validate-binary-search-tree/
//Source: LeetCode (98)
//Topics: Binary Tree
//Diff: Med


public class isVaidBST {
    //Time: 0ms best, beats 100;
    //Space: best, beats 100;
    static Boolean isValidBST(TreeNode root) {
        return isValidBST(root,Long.MIN_VALUE, Long.MAX_VALUE);
    }
    static Boolean isValidBST(TreeNode root, Long min, Long max) {
        if (root == null) {
            return true;
        }
        Long val = (long) root.val;
        if (val <= min || val >= max) {
            return false;
        }
        return isValidBST(root.left, min, val) && isValidBST(root.right, val, max);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);
        System.out.println(isValidBST(root));
    }
}
