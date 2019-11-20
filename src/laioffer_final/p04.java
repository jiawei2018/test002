package laioffer_final;

public class p04 {
    public boolean canChain(String[]  arr){
        if(arr.length <= 1){
            return true;
        }
        boolean[] res = new boolean[1];
        res[0] = false;
        recur(arr, 1, res);

        return res[0];
    }
    // abb acb  aba bbb

    private void recur(String[] arr, int index, boolean[] res){
        if(index == arr.length){
            if(canLink(arr[index - 1], arr[0])){
                res[0] = true;
                return;
            }
            return;
        }
        for(int i = index ; i < arr.length ; i++){
            swap(arr, index, i);
            if(canLink(arr[index - 1], arr[index])){
                recur(arr, index + 1, res);
            }
            swap(arr, index, i);
        }
    }

    private void printArr(String[] arr){
        StringBuilder sb= new StringBuilder();
        for(String i : arr){
            sb.append(i).append(",");
        }
        System.out.println(sb);
    }

    private void swap(String[]  arr, int idx1, int idx2){
        String temp = arr[idx1];
        arr[idx1] = arr[idx2];
        arr[idx2] = temp;
    }


    private boolean canLink(String str1, String str2){
        if(str1.charAt(str1.length() - 1) == str2.charAt(0)){
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        String[] arr = {"aaa", "bbb", "baa", "aab"};
        p04 t = new p04();
        System.out.println(t.canChain(arr));
    }
}
