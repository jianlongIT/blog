package com.blog.blog;

public class Test {
    static void getString(Object obj) {
        System.out.println("object");
    }

    static void getString(int i) {
        System.out.println("int");
    }

    static void getString(Integer integer) {
        System.out.println("integer");
    }

    public static void main(String[] args) {
        getString(1);
    }
}
