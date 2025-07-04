import com.sun.source.tree.Tree;

import java.util.ArrayList;
import java.util.Arrays;

public class LCA {
    static TreeNode usingArrays(TreeNode root, int n1, int n2) {
        ArrayList<TreeNode> n1a = new ArrayList<>();
        ArrayList<TreeNode> n2a = new ArrayList<>();

        TreeNode t1 = root,t2 = root;
        while (t1!= null) {
            n1a.add(t1);
            if (n1 > t1.val) {
                t1 = t1.right;
            }else if (n1 < t1.val) {
                t1 = t1.left;
            }else{
                break;
            }
        }
        while (t2!= null) {
            n2a.add(t2);
            if (n2 > t2.val) {
                t2 = t2.right;
            } else if (n2 < t2.val) {
                t2 = t2.left;
            } else {
                break;
            }
        }
        System.out.println("arr1:"+n1a);
        System.out.println("arr2:"+n2a);
        int len = Math.min(n1a.size(), n2a.size());
        TreeNode result = null;
        for (int i = 0; i < len; i++) {
            if (n1a.get(i).val == n2a.get(i).val) {
                result = n1a.get(i);
            }
        }
        return result;
    }


    static TreeNode usingRec(TreeNode root, int n1, int n2) {
        //Time: 5ms best, beats 100;
        //Space: 44.88 MB, beats 90.93;
        if (n1 < root.val && n2 < root.val) {
            return usingRec(root.left, n1, n2);
        }
        else if (n1 > root.val && n2 > root.val) {
            return usingRec(root.right, n1, n2);
        }else {
            return root;
        }
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

        System.out.println(usingRec(root, 1,11).val);
    }
}
