package googleOA;

public class dominos {
    //lc 1007
    public int minDominoRotations(int[] A, int[] B) {
        if(A == null || B == null || A.length == 0 || B.length == 0){
            return 0;
        }
        int res = Integer.MAX_VALUE;
        for(int dice = 0; dice <= 6; dice++){
            int cur = getOneAns(A, B, dice);
            if(cur == -1) continue;
            res = Math.min(res, cur);
        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }

    private int getOneAns(int[] a, int[] b, int dice){
        int resa = 0;
        int resb = 0;

        for(int i = 0; i < a.length; i++){
            if (a[i] != dice && b[i] != dice){
                resa = -1;
                resb = -1;
                break;
            }

            if(a[i] != dice && b[i] == dice) {
                resa++;
            }
            if(a[i] == dice && b[i] != dice){
                resb++;
            }
        }

        return Math.min(resa, resb);
    }





    /*
        [2,1,2,4,2,2],
    B = [5,2,6,2,3,2]
         x=1346
           x=3456
             x=1345
               x=1356
                 x=1456
                    x=13456


    A = [3,5,1,2,3],
    B = [3,6,3,3,4]
           X=1234
         X=12456
             x=2456
               x=1456
                  x=1256
                  so

      bf:
     try 1 to 6;find if there exist a valid answer;
    */
}
