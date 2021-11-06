package nel.marco.p21_30;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

/*
A permutation is an ordered arrangement of objects. For example, 3124 is one possible permutation of the digits 1, 2, 3 and 4.
If all of the permutations are listed numerically or alphabetically, we call it lexicographic order. The lexicographic permutations of 0, 1 and 2 are:

012   021   102   120   201   210

What is the millionth lexicographic permutation of the digits 0, 1, 2, 3, 4, 5, 6, 7, 8 and 9?

answer = 2783915460
 */
public class Problem24 {
    public static void main(String[] args) {
        try {
            new Problem24();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    List<String> lexicographic = new ArrayList<>();


    public Problem24() throws IOException {

        List<String> numbers = IntStream.range(0, 10).boxed().map(String::valueOf).toList();
        String text = String.join("", numbers);

//        printAllRecursive(text.toCharArray(), text.length() - 1);

        permuteRecursive(text.length(), text.toCharArray());

//        lexicographic = new ArrayList<>(new TreeSet<>(lexicographic));

        lexicographic = lexicographic.stream().sorted().toList();
        System.out.println("answer = " + lexicographic.get(1_000_000 - 1)); // starts at 0


    }

    void permuteRecursive(int n, char[] elements) {

        if (n == 1) {


            String join = Arrays.toString(elements)
                    .replaceAll(", ", "")
                    .replaceAll("\\[", "")
                    .replaceAll("]", "");
            lexicographic.add(join);
        } else {
            for (int i = 0; i < n - 1; i++) {
                permuteRecursive(n - 1, elements);
                if (n % 2 == 0) {
                    swap(elements, i, n - 1);
                } else {
                    swap(elements, 0, n - 1);
                }
            }
            permuteRecursive(n - 1, elements);
        }
    }

    private void swap(char[] input, int a, int b) {
        char tmp = input[a];
        input[a] = input[b];
        input[b] = tmp;
    }

    private void printArray(char[] input) {
        System.out.print('\n');
        for (int i = 0; i < input.length; i++) {
            System.out.print(input[i]);
        }
    }

}
