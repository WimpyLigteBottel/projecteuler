package nel.marco.p11_20;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;

/*
The following iterative sequence is defined for the set of positive integers:

n → n/2 (n is even)
n → 3n + 1 (n is odd)

Using the rule above and starting with 13, we generate the following sequence:

13 → 40 → 20 → 10 → 5 → 16 → 8 → 4 → 2 → 1
It can be seen that this sequence (starting at 13 and finishing at 1) contains 10 terms. Although it has not been proved yet (Collatz Problem), it is thought that all starting numbers finish at 1.

Which starting number, under one million, produces the longest chain?

NOTE: Once the chain starts the terms are allowed to go above one million.

answer = 837799
 */
public class Problem14 {


    public static void main(String args[]) {
        try {
            new Problem14();
        } catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    public Problem14() throws ExecutionException, InterruptedException {


        System.out.println("Bruteforce");
        bruteForce();
        System.out.println();
        System.out.println("Bruteforce with map");
        bruteForceWithMapHelp();

    }

    private void bruteForceWithMapHelp() {

        Map<Long, Long> map = new HashMap<>(1_000_000);
        long before = System.currentTimeMillis();
        long biggestChain = 0;
        long savedNumber = 0;
        for (long i = 1; i < 1_000_000; i++) {
            long counter =1;
            long currentNumber = i;
            while (currentNumber != 1) {
                Long mapResult = map.get(currentNumber);
                if (mapResult != null) {
                    counter += mapResult;
                    break;
                }
                if (currentNumber % 2 == 0) {
                    currentNumber = currentNumber / 2;
                    counter++;
                } else {
                    currentNumber = currentNumber * 3 + 1;
                    counter++;
                }
            }
            map.put(i, counter);
            biggestChain = Math.max(counter, biggestChain);

            if (counter == biggestChain) {
                savedNumber = i;
            }

        }
        System.out.println("total milisecond = " + (System.currentTimeMillis() - before));
        System.out.println("answer = " + savedNumber);

    }

    private void bruteForce() {

        long before = System.currentTimeMillis();
        int biggestChain = 0;
        long savedNumber = 0;
        for (long i = 1; i < 1_000_000; i++) {
            int counter = 0;
            long currentNumber = i;
            while (currentNumber != 1) {

                if (currentNumber % 2 == 0)
                    currentNumber = currentNumber / 2;
                else
                    currentNumber = currentNumber * 3 + 1;

                counter++;
            }
            biggestChain = Math.max(counter, biggestChain);

            if (counter == biggestChain) {
                savedNumber = i;
            }
        }
        System.out.println("total milisecond = " + (System.currentTimeMillis() - before));
        System.out.println("answer = " + savedNumber);
    }

}
