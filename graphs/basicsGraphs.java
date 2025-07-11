import java.util.*;

public class basicsGraphs {
    public static void addEdgeMat(int[][] mat, int i, int j){
        mat[i][j] = 1;
        mat[j][i] = 1;
    }
    static void printMat(int[][] mat){
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat.length; j++){
                System.out.print(mat[i][j]+" ");
            }
            System.out.println();
        }
    }

    static List<Integer> BFS(ArrayList<ArrayList<Integer>> adj) {
        List<Integer> result = new ArrayList<>();
        int n = adj.size();
        boolean[] visited = new boolean[n];
        Queue<Integer> qu = new LinkedList<>();
        qu.add(0);
        visited[0] = true;
        while (!qu.isEmpty()) {
            int curr = qu.poll();
            result.add(curr);
            for (int x : adj.get(curr)) {
                if (!visited[x]) {
                    visited[x] = true;
                    qu.add(x);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[4][4];
        addEdgeMat(matrix,1,0);
        addEdgeMat(matrix, 2, 3);
        addEdgeMat(matrix,0,2);

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        adj.add(new ArrayList<>(Arrays.asList(1, 2)));
        adj.add(new ArrayList<>(Arrays.asList(0, 2, 3)));
        adj.add(new ArrayList<>(Arrays.asList(0, 4)));
        adj.add(new ArrayList<>(Arrays.asList(1,4)));
        adj.add(new ArrayList<>(Arrays.asList(2,3)));

        System.out.println(BFS(adj));
    }
}
