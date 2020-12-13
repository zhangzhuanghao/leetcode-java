// code by 小豪, 2020/12/12

import java.util.Stack;

public class Solution {

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            switch (c) {
                case '(' -> stack.push(')');
                case '{' -> stack.push('}');
                case '[' -> stack.push(']');
                default -> {
                    if (stack.empty() || stack.pop() != c) {
                        return false;
                    }
                }
            }
        }
        return stack.empty();
    }
}
