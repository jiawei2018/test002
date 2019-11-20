package a015;

import java.util.HashSet;
import java.util.Set;

/**
 * 128. Longest Consecutive Sequence
 Hard
 1392
 62


 Given an unsorted array of integers, find the length of the longest consecutive elements sequence.

 Your algorithm should run in O(n) complexity.

 Example:

 Input: [100, 4, 200, 1, 3, 2]
 Output: 4
 Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.
 */
public class longestConsectiveSequences_128 {
    public int longestConsecutive(int[] nums) {
        if(nums == null || nums.length < 1){
            return 0;
        }
        Set<Integer> set = new HashSet<>();
        int res = 0;
        for(int i = 0; i< nums.length ; i++){//put into set
            set.add(nums[i]);
        }

        for(int i = 0; i < nums.length; i++){
            int cur = nums[i];
            int prev = cur - 1;
            int next = cur + 1;
            while(set.remove(prev)){
                prev--;
            }
            while(set.remove(next)){
                next++;
            }

//            while(set.contains(prev)){
//                set.remove(prev);
//                prev--;
//            }
//            while(set.contains(next)){
//                set.remove(next);
//                next++;
//            }
            res= Math.max(res, next - prev - 1);
            //think 3,4,2,1;
            //at final prev = 0;
            // next = 5; the res will be 4 so 5- 0-  1
        }

        return res;
    }
}
