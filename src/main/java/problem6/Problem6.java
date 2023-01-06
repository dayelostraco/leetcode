package problem6;

/**
 * @author dayel
 * @since 2023-01-05T17:09:21Z
 *
 * INCOMPLETE SOLUTION
 */

public class Problem6 {

    /**
     * Converts a {@link String} of length 1<=s.length<=1000 into a zig-zag pattern such as:
     * Input: s = "PAYPALISHIRING", numRows = 4
     * <p>
     * P     I    N
     * A   L S  I G
     * Y A   H R
     * P     I
     * <p>
     * Output: PINALSIGYAHRPI which represents each rows chars written in the left-right order (sans spaces)
     * starting from row 1 and ascending to rwo n
     *
     * @param s       {@link String}
     * @param numRows int
     * @return String
     */
    public static String convert(String s, int numRows) {

        if (s.length() <= 1 || numRows == 1) return s;

        // this is the more efficient class to add substring to
        StringBuilder sb = new StringBuilder();

        // here we are looping for every row and inserting its chars in order
        for (int i = 0; i < numRows; i++) {
            for (int j = i; j < s.length(); j += numRows + (numRows - 2)) {
                sb.append(s.charAt(j)); // this is the regular case

                // this is the special case when there is another char to add from the diagonal
                if ((i != 0 && i != numRows - 1) && j + (2 * (numRows - i - 1)) <= s.length()) {
                    sb.append(s.charAt(j + (2 * (numRows - i - 1))));
                }
            }
        }
        return sb.toString();
//        }

    }

    public static void main(String[] args) {
//        System.out.println(convert("PAYPALISHIRING", 1));
//        System.out.println(convert("PAYPALISHIRING", 2));
//        System.out.println(convert("PAYPALISHIRING", 3));
        System.out.println(convert("PAYPALISHIRING", 4));
//        System.out.println(convert("PAYPALISHIRING", 5));
//        System.out.println(convert("PAYPALISHIRING", 6));
//        System.out.println(convert("PAYPALISHIRING", 7));

    }
}
