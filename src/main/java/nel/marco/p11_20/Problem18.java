package nel.marco.p11_20;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutionException;

/*
By starting at the top of the triangle below and moving to adjacent numbers on the row below, the maximum total from top to bottom is 23.

3
7 4
2 4 6
8 5 9 3

That is, 3 + 7 + 4 + 9 = 23.

Find the maximum total from top to bottom of the triangle below:

75
95 64
17 47 82
18 35 87 10
20 04 82 47 65
19 01 23 75 03 34
88 02 77 73 07 63 67
99 65 04 28 06 16 70 92
41 41 26 56 83 40 80 70 33
41 48 72 33 47 32 37 16 94 29
53 71 44 65 25 43 91 52 97 51 14
70 11 33 28 77 73 17 78 39 68 17 57
91 71 52 38 17 14 91 43 58 50 27 29 48
63 66 04 68 89 53 67 30 73 16 69 87 40 31
04 62 98 27 23 09 70 98 73 93 38 53 60 04 23

ANSWER = 1074

NOTE: As there are only 16384 routes, it is possible to solve this problem by trying every route. However, Problem 67, is the same challenge with a triangle containing one-hundred rows; it cannot be solved by brute force, and requires a clever method! ;o)
 */
public class Problem18 {


    public static void main(String args[]) {
        try {
            new Problem18();
        } catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();
        }
    }


    public Problem18() throws ExecutionException, InterruptedException {

        String pyramidText = """
                75
                95 64
                17 47 82
                18 35 87 10
                20 04 82 47 65
                19 01 23 75 03 34
                88 02 77 73 07 63 67
                99 65 04 28 06 16 70 92
                41 41 26 56 83 40 80 70 33
                41 48 72 33 47 32 37 16 94 29
                53 71 44 65 25 43 91 52 97 51 14
                70 11 33 28 77 73 17 78 39 68 17 57
                91 71 52 38 17 14 91 43 58 50 27 29 48
                63 66 04 68 89 53 67 30 73 16 69 87 40 31
                04 62 98 27 23 09 70 98 73 93 38 53 60 04 23
                """;


        long[][] pyramid = populatePyramid(pyramidText);

        updatePyramidSumPath(pyramid);
        long largest = findLargestValueInRow(pyramid[0]);
        System.out.println("largest = " + largest);
    }

    private void updatePyramidSumPath(long[][] pyramid) {
        for (int i = pyramid.length - 1; i > 0; i--) {
            for (int j = 0; j < pyramid[i].length - 1; j++) {
                long value1 = pyramid[i][j];
                long value2 = pyramid[i][j + 1];
                long value = Math.max(value1, value2);
                pyramid[i - 1][j] = value + pyramid[i - 1][j];
                pyramid[i][j] = 0L;
            }
        }
    }

    private long[][] populatePyramid(String pyramidText) {

        List<String[]> strings = Arrays.stream(pyramidText.split("\n")).map(s -> {
            if (s.contains(" "))
                return s.split(" ");
            return new String[]{s};
        }).toList();

        String[] lastRow = strings.get(strings.size() - 1);

        long[][] pyramid = new long[lastRow.length][lastRow.length];

        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < strings.get(i).length; j++) {
                pyramid[i][j] = Long.parseLong(strings.get(i)[j]);
            }
        }

        return pyramid;
    }

    private long findLargestValueInRow(long[] longs) {
        long largest = 0;
        for (int i = 0; i < longs.length; i++) {
            largest = Math.max(largest, longs[i]);
        }
        return largest;
    }


}
