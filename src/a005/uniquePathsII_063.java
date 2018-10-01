package a005;

/**
 * 63. Unique Paths II
 * DescriptionHintsSubmissionsDiscussSolution
 * Pick One
 * A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
 * The robot can only move either down or right at any point in time.
 * The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).
 * Now consider if some obstacles are added to the grids. How many unique paths would there be?
 * An obstacle and empty space is marked as 1 and 0 respectively in the grid.
 *
 * Note: m and n will be at most 100.
 *
 * Example 1:
 *
 * Input:
 * [
 *   [0,0,0],
 *   [0,1,0],
 *   [0,0,0]
 * ]
 * Output: 2
 * Explanation:
 * There is one obstacle in the middle of the 3x3 grid above.
 * There are two ways to reach the bottom-right corner:
 * 1. Right -> Right -> Down -> Down
 * 2. Down -> Down -> Right -> Right
 */
public class uniquePathsII_063 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int[][] tmp = obstacleGrid ;   //new int[obstacleGrid.length][obstacleGrid[0].length];
         //tmp = //obstacleGrid.clone();
       // System.out.println(obstacleGrid+ "  "+ tmp);

        int m = tmp.length;
        int n = tmp[0].length;
        obstacleGrid = new int[m][n];//clone法法也不行,还是同事变,靠你大爷 ,必须new 一个1数组,当然,我这写法也有问题.
        //System.out.println(n+ "  is n ");
        if( m == 0 || n == 0) return 1;
        for(int i = 0; i < m && tmp[i][0] != 1; i++){
                obstacleGrid[i][0] = 1;
        }

        for(int i = 0; i < n && tmp[0][i] != 1 ; i++){//&& tmp[0][i] != 1
                obstacleGrid[0][i] = 1;
        }





        for(int i = 1; i < m; i++){
            for(int j = 1; j < n; j++){
                //int k = (tmp[i - 1][j] == 1) ? 0: obstacleGrid[i - 1][j];      废话
               // int l = (tmp[i][j - 1] == 1) ? 0: obstacleGrid[i][j - 1];      废话
                if(tmp[i][j] != 1 ){
                    obstacleGrid[i][j] = obstacleGrid[i - 1][j] + obstacleGrid[i][j - 1];
                }else if(tmp[i][j] == 1){
                    obstacleGrid[i][j] = 0;
                }
            }
        }
        return obstacleGrid[m - 1][n - 1];
    }

    public static void main(String[] args){
        int[][] ins = {{0,0,0},{0,1,0},{0,0,0}};
        uniquePathsII_063 t = new uniquePathsII_063();
        System.out.println(t.uniquePathsWithObstacles(ins) + " answer ");
    }
}
