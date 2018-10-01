package a004;

/**
 * 48. Rotate Image
 * DescriptionHintsSubmissionsDiscussSolution
 * Pick One
 * You are given an n x n 2D matrix representing an image.
 *
 * Rotate the image by 90 degrees (clockwise).
 *
 * Note:
 *
 * You have to rotate the image in-place, which means you have to modify the input 2D matrix directly. DO NOT allocate another 2D matrix and do the rotation.
 *
 * Example 1:
 *
 * Given input matrix =
 * [
 *   [1,2,3],
 *   [4,5,6],
 *   [7,8,9]
 * ],
 *
 * rotate the input matrix in-place such that it becomes:
 * [
 *   [7,4,1],
 *   [8,5,2],
 *   [9,6,3]
 * ]
 * Example 2:
 *
 * Given input matrix =
 * [
 *   [ 5, 1, 9,11],
 *   [ 2, 4, 8,10],
 *   [13, 3, 6, 7],
 *   [15,14,12,16]
 * ],
 *
 * rotate the input matrix in-place such that it becomes:
 * [
 *   [15,13, 2, 5],
 *   [14, 3, 4, 1],
 *   [12, 6, 8, 9],
 *   [16, 7,10,11]
 * ]
 */
public class rotateImage_048 {

    //此题的最好解法是利用矩阵的性质
    //常见3种解法
    public void rotate(int[][] matrix) {
        //此人方法最为直观和好理解!这才是好程序,易读性高.
        //https://www.youtube.com/watch?v=9ryIfj5DohI

        if(matrix == null || matrix.length == 0 || matrix[0].length == 0)return;

        int top = 0 , left = 0;
        int n = matrix.length;
        int bottom = n -1, right = n -1 ;

        while( n > 1){
            for(int i = 0; i < n -1; i++){
                int tmp = matrix[top][left + i];
                matrix[top][left + i] = matrix[bottom - i][left];//mistake , 手误,以后 这种最好复制
                matrix[bottom - i][left] = matrix[bottom][right - i];
                matrix[bottom][right - i] = matrix[top + i][right ];
                matrix[top + i][right ] = tmp;
            }
            top++;
            left++;
            bottom--;//so stupid , this should be -- not ++,
            right--;//
            n -= 2;//because top++ and bottom-- toward to center;
        }


    }




}
