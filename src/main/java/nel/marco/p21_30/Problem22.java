package nel.marco.p21_30;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

/*
Using names.txt (right click and 'Save Link/Target As...'), a 46K text file containing over five-thousand first names, begin by sorting it into alphabetical order. Then working out the alphabetical value for each name, multiply this value by its alphabetical position in the list to obtain a name score.

For example, when the list is sorted into alphabetical order, COLIN, which is worth 3 + 15 + 12 + 9 + 14 = 53, is the 938th name in the list. So, COLIN would obtain a score of 938 × 53 = 49714.

What is the total of all the name scores in the file?
 */
public class Problem22 {
    public static void main(String[] args) {
        try {
            new Problem22();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    Map<String, Integer> map = new HashMap<>();

    public Problem22() throws IOException {


        long before = System.currentTimeMillis();
        for (char i = 'A'; i <= 'Z'; i++) {
            map.put(i + "", ((int) i) - 64);
        }

        List<String> strings = Files.readAllLines(Path.of("src/main/resources/p022_names.txt"));
        String replacedQuotes = strings.get(0).replaceAll("\"", "");

        List<String> unSortedList = Arrays.stream(replacedQuotes.split(",")).toList();

        List<String> sortedList = new ArrayList<>(new TreeSet<>(unSortedList));

        long totalValue = 0;
        for (long i = 0; i < sortedList.size(); i++) {
            String word = sortedList.get((int) i);
            int sum = Arrays.stream(word.split(""))
                    .map(s1 -> map.get(s1))
                    .mapToInt(Integer::intValue)
                    .sum();

            totalValue += sum * (i + 1);
        }

        long after = System.currentTimeMillis();
        System.out.println("Took milliseconds =" + (after - before));
        System.out.println("answer = " + totalValue);


    }


}
