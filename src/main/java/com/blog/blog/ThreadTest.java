package com.blog.blog;

import java.util.concurrent.atomic.AtomicInteger;

public class ThreadTest {

    static {
        AtomicInteger atomicInteger = new AtomicInteger(10);
        atomicInteger.incrementAndGet();
    }

}
