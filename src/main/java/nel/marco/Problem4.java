package nel.marco;

/*
A palindromic number reads the same both ways. The largest palindrome made from the product of two 2-digit numbers is 9009 = 91 × 99.

Find the largest palindrome made from the product of two 3-digit numbers.
 */

public class Problem4 {

    public static void main(String[] args) {
        new Problem4();
    }


    public Problem4() {

        long largestPalindrome = 0;

        for (int i = 100; i < 1000; i++) {
            for (int j = i + 1; j < 1000; j++) {
                    long answer = i * j;
                    if (isPalindrome(String.valueOf(answer))) {

                        if (answer > largestPalindrome) {
                            largestPalindrome = answer;
                        }

                }
            }
        }

        System.out.println("answer = " + largestPalindrome);

    }

    public boolean isPalindrome(String number) {

        int startIndex = 0;
        int lastIndex = number.length() - 1;

        while (startIndex <= lastIndex) {
            if (number.charAt(startIndex++) != number.charAt(lastIndex--)) {
                return false;
            }
        }

        return true;

    }


}
