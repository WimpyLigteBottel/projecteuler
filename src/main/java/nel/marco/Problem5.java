package nel.marco;

/*

2520 is the smallest number that can be divided by each of the numbers from 1 to 10 without any remainder.

What is the smallest positive number that is evenly divisible by all of the numbers from 1 to 20?
*/
public class Problem5 {

    public static void main(String[] args) {
        new Problem5();
    }


    public Problem5() {

        long answer = 0;

        for (long i = 2520; i < 10000000000L; i++) {
            boolean dividable = true;
            // optimizing the query a bit because 1-10 everything can also be dividable by 11-20;
            for (int z = 11; z < 21; z++) {
                if (i % z != 0) {
                    dividable = false;
                    break;
                }
            }
            if(dividable){
                answer = i;
                break;
            }
        }

        System.out.println("answer = " + answer);

    }
}
