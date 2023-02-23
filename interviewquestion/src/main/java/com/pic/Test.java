package com.pic;

class A {
    public void f1() {
        System.out.println("A-f1");
    }

    public void f2() {
        System.out.println("A-f2");
    }
}

class B extends A {
    public void f1() {
        System.out.println("B-f1");
    }
}

public class Test {
    public static void main(String[] args) {
        A a = new B();
        a.f1();
        a.f2();
    }
}

