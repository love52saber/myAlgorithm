package com.hedian.cp5MutiArray.cp522ArrayCompress;

import org.junit.Test;

public class SeqCompressMatrix_ex {

    @Test
    public void test01() {
        Triple[] elemsa={new Triple(0,2,11),new Triple(0,4,17),new Triple(1,1,20),
                new Triple(3,0,19),new Triple(3,5,28),new Triple(4,4,50)};
        SeqCompressMatrix ma = new SeqCompressMatrix(5, 6, elemsa);
        System.out.println(ma);
        Triple[] elemsb={new Triple(0,2,11),new Triple(0,4,17),new Triple(1,1,20),
                new Triple(3,0,19),new Triple(3,5,28),new Triple(4,4,50)};
        SeqCompressMatrix mb = new SeqCompressMatrix(5,6,elemsb);
        System.out.println(mb);
        ma.add(mb);
        System.out.println(ma);
    }

}
