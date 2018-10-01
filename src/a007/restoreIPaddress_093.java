package a007;

import java.util.ArrayList;
import java.util.List;

/**
 * 93. Restore IP Addresses
 * DescriptionHintsSubmissionsDiscussSolution
 * Pick One
 * Given a string containing only digits, restore it by returning all possible valid IP address combinations.
 *
 * Example:
 *
 * Input: "25525511135"
 * Output: ["255.255.11.135", "255.255.111.35"]
 */
public class restoreIPaddress_093 {
    public List<String> restoreIpAddresses(String s) {
        //back tracking 但是我却想不出来了,.......
        List<String> res = new ArrayList<>();
        if(s == null || s.length() < 4 ||s.length() > 12) return res;//mistake not null

       // addip(res, s, "", 0);
       // bt(res, s, "", 0, 0);
        return res;
    }


    private void addip(List<String> res, String s, String tmp, int level ){
        if(level == 4 && s.length() == 0){
            res.add(tmp.substring(1));//remove lead "."    注意用法
        }else if (level == 4 || s.length() == 0)
            return;
        else{
            addip(res, s.substring(1), tmp + "." +s.substring(0,1), level + 1);
            if(s.charAt(0) != '0'  && s.length() > 1){ //mistake guess where?
                addip(res, s.substring(2), tmp + "." +s.substring(0,2), level +1);
                if(s.length() > 2 && Integer.valueOf(s.substring(0,3)) < 256){
                    addip(res, s.substring(3), tmp + "." +s.substring(0,3), level + 1);
                }
            }
        }
    }


    private void bt(List<String> res, String s, String tmp,int idx, int level){
        if(level > 4){
            return;
        }

        if(level == 4 && idx ==s.length()) {
            res.add(tmp);
            return;
        }
        for(int i = 0; i < 4; i++){
            if(idx + i > s.length()) break;
            String temp = s.substring(idx, idx +i);
            if((temp.startsWith("0") && temp.length() > 1)||(i == 3 && Integer.parseInt(temp) > 255 ) )continue;
            bt(res, s, tmp + temp + (level == 3 ? "":"."), idx + i,level + 1);
        }

    }


    public static void main(String[] args){
        restoreIPaddress_093 t = new restoreIPaddress_093();
        String s = "25525511135";

         System.out.println(t.restoreIpAddresses(s).toString());
       // System.out.println();
    }
}
