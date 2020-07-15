class JSFenwickTree {

    //*****************
    // Class Members **
    //*****************
    #mOriginal;
    #mFenwick;

    //***************
    // Constructor **
    //***************
    constructor(array) { this.#mOriginal = Array.from(array); }

    sum = (index) => {
        let total = 0;
        while(index > 0) {
            total += this.#fenwick()[index - 1];
            index -= this.#lb(index);
        }
        return total;
    }

    range = (from, to) => this.sum(to) - this.sum(from - 1);

    update = (index, value) => {
        const diff = value - this.#fenwick()[index - 1];
        while(index < this.#fenwick().length) {
            this.#fenwick()[index - 1] += diff;
            index += this.#lb(index);
        }
    }

    //*******************
    // Private Members **
    //*******************

    #createFenwick = () => {
        const array = Array.from(this.#original());
        array.forEach((next, index) => {
            const i = ++index + this.#lb(index);
            if(i < array.length + 1) {
                array[i - 1] += next;
            }
        });
        return array;
    }

    #lb = (value) => value & (-value);

    #fenwick = () => this.#mFenwick === undefined ? this.#mFenwick = this.#createFenwick() : this.#mFenwick;

    #original = () => this.#mOriginal;
}

module.exports = JSFenwickTree;