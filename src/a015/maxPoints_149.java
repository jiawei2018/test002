package a015;

import kotlin.reflect.jvm.internal.impl.types.checker.TypeIntersector;

import java.util.HashMap;
import java.util.Map;

/**
 * 149. Max Points on a Line
 * Hard
 * 335
 * 964
 * <p>
 * <p>
 * Given n points on a 2D plane, find the maximum number of points that lie on the same straight line.
 * <p>
 * Example 1:
 * <p>
 * Input: [[1,1],[2,2],[3,3]]
 * Output: 3
 * Explanation:
 * ^
 * |
 * |        o
 * |     o
 * |  o
 * +------------->
 * 0  1  2  3  4
 * Example 2:
 * <p>
 * Input: [[1,1],[3,2],[5,3],[4,1],[2,3],[1,4]]
 * Output: 4
 * Explanation:
 * ^
 * |
 * |  o
 * |     o        o
 * |        o
 * |  o        o
 * +------------------->
 * 0  1  2  3  4  5  6
 * Accepted
 * 106,473
 * Submissions
 * 693,176
 */
public class maxPoints_149 {
    class Point {
        int x;
        int y;

        Point() {
            x = 0;
            y = 0;
        }

        Point(int a, int b) {
            x = a;
            y = b;
        }
    }


    public int maxPoints(Point[] points) {
        if(points == null || points.length == 0){
            return 0;
        }
        int len = points.length;
        if(len <= 2){
            return points.length;
        }
        int res = 2;
        // < slope , total points at this slope >
        for(int i = 0; i < len; i++){
            Map<String, Integer> map = new HashMap<>();
            int same = 1;//must be at least 1!!!!!!
            int atx = 1;// at same x line
            for(int j = 0; j < len ; j++){
                if(i != j){//make sure not ref equal
                    int xsub = points[i].x - points[j].x;
                    int ysub = points[i].y - points[j].y;

                    if(xsub == 0 && ysub == 0){//same dot
                        same++;
                    }
                    if(xsub == 0){//at same  horizon line
                        atx++;
                        continue;
                    }

                    int gcd = gcd(ysub, xsub);//the order must be this
                    int numerator =  ysub / gcd;
                    int denominator =  xsub / gcd;
                    String cur = numerator +":"+ denominator;
                    Integer num = map.get(cur);
                    if(num == null){
                        map.put(cur, 1 );
                    }else{
                        map.put(cur, num + 1);
                    }
                    //System.out.println(map.get(cur) +"  <> " +same);
                    res = Math.max(res, map.get(cur) + same );
                }
            }
            res = Math.max(res, atx);
        }
        return res;
    }


    private int  gcd(int a, int b){//remember this one
        if (a == 0){
            return b;
        }
        return gcd(b % a, a);
    }
}
