package com.zhoulychn.common.utils;

import java.util.HashMap;

/**
 * Created by lewis on 2016/11/18.
 */
public class SimpleStack<Item> {

    private Item[] a;

    private int n;

    public SimpleStack(int capacity) {
        a = (Item[]) new Object[capacity];
    }

    public SimpleStack() {
        this(10);
    }


    public int size() {
        return n;
    }

    public void push(Item item) {
        if (n >= a.length) {
            this.resize(a.length << 1);
        }
        a[n++] = item;
    }


    public Item pop() {
        Item item = a[--n];
        a[n] = null;
        if (n == a.length >>> 2) {
            this.resize(a.length >>> 1);
        }
        return item;
    }

    public void resize(int capacity) {
        Item[] temp = (Item[]) new Object[capacity];
        for (int i = 0; i < n; i++) {
            temp[i] = a[i];
        }
        a = temp;
    }


}
