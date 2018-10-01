package a006;

/**
 * 79. Word Search
 * DescriptionHintsSubmissionsDiscussSolution
 * Pick One
 * Given a 2D board and a word, find if the word exists in the grid.
 * <p>
 * The word can be constructed from letters of sequentially adjacent cell,
 * where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.
 * <p>
 * Example:
 * <p>
 * board =
 * [
 * ['A','B','C','E'],
 * ['S','F','C','S'],
 * ['A','D','E','E']
 * ]
 * <p>
 * Given word = "ABCCED", return true.
 * Given word = "SEE", return true.
 * Given word = "ABCB", return false.
 */

public class wordSearch_079 {
    public boolean exist(char[][] board, String word) {
        if (word == null || board == null) return false;
        boolean[][] used = new boolean[board.length][board[0].length];

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (findNextChar(board, word.toCharArray(), i, j, 0, used)) return true;//这里绝对不能直接return find();!!!!!!
                //否则就是干一次就退出,无法走完全部ele
            }
        }
        return false;
    }

    private boolean findNextChar(char[][] dic, char[] word, int idx, int idy, int len, boolean[][] used) {
        if (len == word.length) {
            return true;
        }

        if (idx < 0 || idx >= dic.length || idy < 0 || idy >= dic[0].length) return false;
        if (used[idx][idy] || dic[idx][idy] != word[len]) return false;//注意此处,used[idx][idy] == true  这个条件
        used[idx][idy] = true;

        if (findNextChar(dic, word, idx - 1, idy, len + 1, used)) return true;//这写法 很重要

        if (findNextChar(dic, word, idx + 1, idy, len + 1, used)) return true;

        if (findNextChar(dic, word, idx, idy - 1, len + 1, used)) return true;

        if (findNextChar(dic, word, idx, idy + 1, len + 1, used)) return true;

        used[idx][idy] = false;//失败后次坐标还原未标记
        return false;
    }
}
