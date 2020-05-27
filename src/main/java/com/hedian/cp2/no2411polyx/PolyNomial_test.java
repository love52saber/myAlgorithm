package com.hedian.cp2.no2411polyx;

import org.junit.Test;

public class PolyNomial_test {

    @Test
    public void test01() {
        Polynomial poly1 = new Polynomial("+1+2x");
        System.out.println(poly1);
    }

    @Test
    public void test02() {
        PolyTerm[] terms = new PolyTerm[]{
                new PolyTerm("-1"),
                new PolyTerm("2x^2"),
                new PolyTerm("2x")
        };
        Polynomial poly1 = new Polynomial(terms);
        System.out.println(poly1);
    }

    @Test
    public void test03() {
        PolyTerm[] terms = new PolyTerm[]{
                new PolyTerm("-1"),
                new PolyTerm("2x^2"),
                new PolyTerm("2x")
        };
        Polynomial poly1 = new Polynomial(terms);
        Polynomial poly2 = new Polynomial("+1+2x");
        poly1.union(poly2);
        System.out.println(poly1);
    }
}
