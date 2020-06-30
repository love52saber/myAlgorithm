package com.hedian.cp4stack.cp414stack_use;

import com.hedian.cp4stack.cp412seqstack.SeqStack;

public class Bracket {

    public static boolean isMatch(String str) {
        char[] chars = str.toCharArray();
        SeqStack<Character> stack = new SeqStack<>();
        for (char aChar : chars) {
            if (aChar == '(') {
                stack.push(aChar);
            }
            if (aChar == ')') {
                Character pop = stack.pop();
                if (pop == '(') {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        String str = "1(1+2)";
    }
}
