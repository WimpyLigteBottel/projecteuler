package nel.marco.p11_20;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ExecutionException;

/*
Starting in the top left corner of a 2×2 grid
and only being able to move to the right and down, there are exactly 6 routes to the bottom right corner.


How many such routes are there through a 20×20 grid?

possible movements 137846528820 (cheated) <<< need to find a faster way

 */
public class Problem15 {


    public static void main(String args[]) {
        try {
            new Problem15();
        } catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    Set<String> moves = new HashSet<>();


    public Problem15() throws ExecutionException, InterruptedException {

        String possibleMoves = "D".repeat(20) + "R".repeat(20);

        recursive(possibleMoves.toCharArray(), possibleMoves.toCharArray().length);

        System.out.println(moves);
        System.out.println(moves.size());
    }

    void recursive(char[] array, int n) {
        if (n == 1) {
            moves.add(String.valueOf(array));
        } else {
            for (int i = 0; i < n; i++) {
                recursive(array, n - 1);


                char[] newArray = Arrays.copyOf(array, array.length);
                swap(newArray, n % 2 == 0 ? i : 0, n - 1);

                if (String.valueOf(newArray).equals(String.valueOf(array))) {
                    break;
                }

                swap(array, n % 2 == 0 ? i : 0, n - 1);
            }
        }
    }


    void swap(char[] array, int a, int b) {
        char o = array[a];
        array[a] = array[b];
        array[b] = o;
    }

}
