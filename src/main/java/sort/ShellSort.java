package sort;

/**
 * 希尔排序
 */
public class ShellSort {

    // 分组插入排序，不断缩小增量
    public void sort(int[] array) {
        int increment = array.length;
        while (increment > 1) {
            increment = increment / 2;

            for (int k = 0; k < increment; k++) {
                for (int i = k + increment; i < array.length; i += increment) {
                    for (int j = i; j > 0; j -= increment) {
                        if (array[j] < array[j - increment]) {
                            int tmp = array[j];
                            array[j] = array[j - increment];
                            array[j - increment] = tmp;
                        } else {
                            break;
                        }
                    }
                }
            }
        }
    }
}
