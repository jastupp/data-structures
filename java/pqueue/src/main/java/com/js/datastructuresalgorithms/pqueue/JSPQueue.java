package com.js.datastructuresalgorithms.pqueue;

import java.util.ArrayList;
import java.util.List;
//import java.util.Map;
//import java.util.Set;

public class JSPQueue<T extends Comparable<T>> {

    //*******************
    // Private Members **
    //*******************
    private List<T> mList;
    //private Map<T, Set<Integer>> mMap;

    public int size() { return array().size(); }

    public void enqeue(T item) {
        array().add(item);
        if(array().size() != 1) {
            bubbleUp(array().size() - 1);
        }
    }

    public T dequeue() {
        T result = item(0);
        swap(0, array().size() - 1);
        array().remove(array().size() - 1);
        bubbleDown();
        return result;
    }

    public T peek() { return item(0); }

    //*******************
    // Private Members **
    //*******************

    private void bubbleDown() {
        int index = 0;
        int lesser = lesserChild(index);
        while(lesser != -1 && compare(index, lesser) > 0) {
            swap(index, lesser);
            index = lesser;
            lesser = lesserChild(index);
        }
    }

    private void bubbleUp(int index) {
        int parent;
        while(compare(parent = parent(index), index) > 0) {
            swap(parent, index);
            index = parent;
        }
    }

    private int lesserChild(int index)
    {
        int left = left(index);
        int right = right(index);
        int lesser = left < size() ? left : -1;
        if(lesser != -1 && right < size()) {
            lesser = compare(left, right) > 0 ? right : lesser;
        }
        return lesser;
    }

    private T item(int index) { return index >= array().size() ? null : array().get(index); }

    private void swap(int one, int two) {
        T tmp = array().get(one);
        array().set(one, array().get(two));
        array().set(two, tmp);
    }
    //                 0
    //         1                2
    //     3       4        5        6
    //   7   8   9   10  11   12  13    14

    private int compare(int one, int two) { return compare(one, item(two)); }

    private int compare(int one, T two) { return compare(item(one), two); }

    private int compare(T one, T two) { return one == null ? -1 : one.compareTo(two); }

    private int parent(int current) { return current == 1 ? 0 : (current - 1) / 2; }

    private int left(int current) { return current * 2 + 1; }

    private int right(int current) { return current * 2 + 2; }

    private List<T> array() { return mList == null ? mList = new ArrayList<>() : mList; }

    //private Map<T, Set<Integer>> map() { return mMap == null ? mMap = new HashMap<T, Set<Integer>>() : mMap; }

    //private Set set(T key)
    //{
    //    if (!map().containsKey(key)) {
    //        map().put(key, new TreeSet<>());
    //    }
    //    return map().get(key);
    //}
}
