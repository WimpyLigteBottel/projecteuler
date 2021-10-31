package nel.marco.p1_10;


/*

A Pythagorean triplet is a set of three natural numbers, a < b < c, for which,

a2 + b2 = c2
For example, 32 + 42 = 9 + 16 = 25 = 52.

There exists exactly one Pythagorean triplet for which a + b + c = 1000.
Find the product abc.

 */

public class Problem9 {

    public static void main(String[] args) {
        new Problem9();
    }


    public Problem9() {


        for (int i = 0; i < 500; i++) {
            double a = Math.pow(i, 2);
            for (int j = 0; j < 500; j++) {
                double b = Math.pow(j, 2);
                for (int k = 0; k < 500; k++) {
                    double c = Math.pow(k, 2);
                    if (a + b == c) {
                        if ((i + j + k) == 1000) {
                            System.out.println("answer: "+i * j * k);
                            return;
                        }
                    }
                }
            }
        }

    }
}
