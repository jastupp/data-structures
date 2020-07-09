class JSNode {

    #mValue;
    #mNext
    #mPrev

    constructor(value, next, prev) {
        //this.#mValue = value;
        this.value = value;
        this.next = next;
        this.prev = prev;
    }

    get value() { return this.#mValue; }
    set value(val) { this.#mValue = val };

    get next() { return this.#mNext; }
    set next(val) { this.#mNext = val; }

    get prev() { return this.#mPrev; }
    set prev(val) { this.#mPrev = val; }
}



class JSDoubleLinkedList {

    //*****************
    // Class Members **
    //*****************
    #mCount;
    #mHead
    #mTail

    constructor() {
        this.#mCount = 0;
        this.#mHead = null;
        this.#mTail = null;
    }

    size = () => this.#mCount;

    isEmpty = () => this.size() === 0;

    add = (item) => {
        if(this.isEmpty()) {
            this.#mHead = this.#mTail = new JSNode(item, null, null);
        } else {
            this.#tail().next = new JSNode(item, null, this.#tail());
            this.#mTail = this.#mTail.next;
        }
        this.#added();
    }

    addFirst = (item) => {
        if(this.isEmpty()) {
            this.#mHead = this.#mTail = new JSNode(item, null, null);
        } else {
            this.#head().prev = new JSNode(item, this.#head(), null);
            this.#mHead = this.#head().prev;
        }
        this.#added();
    }

    removeFirst = () => {
        const data = this.#head().value;
        this.#mHead = this.#head().next;
        this.#head().prev = null;
        this.#removed();
        return data;
    }

    removeLast = () => {
        const data = this.#tail().value;
        this.#mTail = this.#tail().prev;
        this.#tail().next = null;
        this.#removed();
        return data;
    }

    remove = (value) => {
        let current = this.#head();
        while(current !== null && current.value !== value) {
            current = current.next;
        }
        return current == null ? null : this.#remove(current);
    }

    removeAt = (index) => {
        let current = this.#head();
        while(index > 0 && current !== null) {
            current = current.next;
            index--;
        }
        return current == null ? null : this.#remove(current);
    }

    peekFirst = () => this.#head().value;

    peekLast = () => this.#tail().value;

    clear = () => {
        let current = this.#head();
        while(current != null) {
            let next = current.next;
            this.#clear(current);
            current = next;
        }
        this.#mCount = 0;
    }

    #remove = (node) => {
        if(node === this.#head()) {
            this.removeFirst();
        } else if(node === this.#tail()) {
            this.removeLast();
        } else {
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }
        return node.data;
    }

    #clear = node => {
        node.data = null;
        node.next = null;
        node.prev =null;
    }

    //count = () => this.#mCount;
    #head = () => this.#mHead;
    #tail = () => this.#mTail;
    #added = () => this.#mCount++;
    #removed = () => this.#mCount--;

}

module.exports = JSDoubleLinkedList;