package a002;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 *


 18. 4Sum
 DescriptionHintsSubmissionsDiscussSolution
 Pick One
 Given an array nums of n integers and an integer target,
 are there elements a, b, c, and d in nums such that a + b + c + d = target?
 Find all unique quadruplets in the array which gives the sum of target.

 Note:

 The solution set must not contain duplicate quadruplets.

 Example:

 Given array nums = [1, 0, -1, 0, -2, 2], and target = 0.

 A solution set is:
 [
 [-1,  0, 0, 1],
 [-2, -1, 1, 2],
 [-2,  0, 0, 2]
 ]
 */

public class fourSum_018 {
    //下面的我的方法可以过一些例子,  ok le

    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> fourSumA(int[] nums, int target) {
        if(nums == null || nums.length < 4){
            return res;
        }
        Arrays.sort(nums);
        for(int i = 0 ; i < nums.length -3 ; i++ ){
            if(i > 0  && nums[i-1] == nums[i]){
                continue;
            }
            //int target1 = target - nums[i];
            for(int j = i+1; j <nums.length-2 ; j++){//j = i+1; next  of all
                if(j>i+1 && nums[j]== nums[j-1]){
                    continue;
                }
                //int sum2 = nums[i]+nums[j];
                searchFit(nums,j+1,nums.length-1, nums[i] ,nums[j], target);
            }
        }
        return res;
    }

    private void searchFit(int[] nums,int begin ,int end ,int numa,int numb,int target){
        int left = begin;
        int right = end;
        //int thissum = 0;
        while(left < right  ){
           // System.out.println(nums[left]+"  <>  "+nums[right]);//very odddddddd............
            // thissum = nums[left]+nums[right];
             int thissum2 = nums[left]+nums[right] +numa+numb;
            if(thissum2 == target ) {
                List<Integer> tps = new ArrayList<>();
                tps.add(numa);
                tps.add(numb);
                tps.add(nums[left]);
                tps.add(nums[right]);
                //System.out.println(numa+"   n  "+numb+"  n1  "+nums[left]+"  n2  "+nums[right]);
                res.add(tps);
                while (left < right && nums[left] == nums[left + 1]) {
                    left++;
                }
                while (left < right && nums[right] == nums[right - 1]) {
                    right--;
                }
                left++;
                right--;

            }else if(nums[left] + nums[right] + numa + numb  < target){//过了,是我太蠢,这个地方是target啊,不是0
                left++;
            }else{
                right--;
            }
        }
    }



    //下面网上找的答案,代码量最少
    public List<List<Integer>> fourSum(int[] num, int target) {//
        Arrays.sort( num );
        List<List<Integer>> rt = new LinkedList<>();//注意此处
        int sum = 0;
        for ( int i = 0; i < num.length -3; i++){//4个 所以减3
            if( i == 0 || (i > 0 && num[i] != num[i-1]) )
                for( int j = i + 1;j< num.length - 2 ; j++){//成3个了
                    if( j == 1 || j==i+1 && num[j]== num[i]||(j>1 && num[j]!=num[j-1])){//此处 看不明白 是 如何剔除相同解
                        sum = target - num[i] - num[j];
                        int lo = j + 1;
                        int hi = num.length-1;
                        while( lo < hi ){
                            if( num[lo] + num[hi] == sum ){
                                rt.add(( Arrays.asList(num[i],num[j],num[lo],num[hi])));
                                while( lo < hi && num[hi]==num[hi-1]) hi--;
                                while( lo < hi && num[lo]==num[lo+1]) lo++;
                                lo++;hi--;
                            }else if( num[lo] + num[hi] < sum)
                                lo++;
                            else hi--;
                        }
                    }
                }
        }
        return rt;
    }






    public static void main(String[] args){
        fourSum_018 t = new fourSum_018();
        int[] i = {1,0,-1,0,-2,2};
        int[] i1 = {0,0,0,0};
        int[] i2 = {-3,-1,0,2,4,5};

       // t.fourSum(i,0);
        t.fourSumA(i2,2);
       // System.out.println(t.res);


    }





    /*  下面这个比较直观
        public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length < 4) {
            return res;
        }

        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int sum3 = target - nums[i];  // 后3个数之和需等于sum3
            for (int j = i + 1; j < nums.length - 2; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }

                int sum2 = sum3 - nums[j];  // 后2个数之和需等于sum3
                int left = j + 1, right = nums.length - 1;

                while (left < right) {
                    if (nums[left] + nums[right] == sum2) {
                        List<Integer> quad = new ArrayList<>();
                        quad.add(nums[i]);
                        quad.add(nums[j]);
                        quad.add(nums[left]);
                        quad.add(nums[right]);
                        res.add(quad);

                        while (left < right && nums[left++] == nums[left]) {}  //这个写法好,反正都要++;
                        while (left < right && nums[right--] == nums[right]) {}

                    } else if (nums[left] + nums[right] < sum2) {
                        while (left < right && nums[left++] == nums[left]) {}

                    } else {
                        while (left < right && nums[right--] == nums[right]) {}
                    }
                }
            }
        }
        return res;
    }
     */

}
