package nel.marco.p21_30;

import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

/*
The Fibonacci sequence is defined by the recurrence relation:

Fn = Fn−1 + Fn−2, where F1 = 1 and F2 = 1.
Hence the first 12 terms will be:

F1 = 1
F2 = 1
F3 = 2
F4 = 3
F5 = 5
F6 = 8
F7 = 13
F8 = 21
F9 = 34
F10 = 55
F11 = 89
F12 = 144
The 12th term, F12, is the first term to contain three digits.

What is the index of the first term in the Fibonacci sequence to contain 1000 digits?

answer = 4782
 */
public class Problem25 {
    public static void main(String[] args) {
        try {
            new Problem25();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    List<BigInteger> fibonacci = new ArrayList<>();

    public Problem25() throws IOException {

        BigInteger first = BigInteger.ONE;
        BigInteger second = BigInteger.ONE;
        BigInteger last = BigInteger.ONE;
        fibonacci.add(first);
        fibonacci.add(second);

        while (last.toString().length() < 1000) {
            last = first.add(second);
            fibonacci.add(last);
            first = fibonacci.get(fibonacci.size() - 2);
            second = fibonacci.get(fibonacci.size() - 1);
        }

        System.out.println(first.toString().length());
        System.out.println(second.toString().length());

        System.out.println("answer = " + (fibonacci.size()));


    }


}
