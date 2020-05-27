package com.hedian.cp2.no2411polyx;

import com.hedian.cp2.no232singlylist.Node;

public class Polynomial {

    private PolySortedSinglyList<PolyTerm> terms;

    public Polynomial() {
        this.terms = new PolySortedSinglyList<>();
    }

    public Polynomial(PolySortedSinglyList<PolyTerm> terms) {
        this.terms = new PolySortedSinglyList<>();
    }

    public Polynomial(String polyStr) {
        this();
        Node<PolyTerm> frontNode = this.terms.head;
        int start = 0;
        int end = 0;
        while (start < polyStr.length() && end < polyStr.length()) {
            int i = polyStr.indexOf('+', end+1);
            if (i==-1) {
                i = polyStr.length();
            }
            int j = polyStr.indexOf('-', end+1);
            if (j==-1) {
                j = polyStr.length();
            }
            end = i < j ? i : j;
            Node<PolyTerm> newNode = new Node<>(null, new PolyTerm(polyStr.substring(start, end)));
            frontNode.next = newNode;
            frontNode = frontNode.next;
            start = end;
        }
        System.out.println(1);
    }

    public Polynomial(PolyTerm[] terms) {
        this();
        for (PolyTerm term : terms) {
            this.terms.insert(term);
        }
    }

    @Override
    public String toString() {
        Node<PolyTerm> currentNode = this.terms.head.next;
        String str = "";
        while (currentNode != null) {
            str += currentNode.data.toString();
            currentNode = currentNode.next;
        }
        return str;
    }

    public void union(Polynomial poly) {
        this.terms.add(poly.terms);
    }
}
