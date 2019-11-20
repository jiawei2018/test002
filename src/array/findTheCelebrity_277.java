package array;

public class findTheCelebrity_277 {
    public int findCelebrity(int n) {
        int cele = 0;

        for (int i = 1; i < n; i++) {
            if (knows(cele, i)) {
                cele = i;
            }
        }

        for (int i = 0; i < n; i++) {
            if (i != cele && knows(cele, i)) {
                return -1;
            }
            if (i != cele && !knows(i, cele)) {
                return -1;
            }
        }
        return cele;
    }

    boolean knows(int a, int b) {
        return false;
    }
}
