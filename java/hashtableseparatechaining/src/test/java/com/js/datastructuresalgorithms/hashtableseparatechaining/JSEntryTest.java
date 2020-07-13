package com.js.datastructuresalgorithms.hashtableseparatechaining;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class JSEntryTest extends TestBase<JSEntry<String, Integer>> {


    @Test
    void testHashCode()
    {
        Assertions.assertEquals(testCase().hashCode(), testCase().hashCode());
    }

    @Test
    void equal()
    {
        Assertions.assertTrue(testCase().equal(new JSEntry<>(testKey(), testValue())));
    }

    @Test
    void testToString()
    {
        Assertions.assertEquals(testCase().toString(), testKey() + " => " + testValue());
    }

    @Test
    void key()
    {
        Assertions.assertEquals(testCase().key(), testKey());
    }

    @Test
    void value()
    {
        Assertions.assertEquals(testCase().value(), testValue());
    }

    protected JSEntry<String, Integer> createTest() { return new JSEntry<>(testKey(), testValue()); }

    private String testKey() { return "John"; }

    private Integer testValue() { return 123; }
}