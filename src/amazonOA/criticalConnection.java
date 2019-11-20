package amazonOA;

import java.util.*;

public class criticalConnection {
    /*
    1192. Critical Connections in a Network

There are n servers numbered from 0 to n-1 connected
by undirected server-to-server connections forming a network
where connections[i] = [a, b] represents a connection between servers a and b.
Any server can reach any other server directly or indirectly through the network.
A critical connection is a connection that, if removed,
will make some server unable to reach some other server.
Return all critical connections in the network in any order.[notice here is ANY ORDER]
    * */
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {


        //must use list<>[] to rep graph, if use map<node, list<nei>> will TLE
        List<Integer>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++){
            graph[i] = new ArrayList<>();
        }

        //build graoh with adjascent list
        for(List<Integer> edge :connections) {
            graph[edge.get(0)].add(edge.get(1));
            graph[edge.get(1)].add(edge.get(0));
        }

        List<List<Integer>> results = new ArrayList<>();
        boolean[] visited = new boolean[n];
        int[] timeStamp = new int[n];

        // -1 means node 0's parents does not exist
        find(graph, -1, 0, visited, results, timeStamp);
        return results;
    }

    int timer = 0;

    public void find(List<Integer>[] graph, int parent, int node,
                     boolean[] visited, List<List<Integer>> results, int[] timeStamp) {
        visited[node] = true;
        timeStamp[node] = timer++;
        int cur = timeStamp[node];

        for(int nei : graph[node]) {
            if(nei == parent) continue;

            if(!visited[nei]) {
                find(graph, node, nei, visited, results, timeStamp);
            }

            //update current's smallest reachable node's id
            timeStamp[node] = Math.min(timeStamp[node], timeStamp[nei]);
            if(cur < timeStamp[nei]) {
                results.add(Arrays.asList(node, nei));
            }
        }
    }


    /*
Amazon | OA 2019 | Critical Routers
14
Anonymous User
Anonymous User
Last Edit: November 2, 2019 9:19 AM

9.6K VIEWS

AWS wants to increase the reliability of their network by upgrading crucial data center routers. Each data center has a single router that is connected to every other data center through a direct link or some other data center.

To increase the fault tolerance of the network, AWS wants to identify routers which would result in a disconnected network if they went down and replace then with upgraded versions.

Write an algorithm to identify all such routers.

Input:

The input to the function/method consists of three arguments:

numRouters, an integer representing the number of routers in the data center.
numLinks, an integer representing the number of links between the pair of routers.
Links, the list of pair of integers - A, B representing a link between the routers A and B. The network will be connected.
Output:

Return a list of integers representing the routers with need to be connected to the network all the time.

Example:

Input:

numRouters = 7
numLinks = 7
Links = [[0,1], [0, 2], [1, 3], [2, 3], [2, 5], [5, 6], [3,4]]

Output:

[2, 3, 5]

Explanation:

On disconnecting router 2, a packet may be routed either to the routers- 0, 1, 3, 4 or the routers - 5, 6, but not to all.

On disconnecting router 3, a packet may be routed either to the routers - 0,1,2,5,6 or to the router - 4, but not to all.

On disconnecting router 5, a packet may be routed either to the routers - 0,1,2,3,4 or to the router - 6, but not to all.

Related problems:

Critical Connections

     */


}
