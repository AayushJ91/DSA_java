import com.sun.source.tree.Tree;

import java.util.LinkedList;
import java.util.Queue;

class TreeNode {
    int data;
    TreeNode left;
    TreeNode right;
    //constructors
    TreeNode() {}
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.data = val;
        this.left = left;
        this.right = right;
    }
    TreeNode(int c){
        this.data = c;
        left = right = null;
    }
}

public class BinaryTree {
    static void Inorder(TreeNode root) {
        if (root == null) {return;}
        Inorder(root.left);
        System.out.print(root.data+",");
        Inorder(root.right);
    }

    static void LevelOrder(TreeNode root) {
        if (root == null){return;}
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            TreeNode temp = q.poll();
            System.out.print(temp.data+",");
            if (temp.left != null) q.add(temp.left);
            if (temp.right != null) q.add(temp.right);
        }
    }

    static TreeNode Insert(TreeNode root, int val) {
        //Insertion will always be done from left to right
        if (root == null) {
            return new TreeNode(val);
        }
        //queue for level order traversal
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            TreeNode temp = q.poll();

            if (temp.left == null) {
                temp.left = new TreeNode(val);
                break;
            }else {
                //adding the existing left node
                q.add(temp.left);
            }

            if (temp.right == null) {
                temp.right = new TreeNode(val);
                break;
            }else {
                //adding the existing right node
                q.add(temp.right);
            }
        }
        return root;
    }

    static boolean Search(TreeNode root, int val) {
        //doing by DFS (depth first search)

        //if the root is empty or reached the leaf node
        if (root == null) return false;

        //if it matches the data of a TreeNode
        if (root.data == val) return true;

        //recursively finding the val
        boolean left_search = Search(root.left, val);
        boolean right_search = Search(root.right, val);

        return left_search||right_search;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(6);
        root.right = new TreeNode(7);
        Inorder(root);
    }
}
