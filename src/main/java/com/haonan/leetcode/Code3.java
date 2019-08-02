package com.haonan.leetcode;

import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author rhaonan
 * @Data 2019/7/30
 * @Description
 */
public class Code3 {

    public static int lengthOfLongestSubstring(String s) {
        if (StringUtils.isEmpty(s)) {
            return 0;
        }

        int len = s.length();
        int max = 0;
        List<Character> charList = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            if (charList.contains(s.charAt(i))) {
                max = charList.size() > max ? charList.size() : max;
                deleteBeforeChar(charList, s.charAt(i));
                charList.add(s.charAt(i));
            } else {
                charList.add(s.charAt(i));
            }
        }

        max = charList.size() > max ? charList.size() : max;
        return max;
    }

    private static void deleteBeforeChar(List<Character> charList, Character c) {
        int index = charList.indexOf(c);
        for (int i = 0; i <= index; i ++) {
            charList.remove(0);
        }
    }

    public static void main(String[] args) {
        String test = "vdadfe";
        System.out.println(lengthOfLongestSubstring(test));
    }
}
