package a015;

/**
 * 135. Candy
 Hard
 334
 99


 There are N children standing in a line. Each child is assigned a rating value.

 You are giving candies to these children subjected to the following requirements:

 Each child must have at least one candy.
 Children with a higher rating get more candies than their neighbors.
 What is the minimum candies you must give?

 Example 1:

 Input: [1,0,2]
 Output: 5
 Explanation: You can allocate to the first, second and third child with 2, 1, 2 candies respectively.
 Example 2:

 Input: [1,2,2]
 Output: 4
 Explanation: You can allocate to the first, second and third child with 1, 2, 1 candies respectively.
 The third child gets 1 candy because it satisfies the above two conditions.
 */
public class candy_135 {

    public int candy(int[] ratings) {
        if(ratings == null || ratings.length < 1){
            return 0;
        }

        int len = ratings.length;
        int[] kids = new int[len];
        for(int i = 0; i < len;i++){
            kids[i] = 1;//every kid at least have one candy
        }

        for(int i = 1; i < len;i++){
            if(ratings[i] > ratings[i - 1]){
                kids[i] = kids[i - 1] +1;
            }
        }

        for(int i = len - 2; i >= 0; i--){
            if(ratings[i] > ratings[i + 1]){
                kids[i] = Math.max(kids[i], kids[i + 1] + 1);
            }
        }

        int res = 0;
        for(int i = 0; i < len;i++){
           res += kids[i]; //every kid at least have one candy
        }

        return res;
    }
}
