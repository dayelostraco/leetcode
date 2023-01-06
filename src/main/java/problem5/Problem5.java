package problem5;

/**
 * @author dayel
 * @since 2023-01-06T17:43:65Z
 *
 * Needs optimization to replace the need for storing the variables for longest values to int indices of the
 * provided s {@link String} rather than initializing and storing Strings in memory
 */
public class Problem5 {

    public static String longestPalindrome(String s) {

        String[] sArray = s.split("");

        String leftIndex;
        String index;
        String rightIndex;

        // Check min values
        if (sArray.length == 0) {

            // Returns initialized and empty longestPalindrome without having to create a new String in memory
            return "";
        } else if (sArray.length == 1) {
            return s;
        } else if (sArray.length == 2) {

            // Retrieve the first and second chars of the String for comparison
            index = sArray[0];
            rightIndex = sArray[1];

            return index.equals(rightIndex) ? index + rightIndex : index;

        } else {

            // Scan for Even Palindromes (where xssx where ss is the same char and x values are the same chars
            String longestEvenPalindrome = "";
            for (int i = 0; i < sArray.length; i++) {

                index = sArray[i];
                rightIndex = i + 1 < sArray.length ? sArray[i + 1] : "";

                if (index.equals(rightIndex)) {
                    String currentEvenPalindrome = index + rightIndex;

                    // Check each next outer String values from the current indices
                    for (int j = 1; j + i < sArray.length; j++) {

                        leftIndex = i - j >= 0 ? sArray[i - j] : "";
                        rightIndex = i + j + 1 < sArray.length ? sArray[i + j + 1] : "";

                        if (!leftIndex.equals("") && !rightIndex.equals("") &&
                                leftIndex.equals(rightIndex)) {

                            String newCurrentPalindrome = s.substring(i - j, i + j + 2);

                            longestEvenPalindrome = newCurrentPalindrome.length() > longestEvenPalindrome.length()
                                    ? newCurrentPalindrome : longestEvenPalindrome;
                        } else {
                            break;
                        }
                    }

                    longestEvenPalindrome = currentEvenPalindrome.length() > longestEvenPalindrome.length()
                            ? currentEvenPalindrome : longestEvenPalindrome;
                }
            }

            // Scan for Odd Palindromes (xsx where s is the single char and x values are the same chars
            String longestOddPalindrome = sArray[0];
            for (int i = 0; i < sArray.length ; i++) {

                // Retrieve sliding indices with a single char as the center
                rightIndex = i + 1 < sArray.length ? sArray[i + 1] : "";
                leftIndex = i > 0 ? sArray[i - 1] : "";

                if(leftIndex.equals(rightIndex)) {

                    // Check each next outer String values from the current indices
                    for (int j = 1 ; j + i < sArray.length ; j++) {

                        // Check to make sure that the next outer indices wouldn't exceed the length of s
                        if (i - j >= 0 && i + j < sArray.length) {

                            leftIndex = i - j >= 0 ? sArray[i - j] : "";
                            rightIndex = i + j < sArray.length ? sArray[i + j] : "";

                            if(leftIndex.equals(rightIndex)) {
                                String newCurrentPalindrome = s.substring(i - j, j + i + 1);

                                longestOddPalindrome = newCurrentPalindrome.length() > longestOddPalindrome.length()
                                        ? newCurrentPalindrome : longestOddPalindrome;
                            } else {
                                break;
                            }
                        }
                    }
                }
            }

            return longestEvenPalindrome.length() > longestOddPalindrome.length() ?
                    longestEvenPalindrome : longestOddPalindrome;
        }
    }

    public static void main(String[] args) {
        System.out.println(longestPalindrome("cbba"));
        System.out.println(longestPalindrome("cbbbb"));
        System.out.println(longestPalindrome("babad"));
        System.out.println(longestPalindrome("cbbbadbbbbacbba"));
        System.out.println(longestPalindrome("abb"));
        System.out.println(longestPalindrome("bb"));
        System.out.println(longestPalindrome("aaaa"));
        System.out.println(longestPalindrome("aaaaa"));
        System.out.println(longestPalindrome("abbcccbbbcaaccbababcbcabca"));
    }
}
