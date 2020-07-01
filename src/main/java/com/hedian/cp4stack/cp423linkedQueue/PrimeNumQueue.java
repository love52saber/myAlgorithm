package com.hedian.cp4stack.cp423linkedQueue;

import com.hedian.cp4stack.cp412seqstack.MyStack;
import com.hedian.cp4stack.cp413singlystack.SinglyStack;
import com.hedian.cp4stack.cp422seqQueue.MyQueue;

public class PrimeNumQueue {

    public MyStack<Integer> genPrimeNumQueue(int n) {
        MyQueue<Integer> tempQueue = new LinkedQueue<>();
        MyStack<Integer> resultStack = new SinglyStack<>();
        resultStack.push(1);
        for (int i = 2; i <= n; i++) {
            tempQueue.enqueue(i);
        }
        while (tempQueue.get() != null) {
            Integer leftNum = resultStack.get();
            Integer rightNum = tempQueue.dequeue();
            if (this.isPrime(leftNum + rightNum)) {
                resultStack.push(rightNum);
            } else {
                tempQueue.enqueue(rightNum);
            }
        }
        return resultStack;
    }

    /**
     * 判断素数
     * @param i
     * @return
     */
    private boolean isPrime(int i) {
        if (i == 1) {
            return false;
        }
        for (int j = 2; j < i; j++) {
            if (i % j == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        PrimeNumQueue temp = new PrimeNumQueue();
        MyStack<Integer> stack = temp.genPrimeNumQueue(10);
        System.out.println(stack);
//        boolean prime = temp.isPrime(3);
//        System.out.println(prime);
    }
}
