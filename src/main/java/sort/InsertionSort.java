package sort;

/**
 * 插入排序
 */
public class InsertionSort {

    //每次插入一个数，假设它的前面数组是有序的，从后往前依次比较，直到插入到合适的位置
    public void sort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = i + 1; j > 0; j--) {
                if (array[j] < array[j - 1]) {
                    int tmp = array[j];
                    array[j] = array[j - 1];
                    array[j - 1] = tmp;
                } else {
                    break;
                }
            }
        }
    }
}
