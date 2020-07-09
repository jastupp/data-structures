package com.js.datastructuresalgorithms.doublelinkedlist;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class JSDoubleLinkedListTest extends TestBase<JSDoubleLinkedList<Integer>> {

    @Test
    void clear()
    {
        addData();
        Assertions.assertFalse(testCase().isEmpty());
        testCase().clear();
        Assertions.assertTrue(testCase().isEmpty());
    }

    @Test
    void size()
    {
        Assertions.assertEquals(0, testCase().size());
        addData();
        Assertions.assertEquals(3, testCase().size());
        addData();
        Assertions.assertEquals(6, testCase().size());
    }

    @Test
    void isEmpty()
    {
        Assertions.assertTrue(testCase().isEmpty());
        addData();
        Assertions.assertFalse(testCase().isEmpty());
    }

    @Test
    void add()
    {
        addData();
        checkFirstAndLast(2, 5);
    }

    @Test
    void addFirst()
    {
        testCase().addFirst(7);
        checkFirst(7);
        testCase().addFirst(11);
        checkFirstAndLast(11, 7);
    }

    @Test
    void peekFirst()
    {
        addData();
        checkFirst(2);
    }

    @Test
    void peekLast()
    {
        addData();
        checkLast(5);
    }

    @Test
    void removeFirst()
    {
        addData();
        testCase().removeFirst();
        checkFirstAndLast(3, 5);
    }

    @Test
    void removeLast()
    {
        addData();
        testCase().removeLast();
        checkFirstAndLast(2, 3);
    }

    @Test
    void remove()
    {
        addData();
        testCase().remove(3);
        checkFirstAndLast(2, 5);
    }

    @Test
    void removeAt()
    {
        addData();
        testCase().removeAt(1);
        checkFirstAndLast(2, 5);
    }

    protected JSDoubleLinkedList<Integer> createTestCase() { return new JSDoubleLinkedList<>(); }

    private void addData() {
        testCase().add(2);
        testCase().add(3);
        testCase().add(5);
    }

    private void checkFirst(int first) {
        Assertions.assertEquals(first, testCase().peekFirst().intValue());
    }

    private void checkLast(int last) {
        Assertions.assertEquals(last, testCase().peekLast().intValue());
    }

    private void checkFirstAndLast(int first, int last)
    {
        checkFirst(first);
        checkLast(last);
    }
}