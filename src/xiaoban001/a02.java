package xiaoban001;

import java.util.List;

public class a02 {

// 2D grid , find all words in the board
    // [ a s d f]
    //[ g o o d]
    //[ i h j g ]    asoh good fdgj
    //   DFS  用 tire 优化
     public List<String> findAll(char[][] grid, String[] words){

        return null;
    }
        final int[][] dir = {{-1, 0 },{1, 0}, {0, -1}, {0 , 1}};

    private boolean recur(int level, char[] words, char[][] grid, boolean[][] visited){
        if(level == words.length){
            return true;
        }




        return false;
    }




}
