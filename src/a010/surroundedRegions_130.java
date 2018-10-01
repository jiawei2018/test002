package a010;

/**
 * 130. Surrounded Regions
 * DescriptionHintsSubmissionsDiscussSolution
 * Pick One
 * Given a 2D board containing 'X' and 'O' (the letter O), capture all regions surrounded by 'X'.
 *
 * A region is captured by flipping all 'O's into 'X's in that surrounded region.
 *
 * Example:
 *
 * X X X X
 * X O O X
 * X X O X
 * X O X X
 * After running your function, the board should be:
 *
 * X X X X
 * X X X X
 * X X X X
 * X O X X
 * Explanation:
 *
 * Surrounded regions shouldn’t be on the border,
 * which means that any 'O' on the border of the board are not flipped to 'X'.
 * Any 'O' that is not on the border and it is not connected to an 'O' on the border will be flipped to 'X'.
 * Two cells are connected if they are adjacent cells connected horizontally or vertically.
 */
public class surroundedRegions_130 {
    public void solve(char[][] board) {
        //顺着边一直找不就行了??
        //先检查4边,发现o就沿着他扩散,直到周围3个无法扩散为止
        if(board == null || board.length == 0 || board[0].length ==0){
            return;
        }

    }
}
