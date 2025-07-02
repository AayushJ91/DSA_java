//Problem: implementing preorder transversal;
//Link: self;
//Source: ChatGPT;
//Topics: Tree;
//Diff: Easy

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PreOrder {
    static void recursive(TreeNode root) {
        if (root == null) return;

        System.out.print(root.data+",");
        recursive(root.left);
        recursive(root.right);
    }

    static ArrayList<Integer> recursive2(TreeNode root) {
        if (root == null) return new ArrayList<>();

        ArrayList<Integer> result = new ArrayList<>();
        maker(root, result);
        return result;
    }

    private static void maker(TreeNode root, ArrayList<Integer> list){
        if (root == null) return;

        list.add(root.data);
        maker(root.left, list);
        maker(root.right, list);
    }

    static List<Integer> Iterative(TreeNode root) {
        //the video told to use a stack and print whatever is in the top of the stack

        Stack<TreeNode> st = new Stack<>();
        ArrayList<Integer> result = new ArrayList<>();
        if (root == null) return result;
        st.add(root);
        while (!st.empty()) {
            //Add first right node then the lft node to the stack
            //because left will be at the top
            //As it is preOrder, the popped node will be added first
            TreeNode temp = st.pop();
            result.add(temp.data);
            if (temp.right != null) st.add(temp.right);
            if (temp.left != null) st.add(temp.left);
        }
        return result;
    }

    public static void main(String[] args) {
        TreeNode root = null;
//        root.right = new TreeNode(2);
//        root.right.left = new TreeNode(3);

        System.out.println(Iterative(root));
    }
}
