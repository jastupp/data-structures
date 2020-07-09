const { describe, test, expect, beforeEach } = require('@jest/globals');
const JSUnionFind = require('../../src/types/JSUnionFind');

describe('Test the JSUnionFind class', () => {

    const mSize = 10;
    let mUnion;

    beforeEach(() => mUnion = new JSUnionFind(size()));

    test('the size method', () => {
        expect(union().size()).toBe(size());
    });

    test('the roots method', () => {
        expect(union().roots()).toBe(size());
        union().union(0, 1);
        union().union(0, 1);
        expect(union().roots()).toBe(size() - 1);
        union().union(2, 3);
        union().union(4, 5);
        union().union(6, 7);
        union().union(8, 9);
        expect(union().roots()).toBe(size() - 5);

        for(let i = 0; i < size(); i++) {
            union().union(0, i);
        }
        expect(union().roots()).toBe(1);







    })

    //*******************
    // Private Members **
    //*******************

    const union = () => mUnion;

    const size = () => mSize;

});