package nel.marco;

/*

The sum of the primes below 10 is 2 + 3 + 5 + 7 = 17.

Find the sum of all the primes below two million.
 */

public class Problem10 {
    public static void main(String[] args) {
        new Problem10();
    }


    public Problem10() {

        long sumOfAllPrimes = 2;

        for (long i = 3; i < 2_000_000L ; i++) {
            boolean isPrime = true;

            long maxValue = (long) Math.sqrt(i) + 1;
            for (int j = 2; j < maxValue; j++) {
                if (i % j == 0) {
                    isPrime = false;
                    break;
                }
            }

            if (isPrime) {
                sumOfAllPrimes += i;
            }

        }

        System.out.println("sumOfAllPrimes = " + sumOfAllPrimes);

    }
}
