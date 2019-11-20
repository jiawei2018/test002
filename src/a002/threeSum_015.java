package a002;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**   -- mid
 * 15. 3Sum
 * DescriptionHintsSubmissionsDiscussSolution
 * Pick One
 * Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0?
 * Find all unique triplets in the array which gives the sum of zero.
 * Note:
 * The solution set must not contain duplicate triplets.
 * Example:
 * Given array nums = [-1, 0, 1, 2, -1, -4],
 * A solution set is:
 * [
 *   [-1, 0, 1],
 *   [-1, -1, 2]
 * ]
 */
public class threeSum_015 {
    public static void main(String[] args){

    }
    List<List<Integer>> res = new ArrayList<List<Integer>>();
    protected List<List<Integer>> threeSum(int[] nums) {

        if(nums == null || nums.length <3){//mistake 1 ,must <3 ,if it is 3 ,there will be an error like [0,0,0]  ->  [[0,0,0]]
            return res;
        }
        Arrays.sort(nums);

        for(int i = 0; i < nums.length -2 ; i++){//two pointers
            if(i > 0  && nums[i] == nums[i-1]){
                continue;
            }
                searchFit(nums , i+1,nums.length-1,nums[i]);
        }
        return res;
    }

    protected void searchFit(int[] nums, int begin , int end , int target){
        int left ,right;
        left = begin ;
        right = end;
        while(left < right){
            if(nums[left] + nums[right] + target == 0) {
                List<Integer> sres = new ArrayList<Integer>();
                sres.add(target);
                sres.add(nums[left]);
                sres.add(nums[right]);
                res.add(sres);
                while (left < right && nums[left] == nums[left + 1]) {
                    left++;
                }
                while (left < right && nums[right] == nums[right - 1]) {
                    right--;
                }
                left++;
                right--;
                }else if(nums[left] + nums[right] + target  < 0){//mistake 2, i am so careless.........
                    left++;
                }else{
                    right--;
                }
        }
    }


    //我认为单独提炼出来函数是更好地代码风格



}

/*
作为初学者，我们用最简洁的思路来说一下这道题怎么解。

暴力解决法是每个人都能想到的，三层for循环，时间复杂度是O(n^3)，而且还要处理重复的问题，显然不是题目想要的解法。

那能不能降到O(n^2)？排序算法的时间复杂度为O(nlgn)，小于O(n^2)，那么我们不妨先对数组排个序。

排序之后，我们就可以对数组用两个指针分别从前后两端向中间扫描了，
如果是 2Sum，我们找到两个指针之和为target就OK了，那 3Sum 类似，
我们可以先固定一个数，然后找另外两个数之和为第一个数的相反数就可以了。

代码不难，先看了再说。
 */



//ps：为什么会想到对数组元素进行排序呢，排序是为了让元素之间呈现出某种规律，
  //      处理起来会简单很多。所以，当你觉得一个似乎无从下手的问题的时候，不妨尝试去寻找或制造一种“规律”，排序是手段之一。


/*
tip
Java的Arrays类中有一个sort()方法，该方法是Arrays类的静态方法，在需要对数组进行排序时，非常的好用。

但是sort()的参数有好几种，下面我就为大家一一介绍，这几种形式的用法。

1、Arrays.sort(int[] a)

这种形式是对一个数组的所有元素进行排序，并且是按   >>   从小到大   <<   的顺序。
 */