package com.js.datastructuresalgorithms.bst;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class JSBinarySearchTreeTest extends TestBase<JSBinarySearchTree<Integer>>{

    @Test
    void add()
    {
        testCase().add(10);
        testCase().add(15);
        testCase().add(5);

        Assertions.assertTrue(testCase().contains(5));
        Assertions.assertTrue(testCase().contains(10));
        Assertions.assertTrue(testCase().contains(15));
    }

    @Test
    public void contains()
    {
        testCase().add(10);
        testCase().add(15);
        testCase().add(5);

        Assertions.assertFalse(testCase().contains(0));
        Assertions.assertTrue(testCase().contains(5));
        Assertions.assertTrue(testCase().contains(10));
        Assertions.assertTrue(testCase().contains(15));
        Assertions.assertFalse(testCase().contains(20));
    }

    @Test
    public void remove()
    {
        tree();
        removeCheck(25);

        tree();
        removeCheck(30);

        tree();
        removeCheck(10);

        tree();
        testCase().add(31);
        removeCheck(31);


    }

    protected JSBinarySearchTree<Integer> createTestCase() { return new JSBinarySearchTree<>(); }

    private void removeCheck(int value)
    {
        Assertions.assertTrue(testCase().contains(value));
        Assertions.assertTrue(testCase().remove(value));
        Assertions.assertFalse(testCase().contains(value));
    }


    private void tree() {
        testCase().clear();

        testCase().add(20);

        testCase().add(15);
        testCase().add(25);

        testCase().add(10);
        testCase().add(18);
        testCase().add(23);
        testCase().add(30);

        //testCase().add(6);
        testCase().add(11);
        testCase().add(19);
        testCase().add(17);
        testCase().add(22);
        testCase().add(24);
        testCase().add(29);
    }
}