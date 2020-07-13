class Node {
    #mLeft
    #mRight
    #mValue

    constructor(value) {
        this.#mValue = value;
        this.#mLeft = null;
        this.#mRight = null;
    }

    get value() { return this.#mValue; }
    set value(value) { this.#mValue = value; }

    get left() { return this.#mLeft; }
    set left(value) { this.#mLeft = value; }

    get right() { return this.#mRight; }
    set right(value) { this.#mRight = value; }
}

class JSBinarySearchTree {

    #mRoot

    constructor() { this.#mRoot === null; }

    clear = () => this.#mRoot = null;

    add = (item) => {
        if(this.#root() === null) {
            this.#mRoot = new Node(item);
        } else {
            this.#addItem(item);
        }
    }

    contains = (item) => this.#findNode(item) !== null;

    remove = (item) => this.#removeNode(this.#findNode(item));

    preorder = () => this.#doPreorder(this.#root());

    inOrder = () => this.#doInOrder(this.#root());



    //debug = () => this.#root();

    //*******************
    // Private Members **
    //*******************

    #doPreorder = (node) => {
        if (node === null || node === undefined) return;
        console.log(node.value);
        this.#doPreorder(node.left);
        this.#doPreorder(node.right);
    }

    #doInOrder = (node) => {
        if (node === null || node === undefined) return;
        this.#doInOrder(node.left);
        console.log(node.value);
        this.#doInOrder(node.right);
    }

    #removeNode = (node) => {
        if(node !== null) {
            const parent = this.#parent(node);
            if(node.left === null && node.right === null) {
                this.#deleteChild(parent, node);
            } else if(node.left !== null && node.right !== null) {
                const lowestRight = this.#lowestRight(node);
                this.#removeNode(lowestRight);
                node.value = lowestRight.value;
            } else {
                if(node.left !== null) {
                    parent.left === node ? parent.left = node.left : parent.right = node.left;
                } else if(node.right !== null) {
                    parent.left === node ? parent.left = node.right : parent.right = node.right;
                }
            }
        }
    }

    #lowestRight = (node) => {
        node = node.right;
        while(node.left !== null) {
            node = node.left;
        }
        return node;
    }

    #deleteChild = (parent, child) => {
        if(this.#equal(parent.left, child)) {
            parent.left = null;
        } else if(this.#equal(parent.right, child)) {
            parent.right = null;
        }
    }

    #parent = (child) => {
        let node = this.#root();
        while(!this.#isParent(node, child)) {
            node = child.value > node.value ? node.right : node.left;
        }
        return node;
    }

    #isParent = (node, child) => node !== null && (node.left === child || node.right === child);

    #equal = (one, two) => (one === two) || (one !== null && two !== null && one.value === two.value);

    //#equals = (node, value) => node !== null && node.value === value;

    #findNode = (item) => {
        let node = this.#root();
        while(node !== null && node.value !== item) {
            node = item > node.value ? node.right : node.left;
        }
        return node;
    }

    #addItem = (item) => {
        let node = this.#root();
        let child = node;
        while(child !== null) {
            node = child;
            child = item > node.value ? node.right : node.left;
        }
        if(item > node.value) {
            node.right = new Node(item);
        } else if(item < node.value) {
            node.left = new Node(item);
        }
    }

    #root = () => this.#mRoot;
}

module.exports = JSBinarySearchTree;