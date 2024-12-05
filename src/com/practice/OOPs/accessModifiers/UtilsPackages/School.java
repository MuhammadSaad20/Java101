package com.practice.OOPs.accessModifiers.UtilsPackages;

public class School {

    private static School schoolInstance;

    //private constructor
    private School(){

    }
    //Only a single time object created

    public static School getSchoolInstance(){
        if(schoolInstance==null){
             schoolInstance =new School();
        }
        return schoolInstance;
    }

}
