const { describe, test, expect, beforeAll } = require('@jest/globals');
const JSPQueue = require('../../src/types/JSPQueue');

describe('Test the JSPQueue', () => {

    let mQueue;

    beforeEach(() => mQueue = new JSPQueue());

    test('The size method', () => {
        expect(queue().size()).toBe(0);
        queue().enqueue(12);
        queue().enqueue(11);
        expect(queue().size()).toBe(2)
    });

    test('the enqueue method', () => {
        queue().enqueue(12);
        expect(queue().peek()).toBe(12);
        queue().enqueue(3);
        expect(queue().peek()).toBe(3);
        queue().enqueue(4);
        expect(queue().peek()).toBe(3);
        queue().enqueue(1);
        expect(queue().peek()).toBe(1);
    });

    test('the dequeue method', () => {
        queue().enqueue(12);
        queue().enqueue(3);
        queue().enqueue(4);
        queue().enqueue(1);
        queue().enqueue(11);

        expect(queue().dequeue()).toBe(1);
        expect(queue().dequeue()).toBe(3);
        expect(queue().dequeue()).toBe(4);
        expect(queue().dequeue()).toBe(11);
        expect(queue().dequeue()).toBe(12);
    });

    test('the peek method', () => {
        queue().enqueue(4);
        queue().enqueue(1);
        queue().enqueue(11);

        expect(queue().peek()).toBe(1);
        expect(queue().peek()).toBe(1);
    });

    const queue = () => mQueue;

})
