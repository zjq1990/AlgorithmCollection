package sort;

/**
 * 快速排序 (时间复杂度：nlogn)
 */
public class QuickSort {

    // 设置标杆，将小于它的数放置在左边，将大于它的数放置在右边， 递归方式
    public void sort(int[] array, int l, int u) {
        if (l > u) {
            return;
        }

        int i = l;
        int j = u;
        int key = array[i];//标杆

        while (i < j) {
            while (i < j && array[j] > key) {
                j--;
            }

            if (i < j) {
                array[i] = array[j];
                i++;
            }

            while (i < j && array[i] < key) {
                i++;
            }

            if (i < j) {
                array[j] = array[i];
                j--;
            }
        }

        array[i] = key;

        sort(array, l, i - 1);//左边
        sort(array, i + 1, u);//右边

    }

}
