package amazonOA;

import java.util.LinkedList;
import java.util.Queue;

public class Treasure_Island_II {

    /*
    You have a map that marks the locations of treasure islands.
    Some of the map area has jagged rocks and dangerous reefs.
    O    ther areas are safe to sail in.
    There are other explorers trying to find the treasure.
    So you must figure out a shortest route to one of the treasure islands.

Assume the map area is a two dimensional grid,
represented by a matrix of characters.
You must start from one of the starting point (marked as S) of the map
and can move one block up, down, left or right at a time.
The treasure island is marked as X.
Any block with dangerous rocks or reefs will be marked as D.
You must not enter dangerous blocks. You cannot leave the map area.
 Other areas O are safe to sail in.
 Output the minimum number of steps to get to any of the treasure islands.

Example:

Input:
[['S', 'O', 'O', 'S', 'S'],
 ['D', 'O', 'D', 'O', 'D'],
 ['O', 'O', 'O', 'O', 'X'],
 ['X', 'D', 'D', 'O', 'O'],
 ['X', 'D', 'D', 'D', 'O']]

Output: 3
Explanation:
You can start from (0,0), (0, 3) or (0, 4). The treasure locations are (2, 4) (3, 0) and (4, 0). Here the shortest route is (0, 3), (1, 3), (2, 3), (2, 4).

    * */

    //any to any bfs
    final int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public int shortestPath(char[][] islands){
        if(islands.length == 0 || islands[0].length == 0) return -1;
        int R = islands.length;
        int C = islands[0].length;
        Queue<int[]> queue = new LinkedList<>();//int[] is coordinates
        int steps = 1;

        for(int i = 0; i < R; i++){
            for(int j = 0; j < C; j++){
                if(islands[i][j] == 'S'){
                    queue.add(new int[]{i, j});
                    islands[i][j] = 'D';//mark visited
                }
            }
        }
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                int[] pos = queue.poll();
                for(int[] dir: dirs){
                    int x = pos[0] + dir[0];
                    int y = pos[1] + dir[1];
                    if(x < 0 || x >= R || y < 0 || y >= C || islands[x][y] == 'D') continue;
                    if(islands[x][y] == 'X') return steps;//any one touch first wins
                    queue.add(new int[]{x, y});
                    islands[x][y] = 'D';
                }
            }
            steps++;
        }
        return -1;//corner case
    }









    //leetcode 542 my solution, bfs
    public int[][] updateMatrix(int[][] matrix) {
        if(matrix == null || matrix.length == 0) {
            return matrix;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] res = new int[m][n];
        Queue<cood> queue = new LinkedList<>();
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(matrix[i][j] == 0) {
                    res[i][j] = 0;
                    queue.offer(new cood(i, j));
                } else {
                    res[i][j] = -1;
                }
            }
        }
        bfs(matrix, res, queue);
        return res;
    }

    final int[][] dir = {{0, 1}, {0, -1}, {1, 0,}, {-1, 0}};
    private void bfs(int[][] matrix, int[][] res, Queue<cood> queue ) {
        while(!queue.isEmpty()) {
            cood cur = queue.poll();
            for(int[] d : dir) {
                int nx = cur.x + d[0];
                int ny = cur.y + d[1];
                if(nx >= 0 && ny >= 0 && nx < matrix.length && ny < matrix[0].length && res[nx][ny] == -1 ) {
                    res[nx][ny] = res[cur.x][cur.y] + 1;
                    queue.offer(new cood(nx, ny));
                }
            }//for dir
        }//while
    }

    class cood {
        int x;
        int y;
        public cood(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }




}
