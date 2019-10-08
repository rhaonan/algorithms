package com.haonan.leetcode;

/**
 * @Author rhaonan
 * @Data 2019/8/8
 * @Description 字符串转换整数
 */
public class Code8 {

    public static int myAtoi(String str) {
        boolean negative = false;
        int len = str.length();
        int i, j;

        for (i = 0; i < len; i++) {
            if (str.charAt(i) >= '0' && str.charAt(i) <= '9') {
                break;
            } else if (str.charAt(i) == '+' || str.charAt(i) == '-') {
                negative = str.charAt(i) == '-';
                i++;
                break;
            } else if (str.charAt(i) != ' ') {
                return 0;
            }
        }

        for (j = i; j < len; j++) {
            if (str.charAt(j) < '0' || str.charAt(j) > '9') {
                break;
            }
        }

        int res = 0;
        String num = str.substring(i, j);
        for (int x = 0; x < num.length(); x++) {
            int cur = num.charAt(x) - '0';
            if (negative) {
                if (res < Integer.MIN_VALUE/10 || res == Integer.MIN_VALUE/10 && cur > 8) {
                    return Integer.MIN_VALUE;
                }
                res = res * 10 - cur;
            } else {
                if (res > Integer.MAX_VALUE/10 || res == Integer.MAX_VALUE/10 && cur > 7 ) {
                    return Integer.MAX_VALUE;
                }
                res = res * 10 + cur;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String str = "2147483648";
        System.out.println(myAtoi(str));
    }
}
