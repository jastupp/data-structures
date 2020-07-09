package com.js.datastructuresalgorithms.pqueue;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


class JSPQueueTest extends TestBase<JSPQueue<Integer>> {

    @Test
    void enqueue()
    {
        testCase().enqeue(16);
        testCase().enqeue(20);
        testCase().enqeue(19);
        testCase().enqeue(14);
        testCase().enqeue(18);
        testCase().enqeue(17);
        testCase().enqeue(15);

        check(14, testCase().dequeue());
        check(15, testCase().dequeue());
        check(16, testCase().dequeue());
        check(17, testCase().dequeue());
        check(18, testCase().dequeue());
        check(19, testCase().dequeue());
        check(20, testCase().dequeue());
    }

    @Test
    public void dequeue()
    {
        testCase().enqeue(17);
        testCase().enqeue(16);
        testCase().enqeue(20);
        testCase().enqeue(19);
        testCase().enqeue(14);
        testCase().enqeue(18);
        testCase().enqeue(15);

        check(14, testCase().dequeue());
        check(15, testCase().dequeue());
        check(16, testCase().dequeue());
        check(17, testCase().dequeue());
        check(18, testCase().dequeue());
        check(19, testCase().dequeue());
        check(20, testCase().dequeue());
    }

    @Test
    public void size()
    {
        testCase().enqeue(17);
        testCase().enqeue(16);
        testCase().enqeue(20);
        testCase().enqeue(19);

        check(4, testCase().size());
    }

    @Test
    public void peek()
    {
        testCase().enqeue(17);
        testCase().enqeue(16);
        testCase().enqeue(20);
        testCase().enqeue(19);

        check(16, testCase().peek());
        check(16, testCase().peek());
    }




    //                  4
//          5              6
//      7      11      12      10
//    8  14  17  18   13 19   15 16




    protected JSPQueue<Integer> createTestCase() { return new JSPQueue<>(); }

    private void check(int expected, int actual) {
        Assertions.assertEquals(expected, actual);
    }
}