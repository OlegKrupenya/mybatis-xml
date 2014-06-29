package com.testdev.domain;

public enum Age {
    ENUM20(20), ENUM37(37), ENUM24(24), ENUM77(77), ENUM44(44), ENUM74(74), ENUM17(
            17), ENUM123(123);

    private Integer value;

    private Age(Integer value) {
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }
}
