package com.js.datastructuresalgorithms.bst;

public abstract class TestBase <T> {

    private T mTestCase;

    protected abstract T createTestCase();

    protected T testCase() { return mTestCase == null ? mTestCase = createTestCase() : mTestCase; }
}
