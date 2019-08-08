package com.haonan.leetcode;

/**
 * @Author rhaonan
 * @Data 2019/8/7
 * @Description 字符串Z字型变幻
 */
public class Code6 {

    public static String convert(String s, int numRows) {
        int len = s.length();
        String[] list = new String[Math.min(numRows, len)];
        String ans = "";
        for (int i = 0 ; i < list.length; i++) {
            list[i] = "";
        }

        if (numRows == 1) {
            return s;
        }

        int row = 0;
        boolean goingdown = false;
        for (int i = 0; i < len; i ++) {
            list[row] += s.charAt(i);
            if (row == 0 || row == numRows - 1) {
                goingdown = !goingdown;
            }
            row += goingdown ? 1 : -1;
        }

        for (String item : list) {
            ans += item;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(convert("AB", 1));
    }
}
