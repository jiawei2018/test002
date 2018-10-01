package a005;

/**
 * 64. Minimum Path Sum
 * DescriptionHintsSubmissionsDiscussSolution
 * Pick One
 * Given a m x n grid filled with non-negative numbers,
 * find a path from top left to bottom right which minimizes the sum of all numbers along its path.
 *
 * Note: You can only move either down or right at any point in time.
 *
 * Example:
 *
 * Input:
 * [
 *   [1,3,1],
 *   [1,5,1],
 *   [4,2,1]
 * ]
 * Output: 7
 * Explanation: Because the path 1→3→1→1→1 minimizes the sum.
 */

public class minimumPathSum_064 {
    public int minPathSum(int[][] grid) {
        if(grid.length == 0 || grid[0].length ==0) return 0;
        int m = grid.length;
        int n = grid[0].length;

        int[][] res = new int[m][n];
        res[0][0] = grid[0][0];
        for(int i = 1; i < m; i ++){
            res[i][0] = grid[i][0] + res[i - 1][0];
        }

        for(int i = 1; i < n; i++){
            res[0][i] = grid[0][i] + res[0][i - 1];
        }

        for(int i = 1; i < m; i++){
            for(int j = 1; j < n; j++){
                res[i][j] = Math.min(grid[i][j] + res[i - 1][j], grid[i][j] + res[i][j - 1]);
                //System.out.println(res[i][j] + " <>  " + grid[i][j] );
            }
        }

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
               // System.out.println(res[i][j]);
            }
        }
        return res[m - 1][n - 1];
    }




    public static void main(String[] args){
        minimumPathSum_064 t = new minimumPathSum_064();
        int[][] ins ={{1,3,1},{1,5,1},{4,2,1}};

        int s = t.minPathSum(ins);
        System.out.println(s + " answer");
    }
}
