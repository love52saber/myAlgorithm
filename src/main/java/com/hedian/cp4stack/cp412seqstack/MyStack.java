package com.hedian.cp4stack.cp412seqstack;

public interface MyStack<T> {

    boolean isEmpty();                 //判断栈是否为空
    void push(T x);                    //元素x入栈
    T pop();                           //出栈，返回栈顶元素
    T get();                           //取栈顶元素，未出栈
}
