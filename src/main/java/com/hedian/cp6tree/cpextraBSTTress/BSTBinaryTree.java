package com.hedian.cp6tree.cpextraBSTTress;

import com.hedian.cp2.no01seqlist.SeqList;
import com.hedian.cp4stack.cp412seqstack.MyStack;
import com.hedian.cp4stack.cp412seqstack.SeqStack;
import com.hedian.cp6tree.cp626BinaryTree.BinaryNode;
import com.hedian.cp6tree.cp626BinaryTree.MyBinaryTree;

public class BSTBinaryTree<T extends Comparable<T>> implements MyBinaryTree<T> {

    protected BSTTreeNode<T> root;

    public BSTBinaryTree() {
    }

    /**
     * 前序+中序构造
     * @param prelist
     * @param inlist
     */
    public BSTBinaryTree(SeqList<T> prelist, SeqList<T> inlist) {
        this.root = createTreeByPreAndIn(prelist, inlist, 0, 0, prelist.size());
    }

    private BSTTreeNode<T> createTreeByPreAndIn(SeqList<T> prelist, SeqList<T> inlist, int preStart, int inStart, int n) {
        BSTTreeNode<T> root = null;
        if (n == 0) {
            return root;
        } else {
            int i = 0;
            T rootNodeData = prelist.get(preStart);
            BSTTreeNode<T> rootNode = new BSTTreeNode<>(rootNodeData);
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
        SeqList<Integer> prelist = new SeqList<>(new Integer[]{ 5, 3, 1, 4, 7, 6 });
        SeqList<Integer> inlist = new SeqList<>(new Integer[]{1, 3, 4, 5, 6, 7});
        BSTBinaryTree<Integer> tree = new BSTBinaryTree<Integer>(prelist, inlist);
        System.out.println("111");
        System.out.println(tree.count());
        BSTTreeNode<Integer> e = tree.searchNode(5);
        System.out.println("111");
    }

    /**
     * 带空的先序遍历
     * @param prelist
     */
    public BSTBinaryTree(SeqList<T> prelist) {
        this.root = this.createTreeByInList(prelist, 0);
    }

    private BSTTreeNode<T> createTreeByInList(SeqList<T> prelist, int i) {
        BSTTreeNode<T> binaryNode = null;
        T t1 = prelist.get(i);
        i++;
        if (t1 != null) {
            binaryNode = new BSTTreeNode<>(t1);
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

    private void preOrder(BSTTreeNode<T> p) {
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
        MyStack<BSTTreeNode> stack = new SeqStack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            BSTTreeNode pop = stack.pop();
            System.out.println(pop);
            stack.push(pop.left);
            stack.push(pop.right);
        }
    }


    @Override
    public int count() {
        return this.count(root);
    }

    private int count(BSTTreeNode<T> primaryNode) {
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
    public BSTTreeNode<T> searchNode(T key) {
        return this.searchNode(root, key);
    }

    @Override
    public BinaryNode<T> getParent(BinaryNode<T> node) {
        return null;
    }

    private BSTTreeNode<T> searchNode(BSTTreeNode<T> primaryNode, T key) {
        if (primaryNode == null) {
            return null;
        }
        if (primaryNode.data == key) {
            return primaryNode;
        }
        BSTTreeNode<T> p = searchNode(primaryNode.left, key);
        BSTTreeNode<T> q = searchNode(primaryNode.right, key);
        return p != null ? p : (q != null ? q : null);
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
