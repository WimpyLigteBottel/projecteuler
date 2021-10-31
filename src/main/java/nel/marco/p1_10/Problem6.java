package nel.marco.p1_10;

import java.math.BigDecimal;

/*

The sum of the squares of the first ten natural numbers is, 1^2+2^2...10^2 = 385

The square of the sum of the first ten natural numbers is,(1 + 2 + ... + 10)^2 = 55^2 = 3025

Hence the difference between the sum of the squares of the first ten natural numbers and the square of the sum is .
3025 - 385 = 2640

Find the difference between the sum of the squares of the first one hundred natural numbers and the square of the sum.

*/
public class Problem6 {

    public static void main(String[] args) {
        new Problem6();
    }


    public Problem6() {


        // 1 - 100
        long squareNumbers = 0;
        for (int i = 1; i < 101; i++) {
            squareNumbers += BigDecimal.valueOf(i).pow(2).longValue();
        }

        // 1 - 100
        long sumNumbers = 0;
        for (int i = 1; i < 101; i++) {
            sumNumbers += i;
        }
        sumNumbers = sumNumbers * sumNumbers;

        long answer = sumNumbers - squareNumbers;


        System.out.println("answer = " + answer);


    }
}
