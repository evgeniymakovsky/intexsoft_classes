package com.makovsky.classes02_01072017.interfaces;

/**
 * Class D implements A and B
 */
public class D implements A, B {

    @Override
    public void doSomething() {
        System.out.println("Hello World!");
    }


    @Override
    public void doSomethingForB() {
        System.out.println("B");
    }

    @Override
    public void doSomethingForA() {
        System.out.println("A");
    }
}
