package com.hedian.cp2.no02sortedseqlist;

import com.hedian.cp2.no01seqlist.SeqList;

public class SortedSeqList<T extends Comparable<? super T>> extends SeqList<T> {
    public SortedSeqList(int elementNum) {
        super(elementNum);
    }

    public SortedSeqList() {
        super();
    }

}
