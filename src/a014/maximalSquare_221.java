package a014;

/**
 * 221.
 * Maximal Square
 * Difficulty
 * Medium

 * Given a 2D binary matrix filled with 0's and 1's,
 * find the largest square containing only 1's and return its area.
 *
 * Example:
 *
 * Input:
 *
 * 1 0 1 0 0
 * 1 0 1 1 1
 * 1 1 1 1 1
 * 1 0 0 1 0
 *
 * Output: 4
 */
public class maximalSquare_221 {
    public int maximalSquare(char[][] matrix) {
        if(matrix.length < 1 || matrix[0].length < 1){
            return 0;
        }
        int row = matrix.length;
        int col = matrix[0].length;
        int maxEdgeLen = 0;
        int[][] dp = new int[row][col];
        //没有感觉,没看出来dp

        //物理意义!!物理意义!!物理意义!!物理意义!!物理意义!!物理意义!!


        //     当我们判断以某个点为正方形右下角时最大的正方形时，那它的上方，
        // 左方和左上方三个点也一定是某个正方形的右下角，否则该点为右下角的正方形最大就是它自己了。
        // 这是定性的判断，那具体的最大正方形边长呢？我们知道，该点为右下角的正方形的最大边长，
        // 最多比它的上方，左方和左上方为右下角的正方形的边长多1，最好的情况是是它的上方，
        // 左方和左上方为右下角的正方形的大小都一样的，这样加上该点就可以构成一个更大的正方形。
        //       但如果它的上方，左方和左上方为右下角的正方形的大小不一样，合起来就会缺了某个角落，
        // 这时候只能取那三个正方形中最小的正方形的边长加1了。假设dpi表示以i,j为右下角的正方形的最大边长，则有
        //就是  3 个 正方形 里面挑最小的那个然后和当前的点构成一个大一点正方形.
        for(int i = 0; i < row; i++){
           dp[i][0] = matrix[i][0] == '1' ? 1 : 0;
           if(dp[i][0] == 1){
               maxEdgeLen = 1;//corner case
           }
        }

        for(int i = 0; i < col; i++){
            dp[0][i] = matrix[0][i] == '1' ? 1 : 0;
            if(dp[0][i] == 1){
                maxEdgeLen = 1;// corner case
            }
        }

        for(int i = 1; i < row; i++){
            for(int j = 1; j < col; j++){
                if( matrix[i][j] == '1'){
                    dp[i][j] = Math.min(dp[i - 1][j], Math.min(dp[i][j - 1], dp[i - 1][j - 1])) + 1;
                    maxEdgeLen = Math.max(maxEdgeLen, dp[i][j]);
                }
            }
        }

        return maxEdgeLen * maxEdgeLen;
    }





}
