package a013;

/**
 * 204.
 * Count Primes
 * Difficulty
 * Easy
 *
 * Count the number of prime numbers less than a non-negative number, n.
 *
 * Example:
 *
 * Input: 10
 * Output: 4
 * Explanation: There are 4 prime numbers less than 10, they are 2, 3, 5, 7.
 */
public class countPrimes_204 {

    public int countPrimes(int n) {
        if(n < 2){
            return 0;
        }
        int count = 0;
        boolean[] res = new boolean[n + 1];
        for(int i = 2; i < n; i++){
            if(!res[i] ){
                count++;
                for(int j = 2; j * i < n; j++){
                    res[i * j] = true;
                }
            }

        }

//        for(int i = 2; i < n; i++){
//            if(res[i] == false){
//                count++;
//            }
//        }
        return count;

    }


    public int countPrimesB(int n) {//太笨,要用那个倍数方法!!
        if(n < 2){
            return 0;
        }
        int count = 0;
        for(int i = 2; i <= n; i++){
            if(isP(i)){
                count++;
            }
        }
        return count;

    }
    private boolean isP(int input){
        int root = (int)Math.sqrt(input);
        for(int i = 2; i <= root; i++){
            if(input % i == 0){
                return false;
            }
        }
        return true;
    }




}
