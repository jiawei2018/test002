package a014;

import java.util.HashSet;

/**
 * 223.
 * Rectangle Area
 * Difficulty
 * Medium

 * Find the total area covered by two rectilinear rectangles in a 2D plane.
 *
 * Each rectangle is defined by its bottom left corner and top right corner as shown in the figure.
 *
 * Rectangle Area
 *
 * Example:
 *
 * Input: A = -3, B = 0, C = 3, D = 4, E = 0, F = -1, G = 9, H = 2
 * Output: 45
 * Note:
 *
 * Assume that the total area is never beyond the maximum possible value of int.
 */
public class rectangleArea_223 {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int area = (C - A) * (D - B) + (G - E) * (H - F);

        if(C <= E || G <= A ){
            return area;
        }

        if( F >= D || B >= H){
            return area;
        }

        int right = Math.min(C, G);
        int left = Math.max(A, E);
        int bottom = Math.max(F, B);
        int top = Math.min(H,D);
        int commArea = (right - left) * (top - bottom);
        return area - commArea;

//areaSum = (C - A) * (D - B) + (G - E) * (H - F)
//        if C <= E or G <= A:
//            return areaSum
//        if F >= D or B >= H:
//            return areaSum
//        right = min(C, G)
//        left = max(A, E)
//        top = min(H, D)
//        bottom = max(F, B)
//        commonArea = (right - left) * (top - bottom)
//        return areaSum - commonArea

        //return 0;
    }


}
