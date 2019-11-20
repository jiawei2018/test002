package amazonOA;

public class newMinPath2D {
    /*
    given you a 2d matrix int[][] /?might contains negitive number?/
    [1,2,3]
    [1,2,1]
    [3,2,3]
    from top-left   --> right bottom
    return the minimum of (biggest path numbers)
    it is  just in fact a dp problem
    but beware the base case



    * */



    public int getMinMaxPath(int[][] grid){
        //base top row, first col
        // dp[0][0] = grid[0][0];
        //for top row ,dp[i][j] or dp[0][j] == Math.max(dp[0][j-1], grid[0][j])
        //for first col,dp[i][0] = max(dp[i - 1][0], gird[i][0]);
        //the induction rule  will be like
        // comes = min(dp[i - 1][j], dp[i][j - 1]);
        // dp[i][j] = max(comes, grid[i][j]);
        return 0;
    }
}
