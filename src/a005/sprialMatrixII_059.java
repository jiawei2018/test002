package a005;

/**
 * 59. Spiral Matrix II
 * DescriptionHintsSubmissionsDiscussSolution
 * Pick One
 * Given a positive integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.
 *
 * Example:
 *
 * Input: 3
 * Output:
 * [
 *  [ 1, 2, 3 ],
 *  [ 8, 9, 4 ],
 *  [ 7, 6, 5 ]
 * ]
 */
public class sprialMatrixII_059 {
    public int[][] generateMatrix(int n) {
        if(n == 0 ) return new int[0][0];
        int[][] res = new int[n][n];
        int top = 0;
        int right = n - 1;
        int bottom = n - 1;
        int left = 0;
        int count = 1;
        while( top <= bottom  && left <= right  ){
            for(int i = left; i <= right; i++){//must be <= or will missing some cornor case
                res[top][i] = count++;
            }
            top++;

            for(int i = top; i <= bottom; i++ ){//must be <= or will missing some cornor case
                res[i][right] = count++;
            }
            right--;

            for(int i = right; i >= left; i-- ){//must be >= or will missing some cornor case
                res[bottom][i] = count++;
            }
            bottom--;

            for(int i = bottom; i >= top; i--){//must be >= or will missing some cornor case
                res[i][left] = count++;
            }
            left++;
        }
        return res;
    }
}
