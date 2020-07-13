package com.js.datastructuresalgorithms.hashtableseparatechaining;

import java.util.LinkedList;

public class JSHashTable <K, V> {

    //*******************
    // Private Members **
    //*******************
    private final static int DEFAULT_CAPACITY = 6;
    private final static double DEFAULT_LOAD_FACTOR = 0.75;
    private LinkedList<JSEntry<K, V>>[] mArray;
    private final int mCapacity;
    private final double mLoadFactor;

    public JSHashTable() { this(DEFAULT_CAPACITY); }

    public JSHashTable(int capacity) { this(capacity, DEFAULT_LOAD_FACTOR); }

    public JSHashTable(int capacity, double loadFactor)
    {
        mCapacity = capacity;
        mLoadFactor = loadFactor;
    }

    public boolean put(K key, V value) {
        JSEntry<K, V> entry = new JSEntry<>(key, value);
        LinkedList<JSEntry<K, V>> bucket = list(entry);
        boolean added = false;
        if(!bucket.contains(entry)) {
            bucket.add(entry);
            added = true;
        }
        return added;
    }

    public V get(K key) { return find(key).value(); }

    public boolean remove(K key) {
        LinkedList<JSEntry<K, V>> bucket = list(key);
        return bucket.remove(find(key));
    }

    public boolean contains(K key) { return find(key) != null; }

    //*******************
    // Private Members **
    //*******************

    private JSEntry<K, V> find(K key) {
        LinkedList<JSEntry<K, V>> bucket = list(key);
        JSEntry<K, V> found = null;
        for(JSEntry<K, V> next : bucket) {
            found = next.key().equals(key) ? next : found;
        }
        return found;
    }

    private LinkedList<JSEntry<K, V>> list(JSEntry<K, V> entry) { return list(entry.key()); }

    private LinkedList<JSEntry<K, V>> list(K key) { return list(key.hashCode()); }

    private LinkedList<JSEntry<K, V>> list(int hash) { return listFromIndex(hash % capacity()); }

    private LinkedList<JSEntry<K, V>> listFromIndex(int index) {
        if(array()[index] == null) {
            array()[index] = new LinkedList<JSEntry<K, V>>();
        }
        return array()[index];
    }

    private LinkedList<JSEntry<K, V>>[] array() { return mArray == null ? mArray = new LinkedList[10] : mArray; }

    private int capacity() { return mCapacity; }
}
