package amazonOA;

public class debug {
    public static void main(String[] args) {
        print2(4);
    }


    public static int[] menchester(int[] nums){
        //assu nums[-1] == 0;
        if(nums == null || nums.length == 0){
            return nums;
        }
        if(nums.length == 1){
            int tmp = nums[0] == 0 ? 0 : 1;
            return new int[]{tmp};
        }
        int[] res = new int[nums.length];
        res[0] = nums[0] == 0 ? 0 : 1;
        for(int i = 1; i < nums.length; i++){
            if(nums[i] != nums[i - 1]){
                res[i] = 1;
            }
        }
        return res;
    }


    public static void print2(int n){
        for(int i = 0; i < n ;i++){
            char c = 'a';
            for(int j = 0; j <= i; j++){
                System.out.print((c++));
            }
            System.out.println("");
        }
    }





}
