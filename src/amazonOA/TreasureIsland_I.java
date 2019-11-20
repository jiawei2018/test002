package amazonOA;

import java.util.LinkedList;
import java.util.Queue;

public class TreasureIsland_I {
    /*
    * You have a map that marks the location of a treasure island.
    * Some of the map area has jagged rocks and dangerous reefs.
    * Other areas are safe to sail in.
    * There are other explorers trying to find the treasure.
    * So you must figure out a shortest route to the treasure island.

Assume the map area is a two dimensional grid,
represented by a matrix of characters.
You must start from the top-left corner of the map and
can move one block up, down, left or right at a time.
The treasure island is marked as X in a block of the matrix.
X will not be at the top-left corner.
Any block with dangerous rocks or reefs will be marked as D. You must not enter dangerous blocks.
 You cannot leave the map area. Other areas O are safe to sail in. The top-left corner is always safe.
 Output the minimum number of steps to get to the treasure.

Example:

Input:
[['O', 'O', 'O', 'O'],
 ['D', 'O', 'D', 'O'],
 ['O', 'O', 'O', 'O'],
 ['X', 'D', 'D', 'O']]

Output: 5
Explanation: Route is (0, 0), (0, 1), (1, 1), (2, 1), (2, 0), (3, 0) The minimum route takes 5 steps.
    * */
    //very easy bfs in 2d-array no need to write it.

    final int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public int treasureIsland(char[][] islands) {
        if (islands.length == 0 || islands[0].length == 0 || islands[0][0] == 'D') return -1;
        if (islands[0][0] == 'X') return 0;
        Queue<int[]> queue = new LinkedList<>();
        int steps = 1;
        queue.add(new int[]{0, 0});
        int m = islands.length;
        int n = islands[0].length;
        boolean[][] visited = new boolean[m][n];
        visited[0][0] = true;
        //islands[0][0] = 'D';//we don't want to mess with original input. use visited

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] pos = queue.poll();
                for (int[] dir : dirs) {
                    int x = pos[0] + dir[0], y = pos[1] + dir[1];
                    if (x < 0 || x >= m || y < 0 || y >= n || visited[x][y]) continue;
                    if (islands[x][y] == 'X') return steps;
                    queue.add(new int[]{x, y});
                    visited[x][y] = true;
                }
            }
            ++steps;
        }
        return -1;
    }


}
