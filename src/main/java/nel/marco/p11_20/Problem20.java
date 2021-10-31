package nel.marco.p11_20;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.concurrent.ExecutionException;

/*
n! means n × (n − 1) × ... × 3 × 2 × 1

For example, 10! = 10 × 9 × ... × 3 × 2 × 1 = 3628800,
and the sum of the digits in the number 10! is 3 + 6 + 2 + 8 + 8 + 0 + 0 = 27.

Find the sum of the digits in the number 100!


answer = 648

 */
public class Problem20 {


    public static void main(String args[]) {
        try {
            new Problem20();
        } catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();
        }
    }


    public Problem20() throws ExecutionException, InterruptedException {
        BigInteger nFactor = nFactor(BigInteger.valueOf(100L));
        System.out.println("answer = " + sumOfDigits(nFactor));
    }



    public BigInteger nFactor(BigInteger currentNumber) {
        if (currentNumber.compareTo(BigInteger.ONE) < 1) {
            return BigInteger.ONE;
        }
        return currentNumber.multiply(nFactor(currentNumber.subtract(BigInteger.ONE)));
    }

    public long sumOfDigits(BigInteger a) {
        return Arrays.stream(a.toString().split("")).mapToLong(Long::parseLong).sum();

    }


}
