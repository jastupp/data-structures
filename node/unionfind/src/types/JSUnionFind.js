class JSUnionFind {

    #mArray;
    #mSize;

    constructor(size) { this.#mSize = size; }

    size = () => this.#mSize;

    union = (a, b) => {
        const rootA = this.#root(a);
        const rootB = this.#root(b);

        if(rootA !== rootB) {
            this.#array()[Math.max(rootA, rootB)] = Math.min(rootA, rootB);
        }
    }

    roots = () => this.#array().reduce(
        (total, value, index) => total += value === index ? 1 : 0,
        0);

    //debug = () => this.#mArray;

    //*******************
    // Private Members **
    //*******************

    #root = (index) => {
        let root = index;
        while(!this.#isRoot(root)) {
            root = this.#array()[root];
        }

        while(index !== root) {
            const next = this.#array()[index];
            this.#array()[index] = root;
            index = next;
        }
        return root;
    }

    #createArray = () => [...Array(10).keys()]

    #array = () => this.#mArray === undefined ? this.#mArray = this.#createArray() : this.#mArray;

    #isRoot = (index) => this.#array()[index] === index;
}

module.exports = JSUnionFind;
