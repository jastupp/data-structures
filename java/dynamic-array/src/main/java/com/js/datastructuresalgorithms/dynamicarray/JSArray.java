package com.js.datastructuresalgorithms.dynamicarray;

import java.util.Arrays;
import java.util.Iterator;
import java.util.stream.IntStream;

@SuppressWarnings("unchecked")
public class JSArray<T> implements Iterable<T> {

    //*****************
    // Class Members **
    //*****************
    private T[] mArray;
    private int mLen;
    private int mCapacity;

    //***************
    // Constructor **
    //***************
    public JSArray() { this(16); }

    //***************
    // Constructor **
    //***************
    public JSArray(int capacity) {
        this.mCapacity = capacity;
        mArray = (T[])new Object[capacity()];
    }

    public int size() { return mLen; }

    public boolean isEmpty() { return size() == 0; }

    public T get(int index) { return array()[index]; }

    public void set(int index, T value) { array()[index] = value; }

    public void clear() {
        mArray = (T[])Arrays.stream(array()).map(next ->  null).toArray();
    }

    public void add(T value)
    {
        if(length() + 1 > capacity()) {
            mCapacity = capacity() == 0 ? 1 : capacity() * 2;
            mArray = Arrays.copyOf(array(), capacity());
        }
        array()[mLen++] = value;
    }

    public T removeAt(int index) {
        T item = array()[index];
        mArray = (T[])IntStream.range(0, length()).
                    filter(i -> i != index).
                    mapToObj(next -> array()[next]).toArray();
        mLen--;

        return item;
    }

    public boolean remove(T item) {

        T[] removedArray = (T[])Arrays.stream(array()).
                filter(next -> !(next != null && next.equals(item)) ).
                toArray();

        boolean removed = array().length != removedArray.length;
        mArray = removedArray;
        mLen = removed ? length() - 1 : length();
        return removed;
    }

    public int indexOf(T item)
    {
        int[] index = IntStream.range(0, length()).
                filter(next -> array()[next].equals(item)).
                toArray();
        return index.length == 0 ? -1 : index[0];
    }

    public boolean contains(T item)
    {
        return indexOf(item) != -1;
    }

    @Override
    public Iterator<T> iterator()
    {
        return new Iterator<> () {
            private int mIndex = 0;
            public boolean hasNext() { return mIndex < length(); }
            public T next() { return array()[mIndex++]; }
        };
    }

    @Override
    public String toString()
    {
        StringBuilder builder = new StringBuilder("[");

        for(int i = 0; i < length(); i++) {
            builder.append(", ").append(array()[i]);
        }

        return builder.append("]").toString().replace("[, ", "[");
    }

    //*******************
    // Private Members **
    //*******************

    private int capacity() { return mCapacity; }

    private int length() { return mLen; }

    private T[] array() { return mArray; }

}
