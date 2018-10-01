package a009;

import java.util.ArrayList;
import java.util.List;

/**
 * 120. Triangle
 * DescriptionHintsSubmissionsDiscussSolution
 * Pick One
 * Given a triangle, find the minimum path sum from top to bottom.
 * Each step you may move to adjacent numbers on the row below.
 *
 * For example, given the following triangle
 *
 * [
 *      [2],
 *     [3,4],
 *    [6,5,7],
 *   [4,1,8,3]
 * ]
 * The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).
 *
 * Note:
 *
 * Bonus point if you are able to do this using only O(n) extra space, where n is the total number of rows in the triangle.
 */
public class triangle_120 {
    public int minimumTotal(List<List<Integer>> triangle) {
        if(triangle == null){
            return 0;
        }
        int rows = triangle.size();
        int[]  resdp = new int[rows];

        for(int r = rows - 1; r >= 0; r--) {//from bottom to top;必须有=0 时候,表示r= 0 即第一行 可以执行
        //正的不好想就反的想
            //一定要找出来不变的那个值; 本题中就是 col+ 1,那个不先变
            //要画出来图,才能有想法
            for (int col = 0; col <= r; col++) {//必须有=  否则 最后一个元素走不到
                if (r == rows - 1) {
                    resdp[col] = triangle.get(r).get(col);// initializing the dp and the edge
                }
                resdp[col] = Math.min(resdp[col],   resdp[col + 1]) + triangle.get(r).get(col);
            }
        }
        return resdp[0];
    }
}
