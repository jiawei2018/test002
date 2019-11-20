package debug;

import java.util.Arrays;

public class lc468validIPaddress {
    final String[] sts = {"IPv4", "IPv6", "Neither"};

    public static void main(String[] args) {
        String s = "172.16.254.1";
        String s1 = "a:s:a";
        System.out.println(" >>   "+Arrays.toString(s.split("\\.")));
        System.out.println(" >>   "+Arrays.toString(s1.split(":")));
        lc468validIPaddress t = new lc468validIPaddress();
        t.validIPAddress(s);
//
//            String str = "abc";
//            String c = "abc".substring(2,3);
    }


    public String validIPAddress(String IP) {
        if(IP == null || IP.length() < 7){
            return sts[2];
        }
        System.out.println(Arrays.toString(IP.split(".")));
        boolean v4 = ipV4(IP.split("."));
        boolean v6 = ipV6(IP.split(":"));
        if(!v4 && !v6){
            return sts[2];
        } else
            return v4 ? sts[0] : sts[1];
    }

    private boolean ipV4(String[] v4){
        System.out.println(v4.length + "   <<<");
        if(v4.length != 4){
            return false;
        }
        boolean res = true;
        for(String s : v4){
            System.out.println(s + singleV4(s));
            res &= singleV4(s);
        }
        return res;
    }

    private boolean singleV4(String s4){
        if(s4 == null || s4.length() == 0 || s4.length() > 3 ){
            return false;
        }
        // no leading zero only digis, < 256  >= 0

        for(int i = 0; i < s4.length(); i++){ //chk if ther are non-decimal?
            if(s4.charAt(i) - '0' < 0 || s4.charAt(i) - '0' > 9){
                return false;
            }
        }
        if(s4.charAt(0) - '0' == 0 && s4.length() > 1){
            return false;
        }
        int val = Integer.valueOf(s4);
        if(val < 0 || val > 255 ){
            return false;
        }
        return true;
    }
    //ipv6 looks like: [1:2:3:4:5:6:7:8] 8 parts

    private boolean ipV6(String[] v6){
        if(v6.length != 8){
            return false;
        }
        boolean res = true;
        for(String s : v6){
            res &= singleV6(s);
        }
        return res;
    }

    private boolean singleV6(String s6){
        return false;
    }
}
