package com.js.datastructuresalgorithms.fenwicktree;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class JSFenwickTreeTest extends TestBase<JSFenwickTree> {

    private final int[] mArray = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

    @Test
    public void sum()
    {
        check();
    }

    @Test
    public void range()
    {
        Assertions.assertEquals(sum(6) - sum(3), testCase().range(4, 6));
    }

    @Test
    public void update()
    {
        mArray[2] = 10;
        testCase().update(2, 10);
        check();
    }

    protected JSFenwickTree createTest()
    {
        return new JSFenwickTree(mArray);
    }

    //*******************
    // Private Members **
    //*******************

    private void check()
    {
        for(int i = 1; i <= mArray.length; i++) {
            Assertions.assertEquals(sum(i), testCase().sum(i));
        }
    }

    private int sum(int to) {
        int total = 0;
        for(int i = 0; i < to; i++) {
            total += mArray[i];
        }
        return total;
    }
}