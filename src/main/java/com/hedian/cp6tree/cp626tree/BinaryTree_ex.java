package com.hedian.cp6tree.cp626tree;

import org.junit.Test;

public class BinaryTree_ex {

    @Test
    public void test01() {
        String[] prelist2 = {"A","B","D",null,"G",null,null,null,"C","E",null,null,"F","H"};
        BinaryTree<String> bitree2 = new BinaryTree<String>(prelist2);
        bitree2.preOrder();
        bitree2.inOrder();
        bitree2.postOrder();
    }
}
