package a009;

import java.util.ArrayList;
import java.util.List;

public class pascalsTriangle_II {
    public List<Integer> getRow(int rowIndex) {
        //List<List<Integer>> res = new ArrayList<>();
        List<Integer> res = new ArrayList<>();
        if (rowIndex == 0) return res;
        for (int row = 0; row < rowIndex; row++) {
            res.add(0, 1);//	add(int index, E element)  绝招!!!!! 要理解
            //Inserts the specified element at the specified position in this list.

            for (int col = 1; col <= row - 1; col++) {
                // 原地复用是个绝招,而且每次都是最前面差一个1
                res.set(col, res.get(col) + res.get(col + 1));//key point because col +1 还没有被更改过
                // 夏绝对不能用 col + col(pre) 因为 每次 都会修改 这个值,而在后面的值确不会修改
            }
        }
        return res;
    }
}
