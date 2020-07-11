package com.hedian.cp6tree.cp626BinaryTree;

import com.hedian.cp4stack.cp413singlystack.SinglyStack;
import com.hedian.cp4stack.cp422seqQueue.SeqQueue;

public class BinaryTree<T> implements MyBinaryTree<T> {

    public BinaryNode<T> root;

    public BinaryTree() {
        this.root = null;
    }

    /**
     * 以标明空子树的先根序列构造二叉树
     * @param prelist
     */
    public BinaryTree(T[] prelist) {
        this.root = this.createTree(prelist);
    }

    private int i = 0;
    private BinaryNode createTree(T[] prelist) {
        BinaryNode<T> node  = null;
        //边界条件
        if (i < prelist.length) {
            T element = prelist[i];
            i++;
            if (element != null) {
                node = new BinaryNode<T>(element);
                node.left = this.createTree(prelist);
                node.right = this.createTree(prelist);
            }
        }
        return node;
    }

    /**
     * 以先根序列+中序遍历构造二叉树
     * @param prelist
     */
    public BinaryTree(T[] prelist,T[] inlist) {
        this.root = this.createTree(prelist,inlist,0,inlist.length-1,0);
    }

    private BinaryNode<T> createTree(T[] prelist, T[] inlist) {

        return null;
    }

    private BinaryNode<T> createTree(T[] prelist, T[] inlist, int inStart, int inEnd, int preStart) {
        T elem = prelist[preStart];
        BinaryNode<T> node = new BinaryNode<>(elem);
        int i = 0;
        return null;
    }

    private BinaryNode<T> create(T[] prelist, T[] inlist, int preStart, int inStart, int n)
    {
        if (n<=0)
            return null;
        T elem=prelist[preStart];                          //根结点值
        BinaryNode<T> node = new BinaryNode<>(elem);
        int i = 0;
        while (i < n && elem.equals(inlist[inStart + i])) {
            i++;
        }
        node.left = create(prelist, inlist, preStart + 1, inStart, i);
        node.right = create(prelist, inlist, preStart + i + 1, inStart + i + 1, n - 1 - i);
        return node;
    }

    @Override
    public boolean isEmpty() {
        return root == null;
    }

    @Override
    public void preOrder() {
        System.out.println("前序遍历：\n");
        preOrder(this.root);
    }

    private void preOrder(BinaryNode<T> p) {
        if (p != null) {
            System.out.println(p.data.toString()+ " ");
            preOrder(p.left);
            preOrder(p.right);
        }
    }

    @Override
    public void inOrder() {
        System.out.println("中序遍历：\n");
        inOrder(this.root);
    }

    private void inOrder(BinaryNode<T> p) {
        if (p != null) {
            inOrder(p.left);
            System.out.println(p.data.toString() + " ");
            inOrder(p.right);
        }
    }

    @Override
    public void postOrder() {
        System.out.println("后序遍历：\n");
        postOrder(this.root);
    }

    private void postOrder(BinaryNode<T> p) {
        if (p != null) {
            postOrder(p.left);
            postOrder(p.right);
            System.out.println(p.data.toString() + " ");
        }
    }

    @Override
    //层次遍历
    public void levelOrder() {
        this.levelOrder(this.root);
    }

    private void levelOrder(BinaryNode<T> p) {
        SeqQueue<BinaryNode<T>> queue = new SeqQueue<>();
        BinaryNode<T> node = this.root;
        queue.enqueue(root);
        while (node!=null) {
            node = queue.dequeue();
            System.out.println(node.data + " \n");
            if (node.left != null) {
                queue.enqueue(p.left);
            }
            if (p.right != null) {
                queue.enqueue(p.right);
            }
            node = queue.dequeue();
        }
    }

    //7. 二叉树遍历的非递归算法
    public void preOrderTraverse(){
        BinaryNode<T> node = root;
        SinglyStack<BinaryNode<T>> stack = new SinglyStack<>();
        while (!stack.isEmpty() || node!=null) {
            if (node == null) {
                node = stack.pop();
                node = node.right;
            } else {
                System.out.println(node.data + " \n");
                stack.push(node);
                node = node.left;
            }
        }
    }

    @Override
    public int count() {
        return this.count(this.root);
    }

    private int count(BinaryNode<T> node) {
        if (node == null) {
            return 0;
        }
        return count(node.left) + count(node.right) + 1;
    }

    @Override
    public int height() {
        return this.height(this.root);
    }

    private int height(BinaryNode<T> node) {
        if (node != null) {
            return 0;
        }
        return (height(node.left) >= height(node.right) ? height(node.left) : height(node.right)) + 1;
    }

    @Override
    public T search(T key) {
        return this.searchNode(root, key).data;
    }

    private BinaryNode<T> searchNode(BinaryNode<T> node, T key) {
        if (node == null || key == null) {
            return null;
        }
        if (key.equals(node.data)) {
            return node;
        }
        BinaryNode<T> find = searchNode(node.left, key);
        if (find == null) {
            return searchNode(node.right, key);
        }
        return find;
    }

    @Override
    public BinaryNode<T> getParent(BinaryNode<T> node) {
        return this.getParent(root, node);
    }

    private BinaryNode<T> getParent(BinaryNode<T> p, BinaryNode<T> node) {
        if (p == null) {
            return null;
        }
        if (p.left == node || p.right == node) {
            return p;
        }
        BinaryNode<T> find = getParent(p.left, node);
        if (find == null) {
            find = getParent(p.right, node);
        }
        return find;
    }

    @Override
    //根插入
    public void insertRoot(T x) {
        this.root = new BinaryNode<T>(x, this.root, null);
    }

    @Override
    //作为p的左孩子
    public BinaryNode<T> insertChild(BinaryNode<T> p, T x, boolean leftChild) {
        if (x == null) {
            return null;
        }
        if (leftChild) {
            p.left = new BinaryNode<T>(x, p.left, null);
            return p.left;
        }
        p.right = new BinaryNode<T>(x, null, p.right);
        return null;
    }

    @Override
    public void removeChild(BinaryNode<T> p, boolean leftChild) {
        if (leftChild) {
            p.left = null;
        } else {
            p.right = null;
        }
    }

    @Override
    public void removeAll() {
        root = null;
    }

    @Override
    public String toString()                     //返回先根次序遍历二叉树所有结点的描述字符串
    {
        return toString(root);
    }
    private String toString(BinaryNode<T> p)     //返回先根次序遍历以p为根的子树描述字符串，递归算法
    {
        if (p==null)
            return "";
        return p.data.toString()+" " + toString(p.left) + toString(p.right);//递归调用
    }
}
