package com.hedian.cp6tree.cp626BinaryTree;

import com.hedian.cp2.no01seqlist.SeqList;
import com.hedian.cp4stack.cp412seqstack.MyStack;
import com.hedian.cp4stack.cp412seqstack.SeqStack;

public class BinaryTree<T> implements MyBinaryTree<T> {

    protected BinaryNode<T> root;

    public BinaryTree() {
    }

    /**
     * 前序+中序构造
     * @param prelist
     * @param inlist
     */
    public BinaryTree(SeqList<T> prelist, SeqList<T> inlist) {
        this.root = createTreeByPreAndIn(prelist, inlist, 0, 0, prelist.size());
    }

    private BinaryNode<T> createTreeByPreAndIn(SeqList<T> prelist, SeqList<T> inlist, int preStart, int inStart, int n) {
        BinaryNode<T> root = null;
        if (n == 0) {
            return root;
        } else {
            int i = 0;
            T rootNodeData = prelist.get(preStart);
            BinaryNode<T> rootNode = new BinaryNode<>(rootNodeData);
            while (i<n && !rootNodeData.equals(inlist.get(inStart + i))) {
                i++;
            }
            rootNode.left = createTreeByPreAndIn(prelist, inlist, preStart + 1, inStart, i);
            rootNode.right = createTreeByPreAndIn(prelist, inlist, preStart + i + 1, inStart + i + 1, n - 1 - i);
            root = rootNode;
        }
        return root;
    }

    public static void main(String[] args) {
        SeqList<String> prelist = new SeqList<>(new String[]{"A","B","D","E","C","F"});
        SeqList<String> inlist = new SeqList<>(new String[]{"D","B","E","A","F","C"});
        BinaryTree<String> tree = new BinaryTree<String>(prelist, inlist);
        System.out.println("111");
        System.out.println(tree.count());
        BinaryNode<String> e = tree.searchNode("E");
        System.out.println("111");
    }

    /**
     * 带空的先序遍历
     * @param prelist
     */
    public BinaryTree(SeqList<T> prelist) {
        this.root = this.createTreeByInList(prelist, 0);
    }

    private BinaryNode<T> createTreeByInList(SeqList<T> prelist, int i) {
        BinaryNode<T> binaryNode = null;
        T t1 = prelist.get(i);
        i++;
        if (t1 != null) {
            binaryNode = new BinaryNode<>(t1);
            binaryNode.left = createTreeByInList(prelist, i);
            binaryNode.right = createTreeByInList(prelist, i);
        }
        return binaryNode;
    }


    @Override
    public boolean isEmpty() {
        return root == null;
    }

    @Override
    public void preOrder() {
        preOrder(root);
    }

    private void preOrder(BinaryNode<T> p) {
        while (p != null) {
            System.out.println(p.data);
            preOrder(p.left);
            preOrder(p.right);
        }
    }

    @Override
    public void inOrder() {

    }

    @Override
    public void postOrder() {

    }

    @Override
    public void levelOrder() {
        MyStack<BinaryNode> stack = new SeqStack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            BinaryNode pop = stack.pop();
            System.out.println(pop);
            stack.push(pop.left);
            stack.push(pop.right);
        }
    }


    @Override
    public int count() {
        return this.count(root);
    }

    private int count(BinaryNode<T> primaryNode) {
        if (primaryNode == null) {
            return 0;
        } else {
            return count(primaryNode.left) + count(primaryNode.right) + 1;
        }
    }

    @Override
    public int height() {
        return 0;
    }

    @Override
    public T search(T key) {
        return null;
    }

    @Override
    public BinaryNode<T> searchNode(T key) {
        return this.searchNode(root, key);
    }

    private BinaryNode<T> searchNode(BinaryNode<T> primaryNode, T key) {
        if (primaryNode == null) {
            return null;
        }
        if (primaryNode.data == key) {
            return primaryNode;
        }
        BinaryNode<T> p = searchNode(primaryNode.left, key);
        BinaryNode<T> q = searchNode(primaryNode.right, key);
        return p != null ? p : (q != null ? q : null);
    }

    @Override
    public BinaryNode<T> getParent(BinaryNode<T> node) {
        return null;
    }

    @Override
    public void insertRoot(T x) {

    }

    @Override
    public BinaryNode<T> insertChild(BinaryNode<T> p, T x, boolean leftChild) {
        return null;
    }

    @Override
    public void removeChild(BinaryNode<T> p, boolean leftChild) {

    }

    @Override
    public void removeAll() {

    }

    @Override
    public String toString() {
        return super.toString();
    }
}
