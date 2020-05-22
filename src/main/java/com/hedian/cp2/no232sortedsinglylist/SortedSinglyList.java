package com.hedian.cp2.no232sortedsinglylist;

import com.hedian.cp2.no232singlylist.Node;
import com.hedian.cp2.no232singlylist.SinglyList;

public class SortedSinglyList<T extends Comparable<? super T>> extends SinglyList<T> {

    public SortedSinglyList() {
        super();
    }

    public SortedSinglyList(T[] values) {
        super();
        for (T value : values) {
            this.insert(value);
        }
    }

    //存 异常
    //取 父类
    //增
    @Override
    public int insert(T t) {
        int i = 0;
        Node<T> frontNode = this.head;
        Node<T> currentNode = this.head.next;
        while (currentNode != null) {
            if (currentNode.data.compareTo(t) < 0) {
                Node<T> newNode = new Node<>(currentNode, t);
                frontNode.next = newNode;
                i++;
            }
        }
        return i;
    }
    //删

    @Override
    public T remove(int index) {
        return null;
    }
}
