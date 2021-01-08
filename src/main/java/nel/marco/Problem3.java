package nel.marco;

/*
The prime factors of 13195 are 5, 7, 13 and 29.

What is the largest prime factor of the number 600851475143 ?
 */

public class Problem3 {

    public static void main(String[] args) {
        new Problem3();
    }


    public Problem3() {


        long x = 600851475143L;
        long largestPrimeFactor = 0;

        double sqrt = Math.sqrt(x) + 1;
        for (int i = 3; i < sqrt; i++) {

            if (isPrime(i) && x % i == 0)
                if (i > largestPrimeFactor) {
                    largestPrimeFactor = i;
                }
        }

        System.out.println("answer = " + largestPrimeFactor);

    }

    private boolean isPrime(long number) {

        if (number % 2 == 0) {
            return false;
        }

        double sqrt = Math.sqrt(number) + 1;
        for (int i = 3; i < sqrt; i += 2) {

            if (number % i == 0) {
                return false;
            }


        }

        return true;
    }
}
