package problem4;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public final class Problem4 {

    public static void main(String[] args) {

        // Case 1
        int[] case1Array1 = {1,3};
        int[] case1Array2 = {2};
        System.out.println(findMedianSortedArrays(case1Array1, case1Array2));

        // Case 2
        int[] case2Array1 = {1,2};
        int[] case2Array2 = {3,4};
        System.out.println(findMedianSortedArrays(case2Array1, case2Array2));
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {

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
            return  (double) ((int) combinedList.get((combinedListSize/2) -1) + (int) combinedList.get(combinedListSize/2)) / 2;
        }
        // Odd
        else {
            return (double) combinedList.get(Math.round(combinedListSize/2));
        }
    }
}
