package problem7;

/**
 * @author dayel
 * @since 2023-01-06T14:15:05Z
 */
public class Problem7 {

    /**
     * Reverses the digits of the provided int x while checking to make sure that the potential reversed value
     * does not exceed the MIN and MAX values of an unsigned int (2147483647, -2147483648).
     * If the potential reversed value does exceed the int(32) limits, method will return 0.
     *
     * @param x int
     * @return int
     */
    public int reverse(int x) {

        int reversedInt = 0;

        // Loop through each digit in reverse order using modulo 10
        while (x != 0) {

            // Retrieve digit using modulo 10
            int currentDigit = x % 10;

            // Pop off last digit for the next iteration in the while loop
            x = x / 10;

            /*
             * Determine if the present value of reversedInt exceeds the MAX positive limit of an unsigned int
             * without the last digit of 2147483647 (214748364)
             * OR
             * reversedInt equals the MAX positive limit of an unsigned int without the last digit of
             * 2147483647 (214748364) with the expected next currentDigit added to the current reversedInt value
             * taking the potential value of reversedInt above the Integer.MAX_VALUE of 2147483647
             */
            if (reversedInt > Integer.MAX_VALUE / 10 || (reversedInt == Integer.MAX_VALUE / 10 && currentDigit > 7)) {
                return 0;
            }

            /*
             * Determine if the present value of reversedInt exceeds the MIN negative limit of an unsigned int
             * without the last digit of -2147483648 (-214748364)
             * OR
             * reversedInt equals the MIN negative limit of an unsigned int without the last digit of
             * -2147483648 (-214748364) with the expected next currentDigit added to the current reversedInt value
             * taking the potential value of reversedInt below the Integer.MIN_VALUE of -2147483648
             */
            if (reversedInt < Integer.MIN_VALUE / 10 || (reversedInt == Integer.MIN_VALUE / 10 && currentDigit < -8)) {
                return 0;
            }

            // Add the next "last" digit to the next tens position
            reversedInt = reversedInt * 10 + currentDigit;
        }

        return reversedInt;
    }
}
