package com.validation;

import java.util.Scanner;

public class CreditCardValidation {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a credit card number as a long integer: ");
        long creditCardNumber = scanner.nextLong();
        System.out.println(creditCardNumber + (isValid(creditCardNumber) ? " is valid" : " is invalid"));
    }

    /** Return true if the card number is valid */
    public static boolean isValid(long number) {
        return (getSize(number) >= 13 && getSize(number) <= 16) && 
               (prefixMatched(number, 4) || 
                prefixMatched(number, 5) || 
                prefixMatched(number, 37) || 
                prefixMatched(number, 6)) &&
               ((sumOfDoubleEvenPlace(number) + sumOfOddPlace(number)) % 10 == 0);
    }

    /** Double every second digit from right to left and add them. */
    public static int sumOfDoubleEvenPlace(long number) {
        int sum = 0;
        String num = Long.toString(number);
        for (int i = num.length() - 2; i >= 0; i -= 2) {
            sum += getDigit(Integer.parseInt(num.charAt(i) + "") * 2);
        }
        return sum;
    }

    /**
     * If a number is a single digit return it, otherwise, 
     * return the sum of the two digits 
     */
    public static int getDigit(int number) {
        if (number < 10) {
            return number;
        } else {
            int firstDigit = number % 10;
            int secondDigit = number / 10;
            return firstDigit + secondDigit;
        }
    }

    /** Return sum of odd-place digits in the number */
    public static int sumOfOddPlace(long number) {
        int sum = 0;
        String num = Long.toString(number);
