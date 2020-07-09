package com.js.datastructuresalgorithms.unionfind;

import java.util.stream.IntStream;

public class UnionFind {

    private final int mSize;
    private int[] mArray;

    public UnionFind(int size) { mSize = size; }

    public void union(int a, int b) {
        int rootA = root(a);
        int rootB = root(b);

        if(rootA != rootB) {
            array()[Math.max(rootA, rootB)] = Math.min(rootA, rootB);
        }
    }

    public int roots() {
        int count = 0;
        for(int i = 0; i < array().length; i++) {
            count += isRoot(i) ? 1 : 0;
        }
        return count;
    }

    //*******************
    // Private Members **
    //*******************

    private boolean isRoot(int index) { return array()[index] == index; }

    private int root(int index) {
        int root = index;
        while (!isRoot(root)) {
            root = array()[root];
        }
        while(index != root) {
            int next = array()[index];
            array()[index] = root;
            index = next;
        }
        return index;
    }

    private int size() { return mSize; }

    private int[] array() { return mArray == null ? mArray = createArray() : mArray; }

    private int[] createArray() {
        int[] array = new int[size()];
        IntStream.range(0, size()).forEach((index) -> array[index] = index);
        return array;
    }
}
