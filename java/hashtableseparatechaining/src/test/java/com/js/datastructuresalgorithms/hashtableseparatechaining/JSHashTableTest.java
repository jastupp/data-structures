package com.js.datastructuresalgorithms.hashtableseparatechaining;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class JSHashTableTest extends TestBase<JSHashTable<String, Integer>>{

    @Test
    void put()
    {
        addSome();
        Assertions.assertTrue(testCase().contains("ABC"));
        Assertions.assertTrue(testCase().contains("DEF"));
        Assertions.assertTrue(testCase().contains("GHI"));
        Assertions.assertTrue(testCase().contains("JKL"));
        Assertions.assertTrue(testCase().contains("MNO"));
        Assertions.assertTrue(testCase().contains("PQR"));
        Assertions.assertTrue(testCase().contains("STU"));
    }

    @Test
    void get()
    {
        addSome();
        Assertions.assertEquals(testCase().get("ABC").intValue(), 123);
        Assertions.assertEquals(testCase().get("DEF").intValue(), 234);
        Assertions.assertEquals(testCase().get("GHI").intValue(), 345);
        Assertions.assertEquals(testCase().get("JKL").intValue(), 456);
        Assertions.assertEquals(testCase().get("MNO").intValue(), 567);
        Assertions.assertEquals(testCase().get("PQR").intValue(), 678);
        Assertions.assertEquals(testCase().get("STU").intValue(), 789);
    }

    @Test
    void contains()
    {
        addSome();
        Assertions.assertTrue(testCase().contains("ABC"));
        Assertions.assertTrue(testCase().contains("DEF"));
        Assertions.assertTrue(testCase().contains("GHI"));
        Assertions.assertTrue(testCase().contains("JKL"));
        Assertions.assertTrue(testCase().contains("MNO"));
        Assertions.assertTrue(testCase().contains("PQR"));
        Assertions.assertTrue(testCase().contains("STU"));
    }

    @Test
    void remove()
    {
        addSome();

        Assertions.assertTrue(testCase().contains("ABC"));
        testCase().remove("ABC");
        Assertions.assertFalse(testCase().contains("ABC"));

        Assertions.assertTrue(testCase().contains("MNO"));
        testCase().remove("MNO");
        Assertions.assertFalse(testCase().contains("MNO"));
    }

    @Override
    protected JSHashTable<String, Integer> createTest() { return new JSHashTable<>(); }

    private void addSome() {
        testCase().put("ABC", 123);
        testCase().put("DEF", 234);
        testCase().put("GHI", 345);
        testCase().put("JKL", 456);
        testCase().put("MNO", 567);
        testCase().put("PQR", 678);
        testCase().put("STU", 789);
    }
}