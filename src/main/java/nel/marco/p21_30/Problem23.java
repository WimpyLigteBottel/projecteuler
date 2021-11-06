package nel.marco.p21_30;

import java.io.IOException;
import java.math.BigInteger;
import java.util.*;
import java.util.stream.LongStream;

/*
A perfect number is a number for which the sum of its proper divisors is exactly equal to the number. For example, the sum of the proper divisors of 28 would be 1 + 2 + 4 + 7 + 14 = 28, which means that 28 is a perfect number.

A number n is called deficient if the sum of its proper divisors is less than n and it is called abundant if this sum exceeds n.

As 12 is the smallest abundant number, 1 + 2 + 3 + 4 + 6 = 16, the smallest number that can be written as the sum of two abundant numbers is 24.
By mathematical analysis, it can be shown that all integers greater than 28123 can be written as the sum of two abundant numbers.
However, this upper limit cannot be reduced any further by analysis even though it is known that the greatest number that
cannot be expressed as the sum of two abundant numbers is less than this limit.

Find the sum of all the positive integers which cannot be written as the sum of two abundant numbers.


answer = 4179871
 */
public class Problem23 {
    public static void main(String[] args) {
        try {
            new Problem23();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    Map<Long, Long> abundantNumber = new HashMap<>();
    Map<Long, Long> deficientNumber = new HashMap<>();
    Map<Long, Long> perfectNumber = new HashMap<>();

    public Problem23() throws IOException {


        updateMaps();

        List<Long> abundantNumbers = abundantNumber.entrySet().stream().map(Map.Entry::getKey).sorted().toList();
        Set<Long> abundantNumbersCombined = new TreeSet<>();


        for (int i = 0; i < abundantNumbers.size(); i++) {
            Long a = abundantNumbers.get(i);
            if(a > 28123)
                break;
            for (int j = 0; j < abundantNumbers.size(); j++) {
                Long b = abundantNumbers.get(j);
                abundantNumbersCombined.add(a + b);
            }
        }

        List<Long> numbersThatNotAbundantNumbers = new ArrayList<>(LongStream.rangeClosed(0, 28123).boxed().toList());

        abundantNumbersCombined.forEach(numbersThatNotAbundantNumbers::remove);

        System.out.println("answer = "+sumOfDivisors(numbersThatNotAbundantNumbers));


    }

    private void updateMaps() {
        for (long i = 1; i < 28123; i++) {
            BigInteger sum = sumOfDivisors(properDivisor(i));
            if (sum.longValue() == i) {
                perfectNumber.put(i, i);
            } else if (sum.longValue() > i) {
                abundantNumber.put(i, sum.longValue());
            } else {
                deficientNumber.put(i, sum.longValue());
            }
        }
    }


    public List<Long> properDivisor(long digit) {
        List<Long> digits = new ArrayList<>();
        long maxLength = (digit / 2) + 1;
        for (long i = 1; i < maxLength; i++) {
            if (digit % i == 0) {
                digits.add(i);
            }
        }

        return digits;
    }

    public BigInteger sumOfDivisors(List<Long> digits) {

        BigInteger total = BigInteger.ZERO;
        List<BigInteger> bigIntegers = digits.stream().map(BigInteger::valueOf).toList();
        for (BigInteger value : bigIntegers) {
            total = total.add(value);
        }

        return total;
    }


}
