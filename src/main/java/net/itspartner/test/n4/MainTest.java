package net.itspartner.test.n4;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Task:
 * 1) Implement interface BiggestNumberFinder to provide functionality of finding the biggest number from array
 * 2) Write unit tests for this class with JUnit
 */
public class MainTest implements BiggestNumberFinder {
    @Override
    public int findTheBiggestNumber(int[] numbers) {
        return Arrays.stream(numbers).max().getAsInt();
    }

    @Test
    void findTheBiggestNumberTest() {
        assertEquals(4123, this.findTheBiggestNumber(
                new int[]{2, 4, 345, 123, 634, 123, 4123, 5}), "must be 4123");
        assertEquals(999_999_999, this.findTheBiggestNumber(
                new int[]{34, 32, 4564, 0, -12314, 999_999_999}), "must be 999_999_999");
    }
}
