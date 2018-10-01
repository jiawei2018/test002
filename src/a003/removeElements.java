package a003;

/*
27. Remove Element
DescriptionHintsSubmissionsDiscussSolution
Pick One
Given an array nums and a value val, remove all instances of that value in-place and return the new length.

Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.

The order of elements can be changed. It doesn't matter what you leave beyond the new length.

Example 1:

Given nums = [3,2,2,3], val = 3,

Your function should return length = 2, with the first two elements of nums being 2.

It doesn't matter what you leave beyond the returned length.
Example 2:

Given nums = [0,1,2,2,3,0,4,2], val = 2,

Your function should return length = 5, with the first five elements of nums containing 0, 1, 3, 0, and 4.

Note that the order of those five elements can be arbitrary.

It doesn't matter what values are set beyond the returned length.
Clarification:

Confused why the returned value is an integer but your answer is an array?

Note that the input array is passed in by reference,
 which means modification to the input array will be known to the caller as well.

Internally you can think of this:

// nums is passed in by reference. (i.e., without making a copy)
int len = removeElement(nums, val);

// any modification to nums in your function would be known by the caller.
// using the length returned by your function, it prints the first len elements.
for (int i = 0; i < len; i++) {
    print(nums[i]);
}
 */
public class removeElements {

    public int removeElement(int[] nums, int val) {//脑海里的形象化理解
        //遇到个一样的,从指针就停下一次,然后游标继续走,每走到一个,idx就跟他换一下,
        //也是指针!
        int idx = 0 ;
        for(int i =0; i < nums.length; i++){
            if(nums[i] != val){
                nums[idx++] = nums[i];
            }
        }
        return idx;
    }


    /*
    可通过设置一个初始下标int index = 0；把不等于val的值赋值给nums[index]，然后index++；

    如果nums[i]==val， index不自增1，++i。具体思路见下面图片：
     */
    public static void main(String[] args){

    }
}
