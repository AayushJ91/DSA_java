//Problem: implement level-order traversal;
//link: https://leetcode.com/problems/binary-tree-inorder-traversal/
//Source: Leetcode (102)
//Topics: Tree
//Diff: Easy

import javax.swing.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrder {
    static List<List<Integer>> levelOrder(TreeNode root){
        //Time: 1ms 2nd, beats 90.62;
        //Space: 45.09 MB; beats 54;
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        if (root == null) return res;

        while (!q.isEmpty()) {
            List<Integer> levels = new ArrayList<>();
            int len = q.toArray().length;
            System.out.println("q_len:"+q.toArray().length);
            for (int i = 0; i < len; i++) {
                TreeNode temp = q.poll();
                System.out.println("levels_be:"+levels);
//                System.out.println("temp.data:"+temp.data);
//                System.out.println("temp.ri:"+ temp.right.data);
//                System.out.println("temp.le:"+temp.left.data);
                levels.add(temp.data);
                System.out.println("levels_aft:"+levels);
                if (temp.left != null) q.add(temp.left);
                if (temp.right != null) q.add(temp.right);
                System.out.println();
            }
            res.add(levels);
        }
        return res;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        System.out.println(levelOrder(root));
    }
}
