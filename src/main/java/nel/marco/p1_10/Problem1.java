package nel.marco.p1_10;

/*
If we list all the natural numbers below 10 that are multiples of 3 or 5, we get 3, 5, 6 and 9. The sum of these multiples is 23.

Find the sum of all the multiples of 3 or 5 below 1000.*
 */

import java.util.Set;
import java.util.TreeSet;

public class Problem1 {

    public static void main(String[] args) {
        new Problem1();
    }


    public Problem1() {

        Set<Integer> uniqueSet = new TreeSet<>();


        int multiple3 = 3;
        int multiple5 = 5;
        while (true) {
            if (multiple5 > 1000 && multiple3 > 1000) {
                break;
            }

            if (multiple3 < 1000) {
                uniqueSet.add(multiple3);
            }
            if (multiple5 < 1000) {
                uniqueSet.add(multiple5);
            }
            multiple3 += 3;
            multiple5 += 5;

        }

        long answer = uniqueSet.stream().mapToLong(Integer::longValue).sum();

        System.out.println("answer = " + answer);

    }
}
