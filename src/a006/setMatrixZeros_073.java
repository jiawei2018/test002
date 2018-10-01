package a006;

/**
 * 73. Set Matrix Zeroes
 * DescriptionHintsSubmissionsDiscussSolution
 * Pick One
 * Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in-place.
 *
 * Example 1:
 *
 * Input:
 * [
 *   [1,1,1],
 *   [1,0,1],
 *   [1,1,1]
 * ]
 * Output:
 * [
 *   [1,0,1],
 *   [0,0,0],
 *   [1,0,1]
 * ]
 * Example 2:
 *
 * Input:
 * [
 *   [0,1,2,0],
 *   [3,4,5,2],
 *   [1,3,1,5]
 * ]
 * Output:
 * [
 *   [0,0,0,0],
 *   [0,4,5,0],
 *   [0,3,1,0]
 * ]
 * Follow up:
 *
 * A straight forward solution using O(mn) space is probably a bad idea.
 * A simple improvement uses O(m + n) space, but still not the best solution.
 * Could you devise a constant space solution?
 */
public class setMatrixZeros_073 {


    //相同的矩阵是o(mn),两个array是o(ｍ　＋ｎ)　，标记到　第一行，第一列是o(1)
    public void setZeroes(int[][] matrix) {
        if(matrix == null || matrix[0].length == 0 || matrix.length ==0)
            return ;

        //本题就是个Corner case的 大讨论,还有就是标记到第一行和第一列是个思路
        //这点要学会
        int w = matrix.length;
        int h = matrix[0].length;
        boolean row = false;
        boolean col = false;


        for(int i = 0; i < w; i++){//题点
            if(matrix[i][0] == 0) row =true;
        }
        for(int i = 0; i < h; i++){//题点
            if(matrix[0][i] == 0) col =true;
        }


        for(int i = 1; i < w; i++ ){
            for(int j = 1; j < h; j++){
                if(matrix[i][j] == 0){
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        for(int i = 1; i < w; i++ ){//strat from 1 题点
            int jj = 1;
            while(jj < h && matrix[i][0] == 0){
                matrix[i][jj] = 0;
                jj++;
            }
        }

        for(int i = 1; i < h; i++ ){//strat from 1 题点
            int jj = 1;
            while(jj < w && matrix[0][i] == 0){
                matrix[jj][i] = 0;
                jj++;
            }
        }
        // first line
        if(row){
            for(int i = 0; i < w; i++) matrix[i][0] =0;
        }

        if(col){
            for(int i = 0; i < h; i++) matrix[0][i] =0;
        }

    }
}
