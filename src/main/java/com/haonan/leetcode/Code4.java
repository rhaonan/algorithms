package com.haonan.leetcode;

/**
 * @Author rhaonan
 * @Data 2019/8/2
 * @Description 最长回文子串
 */
public class Code4 {

    /**
     * 暴力法
     */
    public String longestPalindrome(String s) {
        int len = s.length();
        String ans = "";
        int max = 0;
        for (int i = 0; i < len; i++) {
            for (int j = i++; j <= len; j++) {
                String son = s.substring(i, j);
                if(isPalindrome(son) && son.length() > max) {
                    max = son.length();
                    ans = son;
                }
            }
        }
        return ans;
    }

    private boolean isPalindrome(String s) {
        int len = s.length();
        for (int i = 0; i < len/2; i++) {
            if (s.charAt(i) != s.charAt(len - i - 1)) {
                return false;
            }
        }
        return true;
    }

    /**
     *  中心扩展法
     */
    public String longestPalindrome2(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }

        int start = 0, end = 0;
        for (int i = 0; i <= s.length(); i++) {
            int len1 = extentMid(s, i, i);
            int len2 = extentMid(s, i, i+1);
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len -1)/2;
                end = i + len/2;
            }
        }

        return s.substring(start, end);
    }

    private int extentMid(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return (right - 1) - (left + 1) + 1;
    }


    public static void main(String[] args) {

    }
}
