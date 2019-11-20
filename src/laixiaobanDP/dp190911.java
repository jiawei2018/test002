package laixiaobanDP;


import java.security.KeyStore;
import java.util.*;

public class dp190911 {
    public static void main(String[] args) {
        long[][]  tt = {{-4,3}, {-2, 1}, {1, 0}, {3, 2}};
        System.out.println(solution(tt));
        //System.out.println(solution(tt, 600));
    }
    public static long solution(long[][] clients) {//hored oa -2
        // Type your solution here
        //bfs all to one
        long[] xarr = new long[clients.length];
        long[] yarr = new long[clients.length];
        for(int i = 0; i < clients.length; i++){
            xarr[i] = clients[i][0];
            yarr[i] = clients[i][1];
        }
        long mx = median(xarr);
        long my = median(yarr);
        //assume all the distance
        return getdis(clients, mx, my);

    }
    private static long getdis(long[][] clients, long x, long y){
        long dis = 0l;
        for(long[] c : clients){
            dis += adis(x, y, c[0], c[1]);
        }
        return dis;
    }

    private static long adis(long x, long y, long x1, long y1){
        return Math.abs(x - x1) + Math.abs(y - y1);
    }


    private static long median(long[] arr){
        Arrays.sort(arr);
        int n = arr.length;
        if(n / 2 != 0){
            return arr[n / 2];
        }
        return (arr[n - 1] + arr[n - 2]) / 2l;
    }

    static long[][] dir = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    private static String format(long x, long y){
        return x + "," + y;
    }

    static class Node {
        int id;
        long x;
        long y;
        public Node(int id, long x, long y){
            this.id = id;
            this.x = x;
            this.y = y;
        }
    }


    public String customSortString(String S, String T) {
        int[] map = new int[26];
        Arrays.fill(map, Integer.MAX_VALUE);
        for(int i = 0; i < S.length(); i++){
            int idx = S.charAt(i) - 'a';
            map[idx] = i;
        }
        Character[] carr = new Character[T.length()];
        for(int i = 0; i < T.toCharArray().length; i++ ){
            carr[i] = T.toCharArray()[i];
        }
        Arrays.sort(carr , (c1, c2) -> {
            return map[c1 - 'a'] - map[c2 -'a'];

        });
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < carr.length; i++){
            sb.append(carr[i]);
        }

        return null;

    }



////
////    public void t1(int n) {
////        Node[] d = new Node[n];
////        Arrays.sort(d, (a, b) -> {
////            if (a.x == b.x) {
////                return b.y - a.y;
////            }
////            return a.x - b.x;
////        });
////    }
//
//
//    public static double solution(double[][] readings, long endTime) {//hired oa -1
//
//        if (endTime <= 0) {
//            return 0.0;
//        }
//
//        TreeSet<Pair> treeset = new TreeSet<>((a, b) -> {
//            return (int) a.reading[0] - (int) b.reading[0];
//        });
//        double distance = 0.0;
//        treeset.add(new Pair(readings[0], 0.0));
//        for(int i = 1; i < readings.length; i++){
//            distance += (readings[i][0] - readings[i - 1][0])/ 3600 * readings[i - 1][1];
//            treeset.add(new Pair(readings[i], distance));
//        }
//
//        Pair before = treeset.floor(new Pair(new double[]{(double)endTime, 0.0}, 0));
//        double dis = before.distance;
//        double remain = (endTime - before.reading[0])/3600 * before.reading[1];
//
//
//        return dis + remain;
//    }
//    static class Pair{
//        double[] reading;
//        double distance;
//        public Pair(double[] r, double dis){
//            reading = r;
//            distance = dis;
//        }
//    }
//
//
//    class Node {
//        int x;
//        int y;
//
//    }
}