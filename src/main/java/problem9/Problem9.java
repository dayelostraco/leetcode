package problem9;

/**
 * @author dayel
 * @since 2023-01-06T14:15:05Z
 */
public class Problem9 {

    public boolean isPalindrome(int x) {

        // Convert the provided int x to a String wrapped in StringBuilder
        StringBuilder xString = new StringBuilder(x);

        // Use StringBuilder's reverse function
        return xString.toString().equals(xString.reverse().toString());
    }
}
