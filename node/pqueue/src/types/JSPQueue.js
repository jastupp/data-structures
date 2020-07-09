class JSPQueue {

    //*****************
    // Class Members **
    //*****************
    #mArray = [];

    size = () => this.#array().length;

    enqueue = (item) => {
        this.#array().push(item);
        if(this.size() > 1) {
            this.#bubbleUp(this.size() -1);
        }
    }

    dequeue = () => {
        const result = this.#array()[0];
        this.#swap(0, this.size() - 1);
        this.#array().pop();
        this.#bubbleDown();
        return result;
    }

    //             1
    //        3         4
    //     12   11

    peek = () => this.#array()[0];

    //debug = () => this.#array();

    //*******************
    // Private Members **
    //*******************

    #bubbleUp = (index) => {
        let parent;
        while(this.#compare(parent = this.#parent(index), index) > 0) {
            this.#swap(parent, index);
            index = parent;
        }
    }

    #bubbleDown = () => {
        let index = 0;
        let lesser = this.#lesserChild(index);
        while(lesser !== -1 && this.#compare(index, lesser) > 0) {
            this.#swap(index, lesser);
            index = lesser;
            lesser = this.#lesserChild(index);
        }
    }

    #lesserChild = (index) => {
        const left = this.#left(index);
        const right = this.#right(index);
        let lesser = left < this.size() ? left : -1;
        if(lesser !== -1 && right < this.size()) {
            lesser = Math.min(this.#item(left), this.#item(right)) === this.#item(left) ? left : right
        }
        return lesser;
    }

    #swap = (one, two) => {
        const tmp = this.#item(one);
        this.#array()[one] = this.#array()[two];
        this.#array()[two] = tmp;
    }

    #compare = (one, two) => this.#item(one) - this.#item(two);

    #item = index => this.#array()[index];

    #parent = (index) => index === 1 ? 0 : Math.floor((index - 1) / 2);

    #left = (index) => index * 2 + 1;

    #right = (index) => this.#left(index) + 1;

    #array = () => this.#mArray;

}

module.exports = JSPQueue;