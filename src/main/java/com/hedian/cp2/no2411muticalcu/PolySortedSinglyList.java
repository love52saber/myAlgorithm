package com.hedian.cp2.no2411muticalcu;

import com.hedian.cp2.no232singlylist.Node;
import com.hedian.cp2.no232sortedsinglylist.SortedSinglyList;

public class PolySortedSinglyList<T extends Comparable<T> & Addible<T>> extends SortedSinglyList<T> {

    public PolySortedSinglyList() {
    }

    public PolySortedSinglyList(T terms[]) {
        super(terms);
    }

    public PolySortedSinglyList(PolySortedSinglyList<T> polylist)    //深拷贝构造方法
    {
        super(polylist);                                   //单链表深拷贝，复制所有结点，没有复制元素对象
    }

    public void add(PolySortedSinglyList<T> polyList) {
        Node<T> frontNode = this.head;
        Node<T> pNode = this.head.next;
        Node<T> qNode = polyList.head.next;
        while (pNode != null && qNode != null) {
            if (pNode.data.compareTo(qNode.data) == 0) {
                pNode.data.add(qNode.data);
                if (pNode.data.removable()) {
                    frontNode.next = pNode.next;
                }
            } else if (pNode.data.compareTo(qNode.data) > 0) {
                frontNode.next = new Node<>(pNode, qNode.data);
            }
            frontNode = frontNode.next;
            pNode = pNode.next;
            qNode = qNode.next;
        }
    }


}
