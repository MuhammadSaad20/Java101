package com.practice.OOPs.Generics;

import java.util.ArrayList;

public class ProblemWithoutGenerics {
    public static void main(String[] args) {
        int [] arr= new int [1];
        ArrayList  arrayList = new ArrayList();
        arrayList.add(1);
        arrayList.add("Hello"); //Type safety issue class casting exception issue occurs

        Integer a = (Integer) arrayList.get(0);
        Object b=  arrayList.get(1);
        System.out.println(a);
        System.out.println(b);

    }
}
