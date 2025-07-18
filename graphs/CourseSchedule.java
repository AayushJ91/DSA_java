//Problem: given a total n courses and a prerequisites matrix(ai,bi) which means for doing ai first we have to do bi;
//link: https://leetcode.com/problems/course-schedule/
//Source: LeetCode(207)
//Topics: graph
//Diff: Med

import java.util.*;


//NHI HUA

public class CourseSchedule {
    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        if (prerequisites.length == 0) return false;
        List<List<Integer>> courses = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            courses.add(new ArrayList<>());
        }
        for (int[] course : prerequisites) {
            courses.get(course[1]).add(course[0]);
        }
        int[] state = new int[numCourses]; // 0: not visited; 1: visiting; 2: visited
        for (int i = 0; i < numCourses; i++) {
            if (state[i] == 0) {
                if (!DFS(state, courses, i)) {
                    return false;
                }
            }
        }
        return true;
    }
    static boolean DFS(int[] state, List<List<Integer>> courses, int course) {
        if (state[course] == 1) {
            return false;
        }
        if (state[course] == 2) {
            return true;
        }

        state[course] = 1;
        for (int prerequisite : courses.get(course)) {
            if (!DFS(state, courses, prerequisite)) {
                return false;
            }
        }
        state[course] = 2; // Mark as visited (finished)
        return true;
    }

    public static void main(String[] args) {
        int[][] preReq = {{0,10},{3,18},{5,5},{6,11},{11,14},{13,1},{15,1},{17,4}};
        int[][] pre = {{1,0},{0,1}};
        int[][] preo = {{1,0},{2,0},{3,1},{3,2}};
        System.out.println(canFinish(4, preo));
    }
}
