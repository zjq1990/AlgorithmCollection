package jzOffer;

import java.util.HashMap;
import java.util.Map;

/**
 * 统计一个数字在排序数组中出现的次数。
 */
public class GetNumberOfK {

    // map统计每个数出现次数，然后取出k的次数
    public int getNumberOfK(int[] array, int k) {
        Map<Integer, Integer> count = new HashMap<>();
        for (int i = 0; i < array.length; i++) {
            count.put(array[i], count.getOrDefault(array[i], 0) + 1);
        }
        return count.getOrDefault(k, 0);
    }

    /////////////////////////////////////////////////////////////////////////////
    // 有序数列查找，自然联想到二分查找的方式
    public static int getNumberOfK1(int[] array, int k) {
        int low = getLowerBound(array, k);
        int upper = getUpperBound(array, k);
        return Math.abs(upper - low) + 1;//由于没有明确说明是升序或者降序，因此low,upper大小比较不一定
    }

    private static int getLowerBound(int[] array, int k) {
        int start = 0;
        int end = array.length - 1;
        int mid = (start + end) / 2;

        while (start <= end) {
            if (array[mid] < k) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
            mid = (start + end) / 2;
        }
        return start;
    }

    private static int getUpperBound(int[] array, int k) {
        int start = 0;
        int end = array.length - 1;
        int mid = (start + end) / 2;

        while (start <= end) {
            if (array[mid] <= k) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
            mid = (start + end) / 2;
        }
        return end;
    }

    public static void main(String[] args) {
        //int[] a = {1, 1, 2, 3, 4, 4, 5};
        int[] a ={5,4,4,3,2,1,1};
        int index1 = getLowerBound(a, 4);
        int index2 = getUpperBound(a, 4);
        int cnt = getNumberOfK1(a, 4);
        System.out.println(cnt);
    }
}
