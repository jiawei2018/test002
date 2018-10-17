package a011;

/**
 * 165. Compare Version Numbers
 * DescriptionHintsSubmissionsDiscussSolution
 * Pick One
 * Compare two version numbers version1 and version2.
 * If version1 > version2 return 1; if version1 < version2 return -1;otherwise return 0.
 *
 * You may assume that the version strings are non-empty and contain only digits and the .
 * character.
 * The . character does not represent a decimal point and is used to separate number sequences.
 * For instance, 2.5 is not "two and a half" or "half way to version three",
 * it is the fifth second-level revision of the second first-level revision.
 *
 * Example 1:
 *
 * Input: version1 = "0.1", version2 = "1.1"
 * Output: -1
 * Example 2:
 *
 * Input: version1 = "1.0.1", version2 = "1"
 * Output: 1
 * Example 3:
 *
 * Input: version1 = "7.5.2.4", version2 = "7.5.3"
 * Output: -1
 */
public class compareVersionNumbers_165  {
    public int compareVersion(String version1, String version2) {
        if(version1 == null || version2 == null){
            return 0;
        }
        int res = 0;
        String[] st1 = version1.split("\\.");//key word
        System.out.println(st1);
        String[] st2 = version2.split("\\.");
        int len = Math.max(st1.length , st2.length);
        for(int i = 0; i < len; i++){//从前往后比//此处重要!!!
            int v1 = 0;//涉及到赋值
            int v2 = 0;
            if(i < st1.length){//赋值成功条件
                v1 = Integer.valueOf(st1[i]);
            }
            if( i < st2.length){
                v2 = Integer.valueOf(st2[i]);
            }

            if(v1 > v2){//只要出现就return
                return 1;
            }
            if(v1 < v2){
                return -1;
            }

        }
        return res;
    }

    public static int compareVersion3(String version1, String version2) {
        int i = 0;
        int j = 0;
        while (i < version1.length() || j < version2.length()) {
            int temp1 = 0;
            int temp2 = 0;
            while (i < version1.length() && '.' != version1.charAt(i)) {
                temp1 = temp1 * 10 + (version1.charAt(i) - '0');
                i++;
            }
            i++;

            while (j < version2.length() && '.' != version2.charAt(j)) {
                temp2 = temp2 * 10 + (version2.charAt(j) - '0');
                j++;
            }
            j++;
            if (temp1 > temp2) {
                return 1;
            }
            if (temp1 < temp2) {
                return -1;
            }
        }
        return 0;
    }




    public static void main(String[] args) {
        String s1 = "1.1";
        String s2 = "1";
        compareVersionNumbers_165 t = new compareVersionNumbers_165();
        System.out.println(t.compareVersion(s1,s2));
//        String[] h = s1.split("\\.");
//        System.out.println(h.length);
//        System.out.println(h.toString());
    }
}
