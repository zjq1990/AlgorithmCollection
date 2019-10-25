package sort;

/**
 * 冒泡排序
 */
public class BubbleSort {

    // 冒泡排序基本思想就是将小的数往前调或大的数往后调
    public void sort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = i + 1; j < array.length; j++) {
                int tmp;
                if (array[i] > array[j]) {
                    tmp = array[i];
                    array[i] = array[j];
                    array[j] = tmp;
                }
            }
        }
    }
}
