package a002;

import java.util.Arrays;

/**
 * 16. 3Sum Closest
 * DescriptionHintsSubmissionsDiscussSolution
 * Pick One
 * Given an array nums of n integers and an integer target,
 * find three integers in nums such that the sum is closest to target.
 * Return the sum of the three integers.
 * You may assume that each input would have exactly one solution.
 */
public class threeSumClostest {
    public static void main(String[] args){

    }

    protected int threeSumClosest(int[] nums, int target) {
        int diff = Integer.MAX_VALUE;
        int res=0;//output
        Arrays.sort(nums);//果然忘了,一定先sort一下才能用双指针办法


        for(int i = 0 ; i < nums.length - 2; i++) {
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {//以下可以算是模板
                int tmpsum = nums[i] + nums[left] + nums[right];
                int tmpdiff = Math.abs(tmpsum - target);
                if (tmpdiff < diff) {
                    res = tmpsum;
                    diff = tmpdiff;
                }
                if (tmpsum < target) {
                    left++;
                } else if (tmpsum > target) {
                    right--;
                } else
                    return tmpsum;
            }
        }
        return res;
    }

    }




//此题与15的区别一个是 最接近值 , 另一个是是有一个答案. 虽然基本方法是一样,但是没有提炼出来单独的函数