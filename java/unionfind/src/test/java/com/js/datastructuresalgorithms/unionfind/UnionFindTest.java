package com.js.datastructuresalgorithms.unionfind;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UnionFindTest extends TestBase<UnionFind> {

    private final int mSize = 10;

    @Test
    void union()
    {
        Assertions.assertEquals(mSize, testCase().roots());
        testCase().union(9, 8);
        Assertions.assertEquals(mSize - 1, testCase().roots());
        testCase().union(6, 5);
        Assertions.assertEquals(mSize - 2, testCase().roots());
        testCase().union(1, 2);
        testCase().union(1, 2);
        Assertions.assertEquals(mSize - 3, testCase().roots());
        testCase().union(3, 4);
        Assertions.assertEquals(mSize - 4, testCase().roots());
    }

    protected UnionFind createTestCase() { return new UnionFind(mSize); }
}