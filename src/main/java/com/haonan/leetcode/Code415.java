package com.haonan.leetcode;

/**
 * @Author rhaonan
 * @Data 2019/10/8
 * @Description 字符串相加
 */
public class Code415 {

    public static String addStrings(String num1, String num2) {
        int len1 = num1.length();
        int len2 = num2.length();

        int carry = 0;
        StringBuilder sb = new StringBuilder("");
        for (int i = len1 - 1, j = len2 - 1; i >= 0 || j >= 0; i--, j--){
            int num1c = 0, num2c = 0;
            if (i >= 0) {
                num1c = num1.charAt(i) - '0';
            }
            if (j >= 0) {
                num2c = num2.charAt(j) - '0';
            }
            int sum = num1c + num2c + carry;
            carry = sum/10;
            sb.append(sum%10);
        }

        if (carry > 0) {
            sb.append(carry);
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        String num1 = "123424", num2 = "2415";
        System.out.println(addStrings(num1, num2));
    }
}
