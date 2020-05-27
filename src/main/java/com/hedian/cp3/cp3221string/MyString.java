package com.hedian.cp3.cp3221string;

import java.io.Serializable;
import java.util.Arrays;

public final class MyString implements Comparable<MyString>, Serializable {

    protected char[] values;

    public MyString() {
        this.values = new char[0];
    }

    public MyString(char[] values) {
        this(values, 0, values.length);
    }

    public MyString(String str) {
        char[] values = new char[str.length()];
        for (int i = 0; i < values.length; i++) {
            values[i] = str.charAt(i);
        }
    }

    public MyString(char[] values,int i, int n) {
        this.values = new char[n];
        if (i >= 0 && n >= 0 && i + n <= this.values.length) {
            for (int j = 0; j < n; j++) {
                this.values[i] = values[i + j];
            }
        } else {
            throw new StringIndexOutOfBoundsException();
        }
    }

    public MyString(MyString str) {
        this(str.values);
    }

    public int length() {
        return this.values.length;
    }

    @Override
    public String toString() {
        return new String(this.values);
    }

    public char charAt(int i) {
        if (i < 0 || i > this.values.length) {
            throw new StringIndexOutOfBoundsException();
        }
        return this.values[i];
    }

    public MyString substring(int begin, int end) {
        return new MyString(this.values,begin,end-begin);
    }

    public MyString substring(int begin) {
        return new MyString(this.values,begin,this.length()-begin);
    }

    public MyString concat(MyString str) {
        char[] newChars = new char[this.length() + str.length()];
        for (int i = 0; i < this.length(); i++) {
            newChars[i] = this.values[i];
        }
        for (int j = 0; j < str.length(); j++) {
            newChars[this.length() + j] = str.values[j];
        }
        return new MyString(newChars);
    }

    @Override
    public int compareTo(MyString str) {
        for (int i = 0; i < this.length(); i++) {
            if (this.values[i] != str.values[i]) {
                return this.values[i] - str.values[i];
            }
        }
        return this.values.length - str.values.length;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        MyString myString = (MyString) o;
        return Arrays.equals(values, myString.values);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(values);
    }

}
