import com.sun.source.tree.Tree;

import javax.swing.tree.TreeCellRenderer;
import java.io.FilterOutputStream;
import java.lang.classfile.instruction.ReturnInstruction;
import java.util.Enumeration;

public class BST {
    //Insertion will always be as a leaf node
    public static TreeNode InsertionRec(TreeNode root, int key) {
        //if tree is empty or reached the leaf node
        System.out.println("root:"+root);
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
        return isValidRec(root.left, root.right);
    }
    static Boolean isValidRec(TreeNode left, TreeNode right) {
        if (left == null || right == null) return true;
        if (left.val > right.val) return false;
        else return isValidRec(left.left, left.right) && isValidRec(right.left, right.right);
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right = new TreeNode(7);
        //     4
        //    / \
        //   3   7
        //      /
        //     5
        root = InsertionRec(root, 5);
        System.out.println(root.right.left.val);
    }
}
