package OSashish;

import java.io.Console;
import java.lang.management.ManagementFactory;
import java.lang.management.RuntimeMXBean;
import java.util.HashSet;
import java.util.Set;

public class ass01asset {
    public static void main(String[] args) {

//        Thread t = Thread.currentThread();
//        String name = t.getName();
//        System.out.println("name=" + name);
        try {
            System.out.println(args.length);
            //String childIndex = args[0];
           // System.out.println(childIndex);


        } catch (Exception e) {
            e.printStackTrace();
        }


        // RuntimeMXBean runtimeMXBean = ManagementFactory.getRuntimeMXBean();
        //System.out.println(runtimeMXBean.getInputArguments());
        // System.out.println(runtimeMXBean.getVmName());
        //System.out.println(runtimeMXBean.getClassPath());
        //  System.out.println(runtimeMXBean.getName());
        // System.out.println(Integer.valueOf(runtimeMXBean.getName())
        //         );
    }


    private static void pr() {
        for (int i = 0; i < 10; i++) {

            sleep(2000);
            System.out.println("hello world1");
        }

    }

    private static void sleep(int ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }


}
