package com.haonan.leetcode.interger;

/**
 * @Author rhaonan
 * @Data 2019/8/8
 * @Description 回文数
 */
public class Code9 {

    // 负数都不是回文数，反转溢出也不是回文数
    public boolean isPalindrome(int x) {
        if(x< 0) {
            return false;
        }

        int s = 0;
        int x1 = x;
        while (x1/10 != 0) {
            s= s*10 + x1%10;
            x1 = x1/10;
        }
        s = s*10 + x1%10;
        return x == s;
    }
}
