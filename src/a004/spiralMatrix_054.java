package a004;

import java.util.ArrayList;
import java.util.List;

/**
 * 54. Spiral Matrix
 * DescriptionHintsSubmissionsDiscussSolution
 * Pick One
 * Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.
 *
 * Example 1:
 *
 * Input:
 * [
 *  [ 1, 2, 3 ],
 *  [ 4, 5, 6 ],
 *  [ 7, 8, 9 ]
 * ]
 * Output: [1,2,3,6,9,8,7,4,5]
 * Example 2:
 *
 * Input:
 * [
 *   [1, 2, 3, 4],
 *   [5, 6, 7, 8],
 *   [9,10,11,12]
 * ]
 * Output: [1,2,3,4,8,12,11,10,9,5,6,7]
 */

public class spiralMatrix_054 {
    public List<Integer> spiralOrder(int[][] matrix) {
        if(matrix == null ) return null;
        List<Integer> res = new ArrayList<>();
        if( matrix.length == 0 || matrix[0].length == 0) return res;//注意此处的用法!!!!!!!!!!!!!


        int top = 0;
        int height = matrix.length -1;
        int width = matrix[0].length -1;
        int rightst = 0;

        while( top <= height &&  rightst <= width){

            //top - right to top -left
            for(int i = rightst; i<= width; i++){
                res.add(matrix[top][i]);
            }
            top++;

            for(int i = top; i <= height; i++ ){
                res.add(matrix[i][width]);
            }
            width--;

            if(top <= height) {///必须有!!!!!!!!
                for (int i = width; i >= rightst; i--) {
                    res.add(matrix[height][i]);
                }
                height--;
            }

            if(rightst <= width) {///必须有!!!!!!!!!!!!!!
                for (int i = height; i >= top; i--) {
                    res.add(matrix[i][rightst]);
                }
                rightst++;
            }

        }

        return res;
    }

}
