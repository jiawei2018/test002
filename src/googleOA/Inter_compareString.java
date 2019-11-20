package googleOA;

import java.util.Arrays;

public class Inter_compareString {

    public static void main(String[] args) {
        Inter_compareString t = new Inter_compareString();
        String[] testcasesA = {"abcd","aabc","bd"}, testcasesB = {"aaa","aa"};
        for(int i = 0; i < testcasesA.length; ++i)
            System.out.println(Arrays.toString(t.compareStrings(testcasesA, testcasesB)));

    }
    public int[] compareStrings(String[] A, String[] B){
        // String[] strsA = A.split(","), strsB = B.split(",");
        // A.length > 1 B.length > 1;;
        // A[i],B[i] .length() <= 10
        // all lowercase
        int lenB = B.length;
        int[] bucket = new int[11];
        int[] res = new int[lenB];
        for(String s: A){
            if(s.length() == 0) continue;
            int freq = getMinIdxFreq(s);
            bucket[freq]++;
        }
        // prefix sum
        for(int i = 1; i < 11; ++i){
            bucket[i] += bucket[i - 1];
        }

        for(int i = 0; i < B.length; ++i){
            int freq = getMinIdxFreq(B[i]);
            res[i] = freq > 0 ? bucket[freq - 1]: 0;
        }
        return res;
    }

    private int getMinIdxFreq(String str){
        int[] fMap = new int[26];
        int idx = 26;
        for(char cur : str.toCharArray()){
            fMap[cur - 'a']++;
            idx = Math.min(idx, cur - 'a');
        }
        return fMap[idx];
    }

    //            int[] counts = new int[26];
//            int minIdx = 26;
//            for(char c: s.toCharArray()){
//                ++counts[c - 'a'];
//                minIdx = Math.min(minIdx, c - 'a');
//            }
//            int freq = counts[minIdx];


}
