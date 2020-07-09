class JSStack {

    #mArray = [];
    #mSize = 0;

    size = () => this.#mSize;

    isEmpty = () => this.size() === 0;

    push = value => this.#array()[this.#mSize++] = value;

    pop = () => this.#array()[this.#mSize--];

    peek = () => this.#array()[this.#mSize];

    //*******************
    // Private Members **
    //*******************

    #array = () => this.#mArray;
}

module.exports = JSStack;