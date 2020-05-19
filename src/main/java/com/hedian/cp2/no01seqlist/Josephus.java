package com.hedian.cp2.no01seqlist;

public class Josephus {

    private SeqList<Integer> list;

    private int number;

    private int start;

    private int distance;

    public Josephus(int number, int start, int distance) {
        this.number = number;
        this.start = start;
        this.distance = distance;
        this.list = new SeqList<>(number);
        for (int i = 0; i < number; i++) {
            this.list.insert(i);
        }
    }

    public void calcuLastOne() {
        int killIndex = start;
        System.out.println(this.list);
        while (this.list.size() > 1) {
            killIndex = (killIndex + distance - 1) % this.list.size();
            System.out.println(this.list);
            this.list.remove(killIndex);
        }
        System.out.println(this.list);
    }

}
