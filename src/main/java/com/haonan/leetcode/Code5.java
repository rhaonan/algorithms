package com.haonan.leetcode;

/**
 * @Author rhaonan
 * @Data 2019/8/2
 * @Description 最长回文子串
 */
public class Code5 {

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
    public static String longestPalindrome2(String s) {
        if (s == null || s.length() < 1) {
            return "";
        }

        int start=0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = extendMid(s, i, i);
            int len2 = extendMid(s, i, i+1);
            int len = Math.max(len1, len2);

            if (len > end -start) {
                start = i - (len-1)/2;
                end = i + len/2;
            }
        }
        return s.substring(start, end + 1);
    }

    private static int extendMid(String s, int right, int left) {
        int L = left, R = right;
        while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
            L--;
            R++;
        }
        return R - L - 1;
    }


    public static void main(String[] args) {
        String s = "abbab";
        System.out.println(longestPalindrome2(s));
    }
}
