package OSashish;

import java.io.IOException;

public class ass01 {
    public static void main(String[] args) {

        Process iostat = null;
        try {
            iostat = new ProcessBuilder().command("explorer", "D:\temp").inheritIO().start();
        } catch (IOException e) {
            e.printStackTrace();
        }
        int exitCode = 0;
        try {
            exitCode = iostat.waitFor();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("exitCode = " + exitCode);

    }

    class mp{

    }
}
