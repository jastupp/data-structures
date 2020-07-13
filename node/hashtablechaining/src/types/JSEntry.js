const crypto = require('crypto');

class JSEntry {

    #mKey
    #mValue
    #mHash

    constructor(key, value) {
        this.#mKey = key;
        this.#mValue = value;
        this.#mHash = null;
    }

    get key() { return this.#mKey };

    get value() { return this.#mValue; }

    get hash() { return this.#mHash === null ? this.#mHash = this.#hash(this.key) : mHash; }

    equal = (that) => this.hash === that.hash && this.key === that.key;

    //*******************
    // Private Members **
    //*******************

    #hash = (value) => crypto.createHash('md5').update(this.key).digest('hex');
}

module.exports = JSEntry;