package lai0000.c001;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class abc001 {
    public List<String> subSets(String set) {
        // Write your solution here.
        List<String>  res = new ArrayList<>();
        if(set == null ){
            return res;
        }
        if( set.length() == 0){
            res.add("");
            return res;
        }

        char[] carr = set.toCharArray();
        Arrays.sort(carr);
        StringBuilder sb = new StringBuilder();
        recur(carr, 0, sb, res);
        return res;
    }


    private void recur(char[] carr, int idx, StringBuilder temp, List<String>  res){
        if(idx == carr.length){
            res.add(temp.toString());
            return;
        }
        temp.append(carr[idx]);
        recur(carr, idx + 1, temp, res);

        temp.deleteCharAt(temp.length() - 1);//deleteCharAt


        while(idx + 1 < carr.length && carr[idx + 1] == carr[idx]){
            idx++;
        }

        recur(carr, idx + 1, temp, res);
    }

}
