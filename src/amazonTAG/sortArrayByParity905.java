package amazonTAG;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class sortArrayByParity905 {
    public int[] sortArrayByParity(int[] A) {
//        if(A == null || A.length == 0){
//            return A;
//        }
//
//        Arrays.sort(A,  );//can't use to primary type!!!
//        return A;
        //time o(n)-> two pass
        //space o(n)
        String str = "";
        //str.compareTo()
        Arrays.sort(new int[][]{}, new mycom());
        if(A == null || A.length == 0){
            return A;
        }
        int[] res = new int[A.length];
        int k = 0;
        for(int i = 0; i < A.length; i++){
            if(A[i] == 0 || A[i] % 2 == 0){
                res[k++] = A[i];
                A[i] = -1;
            }
        }
        for(int i = 0; i < A.length; i++){
            if(A[i] < 0 )continue;
            res[k++] = A[i];
        }
        return res;


    }

    public int[] sortArrayByParity1(int[] A) {
        //time o(n)-one pass
        //space o(1)
        if(A == null || A.length <= 1){
            return A;
        }

        int left = 0;
        int right = A.length - 1;
        while(left < right){
            if(A[left] % 2 == 0){
                left++;
            } else if(A[right] % 2 != 0){
                right --;
            } else {
                swap(A, left, right);
            }
        }
        return A;
    }

    private void swap(int[] nums, int a, int b){
        int tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;

    }
    class mycom implements Comparator<int[]>{
         @Override
         public int compare(int[] o1, int[] o2) {
             return 0;
         }
    }




}

