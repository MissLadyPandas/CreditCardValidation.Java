
package com.validation;

import java.util.Scanner;

public class CreditCardValidation {
    public static void main(String[] args) {
    	// use scanner to get user input
        Scanner input = new Scanner(System.in); 

        // ask user for cc number
        System.out.print("Enter a valid credit card number: ");
        long number = input.nextLong();

        // print if cc is valid or not
        System.out.println(number + " is " + (isValid(number) ? "a valid cc #." : "a invalid cc #."));
    }

    // Check if the credit card number is valid or not
    public static boolean isValid(long number) {
        return rangeSize(number) && hasValidPrefix(number) && hasValidSum(number);
    }

    // get the result from step 2, calculate the sum of even-place numbers after doubling them.
    public static int sumOfDoubleEvenPlace(long number) {
        int sum = 0;
        String numStr = Long.toString(number);
        for (int i = numStr.length() - 2; i >= 0; i -= 2) {
            sum += getDigit(Character.getNumericValue(numStr.charAt(i)) * 2);
        }
        return sum;
    }

    // Return number if single digit; else, return the sum of its digits.
    public static int getDigit(int number) {
        return number <= 9 ? number : number / 10 + number % 10;
    }

    // Sum of odd-place numbers.
    public static int sumOfOddPlace(long number) {
        int sum = 0;
        String numStr = Long.toString(number);
        for (int i = numStr.length() - 1; i >= 0; i -= 2) {
            sum += Character.getNumericValue(numStr.charAt(i));
        }
        return sum;
    }

    // verify the starting numbers of the credit card
    public static boolean hasValidPrefix(long number) {
        int[] validPrefixes = {4, 5, 37, 6};
        for (int prefix : validPrefixes) {
            if (getPrefix(number, String.valueOf(prefix).length()) == prefix) {
                return true;
            }
        }
        return false;
    }

    // Check if card number input range is between 13 and 16.
    public static boolean rangeSize(long number) {
        int size = getSize(number);
        return size >= 13 && size <= 16;
    }

    // Get the length of the number.
    public static int getSize(long number) {
        return Long.toString(number).length();
    }

    // Get the first k digits of the number.
    public static long getPrefix(long number, int k) {
        String numStr = Long.toString(number);
        return Long.parseLong(numStr.substring(0, k));
    }

    // Check if the total sum of numbers is valid.
    public static boolean hasValidSum(long number) {
        return (sumOfDoubleEvenPlace(number) + sumOfOddPlace(number)) % 10 == 0;
    }
}
