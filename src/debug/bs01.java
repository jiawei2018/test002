package debug;

public class bs01 {

    public static void main(String[] args) {
        bs01 t = new bs01();
        for(int i = 1; i <= 4; i++){
            System.out.println(t.bsc(4, i));
        }

    }
    private int bsc(int n, int target){

        int left = 1;
        int right = n;
        int cost = 0;
        while(left < right){
            int mid = left + (right - left) / 2;
            //System.out.println(mid);
            if(mid == target){
                return cost;
            } else if( mid < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
            cost += mid;
        }
        //System.out.println(target+ " " + cost);
        return cost;
    }

}
