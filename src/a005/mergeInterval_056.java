package a005;

import java.util.*;

/**
 * 56. Merge Intervals
 * DescriptionHintsSubmissionsDiscussSolution
 * Pick One
 * Given a collection of intervals, merge all overlapping intervals.
 *
 * Example 1:
 *
 * Input: [[1,3],[2,6],[8,10],[15,18]]
 * Output: [[1,6],[8,10],[15,18]]
 * Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
 * Example 2:
 *
 * Input: [[1,4],[4,5]]
 * Output: [[1,5]]
 * Explanation: Intervals [1,4] and [4,5] are considerred overlapping.
 */
public class mergeInterval_056 {

    private class Interval {
        int start;
        int end;
        Interval() {
            start = 0;
            end = 0;
        }
        Interval(int s, int e) {
            start = s;
            end = e;
        }
    }

    class Solution {
        public List<Interval> merge(List<Interval> intervals) {
//  我写的垃圾,混乱不堪,一看就是错的.
//            List<Interval> res = new ArrayList<>();
//            int len = intervals.size();
//            //int tmp = 0;
//            for(int i = 0; i < len - 1; i++){
//               // tmp = i;
//                    if(intervals.get(i).end < intervals.get(i + 1).start){
//                        res.add(intervals.get(i));
//                        continue;
//                    }else if(intervals.get(i).end > intervals.get(i + 1).start){
//                            int tmp = 0;
//                           for(int j = i + 1; j < len ; j++){
//                               if(intervals.get(i).end > intervals.get(j).end) {
//                                   continue;
//                               }else
//                                   tmp = j;
//                                   break;
//                           }
//                           Interval temp = new Interval(intervals.get(i).start,intervals.get(tmp).end);
//                                res.add(temp);
//                                i = tmp ;
//                    }
//          }
//            return res;
            if(intervals.size() == 0 || intervals == null) return intervals;
            List<Interval> res = new ArrayList<>();

            int[] start = new int[intervals.size()];
            int[] end = new int[intervals.size()];

            for(int i = 0; i < intervals.size()  ; i++){//mistake
                start[i] = intervals.get(i).start;
                end[i] = intervals.get(i).end;
            }
            Arrays.sort(start);
            Arrays.sort(end);
            int i = 0;//tip
            while(i < intervals.size()){
                int st = start[i];
                while(i < intervals.size() - 1 && start[i + 1] <= end[i]){//the key  start[ i +1] means interv 2.start
                    i++;
                }
                int en = end[i];
                Interval tmp = new Interval(st, en);
                res.add(tmp);
                i++;
            }
            return res;
        }


        //from csdn
        public List<Interval> mergeA(List<Interval> intervals) {
            List<Interval> res = new ArrayList<Interval>();
            if(intervals.size() == 0)   return res;

            //排序，实现了Comparator接口
            Collections.sort(intervals,new Comparator<Interval>() {//key key key
                @Override
                public int compare(Interval o1, Interval o2) {
                    // TODO Auto-generated method stub
                    //return o1.start - o2.start;//起始值升序排序  不能用此法,可能会 overflow
                    if(o1.start > o2.start){
                        return -1;
                    }else if(o1.start < o2.start){
                        return 1;
                    }else
                        return 0;
                }
            });

            Interval i1 = intervals.get(0);
            //遍历
            for(int i = 0; i < intervals.size(); i++){
                Interval i2;
                //分情况i2赋值
                if(i == intervals.size() - 1)//如果i到最后，增加一个虚拟最大的区间
                    i2 = new Interval(Integer.MAX_VALUE, Integer.MAX_VALUE);
                else//否则，i2最后i1后面的值
                    i2 = intervals.get(i+1);
                //合并区间
                if(i2.start >= i1.start && i2.start <= i1.end){
                    i1.end = Math.max(i1.end, i2.end);
                }else{//没有交集，直接添加
                    res.add(i1);
                    i1 = i2;//i1更迭
                }
            }
            return res;
        }




        //final version
        public List<Interval> mergeB(List<Interval> intervals) {
            if (intervals == null || intervals.size() == 0) {
                return intervals;
            }
           // Interval[] intervalArray = intervals.toArray(new Interval[intervals.size()]);//此处不同
            Collections.sort(intervals,new Comparator<Interval>() {//key key key   or use lambda
                @Override
                public int compare(Interval o1, Interval o2) {
                    //return o1.start - o2.start;//起始值升序排序  不能用此法,可能会 overflow
                    if(o1.start == o2 .start){
                        return 0;
                    }else if(o1.start > o2.start){
                        return -1;
                    }else {
                        return 1;
                    }
                }
            });
            List<Interval> res = new ArrayList<>();
            int start = intervals.get(0).start;
            int end = intervals.get(0).end;
            for (Interval i : intervals) {//合并的规则判断
                if(i.start <= end){
                    end = Math.max(end, i.end);
                }else{//i.start > former end
                    res.add(new Interval(start, end));
                    start = i.start;
                    end = i.end;
                }
            }
            res.add(new Interval(start, end));//不要漏了加上最后一个区间   -> 就是呼应的上面那句
            return res;
        }








    }
}