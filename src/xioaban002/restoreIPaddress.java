package xioaban002;

import java.util.ArrayList;
import java.util.List;

public class restoreIPaddress {

    public List<String> restoreIP(String str){
        // k>=0 k <= 255
        List<String> res = new ArrayList<>();
        if(str == null || str.length() < 4 || str.length() > 12){
            return res;
        }





        return null;
    }

    private void recur(String s, List<String> res, StringBuilder sb, int idx){
        if(idx == s.length()){
            res.add(sb.toString());
            return;
        }

        for(int i = idx; i < s.length(); i++){
            char[] cur = s.substring(idx, i ).toCharArray();
            StringBuilder cursb = new StringBuilder();
            for(int j = 0; j < cur.length; j++){
                if(cur[j] == '0'){
                    int len = sb.length();
                    sb.append(cur[j] - '0').append('.');
                    recur(s, res, sb, i);
                    sb.setLength(len);
                } else {

                }
            }

        }


    }
}
