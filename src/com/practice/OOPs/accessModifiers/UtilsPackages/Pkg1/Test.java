package com.practice.OOPs.accessModifiers.UtilsPackages.Pkg1;

import com.practice.OOPs.accessModifiers.UtilsPackages.School;
import com.practice.OOPs.accessModifiers.UtilsPackages.Utils;

public class Test {
    public static void main(String[] args) {

        // Utility constructor is private, so we do not need to create its object
        System.out.println(Utils.utilMain());
        System.out.println(Utils.utilIsRun());

        System.out.println(School.getSchoolInstance());
        System.out.println(School.getSchoolInstance());


    }
}
