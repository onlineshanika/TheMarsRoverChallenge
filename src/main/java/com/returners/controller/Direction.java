package com.returners.controller;

import java.util.HashMap;
import java.util.Map;

public enum Direction {


    N("N"),
    S("S"),
    E("E"),
    W("W"),
    M("M"),
    L("L"),
    R("R");


    private static final Map<String, Direction> BY_DIRECTION = new HashMap<>();

    static {
        for (Direction e : values()) {
            BY_DIRECTION.put(e.getName(), e);
        }
    }

    private final String name;

    Direction(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }



    public static Direction directionBy(String value) {
        return BY_DIRECTION.get(value);
    }

}
//+---------------+
//        | Direction     |
//        +---------------+
//        | - name: String|
//        | - value: int  |
//        +---------------+
//        | + getName(): String   |
//        | + getValue(): int     |
//        +---------------+