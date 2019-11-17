package jzOffer;

/**
 * 输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
 * 例如输入数组{3，32，321}，则打印出这三个数字能排成的最小数字为321323。
 */
public class PrintMinNumber {

    // 类似于排序，自定义比较方式，即为两个数a和b拼接后ab与ba的大小比较，将较小者放在前面
    public String PrintMinNumber_Solution(int[] numbers) {
        for (int i = 0; i < numbers.length - 1; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                int s1 = numbers[i];
                int s2 = numbers[j];
                if (createNewNumber(s1, s2) > createNewNumber(s2, s1)) {//比较大小
                    int tmp = numbers[i];
                    numbers[i] = numbers[j];
                    numbers[j] = tmp;
                }
            }
        }

        StringBuilder builder = new StringBuilder();
        for (int num : numbers) {
            builder.append(num);
        }
        return builder.toString();
    }

    // 拼接
    private int createNewNumber(int a, int b) {
        int sum = b;
        int bit = 0;
        while (b >= 1) {
            b = b / 10;
            bit++;
        }
        return (int) (a * Math.pow(10, bit)) + sum;
    }
}
