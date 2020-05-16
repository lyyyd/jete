package com.tester.jete.e;

/**
 * @EnumName AssertionMode
 * @Description Assertion modes available
 * @Author David.Jackson.Lyd@gmail.com
 * @Date: 2020/05/16 17:28
 */
public enum AssertionMode {
    /**
     * Default mode - tests are failing immediately
     */
    STRICT,
    /**
     * Test are failing only at the end of the methods.
     */
    SOFT
}
