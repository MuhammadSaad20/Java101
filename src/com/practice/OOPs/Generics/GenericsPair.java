package com.practice.OOPs.Generics;

public class GenericsPair<K,V> {

    private K key;
    private V val;

    public GenericsPair(K key, V val) {
        this.key = key;
        this.val = val;
    }

    public K getKey() {
        return key;
    }

    public V getVal() {
        return val;
    }

    public static void main(String[] args) {
        GenericsPair<String, Integer> obj= new GenericsPair<>("xyx", 123);
        System.out.println(obj.getKey());
        System.out.println(obj.getVal());
    }


}

