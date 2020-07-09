package com.js.datastructuresalgorithms.stack;

import java.util.LinkedList;

public class JSStack<T> {

    //*****************
    // Class Members **
    //*****************
    private LinkedList<T> mList;

    //***************
    // Constructor **
    //***************
    public JSStack() {};

    public int size() { return list().size(); }

    public boolean isEmpty() { return size() == 0; }

    public void push(T item) { list().addFirst(item); }

    public T pop() { return list().getFirst(); }

    public T peek() { return list().peekFirst(); }

    //*******************
    // Private Members **
    //*******************

    private LinkedList<T> list() { return mList == null ? mList = new LinkedList<>() : mList; }
}
