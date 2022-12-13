package problem1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Problem1Test {

    Problem1 problem1 = new Problem1();
    Problem1Researched problem1Researched = new Problem1Researched();
    int[] testCase1 = new int[]{2,7,11,15};
    int[] testCase2 = new int[]{3,2,4};
    int[] testCase3 = new int[]{3,3};

    @Test
    void twoSum() {
        assertArrayEquals(new int[]{0,1}, problem1.twoSum(testCase1, 9));
        assertArrayEquals(new int[]{1,2}, problem1.twoSum(testCase2, 6));
        assertArrayEquals(new int[]{0,1}, problem1.twoSum(testCase3, 6));
    }

    @Test
    void twoSumResearched() {
        assertArrayEquals(new int[]{0,1}, problem1Researched.twoSum(testCase1, 9));
        assertArrayEquals(new int[]{1,2}, problem1Researched.twoSum(testCase2, 6));
        assertArrayEquals(new int[]{0,1}, problem1Researched.twoSum(testCase3, 6));
    }
}
