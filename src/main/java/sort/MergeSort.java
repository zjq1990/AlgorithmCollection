package sort;

/**
 * 归并排序
 */
public class MergeSort {

    public void sort(int[] array, int low, int high) {
        if (low < high) {
            int mid = (high + low) / 2;
            sort(array, low, mid);
            sort(array, mid + 1, high);
            merge(array, low, mid, high);
        }
    }

    private void merge(int[] array, int low, int mid, int high) {
        int n = high - low + 1;//合并后总长度
        int[] tmp = new int[n];
        int left = low;
        int right = mid + 1;
        int index = 0;

        while (left <= mid && right <= high) {
            tmp[index++] = array[left] <= array[right] ? array[left++] : array[right++];
        }

        // 左边还有剩余
        while (left <= mid) {
            tmp[index++] = array[left++];
        }
        //右边还有剩余
        while (right <= high) {
            tmp[index++] = array[right++];
        }

        //重新组装在array中
        for (int i = 0; i < n; i++) {
            array[low + i] = tmp[i];
        }

    }
}
