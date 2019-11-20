package other;

import java.util.*;

public class a01 {
    public static void main(String[] args) {
        a01 t = new a01();
        System.out.println(t.alldecode(123213456));
    }
    public List<String> alldecode(int num){
//assumptions
//1. int will never be less than 1; with range in 1 to Integer.max_value
//2.output will be a list of string
        List<String> res = new ArrayList<>();
        char[] carr = String.valueOf(num).toCharArray();
        StringBuilder sb = new StringBuilder();
        recur(carr, res, sb, 0);

        List<TreeNode> s1 = new ArrayList<>();
      Collections.sort(s1, (o1, o2) -> {
          if(o1.val  == o2.val){
              return 0;
          }else{
              return o1.val > o2.val ? 1 : -1;
          }
      });


        TreeNode[] t11 = new TreeNode[10];
        Arrays.sort(t11, new Comparator<TreeNode>() {
            @Override
            public int compare(TreeNode o1, TreeNode o2) {
                return 0;
            }
        });







        return res;


    }



    //孙老师答案
//    int numDecodings(String s, int index) {
//        if (index == s.length()) return 1;
//        int ways = 0;
//        if s[index] can be decode ( that is, s[index ]!= ‘0’)
//        ways += numDecodings(s, index + 1);
//        if s[index] + s[index+1] can be decode (that is  between  ‘10’ and ‘26’)
//        ways += numDecodings(s, index + 2);
//        return ways;
//    }


    private void recur(char[] carr, List<String> res, StringBuilder sb, int idx){
        if(idx == carr.length){
            res.add(sb.toString());
            return;
        }
        int len = sb.length();
        String cur = "";
        for(int i = idx; i < carr.length; i++ ){
            String t1 = String.valueOf(carr[i]);
            cur += t1;
            int  tmp = Integer.valueOf(cur);
            if(tmp < 10 && tmp > 0){
                sb.append(toChar(tmp));
                recur(carr, res, sb, i + 1);
                sb.setLength(len);
            } else if(tmp > 10 && tmp <= 26){
                sb.append(toChar(tmp));
                recur(carr, res, sb, i + 1);
                sb.setLength(len);
            } else {
                return;
            }
        }
    }

    private char toChar(int in ){
        in += 'A' - 1;
        return (char)in;
    }


    //question 2
    int LCA(TreeNode root, TreeNode a, TreeNode b, int level, int [ ]solution) {
        if (root == null)
            return -1;

        int left = LCA(root.left, a, b, level + 1, solution);		// step 1;
        int right = LCA(root.right, a, b, level + 1, solution);


        if (root == a || root == b) {					// step 2
            if (left != -1 || right != -1) {  // find a or b in the subtree below root,   (a, b 直接隶属)
                solution[0] = (left != -1 ? left - level : right - level);
            }
            return level;		    // no other node below the subtree
        } else {
            if (left != -1 && right != -1) {	// root is LCA, a b 不互相隶属
                solution[0] =(left - level) + (right -level);
                return left;
            } else {
                return left != -1 ? left : right;
            }
        }
    }

class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(int val){
            this.val = val;
        }

}




}
