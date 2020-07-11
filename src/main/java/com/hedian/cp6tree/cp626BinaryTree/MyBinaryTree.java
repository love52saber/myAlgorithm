package com.hedian.cp6tree.cp626BinaryTree;

public interface MyBinaryTree<T> {

    boolean isEmpty();                                     //判断二叉树是否空
    void preOrder();                                       //先根次序遍历二叉树
    void inOrder();                                        //中根次序遍历二叉树
    void postOrder();                                      //后根次序遍历二叉树
    void levelOrder();                                     //按层次遍历二叉树
    int count();                                           //返回二叉树的结点个数
    int height();                                          //返回二叉树的高度
    T search(T key);                                       //查找并返回首次出现的关键字为key元素
    //    BinaryNode<T> searchNode(T key);                       //查找并返回首次出现的关键字为key元素结点
    BinaryNode<T> getParent(BinaryNode<T> node);           //返回node的父母结点
    void insertRoot(T x);                                  //插入元素x作为根结点
    BinaryNode<T> insertChild(BinaryNode<T> p, T x, boolean leftChild); //插入x元素作为p结点的左/右孩子
    void removeChild(BinaryNode<T> p, boolean leftChild);  //删除p结点的左或右子树
    void removeAll();

}
