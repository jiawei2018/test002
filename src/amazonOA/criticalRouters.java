package amazonOA;

import java.util.*;
/*
* AWS wants to increase the reliability of their network by
* upgrading crucial data center routers.
* Each data center has a single router that is connected to
* every other data center through a direct link or some other data center.

To increase the fault tolerance of the network,
AWS wants to identify routers which would result in a
disconnected network if they went down and replace then with upgraded versions.

Write an algorithm to identify all such routers.

Input:

The input to the function/method consists of three arguments:

numRouters, an integer representing the number of routers in the data center.
numLinks, an integer representing the number of links between the pair of routers.
Links, the list of pair of integers - A, B representing
a link between the routers A and B. The network will be connected.
Output:

Return a list of integers representing the routers
with need to be connected to the network all the time.

Example:

Input:

numRouters = 7
numLinks = 7       // for this ,might means nothing
Links = [[0,1], [0, 2], [1, 3], [2, 3], [2, 5], [5, 6], [3,4]]

Output:

[2, 3, 5]

Explanation:

On disconnecting router 2, a packet may be routed either to the routers- 0, 1, 3, 4 or the routers - 5, 6, but not to all.

On disconnecting router 3, a packet may be routed either to the routers - 0,1,2,5,6 or to the router - 4, but not to all.

On disconnecting router 5, a packet may be routed either to the routers - 0,1,2,3,4 or to the router - 6, but not to all.
* */




/*
this problem is looks like critical connections but not the same,
a graph have CC MUST have CR,
but have CR does NOT MUST have cc...
example: 4 is CR, but no CC in this graph.
               1
             /   \
            2     3
             \   /
               4
             /  \
            5    6
            \   /
              7
  if a node have one node can not go back, then this node is a CR
    is this graph .is connected ?





 */



public class criticalRouters {



















    public static void main(String[] args) {
        criticalRouters t = new criticalRouters();

        int numRouters1 = 5;
        int numLinks1 = 6;
        int[][] links1 = {{0, 1}, {1, 2}, {0, 2}, {2, 3}, {2, 4}, {3, 4}};
        System.out.println(t.cRouters(t.convert(links1), numRouters1));

        int numRouters2 = 5;
        int numLinks2 = 5;
        int[][] links2 = {{0, 1}, {1, 2}, {0, 2}, {0, 3}, {3, 4}};

        System.out.println(t.cRouters(t.convert(links2), numRouters2));

        int numRouters3 = 4;
        int numLinks3 = 3;
        int[][] links3 = {{0, 1}, {1, 2}, {2, 3}};

        System.out.println(t.cRouters(t.convert(links3), numRouters3));

        int numRouters4 = 7;
        int numLinks4 = 7;
        int[][] links4 = {{0, 1}, {0, 2}, {1, 3}, {2, 3}, {2, 5}, {5, 6}, {3, 4}};

        System.out.println(t.cRouters(t.convert(links4), numRouters4));

        int numRouters5 = 4;
        int numLinks5 = 4;
        int[][] links5 = {{0, 1}, {0, 2}, {0, 3}};
        System.out.println(t.cRouters(t.convert(links5), numRouters5));

                //my new test
        int numRouters6 = 4;
        int numLinks6 = 4;
        int[][] links6 = {{0, 1}, {0, 2}, {0, 3}, {1, 3}, {2, 3}};
        System.out.println(t.cRouters(t.convert(links6), numRouters6));


        /*
        * [2]
        [0, 3]
        [1, 2]
        [2, 3, 5]
        [0]
        *
        *
        * */

    }

    private List<List<Integer>> convert(int[][] arrs){
        List<List<Integer>> res = new ArrayList<>();
        for(int[] nums : arrs){
            int a = nums[0];
            int b = nums[1];
            res.add(Arrays.asList(a, b));
        }
        return res;
    }



    public List<Integer> cRouters(List<List<Integer>> connections, int n ){
       List<Integer>[] graph = new List[n];
       for(int i = 0; i < n; i++){
           graph[i] = new ArrayList<>();
       }
       Set<Integer> res = new HashSet<>();
       if(connections == null || connections.size() == 0){
           return new ArrayList<>();
       }
       timer = 0;

        //build graoh with adjascent list
        for(List<Integer> edge :connections) {
            //change into undirected graph
            graph[edge.get(0)].add(edge.get(1));
            graph[edge.get(1)].add(edge.get(0));
        }
        int[] time = new int[n];
        int[] lowestTime = new int[n];
        boolean[] visited = new boolean[n];
        int[] parent = new int[n];
        Arrays.fill(parent, -1);

        for(int i = 0; i < n; i++){
            if(!visited[i]){
                recur(res, graph, parent, i, time, lowestTime, visited);
            }
        }
        //System.out.println();
        return new ArrayList<>(res);
    }

    int timer ;
    private void recur(Set<Integer> res, List<Integer>[] graph, int[] parent,
                       int cur, int[] discoverTime, int[] lowestTime, boolean[] visited){
        visited[cur] = true;
        int children = 0;
        int curtime = timer++;
        lowestTime[cur] = curtime;
        discoverTime[cur] = curtime;

        for(int nei : graph[cur]){
            if(!visited[nei]){
                parent[nei] = cur;
                children++;
                recur(res, graph, parent, nei, discoverTime,lowestTime, visited);
                lowestTime[cur] = Math.min(lowestTime[cur], lowestTime[nei]);
                //case for root of graph 2 child is a CR
                //此处需要仔细理解,结合我的最后一个例子看,箱单难的题目
                if(parent[cur] == -1 && children > 1) {//must > 1 or fail
                    res.add(cur);
                }
                if(parent[cur] != -1 && lowestTime[nei] >= discoverTime[cur]) {//must >= not just >
                    res.add(cur);
                }
            } else if(nei != parent[cur]){
                lowestTime[cur] = Math.min(lowestTime[cur], discoverTime[nei]);
            }
        }
        //bug, 1. same node -> use set
        //2. why case 1cant pass ?
    }



}


//void APUtil(int u, boolean visited[], int disc[],
//                int low[], int parent[], boolean ap[])
//    {
//
//        // Count of children in DFS Tree
//        int children = 0;
//
//        // Mark the current node as visited
//        visited[u] = true;
//
//        // Initialize discovery time and low value
//        disc[u] = low[u] = ++time;
//
//        // Go through all vertices aadjacent to this
//        Iterator<Integer> i = adj[u].iterator();
//        while (i.hasNext())
//        {
//            int v = i.next();  // v is current adjacent of u
//
//            // If v is not visited yet, then make it a child of u
//            // in DFS tree and recur for it
//            if (!visited[v])
//            {
//                children++;
//                parent[v] = u;
//                APUtil(v, visited, disc, low, parent, ap);
//
//                // Check if the subtree rooted with v has a connection to
//                // one of the ancestors of u
//                low[u]  = Math.min(low[u], low[v]);
//
//                // u is an articulation point in following cases
//
//                // (1) u is root of DFS tree and has two or more chilren.
//                if (parent[u] == NIL && children > 1)
//                    ap[u] = true;
//
//                // (2) If u is not root and low value of one of its child
//                // is more than discovery value of u.
//                if (parent[u] != NIL && low[v] >= disc[u])
//                    ap[u] = true;
//            }
//
//            // Update low value of u for parent function calls.
//            else if (v != parent[u])
//                low[u]  = Math.min(low[u], disc[v]);
//        }