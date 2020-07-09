const { beforeEach, describe, expect, test } = require("@jest/globals");
const JSArray = require('../../src/types/JSArray');

describe('Test JSArray class', () => {

    let mArray;

    beforeEach(() => {
        mArray = new JSArray();
    });

    test('Check the size is zero for a new array', () => {
        expect(mArray.size()).toBe(0);
    });

    test('Check the size works', () => {
        addData();
        expect(mArray.size()).toBe(3);
    });

    test('The isEmpty method works', () => {
        expect(mArray.isEmpty()).toBeTruthy();
        mArray.add(1);
        expect(mArray.isEmpty()).toBeFalsy();
    });

    test('The set method works', () => {
        const object = 'Hello';
        mArray.set(4, object);
        expect(mArray.get(4)).toBe(object);
    });

    test('The get method works', () => {
        const object = 'Hello';
        mArray.set(4, object);
        expect(mArray.get(4)).toBe(object);
    });

    test('The clear method works', () => {
        addData();
        expect(mArray.isEmpty()).toBeFalsy();
        mArray.clear();
        expect(mArray.isEmpty()).toBeTruthy();
    });

    test('The add method works', () => {
        addData();
        expect(mArray.size()).toBe(3);
        expect(mArray.get(0)).toBe(2);
        expect(mArray.get(1)).toBe(3);
        expect(mArray.get(2)).toBe(5);
    });

    test('the removeAt method', () => {
        addData();
        mArray.removeAt(1);
        expect(mArray.get(0)).toBe(2);
        expect(mArray.get(1)).toBe(5);
    });

    test('the remove method', () => {
        addData();
        expect(mArray.remove(3)).toBeTruthy();
        expect(mArray.get(0)).toBe(2);
        expect(mArray.get(1)).toBe(5);
        expect(mArray.remove(100)).toBeFalsy();
    });

    test('the indexOf method', () => {
        addData();
        expect(mArray.indexOf(3)).toBe(1);
        expect(mArray.indexOf(1)).toBe(-1);
    });

    test('the contains method', () => {
        addData();
        expect(mArray.contains(2)).toBeTruthy();
        expect(mArray.contains(3)).toBeTruthy();
        expect(mArray.contains(5)).toBeTruthy();
        expect(mArray.contains(1)).toBeFalsy();
    });

    test('Auto scaling', () => {
        addData();
        addData();
        addData();

        expect(mArray.get(0)).toBe(2);
        expect(mArray.get(3)).toBe(2);
        expect(mArray.get(6)).toBe(2);
    });

    test("tostring method", () => {
        addData();
        expect(mArray.toString()).toBe('[2, 3, 5]');
    })

    const addData = () => {
        mArray.add(2);
        mArray.add(3);
        mArray.add(5);
    };
})


