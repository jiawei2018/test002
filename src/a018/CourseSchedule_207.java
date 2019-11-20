package a018;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class CourseSchedule_207 {
    //bfs solution
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int remain = numCourses;
        int[] ind = new int[remain];
        for (int[] cs : prerequisites) {
            ind[cs[0]]++;
        }
        Deque<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < ind.length; i++) {
            if (ind[i] == 0) {
                q.offer(i);
            }
        }
        while (!q.isEmpty()) {
            int tmp = q.poll();
            remain--;
            for (int[] cs : prerequisites) {
                if (cs[1] == tmp) {
                    ind[cs[0]]--;
                    if (ind[cs[0]] == 0) {
                        q.offer(cs[0]);
                    }
                }

            }
        }
        return remain == 0;
    }

    //from discussion DFS solution
    public boolean canFinish1(int numCourses, int[][] prerequisites) {
        List<Integer>[] from = new ArrayList[numCourses];// watch this
        for (int i = 0; i < numCourses; i++){
            from[i] = new ArrayList();
        }
        int[] to = new int[numCourses];
        boolean[] cur = new boolean[numCourses];//current course
        boolean[] isV = new boolean[numCourses];//is visited
        for (int[] pre : prerequisites) {
            from[pre[1]].add(pre[0]);
            to[pre[0]]++;
        }
        // check if circle exists
        for (int i = 0; i < numCourses; i++) {
            if (to[i] == 0 && !isV[i]) {
                if (findCircle(i, from, cur, isV)) {//better name  to  haveCircle
                    return false;
                }
            }
        }
        // check if all courses are reachable
        for (int i = 0; i < numCourses; i++) {
            if (to[i] != 0 && !isV[i]) return false;
        }
        return true;
    }

    private boolean findCircle(int idx, List<Integer>[] from, boolean[] cur, boolean[] isV) {
        if (isV[idx]) return false;
        if (cur[idx]) return true;

        cur[idx] = true;
        for (int i : from[idx]) {
            if (findCircle(i, from, cur, isV)) {
                return true;
            }
        }
        cur[idx] = false;
        isV[idx] = true;
        return false;
    }


}
