const { describe, test, expect, beforeEach } = require('@jest/globals');
const JSStack = require('../../src/types/JSStack');

describe('Test the stack', () => {

    let mStack;

    beforeEach(() => mStack = new JSStack());

    test('Test the size', () => {
        expect(stack().size()).toBe(0);
        addSome();
        expect(stack().size()).toBe(3);
    });

    test('is Empty', () => {
        expect(stack().isEmpty()).toBeTruthy();
        addSome();
        expect(stack().isEmpty()).toBeFalsy();
    });

    test('the push method', () => {
        stack().push(13);
        expect(stack().peek()).toBe(13);
        expect(stack().pop()).toBe(13);
    });

    test('the pop method', () => {
        stack().push(13);
        expect(stack().pop()).toBe(13);
    });

    test('the peek method', () => {
        stack().push(13);
        expect(stack().peek()).toBe(13);
        expect(stack().peek()).toBe(13);
    });



    const addSome = () => {
        stack().push(2);
        stack().push(3);
        stack().push(5);
    }
    const stack = () => mStack;
})

