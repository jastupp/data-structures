const { describe, test, expect, beforeEach } = require('@jest/globals');
const JSFenwickTree = require('../../src/types/JSFenwickTree');

describe('Fenwick tree test', () => {

    let mTree;
    let mArray;

    beforeEach(() => {
        mTree = null;
        mArray = null;
    });

    test('Test sum', () => check() );

    test('the range method', () => {
        expect(tree().range(3, 5)).toBe(12);
    });

    test('test update', () => {
        tree().update(3, 10);
        testArray()[2] = 10;
        check();
    });

    //*******************
    // Private Members **
    //*******************

    const check = () => {
        for(let i = 1; i <= testArray().length; i++) {
            expect(sum(i)).toBe(tree().sum(i));
        }
    }

    const sum = (index) => testArray().reduce((total, next, i) => total += i > index - 1 ? 0 : next, 0);

    const tree = () => mTree === null ? mTree = new JSFenwickTree(testArray()) : mTree;

    const testArray = () => mArray === null ? mArray = [ 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 ] : mArray;
});

