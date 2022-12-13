package problem1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Problem1Test {

    @Test
    void twoSum() {
        Problem1 problem1 = new Problem1();
        assertArrayEquals(problem1.twoSum(new int[]{2,7,11,15}, 9), new int[]{0,1});
        assertArrayEquals(problem1.twoSum(new int[]{3,2,4}, 6), new int[]{1,2});
        assertArrayEquals(problem1.twoSum(new int[]{3,3}, 6), new int[]{0,1});
    }

    @Test
    void twoSumResearched() {
        Problem1Researched problem1 = new Problem1Researched();
        assertArrayEquals(problem1.twoSum(new int[]{2,7,11,15}, 9), new int[]{0,1});
        assertArrayEquals(problem1.twoSum(new int[]{3,2,4}, 6), new int[]{1,2});
        assertArrayEquals(problem1.twoSum(new int[]{3,3}, 6), new int[]{0,1});
    }
}
