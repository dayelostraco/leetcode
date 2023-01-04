package problem5;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Problem5Test {

    Problem5 problem5 = new Problem5();

    String case1 = "babad";
    String case2 = "cbbd";

    @Test
    void longestPalindrome() {
        assertEquals("aba", Problem5.longestPalindrome(case1));
        assertEquals("bb", Problem5.longestPalindrome(case2));
    }
}
