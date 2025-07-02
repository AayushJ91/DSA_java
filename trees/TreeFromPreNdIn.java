//Problem: Given to arrays of Preorder and Inorder traversal, we have to make a tree from it.


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class TreeFromPreNdIn {
    static TreeNode buildTree(int[] pre,int[] in) {
        if (pre.length == 0 && in.length == 0) return null;
        HashMap<Integer, Integer> inMap = new HashMap<>();

        //adding the node and its pos in Inorder in the map
        for (int i = 0; i < pre.length; i++) {
            inMap.put(in[i], i);
        }

        TreeNode root = new TreeNode(inMap.get(pre[0]));

        root = buildTree(pre, 0, pre.length-1, in, 0, in.length - 1, inMap);
        return root;
    }
    static TreeNode buildTree(int[] pre, int preStart, int preEnd, int[] in, int inStart,
                                        int inEnd, Map<Integer,Integer> inMap) {
        if (preStart > preEnd || inStart > inEnd) return null;
        //preStart - the number starting the root of the subtree in preorder
        //preEnd - end of the preorder subtree
        TreeNode root = new TreeNode(pre[preStart]);

        int inRoot = inMap.get(pre[preStart]);
        int left = inRoot - inStart;

        root.left = buildTree(pre, preStart+1, preStart+left, in, inStart, inRoot - 1, inMap);
        root.right = buildTree(pre, preStart + left, preEnd, in, inRoot+1, inEnd, inMap);

        return root;
    }
}
