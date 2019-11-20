package os;

public class a02 {
    public int findMax(int[] arr,int thread){

        int part = arr.length / thread;
        int start = 0;
        int res = Integer.MIN_VALUE;
        while(start < arr.length){
            if(start + part >= arr.length){
                part = arr.length - 1 - start;
            }
            Thread t = new Child(arr, start, start + part);
            t.start();
            res = Math.max(((Child) t).res , res);
            start += part;
        }

        return res;
    }


}
class Child extends Thread{
    int res;
   public Child(int[] nums, int start, int end){

       int res = Integer.MIN_VALUE;

        for(int i = start; i <= end; i++){
            res = Math.max(nums[i], res);
        }
        this.res = res;
    }
}
