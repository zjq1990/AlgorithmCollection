package sort;

/**
 * 选择排序
 */
public class SelectionSort {

    // 第一遍 从后面(n-1)个数中找出最小值与第一个数进行比较
    // 第二遍 从后面(n-2)个数中找出最小值与第二个数进行比较
    // 以此类推
    public void sort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            int minIndex = i;// 最小值索引
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }
            if(array[minIndex] < array[i]){
                int tmp = array[minIndex];
                array[minIndex] = array[i];
                array[i] = tmp;
            }
        }
    }
}
