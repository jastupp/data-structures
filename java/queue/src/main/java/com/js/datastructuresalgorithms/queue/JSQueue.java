package com.js.datastructuresalgorithms.queue;

import java.util.LinkedList;

public class JSQueue<T> {

    //*****************
    // Class Members **
    //*****************
    private LinkedList<T> mList;

    //***************
    // Constructor **
    //***************
    public JSQueue() {}

    public void enqueue(T item) { list().addLast(item); }
    
    public T dequeue() { return list().removeFirst(); }

    public T peek() { return list().peekFirst(); }

    public int size() { return list().size(); }

    public boolean isEmpty() { return list().isEmpty(); }

    //*******************
    // Private Members **
    //*******************

    private LinkedList<T> list() { return mList == null ? mList = new LinkedList<>() : mList; }
}
