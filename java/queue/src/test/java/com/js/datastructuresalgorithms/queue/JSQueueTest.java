package com.js.datastructuresalgorithms.queue;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class JSQueueTest extends TestBase<JSQueue<Integer>> {

    @Test
    void enqueue()
    {
        Assertions.assertTrue(testCase().isEmpty());
        testCase().enqueue(123);
        check(123, testCase().peek());
    }

    @Test
    void dequeue()
    {
        enqueueSome();;
        check(2, testCase().dequeue());
        check(3, testCase().dequeue());
        check(5, testCase().dequeue());
    }

    @Test
    void peek()
    {
        enqueueSome();
        check(2, testCase().peek());
        check(2, testCase().peek());
        check(2, testCase().peek());
    }

    @Test
    void size()
    {
        check(0, testCase().size());
        enqueueSome();
        check(3, testCase().size());
        enqueueSome();
        check(6, testCase().size());
    }

    @Test
    void isEmpty()
    {
        Assertions.assertTrue(testCase().isEmpty());
        enqueueSome();
        Assertions.assertFalse(testCase().isEmpty());
    }

    //*********************
    // Protected Methods **
    //*********************

    protected JSQueue<Integer> createTestCase() { return new JSQueue<>(); }

    //*******************
    // Private Members **
    //*******************

    private void enqueueSome() {
        testCase().enqueue(2);
        testCase().enqueue(3);
        testCase().enqueue(5);
    }
}