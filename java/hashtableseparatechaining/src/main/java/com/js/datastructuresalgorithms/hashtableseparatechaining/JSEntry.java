package com.js.datastructuresalgorithms.hashtableseparatechaining;

public class JSEntry <K, V> {

    //*****************
    // Class Members **
    //*****************
    private final K mKey;
    private final V mValue;
    private final int mHash;

    //***************
    // Constructor **
    //***************
    public JSEntry(K key, V value) {
        mKey = key;
        mValue = value;
        mHash = key.hashCode();
    }

    public int hashCode() { return mHash; }

    public boolean equal(JSEntry<K, V> other) { return hashCode() == other.hashCode() && key().equals(other.key()); }

    public String toString() { return key() + " => " + value(); }

    public K key() { return mKey; }

    public V value() { return mValue; }
}
