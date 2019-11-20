package lai002;

public class palindromPartitioning_II_hard {


    public int minCut(String s) {
       // char[] s1 = s.toCharArray();
        int[] min = new int[s.length() + 1];
       // min[0] = 0;
        for(int i = 1; i < min.length; i++){
            min[i] = i - 1;
            for(int j = 0; j < i; j++){

                if(isp(s, j, i - 1)){
                     if(j == 0){
                        min[i] = 0;
                     }else{
                        min[i] = Math.min(min[i], min[j] + 1);
                     }

                }
            }
        }
        return min[min.length - 1];
    }

    private boolean isp(String str, int idxa, int idxb){
        while(idxa < idxb){
            if(str.charAt(idxa++)  != str.charAt(idxb--)){
                return false;
            }
        }
        return true;
    }


    public int minCut1(String s) {
        int len = s.length();
        int[] min = new int[len];
        // min[0] = 0;
        boolean[][] isp = new boolean[len][len];

        for(int i = 0; i < s.length(); i++){//also work at i = 1 to end
            min[i] = i;
            for(int j = 0; j <= i; j++){
                if(s.charAt(i) == s.charAt(j) && (i - j < 2 || isp[j + 1][i - 1] )){
                    isp[j][i]= true;       //here important is not i,j is j , i
                    min[i] =  j == 0 ? 0 : Math.min(min[i], min[j - 1] + 1);//j == 0 means this whole 0 to i is a palin so cut is 0;
                }
            }
        }
        return min[min.length - 1];
    }

    public static void main(String[] args) {
        palindromPartitioning_II_hard t = new palindromPartitioning_II_hard();
        System.out.println(t.minCut("aab"));
    }

}
