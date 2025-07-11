import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class DFS {
    static void dfsRecConnected(List<List<Integer>> adj, boolean[] visited, int s, ArrayList<Integer> result) {
        visited[s] = true;
        result.add(s);
        for (int i : adj.get(s)) {
            if (!visited[i]) {
                dfsRecConnected(adj, visited, i, result);
            }
        }
    }

    static List<Integer> dfsIter(List<List<Integer>> adj) {
        List<Integer> res = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        boolean[] visited = new boolean[adj.size()];
        stack.add(0);
        visited[0] = true;
        while (!stack.empty()) {
            int x = stack.pop();
            res.add(x);
            for (int i : adj.get(x)) {
                if (!visited[i]) {
                    visited[i] = true;
                    stack.add(i);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        List<List<Integer>> adj = new ArrayList<>();
        adj.add(new ArrayList<>(Arrays.asList(1, 2)));
        adj.add(new ArrayList<>(Arrays.asList(0,2)));
        adj.add(new ArrayList<>(Arrays.asList(0,1,3,4)));
        adj.add(new ArrayList<>(Arrays.asList(2)));
        adj.add(new ArrayList<>(Arrays.asList(2)));

        System.out.println(dfsIter(adj));
    }
}
