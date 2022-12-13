package problem4;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Problem4Test {

    Problem4 problem4 = new Problem4();
    int[] case1Array1 = {1,3};
    int[] case1Array2 = {2};
    int[] case2Array1 = {1,2};
    int[] case2Array2 = {3,4};

    @Test
    void findMedianSortedArraysCase1() {
        assertEquals(2.0, problem4.findMedianSortedArrays(case1Array1, case1Array2));
    }

    @Test
    void findMedianSortedArraysCase2() {
        assertEquals(2.5, problem4.findMedianSortedArrays(case2Array1, case2Array2));
    }
}
