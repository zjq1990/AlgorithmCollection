package sort;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class MergeSortTest {

    @Test
    public void sort() {
        int[] array = {3, 1, 4, 6, 5, 8, 7, 9, 2};
        System.out.println("排序前：" + Arrays.toString(array));

        MergeSort mergeSort = new MergeSort();
        mergeSort.sort(array, 0, array.length - 1);
        System.out.println("排序后：" + Arrays.toString(array));
    }

}