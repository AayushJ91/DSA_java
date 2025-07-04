import com.sun.source.tree.Tree;
import com.sun.source.tree.WhileLoopTree;

import javax.swing.tree.TreeCellRenderer;
import java.io.FilterOutputStream;
import java.lang.classfile.instruction.ReturnInstruction;
import java.util.ArrayList;
import java.util.Enumeration;

public class BST {
    //Insertion will always be as a leaf node
    public static TreeNode InsertionRec(TreeNode root, int key) {
        //if tree is empty or reached the leaf node
        if (root == null) return new TreeNode(key);

        if (key > root.val) root.right = InsertionRec(root.right, key);

        else root.left = InsertionRec(root.left, key);

        return root;
    }

    public static TreeNode InsertionIter(TreeNode root, TreeNode node) {
        //if node is empty

        if (node == null) return null;
        //if the tree is empty;
        if (root == null) {
            return node;
        }

        TreeNode temp = root;
        while (true) {
            if (node.val > temp.val) {
                if (temp.right == null) {
                    temp.right = node;
                    break;
                }else temp = root.right;
            }else {
                if (temp.left == null) {
                    temp.left = node;
                    break;
                }else temp = root.left;
            }
        }
        return root;
    }

    //Searching
    static Boolean SearchRec(TreeNode root, int key) {
        //if reached at leaf node and still not found; also if the tree is empty
        if (root == null) return false;

        boolean ans;
        if (key > root.val) {
            ans = SearchRec(root.right, key);
        }else if (key < root.val) {
            ans = SearchRec(root.left, key);
        }else {
            ans = true;
        }
        return ans;
    }

    static Boolean SearchIter(TreeNode root, int key) {
        //if tree is empty;
        if (root == null) return false;

        TreeNode curr = root;
        while (curr != null) {
            System.out.println("curr:"+curr.val);
            if (curr.val > key) curr = curr.left;
            else if (curr.val < key) curr = curr.right;
            else return true;
        }
        return false;
    }

    //Validating
    static Boolean isValidRec(TreeNode root) {
        if (root == null) return false;
        return isValidRec(root.left, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    static Boolean isValidRec(TreeNode root, long min,long max) {
        if (root == null) return true;
        long val = (long) root.val;
        if (val < min || val > max) {
            return false;
        }

        return isValidRec(root.right, val, max) && isValidRec(root.left, min, val);
    }

    //deleting a node


    public static void main(String[] args) {
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(5);
        root.right = new TreeNode(15);
        root.left.right = new TreeNode(7);
        root.left.left = new TreeNode(3);
        root.left.left.left = new TreeNode(1);
        root.left.right.right = new TreeNode(9);
        root.left.right.right.right = new TreeNode(11);
        root.left.right.right.left = new TreeNode(8);
        root.right.right = new TreeNode(17);
        root.right.left = new TreeNode(13);
        root.right.left.right = new TreeNode(14);
        root.right.right.right = new TreeNode(20);
        root.right.right.right.left = new TreeNode(18);
        //              12
        //             /  \
        //            5    15
        //           / \   / \
        //          3   7 13  17
        //         /     \  \   \
        //        1       9  14  20
        //               / \     /
        //              8   11  18

        DeleteNode.deleteNode(root, 13);
        System.out.println(root.right.left.val);
    }
}
