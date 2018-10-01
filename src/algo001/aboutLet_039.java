package algo001;

import java.util.List;

public class aboutLet_039 {
    //全排列
    //根据youtube 花花酱 的课件1总结
    private  void pl(int[] nums, int depth, int number, boolean[] used, List<Integer> curr, StringBuilder ans){
        //depth  递归深度
        // numbers    取出多少个 元素的全排列,

        if(depth == number){
            ans.append(curr);
            return;//退出递归机制
        }

        for(int i = 0; i < nums.length; i++){
            if(used[i] == true){
                continue;
            }
            used[i] = true;
            curr.add(nums[i]);
            pl(nums, depth + 1, number, used, curr, ans);//
            curr.remove(curr.indexOf(curr.size()));//??
            used[i] = false;

        }




    }






}
