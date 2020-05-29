package com.hedian.cp3.cp3223stringbuffer;

public class MyStringBuffer {

    private char[] values;                                  //字符数组，私有成员变量
    private int len;                                       //串长度

    public MyStringBuffer(int size)                        //构造指定容量的空串
    {
        char[] chars = new char[size * 2];
        this.values = chars;
        this.len = 0;
    }

    public MyStringBuffer()                                //以默认容量构造空串
    {
        this(64);
    }

    public MyStringBuffer(String str)                      //以字符串常量构造串对象
    {
        this(str.length());
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            this.values[i] = chars[i];
        }
        this.len = str.length();
    }

    public int length()                                    //返回字符串长度
    {
        return this.len;
    }

    public void setLength(int len)                         //设置当前字符串长度为len
    {
        this.len = len;
    }

    public synchronized char charAt(int i)                 //返回第i（i≥0）个字符
    {
        if (i < 0 || i > this.len) {
            throw new StringIndexOutOfBoundsException();
        }
        return this.values[i];
    }

    public void setCharAt(int i, char ch)                  //设置第i个字符为ch
    {
        if (i < 0 || i > this.len) {
            throw new StringIndexOutOfBoundsException();
        }
        this.values[i] = ch;
    }

    @Override
    public synchronized String toString() {
        return new String(this.values);
    }

    //2.  插入串
    public synchronized MyStringBuffer insert(int i, MyStringBuffer str)  //在第i个字符处插入str串
    {
        if (i < 0 || i > this.len) {
            throw new StringIndexOutOfBoundsException();
        }
        int toAddStrLength = str.length();
        char[] temp = this.values;
        if (this.len + toAddStrLength > this.values.length) {
            //扩容
            this.values = new char[(this.len + toAddStrLength) * 2];
            for (int j = 0; j < temp.length; j++) {
                this.values[j] = temp[j];
            }
        }
        for (int j = this.len; j > i; j--) {
            this.values[j] = this.values[j + toAddStrLength];
        }
        for (int j = 0; j < toAddStrLength; j++) {
            this.values[i + j] = str.values[j];
        }
        this.len +=str.len;
        return this;
    }

    public synchronized MyStringBuffer insert(int i, String str)     //在第i个字符处插入str串
    {
        if (i < 0 || i > this.len) {
            throw new StringIndexOutOfBoundsException();
        }
        int toAddStrLength = str.length();
        char[] temp = this.values;
        if (this.len + toAddStrLength > this.values.length) {
            //扩容
            this.values = new char[(this.len + toAddStrLength) * 2];
            for (int j = 0; j < temp.length; j++) {
                this.values[j] = temp[j];
            }
        }
        for (int j = this.len; j > i; j--) {
            this.values[j] = this.values[j + toAddStrLength];
        }
        for (int j = 0; j < toAddStrLength; j++) {
            this.values[i + j] = str.charAt(j);
        }
        this.len +=str.length();
        return this;
    }

    public synchronized MyStringBuffer insert(int i, boolean b)      //在i处插入变量值转换成的串
    {
        return this.insert(i, b ? "true" : "false");
    }

    public synchronized MyStringBuffer append(String str)            //添加指定串
    {
        return this.insert(this.len, (str == null) ? "null" : str);
    }

    //3.  删除子串
    public synchronized MyStringBuffer delete(int begin, int end)  //删除从begin到end-1的子串
    {
        if (begin >= 0 && end >= begin && end < this.length()) {
            int fallback = begin - end;
            for (int i = end; i < this.length(); i++) {
                this.values[i - fallback] = this.values[i];
            }
            this.len -= fallback;
            return this;
        } else {
            throw new StringIndexOutOfBoundsException();
        }
    }

    //习题3
    public MyStringBuffer reverse() {
        int start = 0;
        int end = this.len;
        while (start < end) {
            char temp = 't';
            temp = this.values[start];
            this.values[start] = this.values[end];
            this.values[end] = temp;
            start++;
            end--;
        }
        return this;
    }
}
