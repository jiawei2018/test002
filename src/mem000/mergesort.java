package mem000;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class mergesort { //merge sort is the english for 归并排序


    private void sortA(int[] array, int low, int high, int[] temp) {//   int[] temp=new int[array.length];
        if (low >= high) {
            return;
        }
        int mid = (low + high) / 2;
            sortA(array, low, mid, temp);
            sortA(array, mid + 1, high, temp);
            mergeA(array, low, mid, high, temp);


    }


    private void mergeA(int[] array, int first, int mid, int last, int[] temp) {

        int left = first, right = mid + 1;
        int idx = first;

        while (left <= mid && right <= last) {
            if(array[left] > array[right]){
                temp[idx++] = array[right++];
            }else {
                temp[idx++] = array[left++];
            }
            //temp[idx++] = array[left] >= array[right] ? array[right++] : array[left++];



            System.out.println(idx + " left-> " +left + "   <> " + right);
        }
        while (left <= mid)
            temp[idx++] = array[left++];

        while (right <= last)
            temp[idx++] = array[right++];
         for (int i = 0; i < idx - first; i++)
             array[first + i] = temp[first + i];
    }


    // 归并排序的实现
    //------------------------------------------
//
//    private int[] sort(int[] nums, int[] temp, int left, int right) {
//        if (left >= right) return nums;
//        int mid = left + (right - left) / 2;
//        //System.out.println(left + "   <>  "  + mid + "    >>" + right);
//        //System.out.println(left + "   <>  "  + mid + "    >>" + right);
//        sort(nums, temp, left, mid);//this may be wrong, never mid -1 ,may be -1 in idx
//        sort(nums, temp, mid + 1, right);//this maybe wrong . 如果用 left = mid- 1 则会出现死循环?为什么???
//        merge(nums, temp, left, mid, right);
//        return nums;
//    }
//
//
//    private void merge(int[] nums, int[] temp, int left, int mid, int right) {
//
//        int leftidx = left;
//        int rightidx = mid + 1;
//        int lefttemp = 0;
//
//        while (leftidx <= mid && rightidx <= right) {//test < not <=
//            //上面那句如果不是<= 那么 会出现根本不排序的情况,因为最后拆成单一元素的时候就没有 < 了,只有 =
//            if (nums[leftidx] < nums[rightidx]) {//test < not <=   好像也行?
//                temp[lefttemp++] = nums[leftidx++];
//            } else
//                temp[lefttemp++] = nums[rightidx++];
//        }
//
//        while (leftidx <= mid) temp[lefttemp++] = nums[leftidx++];//test < not <=  有问题,会出现重复元素
//        while (rightidx <= right) temp[lefttemp++] = nums[rightidx++];//test < not <=  好像也行???
//
//        for (int i = 0; i < lefttemp; i++) {//mistake    not temp.length  is the lefttemp!!!!!!!!!!
//            //System.out.println(left + "  <<");
//            nums[left++] = temp[i];// only replace a part of the array
//        }
//
//    }


    //quicksort
//    public static void quickSortA(int array[], int left, int right) {
//        if (left >= right) {
//            return;
//        }
//        int i = left;
//        int j = right;
//        int key = array[left];
//        while (i <= j) {
//            while (i < j && array[j] > key) {
//                j--;
//            }
//            array[i] = array[j];
//            while (i < j && array[i] < key) {
//                i++;
//            }
//            array[j] = array[i];
//        }
//        array[i] = key;
//        quickSortA(array, left, i - 1);
//        quickSortA(array, i + 1, right);
//    }

//    private void mysort(int[] nums, int left, int right) {
//        //this on worked
//        if (left >= right) return;
//        int i = left, j = right;
//        int pivot = nums[left];
//        while (i <= j) {
//            System.out.println(i + "  " + j);
//            while (i < j && nums[j] >= pivot) j--;
//            nums[i] = nums[j];//swap here  big
//            while (i < j && nums[i] < pivot) i++;
//            nums[j] = nums[i];//small here
//        }
//        nums[i] = pivot;
//        mysort(nums, left, i - 1);
//        mysort(nums, i + 1, right);
//    }


    //laioffer

//    private void quickSort(int[] nums, int left, int right) {
//        //base case
//        if (left >= right) return;
//        int cut = getPivot(nums, left, right);
//
//        quickSort(nums, left, cut - 1);
//        quickSort(nums, cut + 1, right);
//    }

    private int getPivot(int[] nums, int left, int right) {

        int pivot = nums[left];// 选择左边的作为pivot,则就要跟j互换,才能保证i左边的都比pivot小,因为i ,j交错时候,
        //  i 下一个值是一定大于pivot的(之前j走过这里符合逻辑,才 j--),而pivot在最左边(理论最小位置),
        // 所以一定要跟j换才能保证挡板的理论符合,

        //同理如果 是选right  = pivot则 最后swap 就是 跟i互换了
        int i = left + 1;
        int j = right;

        while (i <= j) {
            //{ 2, 7, 8, 3, 1, 6, 9, 1, 5, 4 };
            if (nums[i] < pivot) {
                i++;
            } else if (nums[j] >= pivot) {
                j--;
            } else
                swap(nums, i++, j--);
        }
        swap(nums, j, left);//why must be this? or ?
        return j;//must be j too
    }

    private void swap(int[] nums, int idxa, int idxb) {
        int temp = nums[idxa];
        nums[idxa] = nums[idxb];
        nums[idxb] = temp;
    }


    public void ms(int[] nums){
        int[] temp = new int[nums.length];
        sortA(nums,0, nums.length - 1, temp );
        List<Integer> mm = new ArrayList<>();
        for(int i = 0; i < temp.length; i++){
            mm.add(nums[i]);
        }
        System.out.println(mm);
    }
    public static void main(String[] args) {

        int[] array = {2, 7, 8, 3, 1, 6, 9, 1, 5, 4};
        int[] array1 = {3, 5, 1, 2, 4, 8};
        // int[] temp=new int[array.length];
        mergesort t = new mergesort();
        t.ms(array);
        //  t.sort(array, temp, 0, array.length - 1);  //(input array,low,high,temp[])

        //t.quickSort(array1, 0, array1.length - 1);
       // t.mysort(array, 0, array.length - 1);
       // System.out.println(Arrays.toString(array));



    }


}



