package com.js.datastructuresalgorithms.pqueue;

public abstract class TestBase<T> {

    //*****************
    // Class Members **
    //*****************
    private T mTest;

    protected abstract T createTestCase();

    protected T testCase() { return mTest == null ? mTest = createTestCase() : mTest; }
}
