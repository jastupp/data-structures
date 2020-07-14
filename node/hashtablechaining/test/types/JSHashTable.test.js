const { describe, beforeEach, test, expect } = require('@jest/globals');
const JSHashTable = require('../../src/types/JSHashTable');

describe('Test the hashtable class', () => {

    let mTestCase;

    beforeEach(() => mTestCase = null);

    test('Test the add method', () => {
        addSome();

        expect(testCase().contains("ABC")).toBeTruthy();
        expect(testCase().contains("DEF")).toBeTruthy();
        expect(testCase().contains("GHI")).toBeTruthy();
        expect(testCase().contains("JKL")).toBeFalsy();
    });

    test('The get method', () => {
        addSome();

        expect(testCase().get("ABC")).toBe(123);
        expect(testCase().get("DEF")).toBe(234);
        expect(testCase().get("GHI")).toBe(345);
        expect(testCase().get("JKL")).toBeNull();
    })

    const addSome = () => {
        testCase().add("ABC", 123);
        testCase().add("DEF", 234);
        testCase().add("GHI", 345);
    }

    const testCase = () => mTestCase === null ? mTestCase = new JSHashTable() : mTestCase;
})