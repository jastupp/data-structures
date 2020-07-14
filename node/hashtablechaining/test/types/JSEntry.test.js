const { describe, beforeEach, test, expect } = require('@jest/globals');
const JSEntry = require('../../src/types/JSEntry');
const crypto = require('crypto');

describe('Test JSEntry class', () => {

    let mEntry;

    beforeEach(() => mEntry = null );

    test('The key method', () => {
        expect(entry().key).toBe(key());
    });

    test('The value method', () => {
        expect(entry().value).toBe(value());
    });

    test('The hash method', () => {
        expect(entry().hash).toBe(hash(key()));
        expect(entry().hash).toBe(hash(key()));
    });

    test('The equal method', () => {
        expect(entry().equal(new JSEntry(key(), value()))).toBeTruthy();
    });

    const entry = () => mEntry === null ? mEntry = new JSEntry(key(), value()) : mEntry;

    const key = () => 'John';

    const value = () => 123;

    const hash = (value) => parseInt(crypto.createHash('md5').update(value).digest('hex'), 16) % 100000000;

})