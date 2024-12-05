package com.practice.OOPs.Exceptions;

import com.practice.OOPs.Static.Student;

public class Test01 {

    public static void main(String[] args) {
        int [] numerator = {10,200,30,40};
        int [] denominator = {1,2,0,4};

        for(int i=0 ;i< numerator.length;i++){
            System.out.println(divide(numerator[i], denominator[i]));
        }
    }

    public static int divide(int a , int b){
        try{
            return a/b;
        }
        catch (RuntimeException e){
            System.out.println(e);
            return -1;
        }
    }
}
