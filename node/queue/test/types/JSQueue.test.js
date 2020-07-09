const { describe, expect, test, beforeEach } = require('@jest/globals')
const JSQueue = require('../../src/types/JSQueue');

describe('Tests for queue', () => {

    let mQueue;

    beforeEach(() => mQueue = new JSQueue() )

    test('test size method', () => {
         expect(queue().size()).toBe(0);
         addSome();
         expect(queue().size()).toBe(3);
    });

    test('test isEmpty method', () => {
         expect(queue().isEmpty()).toBeTruthy();
         addSome();
         expect(queue().isEmpty()).toBeFalsy();
    });

    test('test enqueue method', () => {
         expect(queue().isEmpty()).toBeTruthy();
         addSome();
         expect(queue().size()).toBe(3);
    });

    test('test dequeue method', () => {
         expect(queue().isEmpty()).toBeTruthy();
         addSome();
         expect(queue().dequeue()).toBe(2);
         expect(queue().dequeue()).toBe(3);
         expect(queue().dequeue()).toBe(5);
    });

    test('test peek method', () => {
         expect(queue().isEmpty()).toBeTruthy();
         addSome();
         expect(queue().peek()).toBe(2);
         expect(queue().peek()).toBe(2);
         expect(queue().peek()).toBe(2);
    });

    const addSome = () => {
        queue().enqueue(2);
        queue().enqueue(3);
        queue().enqueue(5);
    }

    const queue = () => mQueue;
})
