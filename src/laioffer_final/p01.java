package laioffer_final;

import java.util.ArrayList;
import java.util.List;

public class p01 {

    public List<String> getAll(String str){
        List<String> res = new ArrayList<>();
        if(str.length() < 1){
            return res;
        }

        recur(str, res, 0, new StringBuilder());
        return  res;
    }

    private void recur(String  str, List<String> res , int idx, StringBuilder curr){
        if(idx == str.length()){
            res.add(curr.toString());
            return;
        }
        //add " _"
        curr.append("_");
        curr.append(str.charAt(idx));
        recur(str,res,idx + 1, curr);
        curr.deleteCharAt(curr.length() - 1);
        curr.deleteCharAt(curr.length() - 1);

        //add char
        curr.append(str.charAt(idx));
        recur(str,res,idx + 1, curr);
        curr.deleteCharAt(curr.length() - 1);

    }



}
