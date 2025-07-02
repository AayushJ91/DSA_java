//Problem: implement inorder traversal;
//link: https://leetcode.com/problems/binary-tree-inorder-traversal/
//Source: Leetcode (94)
//Topics: Tree
//Diff: Easy
import com.sun.source.tree.Tree;

import javax.swing.tree.TreeCellRenderer;
import java.util.ArrayList;

public class InorderTraversal {
    static ArrayList<Integer> inorderTraversal(TreeNode root) {
        //Time: 0ms best, beats 100;
        //Space: 43 MB, beats 40;
        //left root right
        ArrayList<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        list.addAll(inorderTraversal(root.left));
        list.add(root.data);
        list.addAll(inorderTraversal(root.right));
        return list;
    }

    static void recursive(TreeNode root) {
        if (root == null) return;

        recursive(root.left);
        System.out.print(root.data+",");
        recursive(root.right);
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = null;
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        System.out.println(inorderTraversal(root));
    }
}
