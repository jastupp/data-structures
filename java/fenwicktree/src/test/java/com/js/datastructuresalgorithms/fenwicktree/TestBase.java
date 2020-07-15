package com.js.datastructuresalgorithms.fenwicktree;

public abstract class TestBase <T> {

    private T mTest;

    protected abstract T createTest();

    protected T testCase() { return mTest == null ? mTest = createTest() : mTest; }
}
