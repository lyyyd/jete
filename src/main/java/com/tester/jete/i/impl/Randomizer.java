package com.tester.jete.i.impl;

import java.util.UUID;

/**
 * @ClassName Randomizer
 * @Description TODO
 * @Author David.Jackson.Lyd@gmail.com
 * @Date: 2020/05/16 18:09
 */
public class Randomizer {
    public String text() {
        return UUID.randomUUID().toString();
    }
}
