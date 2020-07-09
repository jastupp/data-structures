package com.js.datastructuresalgorithms.queue;

import org.junit.jupiter.api.Assertions;

public abstract class TestBase<T> {

    private T mTest;

    protected abstract T createTestCase();

    protected void check(int expeceted, int actual)
    {
        Assertions.assertEquals(expeceted, actual);
    }

    protected T testCase() { return mTest == null ? mTest = createTestCase() : mTest; }
}
