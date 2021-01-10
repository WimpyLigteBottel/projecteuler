package nel.marco;

import java.util.ArrayList;
import java.util.List;

/*
By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, we can see that the 6th prime is 13.

What is the 10 001st prime number?
*/
public class Problem7 {

    public static void main(String[] args) {
        new Problem7();
    }


    public Problem7() {


        List<Long> primeNumbers = new ArrayList<>();
        primeNumbers.add(2L);
        primeNumbers.add(3L);

        for (long i = 5; i < Long.MAX_VALUE; i++) {
            boolean isPrime = true;
            long maxValue = (long) Math.sqrt(i)+1;
            for (int j = 2; j < maxValue; j++) {
                if(i % j == 0){
                    isPrime = false;
                    break;
                }
            }

            if(isPrime){
                primeNumbers.add(i);

                if(primeNumbers.size()==10_002){
                    break;
                }
            }

        }


        System.out.println("10 001st prime = " + primeNumbers.get(10_001));


    }
}
