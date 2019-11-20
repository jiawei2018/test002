package ashishi;

import java.util.ArrayDeque;
import java.util.Deque;

public class fianl {
    //# Question 1
//Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. An island
//is surrounded by water and is formed by connecting adjacent lands horizontally or
//vertically. You may assume all four edges of the grid are all surrounded by water.
//Example 1:
//11110
//11010
//11000
//00000
//Answer: 1
//Example 2:
//11000
//11000
//00100
//00011
//Answer: 3
//Method Signature:
//
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] used = new boolean[m][n];
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1' && !used[i][j]) {
                    extend(grid, used, i, j);
                    count++;
                }
            }
        }
        return count;
    }

    private void extend(char[][] grid, boolean[][] used, int idxi, int idxj) {
        int m = grid.length;
        int n = grid[0].length;
        used[idxi][idxj] = true;
        if (idxi + 1 <= m && !used[idxi + 1][idxj]) {
            extend(grid, used, idxi + 1, idxj);
        }
        if (idxj + 1 <= n && !used[idxi][idxj + 1]) {
            extend(grid, used, idxi, idxj + 1);
        }
        if (idxi - 1 >= 0 && !used[idxi - 1][idxj]) {
            extend(grid, used, idxi - 1, idxj);
        }
        if (idxj - 1 >= 0 && !used[idxi][idxj - 1]) {
            extend(grid, used, idxi, idxj - 1);
        }
    }

    //
//
//
//# Question 2
//Given a binary tree, you need to compute the length of the diameter of the tree. The
//diameter of a binary tree is the length of the longest path between any two nodes in a
//tree. This path may or may not pass through the root.
//Example:
//Given a binary tree
//1
/// \
//2 3
/// \
//4 5
//Return 3, which is the length of the path [4,2,1,3] or [5,2,1,3].
//Note: The length of path between two nodes is represented by the number of edges
//between them.
//Method Signature:
    class TreeNode {
        TreeNode left;
        TreeNode right;
        int val;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public int diameterOfBinaryTree(TreeNode root) {
        if(root == null ){
            return 0;
        }

        int[] max = new int[1];

        return max[0];

    }

    private int recur(TreeNode root, int[] max) {
        if(root == null){
            return 0;
        }
        int left = recur(root.left, max);
        int right = recur(root.right, max);
        if(left < 0){
            left = -1;
        }
        if(right < 0){
            right = -1;
        }
        max[0] = Math.max(max[0], right + left + 2);
        return Math.max(left , right) + 1;
    }


    //
//# Question 3
//Given a “2 x n” board and tiles of size “2 x 1”, count the number of ways to tile the given
//board using the 2 x 1 tiles. A tile can either be placed horizontally i.e., as a 1 x 2 tile or
//vertically i.e., as 2 x 1 tile.
//Example :
//Input n = 3
//Output: 3
//Explanation:
//We need 3 tiles to tile the board of size 2 x 3.
//We can tile the board using following ways
//1) Place all 3 tiles vertically.
//2) Place first tile vertically and remaining 2 tiles horizontally.
//3) Place first 2 tiles horizontally and remaining tiles vertically
//Input n = 4
//Output: 5
//Explanation:
//For a 2 x 4 board, there are 5 ways
//1) All 4 vertical
//2) All 4 horizontal
//3) First 2 vertical, remaining 2 horizontal
//4) First 2 horizontal, remaining 2 vertical
//5) Corner 2 vertical, middle 2 horizontal
//Board
//Tile
//Method Signature:
    public int numberOfWaysToTile(int boardColumns) {
        if(boardColumns == 0){
            return 0;
        }

        int[] count = new int[boardColumns];
        count[0] = 0;
        count[1] = 1;
        int i = boardColumns;
        int j = 0;
        while(i > 0){
                count[j++] = count[j - 1] + count[j  -2];
                i--;
        }
        return count[count.length - 1];
    }














//# Question 4  leetcode 678
//Given a string containing only three types of characters: '(', ')' and '*', write a function to
//check whether this string is valid. We define the validity of a string by these rules:
//1. Any left parenthesis '(' must have a corresponding right parenthesis ')'.
//2. Any right parenthesis ')' must have a corresponding left parenthesis '('.
//3. Left parenthesis '(' must go before the corresponding right parenthesis ')'.
//4. '*' could be treated as a single right parenthesis ')' or a single left parenthesis '(' or
//an empty string.
//5. An empty string is also valid.
//Example 1:
//Input: "()"
//Output: True
//Example 2:
//Input: "(*)"
//Output: True
//Example 3:
//Input: "(*))"
//Output: True
//Note: The string size will be in the range [1, 100].
//Method Signature :
    public boolean checkValidString(String s) {
        if(s == null || s.length() == 0){
            return true;
        }
        int left = 0;
        int right =0;

        char[] arr = s.toCharArray();
        for(int i = 0; i < arr.length;i++){
            if(arr[i] == '(' ){
                left++;
                right++;
            }else if (arr[i] == ')'){
                if(left > 0){ //  there are more ( than )
                    left--;
                }
                right--;//pop one )
            }else {// the * situation
                if(left > 0){//  ((     *)
                    left--;
                }
                right++;
            }
            if(right < 0){
                return false;
            }
        }
        return left == 0;
    }



}
