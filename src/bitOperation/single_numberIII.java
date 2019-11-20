package bitOperation;

public class single_numberIII {
    public static void main(String[] args) {
        int[] arr = {1,2,1,2,3,5,5,7};
        single_numberIII t = new single_numberIII();
        t.singleNumber(arr);
    }
    public int[] singleNumber(int[] nums) {
        int tmp = nums[0];
        for(int i = 1; i < nums.length; i++){
            tmp ^= nums[i];
        }
        //000...0010
        int pat = 1;
        for(int i = 1; i <31; i++){
            if((pat<<i & tmp) == (pat<<i)){
                pat = pat<<i;
                break;
            }
        }
        System.out.println(pat);
        //1 2 1 3 2 5
        //i
        int[] res = {0, 0};
        for(int i = 0; i < nums.length; i++){
            if((pat & nums[i]) != 0){
                res[0] ^= nums[i];
            } else {
                res[1] ^= nums[i];
            }
        }
        return res;
    }



}
