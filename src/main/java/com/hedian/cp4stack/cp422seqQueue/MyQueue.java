package com.hedian.cp4stack.cp422seqQueue;//4.2.1   ���г�����������

public interface MyQueue<T>                       //���нӿڣ��������г�����������
{
    boolean isEmpty();                           //�ж϶����Ƿ��
    void enqueue(T x);                           //Ԫ��x���
    T dequeue();                                 //���ӣ����ض�ͷԪ��
}
//����    T get();                           //ȡ��ͷԪ��
