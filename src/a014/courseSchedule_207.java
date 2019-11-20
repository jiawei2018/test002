package a014;

/**
 * 207.
 * Course Schedule
 * Difficulty
 * Medium

 * There are a total of n courses you have to take, labeled from 0 to n-1.
 *
 * Some courses may have prerequisites,
 * for example to take course 0 you have to first take course 1,
 * which is expressed as a pair: [0,1]
 *
 * Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses?
 *
 * Example 1:
 *
 * Input: 2, [[1,0]]
 * Output: true
 * Explanation: There are a total of 2 courses to take.
 *              To take course 1 you should have finished course 0. So it is possible.
 * Example 2:
 *
 * Input: 2, [[1,0],[0,1]]
 * Output: false
 * Explanation: There are a total of 2 courses to take.
 *              To take course 1 you should have finished course 0, and to take course 0 you should
 *              also have finished course 1. So it is impossible.
 * Note:
 *
 * The input prerequisites is a graph represented by a list of edges,
 * not adjacency matrices.
 * Read more about how a graph is represented.
 * You may assume that there are no duplicate edges in the input prerequisites.
 */
public class courseSchedule_207 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        //拓扑排序问题,先放一放

        return false;
    }

    /**
     * 【解析】
     * 典型的拓扑排序。原理也很简单，在一个有向图中，每次找到一个没有前驱节点的节点（也就是入度为0的节点），然后把它指向其他节点的边都去掉，重复这个过程（BFS），直到所有节点已被找到，或者没有符合条件的节点（如果图中有环存在）。
     *
     * 回顾一下图的三种表示方式：边表示法（即题目中表示方法），邻接表法，邻接矩阵。用邻接表存储图比较方便寻找入度为0的节点。
     *
     * 【Java代码】
     *
     * public class Solution {
     *     public boolean canFinish(int numCourses, int[][] prerequisites) {
     *         // init the adjacency list
     *         List<Set> posts = new ArrayList<Set>();
     *         for (int i = 0; i < numCourses; i++) {
     *             posts.add(new HashSet<Integer>());
     *         }
     *
     *         // fill the adjacency list
     *         for (int i = 0; i < prerequisites.length; i++) {
     *             posts.get(prerequisites[i][1]).add(prerequisites[i][0]);
     *         }
     *
     *         // count the pre-courses
     *         int[] preNums = new int[numCourses];
     *         for (int i = 0; i < numCourses; i++) {
     *             Set set = posts.get(i);
     *             Iterator<Integer> it = set.iterator();
     *             while (it.hasNext()) {
     *             	preNums[it.next()]++;
     *             }
     *         }
     *
     *         // remove a non-pre course each time
     *         for (int i = 0; i < numCourses; i++) {
     *             // find a non-pre course
     *             int j = 0;
     *             for ( ; j < numCourses; j++) {
     *                 if (preNums[j] == 0) break;
     *             }
     *
     *             // if not find a non-pre course
     *             if (j == numCourses) return false;
     *
     *             preNums[j] = -1;
     *
     *             // decrease courses that post the course
     *             Set set = posts.get(j);
     *             Iterator<Integer> it = set.iterator();
     *             while (it.hasNext()) {
     *             	preNums[it.next()]--;
     *             }
     *         }
     *
     *         return true;
     *     }
     * }
     * 注意，输入可能有重复的边，所以邻接表用HashSet存储。
     *
     * 下面一种代码是不用HashSet的，对于重复的边，它在邻接表中村了两份，
     * 同时计算入度时也算了两次，所以代码不会有问题。但个人感觉最好用HashSet，这样符合图的定义。
     *
     * 下面的代码还是比较典型的BFS写法，大家可以对比理解下：
     *
     * public class Solution {
     *     public boolean canFinish(int numCourses, int[][] prerequisites) {
     *         List<List<Integer>> posts = new ArrayList<List<Integer>>();
     *         for (int i = 0; i < numCourses; i++) {
     *             posts.add(new ArrayList<Integer>());
     *         }
     *
     *         int[] preNums = new int[numCourses];
     *         for (int i = 0; i < prerequisites.length; i++) {
     *             posts.get(prerequisites[i][1]).add(prerequisites[i][0]);
     *             preNums[prerequisites[i][0]]++;
     *         }
     *
     *         Queue<Integer> queue = new LinkedList<Integer>();
     *         for (int i = 0; i < numCourses; i++) {
     *             if (preNums[i] == 0){
     *                 queue.offer(i);
     *             }
     *         }
     *
     *         int count = numCourses;
     *         while (!queue.isEmpty()) {
     *             int cur = queue.poll();
     *             for (int i : posts.get(cur)) {
     *                 if (--preNums[i] == 0) {
     *                     queue.offer(i);
     *                 }
     *             }
     *             count--;
     *         }
     *
     *         return count == 0;
     *     }
     *
     */
}
