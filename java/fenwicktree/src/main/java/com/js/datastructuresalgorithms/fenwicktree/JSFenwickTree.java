package com.js.datastructuresalgorithms.fenwicktree;

import java.util.Arrays;

public class JSFenwickTree {

    //*****************
    // Class Members **
    //*****************
    private final int[] mOrginal;
    private int[] mFenwick;

    //***************
    // Constructor **
    //***************
    public JSFenwickTree(int[] orginal) { mOrginal = orginal; }

    public int sum(int to) { return sumArray(to); }

    public int range(int begin, int end) { return sumArray(end) - sumArray(begin - 1); }

    public void update(int to, int value) {
        int diff = value - fenwick()[to];
        while(to < fenwick().length) {
            fenwick()[to - 1] += diff;
            to += +lsb(to);
        }
    }

    //*******************
    // Private Members **
    //*******************

    private int sumArray(int index)
    {
        int total = 0;
        while (index > 0) {
            total += fenwick()[index - 1];
            index -= lsb(index);
        }
        return total;
    }

    private int[] original()
    {
        return mOrginal;
    }

    private int[] fenwick()
    {
        return mFenwick == null ? mFenwick = createFenwick() : mFenwick;
    }

    private int[] createFenwick()
    {
        mFenwick = Arrays.copyOf(original(), original().length);
        for (int i = 0; i < mFenwick.length; i++) {
            int index = i + lsb(i + 1);
            if(index < mFenwick.length) {
                mFenwick[index] += mFenwick[i];
            }
        }

        return mFenwick;
    }

    private int lsb(int num) { return num & (-num); }
}
