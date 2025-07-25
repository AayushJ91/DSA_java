//Problem: find all the paths in a binary tree
//link: https://leetcode.com/problems/binary-Tree-Paths/
//Source: LeetCode(-)
//Topics: BackTracking
//Diff: Easy

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreePaths {
    public static List<String> binaryTreePaths(TreeNode root) {
        List<String> answer = new ArrayList<String>();
        if (root != null) searchBT(root, "", answer);
        return answer;
    }
    private static void searchBT(TreeNode root, String path, List<String> answer) {
        if (root.left == null && root.right == null) answer.add(path + root.val);
        if (root.left != null) searchBT(root.left, path + root.val + "->", answer);
        if (root.right != null) searchBT(root.right, path + root.val + "->", answer);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.right = new TreeNode(5);
        root.left.right.left = new TreeNode(4);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(6);
        root.right.left.left = new TreeNode(9);
        root.right.left.right = new TreeNode(8);
        root.right.right = new TreeNode(7);
        //                  1
        //                /   \
        //               /     \
        //              2       3
        //               \     / \
        //                5   6   7
        //               /   / \
        //              4   9   8

        System.out.println(binaryTreePaths(root));
    }
}