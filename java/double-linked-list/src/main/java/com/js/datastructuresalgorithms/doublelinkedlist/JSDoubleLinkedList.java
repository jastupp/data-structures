package com.js.datastructuresalgorithms.doublelinkedlist;

import java.util.Objects;

public class JSDoubleLinkedList<T> {

    private int mSize;
    private JSNode<T> mHead;
    private JSNode<T> mTail;

    private static class JSNode<T> {
        private T mData;
        private JSNode<T> mNext;
        private JSNode<T> mPrev;

        private JSNode(T data, JSNode<T> prev, JSNode<T> next)
        {
            mData = data;
            mPrev = prev;
            mNext = next;
        }
        public JSNode<T> prev() { return mPrev; }
        public JSNode<T> next() { return mNext; }
        public T data() { return mData; }
    }

    public void clear()
    {
        JSNode<T> current = head();
        while(current != null) {
            JSNode<T> next = current.next();
            clear(current);
            current = next;
        }
        mSize = 0;
    }

    public int size() { return mSize; }

    public boolean isEmpty() { return size() == 0; }

    public void add(T item) { addLast(item); }

    public void addFirst(T item) {
        if(isEmpty()) { setHeadTail(item); }
        else { addFront(item); }
    }

    public T peekFirst() { return head().data(); }

    public T peekLast() { return tail().data(); }

    public T removeFirst() {
        T data = head().data();
        mHead = head().next();
        removed();
        return data;
    }

    public T removeLast() {
        T data = tail().data();
        mTail = tail().prev();
        removed();
        return data;
    }

    public T remove(T value) {
        JSNode<T> current = head();
        while(current != null && !Objects.equals(current.data(), value)) {
            current = current.next();
        }
        return current == null ? null : remove(current);
    }

    public T removeAt(int index) {
        JSNode<T> current = head();
        while(index > 0 && current != null) {
            current = current.next();
        }
        return current == null ? null : remove(current);
    }

    //*******************
    // Private Members **
    //*******************

    private T remove(JSNode<T> node)
    {
        if(node == head()) {
            removeFirst();
        } else if(node == tail()) {
            removeLast();
        } else {
            node.prev().mNext = node.next();
            node.next().mPrev = node.prev();
        }
        removed();

        return node.data();
    }

    private void added() { mSize++; }

    private void removed() { mSize--; }

    private void addFront(T item) {
        head().mPrev = new JSNode(item, null, head());
        mHead = head().prev();
        added();
    }

    private void addLast(T item) {
        if(isEmpty()) { setHeadTail(item); }
        else { addToTail(item); }
    }

    private void setHeadTail(T item) {
        mHead = mTail = new JSNode(item, null, null);
        added();
    }

    private void addToTail(T item) {
        tail().mNext = new JSNode(item, tail(), null);
        mTail = tail().next();
        added();
    }

    private void clear(JSNode<T> node) {
        node.mData = null;
        node.mPrev = null;
        node.mNext = null;
    }

    private JSNode<T> head() { return mHead; }

    private JSNode<T> tail() { return mTail; }
}
