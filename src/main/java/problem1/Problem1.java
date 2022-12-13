package problem1;

public final class Problem1 {

    public int[] twoSum(int[] values, int target) {

        // Loop through the array
        for(int i = 0 ; i< values.length ; i++) {

            // Nested for-loop
            for (int j = i + 1; j < values.length; j++) {
                if (values[i] + values[j] == target) {
                    return new int[]{i, j};
                }
            }
        }

        return null;
    }
}
