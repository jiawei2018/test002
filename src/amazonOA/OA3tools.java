package amazonOA;

public class OA3tools {
    public static void main(String[] args) {
        String low = "abc";
        String upper = "LHK";
        //lowerCaseChar(low);
        //lowerCaseChar("");
        //upperCaseChar(upper);
        upperCaseChar("TENNIS");
        upperCaseChar("UDOMJR");

        upperCaseChar("CRICKET");
        upperCaseChar("PSQR");
        //print();
        //printPrim(100);
    }
    public static void print(){
        for(int i = 1; i < 27; i++){
            System.out.println(i + " : " + (char)('A' + i - 1));
        }
    }

    public static void lowerCaseChar(String str){
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < str.length(); i++){
            sb.append((str.charAt(i) - 'a')).append(",");
        }
        if(sb.length() >= 1)sb.setLength(sb.length() - 1);
        System.out.println(str);
        System.out.println(sb);
    }


    public static void upperCaseChar(String str){
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < str.length(); i++){
            sb.append((str.charAt(i) - 'A')).append(",");
        }
        if(sb.length() >= 1)sb.setLength(sb.length() - 1);
        System.out.println(str);
        System.out.println(sb);
    }

    private static void printPrim(int  i){

        for(int j = 2; j < i; j++){
            if(isP(j)){
                System.out.println(j);
            }
        }

    }

    private static boolean isP(int num){
        int sr = (int)(Math.sqrt(num));
        for(int i = 2; i <= sr; i++){
            if(num % i == 0){
                return false;
            }
        }
        return true;
    }

}
