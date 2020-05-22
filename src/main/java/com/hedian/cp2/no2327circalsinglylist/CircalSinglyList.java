package com.hedian.cp2.no2327circalsinglylist;

import com.hedian.cp2.no232singlylist.Node;
import com.hedian.cp2.no232singlylist.SinglyList;

public class CircalSinglyList<T> extends SinglyList<T> {

    private Node<T> rear;//尾结点

    public CircalSinglyList() {
        super();
        rear = head.next;
    }

    public CircalSinglyList(T[] values) {
        super();
        rear = head;
        for (int i = 0; i < values.length; i++) {
            rear.next = new Node<>(head, values[i]);
            rear = rear.next;
            size++;
        }
    }

    //存
    //取
    //遍历
    //增
    @Override
    public int insert(int index, T t) {
        if (index > this.size || index < 0) {
            throw new IndexOutOfBoundsException();
        }
        Node<T> frontNode = this.head;

        for (int i = 0; i < index; i++) {
            frontNode = frontNode.next;
        }
        frontNode.next = new Node<>(frontNode.next, t);
        return -1;
    }
}
