package nel.marco.p11_20;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ExecutionException;

/*
215 = 32768 and the sum of its digits is 3 + 2 + 7 + 6 + 8 = 26.

What is the sum of the digits of the number 2^1000?

answer = 1366

 */
public class Problem16 {


    public static void main(String args[]) {
        try {
            new Problem16();
        } catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();
        }
    }



    public Problem16() throws ExecutionException, InterruptedException {
        BigInteger value = BigInteger.valueOf(2);

        value = value.pow(1000);

        long sum = Arrays.stream(value.toString().split("")).mapToLong(Long::valueOf).sum();
        System.out.println(sum);

    }


}
