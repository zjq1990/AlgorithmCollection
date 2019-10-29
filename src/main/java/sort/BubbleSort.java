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


    public void sort1(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {//趟数
            for (int j = array.length - 1; j > i; j--) {
                int tmp;
                if (array[j] < array[j - 1]) {// 小数上移
                    tmp = array[j];
                    array[j] = array[j - 1];
                    array[j - 1] = tmp;
                }
            }
        }
    }

    //增加flag标识，减少一些无用的计算
    public void sortWithFlag(int[] array) {
        boolean flag;
        for (int i = 0; i < array.length - 1; i++) {
            flag = false;
            for (int j = array.length - 1; j > i; j--) {
                int tmp;
                if (array[j] < array[j - 1]) {
                    tmp = array[j];
                    array[j] = array[j - 1];
                    array[j - 1] = tmp;
                    flag = true;
                }
            }
            // flag表示后面数组是否还发生交换过程，如果没有，则说明后面已经有序，没有必要继续调整
            if (!flag) break;
        }
    }
}
