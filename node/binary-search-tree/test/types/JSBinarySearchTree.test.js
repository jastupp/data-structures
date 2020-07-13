const { describe, test, beforeEach, expect } = require('@jest/globals');
const JSBinarySearchTree = require('../../src/types/JSBinarySearchTree');

describe('Test the Binary Search Tree', () => {

    let mTree;

    beforeEach(() => { mTree = null; });

    test('The clear app', ()=> {
        tree().clear();
    });

    test('The add method', () => {
        addTree();
    });

    test('The contains method', () => {
        addTree();
        expect(tree().contains(20)).toBeTruthy();

        expect(tree().contains(15)).toBeTruthy();
        expect(tree().contains(25)).toBeTruthy();

        expect(tree().contains(10)).toBeTruthy();
        expect(tree().contains(18)).toBeTruthy();
        expect(tree().contains(23)).toBeTruthy();
        expect(tree().contains(30)).toBeTruthy();

        expect(tree().contains(11)).toBeTruthy();
        expect(tree().contains(19)).toBeTruthy();
        expect(tree().contains(17)).toBeTruthy();
        expect(tree().contains(22)).toBeTruthy();
        expect(tree().contains(24)).toBeTruthy();
        expect(tree().contains(29)).toBeTruthy();

        expect(tree().contains(28)).toBeFalsy();
    });

    test('The remove method', () => {

        addTree();
        tree().remove(null);

        expect(tree().contains(15)).toBeTruthy();
        tree().remove(15);
        expect(tree().contains(15)).toBeFalsy();

        addTree();
        expect(tree().contains(30)).toBeTruthy();
        tree().remove(30);
        expect(tree().contains(30)).toBeFalsy();

        addTree()
        expect(tree().contains(10)).toBeTruthy();
        tree().remove(10);
        expect(tree().contains(10)).toBeFalsy();

        addTree();
        expect(tree().contains(30)).toBeTruthy();
        tree().remove(30);
        expect(tree().contains(30)).toBeFalsy();

        addTree();
        expect(tree().contains(29)).toBeTruthy();
        tree().remove(29);
        expect(tree().contains(29)).toBeFalsy();

        addTree()
        expect(tree().contains(11)).toBeTruthy();
        tree().remove(11);
        expect(tree().contains(11)).toBeFalsy();

    })


    const addTree = () => {
        tree().clear();

        tree().add(20);

        tree().add(15);
        tree().add(25);

        tree().add(10);
        tree().add(18);
        tree().add(23);
        tree().add(30);

        //testCase().add(6);
        tree().add(11);
        tree().add(19);
        tree().add(17);
        tree().add(22);
        tree().add(24);
        tree().add(29);
    }
    //
    // test('InOrder method', () => {
    //     addTree();
    //     tree().inOrder()
    // });


    const tree = () => mTree === null ? mTree = new JSBinarySearchTree() : mTree;
});