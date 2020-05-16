package com.tester.jete.i.impl;

import java.util.function.Predicate;

import static java.lang.System.currentTimeMillis;

/**
 * @ClassName Waiter
 * @Description TODO
 * @Author David.Jackson.Lyd@gmail.com
 * @Date: 2020/05/16 18:17
 */
public class Waiter {
    public <T> void wait(T subject, Predicate<T> condition, long timeout, long pollingInterval) {
        for (long start = currentTimeMillis();
             !isTimeoutExceeded(timeout, start) && !condition.test(subject); ) {
            sleep(pollingInterval);
        }
    }

    private boolean isTimeoutExceeded(long timeout, long start) {
        return currentTimeMillis() - start > timeout;
    }

    void sleep(long milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }
    }
}
