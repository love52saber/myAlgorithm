package com.hedian.cp4stack.cp414stack_use;

import com.hedian.cp4stack.cp412seqstack.SeqStack;
import com.hedian.cp4stack.cp413singlystack.SinglyStack;

public class Expression {

    public static String toPostfix(String expstr)          //返回expstr的后缀表达式
    {
        SinglyStack<String> stack = new SinglyStack<>();
        String postfix = "";
        char[] chars = expstr.toCharArray();
        int i = 0;
        while (i < expstr.length()) {
            char ch = expstr.charAt(i);
            switch (ch) {
                case '+':
                case '-':
                    while (!stack.isEmpty() && !stack.get().equals("(")) {
                        postfix += stack.pop();
                    }
                    stack.push(ch + "");
                    i++;
                    break;
                case '*':
                case '/':
                    while (!stack.isEmpty() && (stack.get().equals("*") || stack.get().equals("/"))) {
                        postfix += stack.pop();
                    }
                    stack.push(ch + "");
                    i++;
                    break;
                case '(':
                    stack.push(ch + "");
                    i++;
                    break;
                case ')':
                    String pop = stack.pop();
                    while (!stack.isEmpty() && !pop.equals("(")) {
                        postfix += pop;
                        pop = stack.pop();
                    }
                    i++;
                    break;
                default:
                    while (i < expstr.length() && ch >= '0' && ch <= '9') {
                        postfix += ch;
                        i++;
                        if (i < expstr.length()) {
                            ch = expstr.charAt(i);
                        }
                    }
                    postfix += " ";
            }
        }
        while (!stack.isEmpty()) {
            postfix += stack.pop();
        }
        return postfix;
    }

    public static int value(String postfix)                //计算后缀表达式的值
    {
        int result = 0;
        int i = 0;
        SinglyStack<Integer> toCalNums = new SinglyStack<>();
        while (i < postfix.length()) {
            char ch = postfix.charAt(i);
            if (ch <= '9' && ch >= '0') {
                String temp = "";
                while (ch != ' ') {
                    temp += ch;
                    ch = postfix.charAt(++i);
                }
                i++;
                toCalNums.push(Integer.parseInt(temp));
            } else if (ch != ' ') {
                Integer y = toCalNums.pop();
                Integer x = toCalNums.pop();
                switch (ch) {
                    case '+':
                        result = x + y;
                        break;
                    case '-':
                        result = x - y;
                        break;
                    case '*':
                        result = x * y;
                        break;
                    case '/':
                        result = x / y;
                        break;
                    default:
                        break;
                }
                toCalNums.push(result);
                i++;
            }
        }
        return toCalNums.pop().intValue();
    }
    public static void main(String args[])
    {
        String expstr="121+10*(53-49+20)/((35-25)*2+10)+11";
        String postfix = toPostfix(expstr);
        System.out.println("expstr= "+expstr);
        System.out.println("postfix= "+postfix);
        System.out.println("value= "+value(postfix));
    }

}
