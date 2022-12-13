package problem3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Problem3Test {

    Problem3 problem3 = new Problem3();
    Problem3Researched problem3Researched = new Problem3Researched();
    String case1 = "ggububgvfk";


    @Test
    void lengthOfLongestSubstring() {
        assertEquals(6, problem3.lengthOfLongestSubstring(case1));
    }

    @Test
    void lengthOfLongestSubstringOptimized() {
        assertEquals(6, problem3Researched.lengthOfLongestSubstring(case1));
    }
}
