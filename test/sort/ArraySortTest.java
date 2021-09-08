package sort;

/* Raj Kumar Boddupally created on 8/20/2021 inside the package - sort */

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

class ArraySortTest {
    static int[] toSort;
    static int[] sortedInts;
    static int[] sortedRangeInts;

    @BeforeAll
    static void setUp() {
        toSort = new int[]
                {5, 1, 89, 255, 7, 88, 200, 123, 66};
        sortedInts = new int[]
                {1, 5, 7, 66, 88, 89, 123, 200, 255};
        sortedRangeInts = new int[]
                {5, 1, 89, 7, 88, 200, 255, 123, 66};
    }

    @Test
    void givenIntArray_whenUsingSort_thenSortedArray() {
        Arrays.sort(toSort);
        Assertions.assertArrayEquals(sortedInts, toSort);
    }
}
