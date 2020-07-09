class JSArray {

    //*****************
    // Class Members **
    //*****************
    #mCapacity;
    #mArray;
    #mLength;

    constructor(capacity = 0) {
        this.#mArray = new Array(this.#mCapacity = capacity);
        this.#mLength = 0;
    }

    size = () => this.#length();

    isEmpty = () => this.size() === 0;

    get = (index) => this.#array()[index];

    set = (index, value) => this.#array()[index] = value;

    clear = () => {
        this.#mArray = this.#array().map(() => null);
        this.#mLength = 0;
    }

    add = (item) => {
        if(this.#length() + 1 > this.#capacity()) {
            this.#mCapacity = this.#capacity() === 0 ? 1 : this.#capacity() * 2;
            let newArray = new Array(this.#capacity());
            this.#array().forEach((next, index) => newArray[index] = next);
            this.#mArray = newArray;
        }
        this.#mArray[this.#mLength++] = item;
    }

    remove = (item) => {
        let result = this.#array().filter(next => next !== item);
        const found = result.length !== this.#array().length;
        this.#mLength = found ? this.#length() - 1 : this.#length();
        this.#mArray = result;
        return found;
    }

    removeAt = (index) => {
        const item = this.get(index);
        this.#mArray = this.#array().filter((next, i) => i !== index);
        this.#mLength--;
        return item;
    }

    indexOf = (item) => {
        let index = -1;
        this.#array().filter((next, i) => index = next === item ? i : index );
        return index;
    }

    contains = (item) => this.indexOf(item) !== -1;

    toString = () => {
        let str = '[';
        this.#mArray.forEach(next => str += ', ' + next);
        return str.replace('[, ', '[') + ']';
    }

    //*******************
    // Private Members **
    //*******************

    #array = () => this.#mArray;

    #capacity = () => this.#mCapacity;

    #length = () => this.#mLength;
}

module.exports = JSArray;