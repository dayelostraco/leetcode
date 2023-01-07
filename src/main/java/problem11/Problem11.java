package problem11;

/**
 * @author dayel
 * @since 2023-01-07T02:55:81Z
 */
public class Problem11 {

    public int maxArea(int[] height) {

        int maxArea = 0;

        // Column 1 comparison
        for(int i = 0 ; i < height.length ; i++) {

            int col1 = height[i];

            // Column 2 Comparison
            for(int j = i+1 ; j < height.length ; j++) {

                int col2 = height[j];
                int lowestCurrentColumn = col1 <= col2 ? col1 : col2;
                int colPairArea = lowestCurrentColumn * (j-i);

                if(colPairArea > maxArea) {
                    maxArea = colPairArea;
                }
            }
        }

        return maxArea;
    }
}
