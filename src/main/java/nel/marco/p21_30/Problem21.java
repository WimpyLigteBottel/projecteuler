package nel.marco.p21_30;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
Let d(n) be defined as the sum of proper divisors of n (numbers less than n which divide evenly into n).
If d(a) = b and d(b) = a, where a ≠ b, then a and b are an amicable pair and each of a and b are called amicable numbers.

For example, the proper divisors of 220 are 1, 2, 4, 5, 10, 11, 20, 22, 44, 55 and 110; therefore d(220) = 284. The proper divisors of 284 are 1, 2, 4, 71 and 142; so d(284) = 220.

Evaluate the sum of all the amicable numbers under 10000.


10000
took in ms = 170
answer = 31626


100000
took in ms = 11828
answer = 852810
 */
public class Problem21 {
    public static void main(String[] args) {
        new Problem21();
    }

    Map<Long, Long> map = new HashMap<>();

    public Problem21() {

        long before = System.currentTimeMillis();
        for (long i = 1; i < 10000; i++) {

            long a = sumOfDivisors(properDivisor(i));
            long b = sumOfDivisors(properDivisor(a));

            if (a != b && b == i) {
                if (map.get(a) == null && map.get(b) == null) {
                    map.put(i, a);
                }
            }
        }

        long sum = 0;
        for (Map.Entry<Long, Long> entry : map.entrySet()) {
            sum += entry.getKey();
            sum += entry.getValue();
        }

        long after = System.currentTimeMillis();

        System.out.println("took in ms = " + (after - before));
        System.out.println("answer = " + sum);
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

    public long sumOfDivisors(List<Long> digits) {
        return digits.stream().mapToLong(Long::longValue).sum();
    }
}
