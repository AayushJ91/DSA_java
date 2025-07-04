//Problem: determine whether the root given is valid BST or not
//link: https://leetcode.com/problems/delete-node-in-a-bst/
//Source: LeetCode (450)
//Topics: Binary Tree
//Diff: Med

public class DeleteNode {
    //Time: best 0ms;
    //Space: 46.2MB;
    static TreeNode deleteNode(TreeNode root, int key) {
        //return the root of updated tree

        //if key do not exist in the tree
        if (!BST.SearchRec(root, key)) {
            return root;
        }

        if (root == null) return root;

        if (key > root.val) {
            root.right = deleteNode(root.right, key);
        } else if (key < root.val) {
            root.left = deleteNode(root.left, key);
        } else {
            //if it matches the value

            //when it has one child (right child)
            //it will return that child
            //will also work with node with no child
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }
            //if it has both child
            else {
                TreeNode Target = getSuccessor(root);
                root.val = Target.val;
                root.left = deleteNode(root.left, Target.val);
            }

        }
        return root;
    }

    //going in the left subtree
    //for finding the max node to
    //substitute it from the targeted node
    //-- this is the predecessor of
    //targeted node in inorder traversal
    //Similarly the right subtree approach
    //will give the inorder successor and
    //can use both
    static TreeNode getSuccessor(TreeNode root) {
        //the max value in the left subtree
        //will occur at the right part
        TreeNode target = root.left;

        while (target != null) {
            if (target.right != null) {
                target = target.right;
            } else {
                return target;
            }
        }
        return target;
    }

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
    }
}
