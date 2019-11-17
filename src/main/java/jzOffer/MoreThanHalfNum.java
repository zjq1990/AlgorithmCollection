package jzOffer;


import java.util.HashMap;
import java.util.Map;

/**
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。
 * 由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。如果不存在则输出0。
 */
public class MoreThanHalfNum {

    // hashmap存储每个数的出现次数
    public int MoreThanHalfNum_Solution(int[] array) {
        Map<Integer, Integer> elementCount = new HashMap<>();
        for (int a : array) {
            int count = elementCount.getOrDefault(a, 0) + 1;
            elementCount.put(a, count);
        }

        for (Map.Entry<Integer, Integer> entry : elementCount.entrySet()) {
            if (entry.getValue() > array.length * 0.5) {
                return entry.getKey();
            }
        }
        return 0;
    }


    // O(n)复杂度
    // 遍历每个数字，保存两个值，一个是当前数字，一个是次数。 如果下个数字与当前数字相同，则次数加一；如果下个数字与当前数字不同，则次数减一；
    // 如果次数为0时，则重置当前数字，次数为1. 最后检查所选择的数字是否真正的出现次数超过一半.
    public int MoreThanHalfNum_Solution1(int[] array) {
        // 找出出现次数最多的数字
        int times = 1;
        int result = array[0];
        for (int i = 1; i < array.length; i++) {
            if (times == 0) {
                result = array[i];
                times = 1;
            }
            if (result == array[i]) {
                times++;
            } else {
                times--;
            }
        }

        // check
        int cnt = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == result) {
                cnt++;
            }
        }
        if (cnt <= array.length * 0.5) {
            result = 0;
        }
        return result;
    }
}
