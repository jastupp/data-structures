const JSEntry = require('./JSEntry');
const crypto = require('crypto');

class JSHashTable {

    #mArray = null;
    #mCapacity = 10;

    constructor() {}

    add = (key, value) => {
        const entity = this.#entry(key, value);
        this.#listFromHash(entity.hash).push(entity);
    }

    contains = (key) => this.get(key) !== null;

    get = (key) => {
        const found = this.#listFromKey(key).filter((next) => this.#equal(next, key));
        return found.length === 0 ? null : found[0].value;
    }

    //*******************
    // Private Members **
    //*******************

    #equal = (entity, key) => entity.key === key;

    #entry = (key, value) => new JSEntry(key, value);

    #listFromKey = (key) => this.#listFromHash(this.#hash(key));

    #listFromHash = (hash) => {
        const index = hash % this.#capacity();
        if(this.#array()[index] === undefined) {
            this.#array()[index] = [];
        }
        return this.#array()[index];
    }

    #hash = (value) => parseInt(crypto.createHash('md5').update(value).digest('hex'), 16) % 100000000;

    #capacity = () => this.#mCapacity;

    #array = () => this.#mArray === null ? this.#mArray = [] : this.#mArray;
}

module.exports = JSHashTable;