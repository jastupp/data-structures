package com.js.datastructuresalgorithms.stack;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


class JSStackTest extends TestBase<JSStack<Integer>> {

    @Test
    void size()
    {
        check(0, testCase().size());
        pushSome();
        check(3, testCase().size());
    }

    @Test
    void isEmpty()
    {
        Assertions.assertTrue(testCase().isEmpty());
        pushSome();
        Assertions.assertFalse(testCase().isEmpty());
    }

    @Test
    void push()
    {
        testCase().push(12);
        check(12, testCase().peek());
        testCase().push(13);
        check(13, testCase().peek());
    }

    @Test
    void pop()
    {
        testCase().push(11);
        check(11, testCase().pop());
    }

    @Test
    void peek()
    {
        testCase().push(23);
        check(23, testCase().peek());
        check(23, testCase().peek());
        check(1, testCase().size());
    }

    //*********************
    // Protected Methods **
    //*********************

    @Override
    protected JSStack<Integer> createTestCase() { return new JSStack<>(); }

    //*******************
    // Private Members **
    //*******************

    private void check(int expected, int actual) {
        Assertions.assertEquals(expected, actual);
    }

    private void pushSome() {
        testCase().push(2);
        testCase().push(3);
        testCase().push(5);
    }
}