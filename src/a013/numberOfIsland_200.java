package a013;

/**
 * 200.
 * Number of Islands
 * Difficulty
 * Medium

 * Submissions
 * Given a 2d grid map of '1's (land) and '0's (water), count the number of islands.
 * An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically.
 * You may assume all four edges of the grid are all surrounded by water.
 *
 * Example 1:
 *
 * Input:
 * 11110
 * 11010
 * 11000
 * 00000
 *
 * Output: 1
 * Example 2:
 *
 * Input:
 * 11000
 * 11000
 * 00100
 * 00011
 *
 * Output: 3
 */
public class numberOfIsland_200 {
    public static void main(String[] args) {
       // char[][] a =
               // {{"1","1","1","1","0"},{"1","1","0","1","0"},{"1","1","0","0","0"},{"0","0","0","0","0"}}
    }
    public int numIslands(char[][] grid) {
        if(grid.length == 0 || grid[0].length == 0){
            return 0;
        }
        int row = grid.length;
        int col = grid[0].length;
        boolean[][] visited = new boolean[row][col];
        int res = 0;
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(grid[i][j] == '1' && !visited[i][j]){
                    res++;
                    expend(grid, visited, i, j);
                }
            }
        }
        return res;
    }

    private void expend(char[][] grid, boolean[][] visited, int idxrow, int idxcol){

        int row = idxrow;
        int col = idxcol;
        if(row < 0 || row >= grid.length || col < 0 || col >= grid[0].length ){
            return;
        }else if( !visited[row][col] && grid[row][col] == '1'){
            visited[row][col] = true;

            expend(grid, visited, row+ 1, col);
            expend(grid, visited, row , col + 1);
            expend(grid, visited, row - 1, col);
            expend(grid, visited, row , col - 1);
        }
    }
}
