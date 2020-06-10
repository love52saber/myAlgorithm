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
        this.values = new char[str.length()];
        for (int i = 0; i < values.length; i++) {
            values[i] = str.charAt(i);
        }
    }

    public MyString(char[] values, int i, int n) {
        this.values = new char[n];
        if (i >= 0 && n >= 0 && i + n <= this.values.length) {
            for (int j = 0; j < n; j++) {
                this.values[j] = values[i + j];
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
        return new MyString(this.values, begin, end - begin);
    }

    public MyString substring(int begin) {
        return new MyString(this.values, begin, this.length() - begin);
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

    public int indexofByBf(MyString str) {
        for (int i = 0; i < this.values.length - str.length(); i++) {
            for (int j = 0; j < str.length(); j++) {
                if (this.values[i + j] == str.charAt(j)) {
                    if (j == str.length() - 1) {
                        return i;
                    }
                }
            }
        }
        return -1;
    }

    public int indexofByBf2(MyString pattern) {
        int targLen = this.length();
        int patternLen = pattern.length();
        int tIndex = 0;
        int pIndex = 0;
        while (tIndex < targLen && pIndex < patternLen) {
            if (this.charAt(tIndex) == pattern.charAt(pIndex)) {
                if (pIndex == patternLen - 1) {
                    return tIndex - pIndex;
                }
                tIndex++;
                pIndex++;
            } else {
                tIndex = tIndex - pIndex + 1;
                pIndex = 0;
            }
        }
        return -1;
    }

    public int indexofByKMT(MyString pattern) {
        int[] next = this.getNextArr(pattern);
        int patternLen = pattern.length();
        int pIndex = 0;
        for (int tIndex = 0; tIndex < this.length(); tIndex++) {
            while (pIndex > 0 && this.charAt(tIndex) != pattern.charAt(pIndex)) {
                pIndex = next[pIndex];
            }
            if (this.charAt(tIndex) == pattern.charAt(pIndex)) {
                pIndex++;
            }
            if (pIndex == patternLen) {
                return tIndex - patternLen + 1;
            }
        }
        return -1;
    }

    public int indexofByKMT2(MyString pattern) {
        int[] next = this.getNextArr(pattern);
        int patternLen = pattern.length();
        int targLen = this.length();
        int pIndex = 0;
        int tIndex = 0;
        while (tIndex < targLen) {
            if (this.charAt(tIndex) == pattern.charAt(pIndex)) {
                if (pIndex == patternLen - 1) {
                    return tIndex - pIndex;
                }
                pIndex++;
                tIndex++;
            } else if (pIndex == 0) {
                tIndex++;
            } else {
                pIndex = next[pIndex];
            }
        }
        return -1;
    }

    /**
     * @param pattern
     * @return
     */
    private int[] getNextArr(MyString pattern) {
        int patternLen = pattern.length();
        int[] next = new int[patternLen];
        //最长可匹配子串下一个字符
        int j = 0;
        for (int i = 2; i < patternLen; i++) {
            while (j > 0 && pattern.charAt(j) != pattern.charAt(i - 1)) {
                j = next[j];
            }
            if (pattern.charAt(j) == pattern.charAt(i - 1)) {
                j++;
            }
            next[i] = j;
        }
        return next;
    }

    private int[] getNextArr2(MyString pattern) {
        int patternLen = pattern.length();
        int[] next = new int[patternLen];

        return next;
    }


}
