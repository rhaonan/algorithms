package com.haonan.leetcode;

import org.springframework.util.StringUtils;

import java.util.*;

/**
 * @Author rhaonan
 * @Data 2019/7/30
 * @Description  最长不重复字符字串长度
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
                max = Math.max(charList.size(), max);
                deleteBeforeChar(charList, s.charAt(i));
                charList.add(s.charAt(i));
            } else {
                charList.add(s.charAt(i));
            }
        }

        max = Math.max(charList.size(), max);
        return max;
    }

    private static void deleteBeforeChar(List<Character> charList, Character c) {
        int index = charList.indexOf(c);
        for (int i = 0; i <= index; i ++) {
            charList.remove(0);
        }
    }

    public static int lengthOfLongestSubstring2(String s) {
        int n = s.length();
        Set<Character> set = new HashSet<>();
        int ans = 0, i = 0, j = 0;
        while (i < n && j < n) {
            if (!set.contains(s.charAt(j))){
                set.add(s.charAt(j++));
                ans = Math.max(ans, j - i);
            }
            else {
                set.remove(s.charAt(i++));
            }
        }
        return ans;
    }

    public static int lengthOfLongestSubstring3(String s) {
        int ant = 0;
        int n= s.length();

        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0, j = 0; j < n; j++) {
            if (map.containsKey(s.charAt(j))) {
                i = map.get(s.charAt(j));
            }
            ant = Math.max(ant, j - i + 1);
            map.put(s.charAt(j), j + 1);
        }
        return ant;
    }

    public static void main(String[] args) {
        String test = "vdadfe";
        System.out.println(lengthOfLongestSubstring2(test));
        System.out.println(lengthOfLongestSubstring3(test));
    }
}
