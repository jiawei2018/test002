package laioffer_final;

public class p03 {
    public int minSqure(int num){
        if (num <= 0){
            return 0;
        }
        int[] res = new int[num + 1];
        for(int i = 0; i <= num; i++){
            res[i] = i;
            for(int j = 0; j * j <= num; j++){
                if(i - j* j >= 0){
                    res[i] = Math.min(res[i], res[i - j* j] + 1);
                }
            }
        }
        return res[num];
    }

    public static void main(String[] args) {
        p03 t = new p03();
        System.out.println(t.minSqure(4));

    }
}
