package com.haonan.leetcode.string;

/**
 * @Author rhaonan
 * @Data 2019/10/8
 * @Description 字符串相乘
 */
public class Code43 {

    public static String multiply(String num1, String num2) {
        if ("0".equals(num1) || "0".equals(num2)) {
            return "0";
        }

        String res = "0";
        int len1 = num1.length(), len2 = num2.length();

        for (int i = len2 - 1; i >= 0; i--) {
            int carry = 0;
            StringBuilder sb = new StringBuilder("");

            //补0
            for(int j = 0; j < len2 - 1 - i; j++) {
                sb.append(0);
            }

            //num2的第i位与num1相乘
            int n2 = num2.charAt(i) - '0';
            for (int j = len1 - 1; j >=0; j--) {
                int n1 = num1.charAt(j) - '0';
                int sum = n1 * n2 + carry;
                sb.append(sum%10);
                carry = sum / 10;
            }
            if (carry > 0) {
                sb.append(carry);
            }

            res = Code415.addStrings(res, sb.reverse().toString());
        }

        return res;
    }

    public static void main(String[] args) {
        String str1 = "123", str2 = "456";
        System.out.println(multiply(str1, str2));
    }
}
