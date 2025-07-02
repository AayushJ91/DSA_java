import java.util.*;

public class PostOrder {
    //left right root
    static void recursive(TreeNode root) {
        if (root == null) return;

        recursive(root.left);
        recursive(root.right);
        System.out.print(root.data+",");
    }

    static ArrayList<Integer> recursive2(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<>();
        maker(result, root);
        return result;
    }

    static void maker(ArrayList<Integer> list, TreeNode root) {
        if (root == null) return;

        ArrayList<Integer> result = new ArrayList<>();
        maker(result, root.left);
        maker(result, root.right);
        list.add(root.data);
    }

    static ArrayList<Integer> Iterative1(TreeNode root) {
        //using 2 stacks
        Stack<TreeNode> st1 = new Stack<>();
        Stack<TreeNode> st2 = new Stack<>();
        ArrayList<Integer> result = new ArrayList<>();
        st1.push(root);
        while (!st1.isEmpty()) {
            TreeNode temp = st1.pop();
            st2.push(temp);
            if (temp.left != null) st1.push(temp.left);
            if (temp.right != null) st1.push(temp.right);
        }
        while (!st2.empty()) result.add(st2.pop().data);
        return result;
    }

    static ArrayList<Integer> Iterative2(TreeNode root){
        Stack<TreeNode> st = new Stack<>();
        ArrayList<Integer> result = new ArrayList<>();
        st.add(root);
        while (!st.isEmpty()) {
            TreeNode temp = st.pop();
            result.add(temp.data);
            if (temp.left != null) st.push(temp.left);
            if (temp.right != null) st.push(temp.right);
        }
        Collections.reverse(result);
        return result;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.left.right.left = new TreeNode(5);
        root.left.right.right = new TreeNode(6);
        root.right = new TreeNode(7);

        System.out.println("Iter2:"+Iterative2(root));
        System.out.println("Iter1:"+Iterative1(root));
    }
}
