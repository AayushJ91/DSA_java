import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;


//NHI HUA

public class CourseSchedule {
    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        if (prerequisites.length == 0) return false;
        boolean result = true;
        HashSet<Integer> visited = new HashSet<>();
        ArrayList<Integer> completed = new ArrayList<>();
        ArrayList<ArrayList<Integer>> preReq = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            preReq.add(new ArrayList<>());
        }
        for (int i = 0; i < prerequisites.length; i++) {
            int[] curr = prerequisites[i];
            preReq.get(curr[0]).add(curr[1]);
            //if you want to do curr[0] course you should do the curr[1] courses
        }
        System.out.println(preReq);
        for (int i = 0; i < numCourses; i++) {
            result &= dfs(preReq, visited, i, completed);
        }
        return result;
    }
    static boolean dfs(ArrayList<ArrayList<Integer>> preReq, HashSet<Integer> visited, int course, ArrayList<Integer> completed) {
        if (preReq.get(course).isEmpty()) {
            return true;
        }
        visited.add(course);
        for (int i = 0; i < preReq.get(course).size(); i++) {
            if (visited.contains(course)){
                return false;
            }
            dfs(preReq, visited, i, completed);
            preReq.get(course).removeLast();
        }
        return true;
    }
    public static void main(String[] args) {
        int[][] preReq = {{0,10},{3,18},{5,5},{6,11},{11,14},{13,1},{15,1},{17,4}};
        int[][] pre = {{1,0},{0,1}};
        int[][] preo = {{1,0},{2,0},{3,1},{3,2}};
        System.out.println(canFinish(4, preo));
    }
}
