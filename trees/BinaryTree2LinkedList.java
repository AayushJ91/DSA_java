//Problem: make a linked list out of binary tree where the right is next and left is always null
//link: https://leetcode.com/problems/flatten-binary-tree-to-linked-list/
//Source: LeetCode(114)
//Topics: Binary Tree
//Diff: Medium - done by self

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTree2LinkedList {
    public void flatten(TreeNode root) {
        //1ms, 17.63;
        //42.3 MB, 38.48;
        List<Integer> pre = new ArrayList<>();
        preOrder(root, pre);
        for (int i = 1; i < pre.size(); i++) {
            root.right = new TreeNode(pre.get(i));
            root.left = null;
            root = root.right;
        }

    }
    static void preOrder(TreeNode root, List<Integer> pre) {
        if (root == null) return;
        pre.add(root.val);
        preOrder(root.left, pre);
        preOrder(root.right, pre);
    }

    public static  void flatten1(TreeNode root) {
        Queue<TreeNode> pre = new LinkedList<>();
        preOrder(root, pre);
        System.out.println(pre);
        pre.poll();
        while (!pre.isEmpty()){
            root.right = pre.poll();
            root.left = null;
            root = root.right;
        }

    }
    static void preOrder(TreeNode root, Queue<TreeNode> pre) {
        if (root == null){
            return;
        }
        pre.add(root);
        preOrder(root.left, pre);
        preOrder(root.right, pre);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        flatten1(root);
        System.out.println(root.val);
        System.out.println(root.right.val);
        System.out.println(root.right.right.val);
    }
}
