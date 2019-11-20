package amazonOA;

public class SpiralMatrix_II {
    /*
    59. Spiral Matrix II
Given a positive integer n,
generate a square matrix filled with elements from 1 to n2 in spiral order.

Example:

Input: 3
Output:
[
 [ 1, 2, 3 ],
 [ 8, 9, 4 ],
 [ 7, 6, 5 ]
]
    * */
    public int[][] generateMatrix(int n) {
        if( n < 1 ){
            return new int[0][0];
        }
        if(n == 1){
            return new int[][]{{1}};
        }

        int[][] res = new int[n][n];
        int left = 0;
        int top = 0;
        int right = n - 1;
        int bottom = n - 1;

        int z = 1;// from 1 to n^2 like a timer...

        while(left <= right && top <= bottom){
            // top most row
            int curleft = left;
            while(curleft <= right){
                res[top][curleft++] = z++;
            }
            top++;

            //right most col
            int curtop = top;
            while(curtop <= bottom){
                res[curtop++][right] = z++;
            }
            right--;

            //bottom row
            if(top <= bottom){
                int curright = right;
                while(curright >= left){
                    res[bottom][curright--] = z++;
                }
                bottom--;
            }

            //left most col
            if(left <= right){
                int curbottom = bottom;
                while(curbottom >= top){
                    res[curbottom--][left] = z++;
                }
                left++;
            }
        }
        return res;
    }

    //can we do recursion version ?

    private void recur(int[][] matrix, int x, int y, boolean condition) {
        if(condition){

        }
    }


}
