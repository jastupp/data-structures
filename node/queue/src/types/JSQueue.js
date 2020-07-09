class JSQueue {

    #mArray = [];

    size = () => this.#array().length;

    isEmpty = () => this.size() === 0;

    enqueue = item => this.#array().push(item);

    dequeue = () => this.#array().shift();

    peek = () => this.#array()[0];

    //*******************
    // Private Members **
    //*******************

    #array = () => this.#mArray;
}

module.exports = JSQueue;

