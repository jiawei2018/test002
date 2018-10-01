package a009;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 118. Pascal's Triangle
 * DescriptionHintsSubmissionsDiscussSolution
 * Pick One
 * Given a non-negative integer numRows, generate the first numRows of Pascal's triangle.
 *
 *
 * In Pascal's triangle, each number is the sum of the two numbers directly above it.
 *
 * Example:
 *
 * Input: 5
 * Output:
 * [
 *      [1],
 *     [1,1],
 *    [1,2,1],
 *   [1,3,3,1],
 *  [1,4,6,4,1]
 * ]
 */
public class pascalsTriangle {
    public List<List<Integer>> generate(int numRows) {

        List<List<Integer>> res = new ArrayList<>();
        if(numRows == 0) return res;

        List<Integer> temp = new ArrayList<>();
            //temp.add(1);
        for(int row = 0; row < numRows; row++){
            temp.add(0, 1);//	add(int index, E element)
            //Inserts the specified element at the specified position in this list.

            for(int col = 1; col < row ; col++){
                 temp.set(col, temp.get(col ) + temp.get(col + 1 ));//key point because col +1 还没有被更改过
            }
            res.add(new ArrayList<>(temp));
        }
            return res;
    }

    public static void main(String[] args){
        pascalsTriangle t = new pascalsTriangle();

        System.out.println(t.generate(5));

    }



}
