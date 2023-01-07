package problem45;

/**
 * @author dayel
 * @since 2023-01-07T04:02:34Z
 */
public class Problem45 {

    public int jump(int[] nums) {

        if(nums.length == 1) {
            return 0;
        }

        return calculateMinimizedJumps(nums, nums.length-1, 0);
    }

    private int calculateMinimizedJumps(int[] nums, int currentLandingIndex, int currentJumps) {

        int longestPossibleJumpIndex = currentLandingIndex - 1;
        for(int currentJumpIndex = currentLandingIndex - 1 ; currentJumpIndex >= 0 ; currentJumpIndex--) {

            if(nums[currentJumpIndex] >= currentLandingIndex - currentJumpIndex) {
                longestPossibleJumpIndex = currentJumpIndex;
            }
        }

        if(longestPossibleJumpIndex > 0) {
            return calculateMinimizedJumps(nums, longestPossibleJumpIndex, currentJumps + 1);
        } else {
            return currentJumps + 1;
        }
    }
}
