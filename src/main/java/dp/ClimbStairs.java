package dp;

public class ClimbStairs {
    // 跳台阶， 每次可以跳一级或者跳两级，求跳到n级台阶总共有多少种方式
    // 类似于斐波那契， S(n) = S(n-1) + S(n-2)
    public int climbStairs(int n) {
        if (n <= 1) return 1;
        if (n == 2) return 2;

        int sum = 0;
        int p = 1, q = 2;
        for (int i = 3; i <= n; i++) {
            sum = p + q;
            p = q;
            q = sum;
        }
        return sum;
    }
}
