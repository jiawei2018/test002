package googleOA;

public class oa19FillMatrix {

    public static void main(String[] args) {

    }
    /*Given a NxN matrix. Fill the integers from 1 to n*n to this matrix that makes the sum of each row,
    each column and the two diagonals equal.

Example 1:

Input: n = 2
Output: null
Explanation: We need to fill [1, 2, 3, 4] into a 2x2 matrix, which is not possible so return null.
Example 2:

Input: n = 3
Output:
[[8, 3, 4],
 [1, 5, 9],
 [6, 7, 2]]
Explanation: We need to fill [1, 2, 3... 9] into a 3x3 matrix. This is one way to do it
Each row [8, 3, 4] [1, 5, 9] [6, 7, 2] sum is 15.
Each column [8, 1, 6] [3, 5, 7] [4, 9, 2] sum is 15.
The two diagonals [8, 5, 2] [4, 5, 6] sum is 15.
int[][] fillMatrix(int n) {
}
    * */

    public int[][] fillMatrix(int n ){
        int[][] res = new int[n][n];



        return null;
    }

    private int form(int n){
        int sum = (n*n + 1)* n*n / 2;
        int edgeSum = sum / n;
        if(sum % n != 0){
            //false;
            return -1;
        }
        return edgeSum;
    }


}
