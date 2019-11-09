package com.haonan.leetcode.string;

import java.util.*;

/**
 * @Author rhaonan
 * @Data 2019/8/8
 * @Description 有效的括号
 */
public class Code20 {

    Map<Character, Character> charMap = new HashMap<Character, Character>() {{
        put(')', '(');
        put(']', '[');
        put('}', '{');
    }};

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (charMap.containsKey(c)) {
                char top = stack.empty() ? '#':stack.pop();
                if (charMap.get(c) != top) {
                    return false;
                }
            } else {
                stack.push(s.charAt(i));
            }
        }

        return stack.isEmpty();
    }
}
