package a004;

public class hard_45 {
    public int jump(int[] nums) {
        //bfs
        if(nums == null || nums.length < 2  ){
            return 0;
        }
        int level = 0;
        int maxNext = 0;
        int maxRange = 0;
        int i = 0;

        while(maxRange - i + 1 > 0){
            level++;
            for(; i <= maxRange; i++){
                maxNext = Math.max(maxNext, nums[i] + i);
                if(maxNext >= nums.length - 1){
                    return level;
                }
            }
            maxRange = maxNext;
        }
        return 0;
    }
}
