const { beforeEach, describe, expect, test } = require("@jest/globals");
const JSDoubleLinkecList = require('../../src/types/DoubleLinkedList');

describe('Test DoubleLinkedList', () => {

    let mList;

    beforeEach(() => {
        mList = new JSDoubleLinkecList();
    });

    test('The size method', () => {
        expect(list().size()).toBe(0);
        addSome();
        expect(list().size()).toBe(3);
    });

    test('Check the isEmpty / clear method', () => {
        expect(list().isEmpty()).toBeTruthy();
        addSome();
        expect(list().isEmpty()).toBeFalsy();
        list().clear();
        expect(list().isEmpty()).toBeTruthy();
    });

    test('Add Method', () => {
        addSome();
        checkFirst(2);
        checkLast(5);
    });

    test('the addFirst Method', () => {
        list().addFirst(11);
        checkFirst(11);
        checkLast(11);
        list().addFirst(7);
        checkFirst(7);
        checkLast(11)
        expect(list().size()).toBe(2);
    });

    test('The peekFirst method', () => {
        addSome();
        checkFirst(2);
    });

    test('The peekLast method', () => {
        addSome();
        checkLast(5);
        list().add(7);
        checkLast(7);
    });

    test('the remove first method', () => {
        addSome();
        checkFirst(2);
        expect(list().removeFirst()).toBe(2);
        checkFirst(3);
    });

    test('the remove last method', () => {
        addSome();
        checkLast(5);
        expect(list().removeLast()).toBe(5);
        checkLast(3);
    });

    test('the remove method', () => {
        addSome();
        list().remove(5);
        checkFirst(2);
        checkLast(3);
        list().remove(3);
        checkFirst(2);
        checkLast(2);
        list().remove(100);
        checkFirst(2);
    });

    test('the removeAt method', () => {
        addSome();
        list().removeAt(1);
        checkFirst(2);
        checkLast(5);
        list().removeAt(0);
        checkFirst(5);
        checkLast(5);
        list().removeAt(100);
        checkLast(5)
    });

    const checkFirst = first => expect(list().peekFirst()).toBe(first);

    const checkLast = last => expect(list().peekLast()).toBe(last);

    const list = () => mList;

    const addSome = () => {
        mList.add(2);
        mList.add(3);
        mList.add(5);
    }
})