package com.hedian.cp2.no2411muticalcu;

import java.util.Objects;

public class PolyTerm implements Comparable<PolyTerm>,Addible<PolyTerm> {

    protected int coef;//coefficient系数
    protected int exp;//exponent指数

    public PolyTerm() {
    }

    public PolyTerm(int coef, int exp) {
        this.coef = coef;
        this.exp = exp;
    }

    public PolyTerm(PolyTerm term) {
        this(term.coef, term.exp);
    }

    //以“系数x^指数”的省略形式构造一元多项式的一项。
    //省略形式说明：当系数为1或-1且指数>0时，省略1，-1只写负号“-”，如x^2、-x^3；
    //当指数为0时，省略x^0，只写系数；当指数为1时，省略^1，只写x。
    public PolyTerm(String termStr) {
        if (termStr.charAt(0) == '+') {
            termStr = termStr.substring(1);
        }
        int xPosition = termStr.indexOf("x");
        if (xPosition == -1) {
            //常系数
            this.coef = Integer.parseInt(termStr);
            this.exp = 0;
        } else {
            String coefStr = termStr.substring(0, xPosition);
            this.coef = Integer.parseInt(coefStr);
            int expSpliterCharPos = termStr.indexOf("^");
            if (expSpliterCharPos == -1) {
                this.exp = 1;
            } else {
                String expStr = termStr.substring(expSpliterCharPos+1, termStr.length());
                this.exp = Integer.parseInt(expStr);
            }
        }
    }

    @Override
    public String toString() {
        String str = (this.coef > 0 ? "+" : "") + this.coef;
        if (this.exp == 0) {
            return str;
        }
        if (this.exp == 1) {
            return str += "x";
        }
        if (this.exp > 1) {
            str += ("x^" + this.exp);
        }
        return str;
    }

    @Override
    public void add(PolyTerm t) {
        try {
            if (this.compareTo(t) == 0) {
                this.coef += t.coef;
            } else {
                throw new IllegalAccessException("两项指数不同");
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    @Override
    public int compareTo(PolyTerm term) {
        if (this.exp==term.exp) {
            return 0;
        }
        return this.exp < term.exp ? -1 : 1;
    }

    @Override
    public boolean removable() {
        return this.coef==0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PolyTerm polyTerm = (PolyTerm) o;
        return coef == polyTerm.coef &&
                exp == polyTerm.exp;
    }

    @Override
    public int hashCode() {
        return Objects.hash(coef, exp);
    }

    public static void main(String[] args) {
        PolyTerm polyTerm = new PolyTerm("-2x^2");
        System.out.println(polyTerm);
    }
}
