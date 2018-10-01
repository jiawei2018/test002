package a006;

/**
 * 74. Search a 2D Matrix
 * DescriptionHintsSubmissionsDiscussSolution
 * Pick One
 * Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:
 *
 * Integers in each row are sorted from left to right.
 * The first integer of each row is greater than the last integer of the previous row.
 * Example 1:
 *
 * Input:
 * matrix = [
 *   [1,   3,  5,  7],
 *   [10, 11, 16, 20],
 *   [23, 30, 34, 50]
 * ]
 * target = 3
 * Output: true
 * Example 2:
 *
 * Input:
 * matrix = [
 *   [1,   3,  5,  7],
 *   [10, 11, 16, 20],
 *   [23, 30, 34, 50]
 * ]
 * target = 13
 * Output: false
 */

public class searchA2DMatrix_074 {

   // public boolean searchMatrix(int[][] matrix, int target) {

        //边界问题不好处理,现在还想不出来该怎么办
        //失败
//        if(matrix.length == 0 || matrix[0].length == 0|| matrix == null) return false;
//        if(target < matrix[0][0] || target > matrix[matrix.length - 1][matrix[0].length - 1]) return false;
//
//        int idxc = 0;
//        if(matrix.length > 1){
//            int[] col = new int[matrix.length];
//            for(int i = 0; i < col.length; i++) col[i] = matrix[i][0];
//            idxc = bs(col, target);
//        }
//
//        int idxr = 0;
//        if(matrix[0].length > 1){
//            int[] row = new int[matrix[0].length];
//            for(int i = 0; i < row.length; i++) row[i] = matrix[idxc][i];
//            idxr = bs(row, target);
//        }
//
//        System.out.println( idxr + "  " + idxc);
//        if(matrix[idxc][idxr] == target){
//            return true;
//        }
//        return false;
//    }
//
//    private int bs(int[] nums, int target){
//        //return idx of row /col of target should be.
//        int left = 0;
//        int right = nums.length;
//        int mid  = 0;
//        while(left < right ){//&& right - left > 1
//            mid = (left + right) / 2;
//            if(nums[mid] == target) return mid;
//            if(target > nums[mid]){
//                left = mid + 1;
//            }
//            if(target < nums[mid]){
//                right = mid - 1;
//            }
//        }
//        return left;
   // }

    public boolean searchMatrix(int[][] matrix, int target) {
        //二维思想
        //把二位数组铺平 二分查找;
        //题眼就是二维转一维

        if (matrix.length == 0 || matrix[0].length == 0 || matrix == null) return false;
        int m = matrix.length;//m*n   m 行-x    n 列-y(每行几个元素)
        int n = matrix[0].length;

        int left = 0;
        int right = m*n - 1;
        while(left <= right){
            int mid = (left + right) / 2;
            int midx =  mid / n ; //题眼
            int midy = mid % n;//题眼

            if(matrix[midx][midy] == target)return true;
            if(matrix[midx][midy] > target){
                right = mid - 1;//mistake
            }else{
                left = mid + 1;//mistake
            }
        }
        return false;
    }

    /**
     * public boolean searchMatrix(int[][] matrix, int target) {
     * 		if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
     * 			return false;
     *
     * 		int m = matrix.length;
     * 		int n = matrix[0].length;
     * 		int start = 0;
     * 		int end = m * n - 1;
     * 		while (start <= end) {
     * 			int mid = start + (end - start) / 2;
     * 			int midX = mid / n;
     * 			int midY = mid % n;
     *
     * 			if (matrix[midX][midY] == target)
     * 				return true;
     *
     * 			if (matrix[midX][midY] < target) {
     * 				start = mid + 1;//
     *                        } else {
     * 				end = mid - 1;
     *            }        * 		}
     *
     * 		return false;
     *    }
     * @param args
     */



    public static void main(String[] args){
        //[[1,3,5,7],[10,11,16,20],[23,30,34,50]]
        //13
        searchA2DMatrix_074 t = new searchA2DMatrix_074();
        //int[][] ins = {{1,3,5,7},{10,11,16,20},{23,30,34,50}};
        int[][] ins = {{1,3,5,7},{10,11,16,20},{23,30,34,50}};
        //3
        //int target  = 13;
        int target  = 3;

        t.searchMatrix(ins, target);


    }
}
