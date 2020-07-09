package com.js.datastructuresalgorithms.dynamicarray;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class JSArrayTest extends TestBase<JSArray<Integer>> {


    @Test
    void size()
    {
        Assertions.assertEquals(0, testCase().size());
        setUpData();
        Assertions.assertEquals(3, testCase().size());
    }

    @Test
    void isEmpty()
    {
        Assertions.assertTrue(testCase().isEmpty());
        setUpData();
        Assertions.assertFalse(testCase().isEmpty());
    }

    @Test
    void get()
    {
        setUpData();

        Assertions.assertEquals(2, testCase().get(0));
        Assertions.assertEquals(3, testCase().get(1));
        Assertions.assertEquals(5, testCase().get(2));
    }

    @Test
    void set()
    {
        testCase().set(5, 34);
        Assertions.assertEquals(34, testCase().get(5));
    }

    @Test
    void clear()
    {
        setUpData();
        Assertions.assertEquals(2, testCase().get(0));

        testCase().clear();

        Assertions.assertNull(testCase().get(0));
    }   

    @Test
    void add()
    {
        setUpData();

        Assertions.assertEquals(2, testCase().get(0));
        Assertions.assertEquals(3, testCase().get(1));
        Assertions.assertEquals(5, testCase().get(2));
    }

    @Test
    void removeAt()
    {
        setUpData();

        Integer tmp = testCase().removeAt(1);

        Assertions.assertEquals(3, tmp);

        Assertions.assertEquals(2, testCase().get(0));
        Assertions.assertEquals(5, testCase().get(1));
    }

    @Test
    void remove()
    {
        setUpData();

        Assertions.assertFalse(testCase().remove(-1));
        Assertions.assertTrue(testCase().remove(3));

        Assertions.assertEquals(2, testCase().get(0));
        Assertions.assertEquals(5, testCase().get(1));
    }

    @Test
    void indexOf()
    {
        setUpData();

        Assertions.assertEquals(1, testCase().indexOf(3));
    }

    @Test
    void contains()
    {
        setUpData();

        Assertions.assertFalse(testCase().contains(1));
        Assertions.assertTrue(testCase().contains(2));
        Assertions.assertTrue(testCase().contains(3));
        Assertions.assertTrue(testCase().contains(5));
    }

    @Test
    void iterator()
    {
        setUpData();

        for(Integer integer : testCase()) {
            Assertions.assertNotNull(integer);
        }
    }

    @Test
    void testToString()
    {
        setUpData();

        Assertions.assertEquals("[2, 3, 5]", testCase().toString());
    }

    @Test
    void testIncrease()
    {
        setUpData();
        setUpData();
        setUpData();
        setUpData();
        setUpData();
        setUpData();

        Assertions.assertEquals(18, testCase().size());
        Assertions.assertEquals(2, testCase().get(0));
        Assertions.assertEquals(2, testCase().get(3));
        Assertions.assertEquals(2, testCase().get(6));
        Assertions.assertEquals(2, testCase().get(9));
    }

    //*********************
    // Protected Methods **
    //*********************

    protected JSArray<Integer> createTestCase() { return new JSArray<>(); }

    //*******************
    // Private Members **
    //*******************

    private void setUpData()
    {
        testCase().add(2);
        testCase().add(3);
        testCase().add(5);
    }
}