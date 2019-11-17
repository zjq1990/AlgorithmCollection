package jzOffer;

import java.util.HashMap;
import java.util.Map;

/**
 * 在一个字符串(0<=字符串长度<=10000，全部由字母组成)中找到第一个只出现一次的字符,并返回它的位置, 如果没有则返回 -1（需要区分大小写）.
 */
public class FirstNotRepeatingChar {

    // 对访问过的元素标记，循环遍历，找出其后面没有重复值
    public int FirstNotRepeatingChar_solution(String str) {
        int[] visit = new int[str.length()];
        boolean findit;
        for (int i = 0; i < str.length(); i++) {
            findit = false;
            if (visit[i] == 0) {
                visit[i] = 1;
                for (int j = i + 1; j < str.length(); j++) {
                    if (visit[j] == 0 && str.charAt(j) == str.charAt(i)) {
                        findit = true;
                        visit[j] = 1;
                    }
                }

                if (!findit) {
                    return i;
                }
            }

        }
        return -1;
    }


    // 利用hash表统计每个字母出现次数，然后找出第一个出现次数为1的值
    public int FirstNotRepeatingChar_solution1(String str) {
        Map<Character, Integer> countMap = new HashMap<Character, Integer>();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            countMap.put(c, countMap.getOrDefault(c, 0) + 1);
        }

        for (int i = 0; i < str.length(); i++) {
            if (countMap.get(str.charAt(i)) == 1) {
                return i;
            }
        }
        return -1;
    }
}
