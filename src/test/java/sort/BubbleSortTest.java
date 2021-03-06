package sort;

import org.junit.Test;

import java.util.Arrays;


public class BubbleSortTest {

    @Test
    public void sort() {
        int[] array = {3, 1, 4, 6, 5, 8, 7, 9, 2};
        System.out.println("排序前：" + Arrays.toString(array));

        BubbleSort bubbleSort = new BubbleSort();
        bubbleSort.sort(array);
        System.out.println("排序后：" + Arrays.toString(array));
    }

    @Test
    public void sort1() {
        int[] array = {3, 1, 4, 6, 5, 8, 7, 9, 2};
        System.out.println("排序前：" + Arrays.toString(array));

        BubbleSort bubbleSort = new BubbleSort();
        bubbleSort.sort1(array);
        System.out.println("排序后：" + Arrays.toString(array));
    }

    @Test
    public void sortWithFlag() {
        int[] array = {3, 1, 4, 6, 5, 8, 7, 9, 2};
        System.out.println("排序前：" + Arrays.toString(array));

        BubbleSort bubbleSort = new BubbleSort();
        bubbleSort.sortWithFlag(array);
        System.out.println("排序后：" + Arrays.toString(array));
    }
}