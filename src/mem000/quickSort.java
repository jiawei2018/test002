package mem000;

public class quickSort {
    public static void main(String[] args) {

        int[]  t = {1,5,6,3,4,88,2,3,44,3,2,8,9,65,5,0};
        int len = t.length;
        quickSort.quickSort(t,0,len -1 );
        System.out.println(String.valueOf(t));

    }






    public static void quickSort(int[] array, int start, int end) {
        // i相当于助手1的位置，j相当于助手2的位置
        int left = start, right = end;
        int pivot = array[left]; // 取第1个元素为基准元素
        int emptyIndex = left; // 表示空位的位置索引，默认为被取出的基准元素的位置
        // 如果需要排序的元素个数不止1个，就进入快速排序(只要i和j不同，就表明至少有2个数组元素需要排序)
        while (left < right) {
            // 助手2开始从右向左一个个地查找小于基准元素的元素
            while (left < right && pivot <= array[right])
                right--;
            if (left < right) {
                // 如果助手2在遇到助手1之前就找到了对应的元素，就将该元素给助手1的"空位"，j成了空位
                array[emptyIndex] = array[emptyIndex = right];
            }

            // 助手1开始从左向右一个个地查找大于基准元素的元素
            while (left < right && array[left] <= pivot)
                left++;
            if (left < right) {
                // 如果助手1在遇到助手2之前就找到了对应的元素，就将该元素给助手2的"空位"，i成了空位
                array[emptyIndex] = array[emptyIndex = left];
            }
        }
        // 助手1和助手2相遇后会停止循环，将最初取出的基准值给最后的空位
        array[emptyIndex] = pivot;

        // 如果分割点i左侧有2个以上的元素，递归调用继续对其进行快速排序
        if (left - start > 1) {
            quickSort(array, 0, left - 1);
        }
        // 如果分割点j右侧有2个以上的元素，递归调用继续对其进行快速排序
        if (end - right > 1) {
            quickSort(array, right + 1, end);
        }
    }
}
