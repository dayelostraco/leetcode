package problem4;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public final class Problem4 {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        List<Integer> combinedList = new ArrayList<>();
        for (int i : nums1) {
            combinedList.add(i);
        }
        for(int j : nums2) {
            combinedList.add(j);
        }
        combinedList.sort(Comparator.naturalOrder());

        // Even
        int combinedListSize = combinedList.size();
        if (combinedList.size() % 2 == 0) {
            return  (double) (combinedList.get((combinedListSize/2) -1) + combinedList.get(combinedListSize/2)) / 2;
        }
        // Odd
        else {
            return (double) combinedList.get(Math.round(combinedListSize/2));
        }
    }
}
