package test;

public class testcloud {

    public static String generateId(String prefix, int count) {
        return String.format("%s%04d", prefix , count);
    }


    public static void main(String[] args) {
        System.out.println(generateId("jw", 2));
    }
}
