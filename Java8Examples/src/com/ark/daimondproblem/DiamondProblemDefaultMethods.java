package com.ark.daimondproblem;

/**
 * Illustration of diamond problem caused due to the default method
 * Resolution of diamond problem with examples
 */
public class DiamondProblemDefaultMethods {

    /**
     * Diamond problem happend in programming languages that supports multiple inheritance
     * and child class inherit from multiple parents with the same method signature
     * <p>
     * <p>
     * But java does not support multiple inheritance, but since java 8 introduced the default
     * methods in interfaces and it is possible that same signature method available
     * in multiple interfaces so the same problem might be arised
     */

    public static void main(String[] args) {
        new Class1().print();//It chooses the nearest interface (most specific which is MyInterface2)
        new Class2().print();
        new Class3().print();
        new Class4().print();
        new Class5().print();
        new Class6().print();//Print from class6 as already overridden
        new Class7().print();//Print from class6 as class wins over interfaces
        new Class8().print();//Explicit Resolution using super
    }
}

interface MyInterface1 {

    default void print() {
        System.out.println("Print from MyInterface1");
    }

}

interface MyInterface2 extends MyInterface1 {
    default void print() {
        System.out.println("Print from MyInterface2");
    }
}

class Class1 implements MyInterface1, MyInterface2 {


}

class Class2 extends Class1 implements MyInterface1 {

}

class Class3 extends Class1 implements MyInterface1, MyInterface2 {

}

class Class4 extends Class1 implements MyInterface2, MyInterface1 {

}

class Class5 implements MyInterface2, MyInterface1 {

}

class Class6 extends Class1 implements MyInterface1, MyInterface2 {
    public void print() {
        System.out.println("Print from class 6, class wins in battle of classes and interfaces");
    }
}

class Class7 extends Class6 implements MyInterface1, MyInterface2 {

}

interface MyInterface3 {
    default void print() {
        System.out.println("Print from MyInterface3");
    }
}

interface MyInterface4 {
    default void print() {
        System.out.println("Print from MyInterface4");
    }
}

class Class8 implements MyInterface4, MyInterface3 {
    public void print() {
        //Explicitly resolve the conflict by identifying which interface to call
        MyInterface4.super.print();//Commenting this line create the diamond problem
    }
}