package problem5;

public class Problem5 {

    public static String longestPalindrome(String s) {

        String[] sArray = s.split("");
        String longestPalindrome = sArray[0];
        String currentPalindrome = longestPalindrome;
        String index = "";
        String leftIndex = "";
        String rightIndex = "";

        for (int i = 0; i < sArray.length; i++) {

            // Store leftIndex
            leftIndex = i != 0 ? sArray[i - 1] : "";

            // Store index
            index = sArray[i];

            // Store rightIndex
            rightIndex = i != s.length()-1 ? sArray[i + 1] : "";

            // Odd length Palindrome check
            if (leftIndex.equals(rightIndex)) {
                currentPalindrome = determineLongestPalindromeFromStringIndex(s, leftIndex + index + rightIndex, i, 1);
            }
            // Even length Palindrome check
            else if (index.equals(leftIndex)) {
                currentPalindrome = determineLongestPalindromeFromStringIndex(s, leftIndex + index, i, 1);
            } else if (index.equals(rightIndex)) {
                currentPalindrome = determineLongestPalindromeFromStringIndex(s, index + rightIndex, i, 1);
            }

            // Replace longestPalindrome if currentPalindrome is longer
            if (currentPalindrome.length() > longestPalindrome.length()) {
                longestPalindrome = currentPalindrome;
            }
        }

        return longestPalindrome;
    }

    private static String determineLongestPalindromeFromStringIndex(
            String baseString, String currentPalindrome, int index, int width) {

        // Left and Right outer evaluation
        if ((index - width - 1) > 0 && (index + width + 1) < baseString.length() - 1) {

            width++;
            String nextEval = baseString.charAt(index - width) + currentPalindrome + baseString.charAt(index + width);
            if (isPalindrome(nextEval)) {
                return determineLongestPalindromeFromStringIndex(baseString, nextEval, index, width);
            } else {
                return currentPalindrome;
            }
        } else {
            return currentPalindrome;
        }
    }

    private static boolean isPalindrome(String s) {
        return new StringBuilder(s).reverse().toString().equals(s);
    }

    public static void main(String[] args) {
        System.out.println(longestPalindrome("cbba"));
        System.out.println(longestPalindrome("babad"));
        System.out.println(longestPalindrome("abb"));
        System.out.println(longestPalindrome("bb"));
        System.out.println(longestPalindrome("aaaa"));
    }
}
