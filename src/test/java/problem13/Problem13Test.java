package problem13;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Problem13Test {

    Problem13 problem13 = new Problem13();
    String case1 = "III";
    String case2 = "LVIII";
    String case3 = "MCMXCIV";
    String case4 = "DCXXI";

    @Test
    void romanToInt() {
        assertEquals(3, problem13.romanToInt(case1));
        assertEquals(58, problem13.romanToInt(case2));
        assertEquals(1994, problem13.romanToInt(case3));
        assertEquals(621, problem13.romanToInt(case4));
    }
}
