package xiaoban001;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class a03 {
    //assumption 1. not negitive
    //
    public  List<List<Integer>>  findAll(int num, int s){
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();

        if(num < 1){
            return res;
        }
        recur(1 , num, res, temp, s );
        return res;
    }

    private void recur(int level , int target,  List<List<Integer>> res, List<Integer> temp, int s){
       // System.out.println(target + "   <-anwser");
        if(target == 0 && temp.size() == s){
            res.add(new ArrayList<>(temp));
            return;
        }

        for(int i = level; i <= 9; i++){
            int cur = target - i;
            if(cur < 0 ){
                return;
            }
                temp.add(i);
                recur(i + 1, cur, res, temp, s);
                temp.remove(temp.size() - 1);
        }
    }


    public static void main(String[] args) {
        a03 t = new a03();
        System.out.println(t.findAll(8,3));
    }
}
