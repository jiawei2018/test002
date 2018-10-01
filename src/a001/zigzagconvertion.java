package a001;


/*
6. ZigZag Conversion
The string “PAYPALISHIRING” is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)
P　　  A　　 H　　N
A　P　L　S　I　I　G
Y　　   I　　 R
And then read line by line: “PAHNAPLSIIGYIR”
Write the code that will take a string and make this conversion given a number of rows:
string convert(string text, int nRows);
convert(“PAYPALISHIRING”, 3) should return “PAHNAPLSIIGYIR”.
 */
public class zigzagconvertion {
    public static void main(String[] args){

    }
    private String covs(String s,int numRows){//此方法直观,好理解,但是有种 brutal的感觉
        StringBuilder[] sb = new StringBuilder[numRows];//1mis
        for(int i = 0 ;i<sb.length; i++) sb[i] = new StringBuilder();//语法快忘了
        if(s == null || s.length() <=1 || numRows <= 1){
            return s;
        }
        int dir = 1; //this is direction ,1 mean top to buttom, -1 b to top
        int idx = 0;
        for(char c : s.toCharArray()){// mem this line
            sb[idx].append(c);
            idx += dir;   //此处就是扣子,我没翻译出来就是失败
            if(idx == 0 || idx == numRows -1 ) dir = -dir;
        }
        StringBuilder res = new StringBuilder();
        for(int i = 0 ; i<sb.length ; i++){
            res.append(sb[i]);
        }
        return res.toString();
    }
}
