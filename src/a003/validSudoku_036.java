package a003;

import java.util.HashSet;

/**
 * 36. Valid Sudoku
 * DescriptionHintsSubmissionsDiscussSolution
 * Pick One
 * Determine if a 9x9 Sudoku board is valid. Only the filled cells need to be validated according to the following rules:
 *
 * Each row must contain the digits 1-9 without repetition.
 * Each column must contain the digits 1-9 without repetition.
 * Each of the 9 3x3 sub-boxes of the grid must contain the digits 1-9 without repetition.
 *
 * A partially filled sudoku which is valid.
 *
 * The Sudoku board could be partially filled, where empty cells are filled with the character '.'.
 *
 * Example 1:
 *
 * Input:
 * [
 *   ["5","3",".",".","7",".",".",".","."],
 *   ["6",".",".","1","9","5",".",".","."],
 *   [".","9","8",".",".",".",".","6","."],
 *   ["8",".",".",".","6",".",".",".","3"],
 *   ["4",".",".","8",".","3",".",".","1"],
 *   ["7",".",".",".","2",".",".",".","6"],
 *   [".","6",".",".",".",".","2","8","."],
 *   [".",".",".","4","1","9",".",".","5"],
 *   [".",".",".",".","8",".",".","7","9"]
 * ]
 * Output: true
 * Example 2:
 *
 * Input:
 * [
 *   ["8","3",".",".","7",".",".",".","."],
 *   ["6",".",".","1","9","5",".",".","."],
 *   [".","9","8",".",".",".",".","6","."],
 *   ["8",".",".",".","6",".",".",".","3"],
 *   ["4",".",".","8",".","3",".",".","1"],
 *   ["7",".",".",".","2",".",".",".","6"],
 *   [".","6",".",".",".",".","2","8","."],
 *   [".",".",".","4","1","9",".",".","5"],
 *   [".",".",".",".","8",".",".","7","9"]
 * ]
 * Output: false
 * Explanation: Same as Example 1, except with the 5 in the top left corner being
 *     modified to 8. Since there are two 8's in the top left 3x3 sub-box, it is invalid.
 * Note:
 *
 * A Sudoku board (partially filled) could be valid but is not necessarily solvable.
 * Only the filled cells need to be validated according to the mentioned rules.
 * The given board contain only digits 1-9 and the character '.'.
 * The given board size is always 9x9.
 */


public class validSudoku_036 {

    public boolean isValidSudoku(char[][] board) {



        //rows check
        for(int i = 0; i < 9; i++){
            int[] rcr = new int[9];//mistake   应该在循环体里面我放在外面的话就很快出错....每检查九个元素 need to restart
            int[] rcc = new int[9];
            int[] sbc = new int[9];
            for(int j = 0; j < 9; j++){
                if(board[i][j] != '.'){
                    rcr[board[i][j] - '1']++;//此处必须是 1 否则找不到对应关系,临时数组是0--8
                    if(rcr[board[i][j]- '1'] > 1) return false;
                }

                //column chk
                if(board[j][i] != '.'){
                    rcc[board[j][i]- '1']++;
                    if(rcc[board[j][i]- '1'] > 1) return false;
                }
                int cr = 3 * (i / 3)  + j / 3;
                int cc = 3 * (i % 3) + j % 3;
                if(board[cr][cc] != '.'){//这个映射关系 不好找,但是可以暴力.....
                    sbc[board[cr][cc] - '1']++;
                    System.out.println();
                    if(sbc[board[cr][cc] - '1']  > 1) return false;
                    System.out.println();
                }

            }
        }
       return true;
    }

    public static void main(String[] args){

    }
//此例子 要用 hashset
public boolean isValidSudokuA(char[][] board) {
    for (int i = 0; i < 9; i++) {
        HashSet<Character> row = new HashSet<>();
        HashSet<Character> column = new HashSet<>();
        HashSet<Character> cube = new HashSet<>();
        for (int j = 0; j < 9; j++) {
            // 检查第i行，在横坐标位置
            if (board[i][j] != '.' && !row.add(board[i][j]))//hashset 如果 已经 .add过一个值,则之后 再次add就false
                return false;
            // 检查第i列，在纵坐标位置
            if (board[j][i] != '.' && !column.add(board[j][i]))
                return false;
            // 行号+偏移量
            int RowIndex = 3 * (i / 3) + j / 3;//这个就是本题的考点   00,01,02,03,04,05,06,07,08,09//1st row
            // 列号+偏移量
            int ColIndex = 3 * (i % 3) + j % 3;
            //每个小九宫格，总共9个
            if (board[RowIndex][ColIndex] != '.'
                    && !cube.add(board[RowIndex][ColIndex]))
                return false;
        }
    }
    return true;
}


}
