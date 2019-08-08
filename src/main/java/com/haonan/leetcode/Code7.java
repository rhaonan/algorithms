package com.haonan.leetcode;

/**
 * @Author rhaonan
 * @Data 2019/8/8
 * @Description
 */
public class Code7 {

    public static int reverse(int x) {
        int ans = 0;
        while (x != 0) {
            int pop = x % 10;
            if (ans * 10 > Integer.MAX_VALUE || (ans * 10 == Integer.MAX_VALUE && pop > 7)) {
                return 0;
            }
            if (ans * 10 < Integer.MIN_VALUE || (ans * 10 == Integer.MIN_VALUE && pop < -8)) {
                return 0;
            }
            ans = ans * 10 + pop;
            x /= 10;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(reverse(123));
    }
}
