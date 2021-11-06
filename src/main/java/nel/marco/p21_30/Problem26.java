package nel.marco.p21_30;


import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*

A unit fraction contains 1 in the numerator. The decimal representation of the unit fractions with denominators 2 to 10 are given:

1/2	= 	0.5
1/3	= 	0.(3)
1/4	= 	0.25
1/5	= 	0.2
1/6	= 	0.1(6)
1/7	= 	0.(142857)
1/8	= 	0.125
1/9	= 	0.(1)
1/10	= 	0.1
Where 0.1(6) means 0.166666..., and has a 1-digit recurring cycle. It can be seen that 1/7 has a 6-digit recurring cycle.

Find the value of d < 1000 for which 1/d contains the longest recurring cycle in its decimal fraction part.


answer = ????
 */
public class Problem26 {

    public static void main(String[] args) {
        new Problem26();
    }

    List<String> stringList = new ArrayList<>();

    public Problem26() {

        long before = System.currentTimeMillis();


        for (int i = 2; i < 1000; i++) {

            BigDecimal bigDecimal = new BigDecimal("1").setScale(1001, RoundingMode.HALF_EVEN);
            BigDecimal divisor = BigDecimal.valueOf(i).setScale(1001, RoundingMode.HALF_EVEN);
            bigDecimal = bigDecimal.divide(divisor, RoundingMode.HALF_EVEN);

//            stringList.add(bigDecimal.toString().substring(2));
            stringList.add(extractLongestRepeatingCharacter(bigDecimal.stripTrailingZeros().toString()));
        }

        long after = System.currentTimeMillis();

        System.out.println("answer = " + "");


        System.out.println("took ms=" + (after - before));


    }

    public String extractLongestRepeatingCharacter(String text) {

        text = text.substring(2);
        char[] chars = text.toCharArray();

        String temp = "" + text.charAt(0);

        long longest = 0;

        for (int i = 1; i < chars.length; i++) {
            temp = text.substring(0, i);

            String[] split = text.split(temp);
            split = Arrays.stream(split).filter(s -> !s.equals("")).toList().toArray(new String[0]);
            if (Arrays.stream(split).count() == 1) {
                return temp;
            }
        }


        return temp;
    }

}
