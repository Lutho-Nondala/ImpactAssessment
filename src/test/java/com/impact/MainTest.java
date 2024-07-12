package com.impact;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @org.junit.jupiter.api.Test
    void collect() {
        Main main = new Main();
        int[] value = main.collect("1,2,6,8,9");
        int[] test = {1,2,6,8,9};
        assertArrayEquals(test, value);
    }

    @org.junit.jupiter.api.Test
    void summarizeCollection() {
        Main main = new Main();
        int[] value1 = {1,2,6,8,9};
        int[] value2 = {1,3,6,8,9};
        int[] value3 = {1,3,6,7,9};

        String test1 = main.summarizeCollection(value1);
        String test2 = main.summarizeCollection(value2);
        String test3 = main.summarizeCollection(value3);

        assertAll(
                () -> assertEquals("1-2, 6, 8-9", test1),
                () ->  assertEquals("1, 3, 6, 8-9", test2),
                () ->  assertEquals("1, 3, 6-7, 9", test3)
        );
    }
}