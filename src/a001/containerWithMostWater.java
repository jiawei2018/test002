package a001;

/* this is mediem
11. Container With Most Water
DescriptionHintsSubmissionsDiscussSolution
Pick One
Given n non-negative integers a1, a2, ..., an , where each represents a point at coordinate (i, ai).
n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0).
Find two lines, which together with x-axis forms a container, such that the container contains the most water.
Note: You may not slant the container and n is at least 2.
The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7].
In this case, the max area of water (blue section) the container can contain is 49.
Example:
Input: [1,8,6,2,5,4,8,3,7]
Output: 49
 */


public class containerWithMostWater {

    public static void main(String[] args){





    }

    public int maxArea(int[] height) {//又是双指针
        if (height.length < 2) return 0;
        if(height.length == 2 ){
            return Math.min(height[0],height[1]);
        }

        int left = 0 ,right = height.length-1;
        int are =0;
        while(left < right){
            are = Math.max(Math.min(height[left],height[right])*(right-left),are);

            if(height[left] <= height[right]){
                left++;
            }else{
                right--;
            }
        }
    return are;
    }
}


/**
 解题思路分析

 1.定义两个指针，left和right，初始时，指向首部和尾部；--此题的考点,一定要双指针才行

 2.计算两个指针之间的面积area1 = min(height[left]，height[right])*(right-left)；

 3.maxArea = Max(maxArea,area1);

 4.height[left]和height[right]，谁小谁往里面走；----另一个考点,逻辑要出来"谁小谁变化"
 */