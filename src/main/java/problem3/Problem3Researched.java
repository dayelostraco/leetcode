package problem3;

public final class Problem3Researched {

    /**
     * The basic idea is just like the sliding window;
     * Three pointers: left, right, pointer;
     * Max length of substring: max
     * Every time, we just compare the char at pointer and position (right +1).
     * If they are the same, set left to be (pointer+1).
     * If not, we just increase right by 1 and update our max.
     */
    public int lengthOfLongestSubstring(String s) {
        int lp = 0;
        int rp = 0;
        int max = 0;

        if (s == null) return 0;
        if (s.length() == 1) return 1;

        while (rp < s.length() - 1 && lp <= rp) {
            int pointer = lp;
            while (pointer <= rp) {
                if (s.charAt(pointer) == s.charAt(rp + 1)) {
                    lp = pointer + 1;
                }
                pointer += 1;
            }
            rp += 1;
            if (rp - lp + 1 > max) {
                max = rp - lp + 1;
            }
        }
        return max;
    }
}
