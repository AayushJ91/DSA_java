//Problem: construct a Binary Search Tree from the given preorder list;
//link: https://leetcode.com/problems/construct-binary-search-tree-from-preorder-traversal/
//Source: LeetCode (1008)
//Topics: Binary Tree
//Diff: Med

import java.security.UnrecoverableEntryException;

public class BST_FromPre {
    public TreeNode bstFromPreorder(int[] preorder) {
        TreeNode root = new TreeNode(preorder[0]);
        int rightStart = 0;
        int leftStart = 1;
        for (int i = 1; i < preorder.length; i++) {
            if (preorder[i] > preorder[leftStart]){
                rightStart = i;
                break;
            }
        }
    }

    public TreeNode bstFromPreorder(TreeNode root, int[] preorder, int leftStart, int rightStart) {
        if (preorder[leftStart] > preorder[0]) {
            return null;
        }
        for (int i = 0; i < preorder.length; i++){
            if (preorder[i] < preorder[leftStart]){
                leftStart = i;
                return new TreeNode(preorder[leftStart]);
            }
        }
        root.left = bstFromPreorder(root.left, preorder, leftStart, rightStart);

        for (int i = leftStart; i < preorder.length; i++){
            if (preorder[i] > preorder[leftStart]){
                rightStart = i;
                return new TreeNode(preorder[rightStart]);
            }
        }
        root.right = bstFromPreorder(root.right, preorder, leftStart, rightStart);

    }
}
