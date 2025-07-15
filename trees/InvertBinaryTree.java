//Problem: Invert the given binary tree;
//link: https://leetcode.com/problems/invert-binary-tree/
//Source: LeetCode(226)
//Topics: Binary Tree
//Diff: Easy

public class InvertBinaryTree {
    //0ms, Best;
    //41.2 MB, 62.88;
    public static TreeNode invertTree(TreeNode root) {
        rec(root);
        return root;
    }
    static void rec(TreeNode root) {
        if (root == null || (root.right == null && root.left == null)) {
            return;
        }
        rec(root.left);
        rec(root.right);
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right= new TreeNode(3);

        TreeNode res = invertTree(root);
        System.out.println("right:"+res.right.val);
        System.out.println("left:"+res.left.val);
        System.out.println();

        TreeNode NewRoot = new TreeNode(1);
        NewRoot.left = new TreeNode(2);
        NewRoot.right= new TreeNode(3);
        NewRoot.left.left = new TreeNode(4);
        NewRoot.left.right = new TreeNode(5);
        NewRoot.right.left = new TreeNode(6);

        TreeNode result = invertTree(NewRoot);
        System.out.println("root:"+result.val);
        System.out.println("right:"+result.right.val);
        System.out.println("left:"+result.left.val);
        System.out.println("left.right:"+result.left.right.val);
        System.out.println("right.right:"+result.right.right.val);
        System.out.println("right.left:"+result.right.left.val);
    }
}
