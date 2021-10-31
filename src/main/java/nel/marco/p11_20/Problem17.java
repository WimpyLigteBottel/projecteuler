package nel.marco.p11_20;

import java.util.concurrent.ExecutionException;

import static nel.marco.p11_20.Problem17.e10_19.*;
import static nel.marco.p11_20.Problem17.e1_9.*;
import static nel.marco.p11_20.Problem17.e20_90.*;

/*
If the numbers 1 to 5 are written out in words: one, two, three, four, five, then there are 3 + 3 + 5 + 4 + 4 = 19 letters used in total.

If all the numbers from 1 to 1000 (one thousand) inclusive were written out in words, how many letters would be used?


NOTE: Do not count spaces or hyphens. For example, 342 (three hundred and forty-two) contains 23 letters and 115 (one hundred and fifteen) contains 20 letters. The use of "and" when writing out numbers is in compliance with British usage.

my answer -> 21124

 */
public class Problem17 {


    public static void main(String args[]) {
        try {
            new Problem17();
        } catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();
        }
    }


    public Problem17() throws ExecutionException, InterruptedException {


        int total = 0;
        for (int i = 1; i <= 1000; i++) {
            String fullText = processNumbers("", i);
//            System.out.println(fullText);
            fullText = replaceUncountedCharacters(fullText);
            total += fullText.length();
        }

        System.out.println("answer = " + total);

    }

    private String replaceUncountedCharacters(String text) {
        return text.replaceAll("_", "").replaceAll(" ", "");
    }

    public String processNumbers(String text, int digit) {


        if (digit > 0 && digit < 10) {
            text += convertSingleDigit(digit);
        } else if (digit >= 10 && digit < 20) {
            text += convertDoubleLowerDigit(digit);
        } else if (digit >= 20 && digit < 100) {
            int newDigit = digit;
            if (digit % 10 != 0) {
                newDigit = Integer.parseInt((digit + "").charAt(0) + "");
                newDigit *= 10;
            }
            text += convertDoubleUpperDigit(newDigit) + " ";
            return processNumbers(text, digit - newDigit);
        } else if (digit >= 100 && digit <= 1000) {
            int newDigit = digit;

            if (digit % 100 != 0) {
                newDigit = Integer.parseInt((digit + "").charAt(0) + "");
                newDigit *= 100;
            }
            text += convertTripleDigit(newDigit).replace("_", " ") + " AND ";
            return " " + processNumbers(text, digit - newDigit);
        }

        if (text.endsWith(" AND ")) {
            text = text.substring(0, text.length() - " AND ".length());
        }

        return text;
    }


    private String convertSingleDigit(int digit) {

        e1_9 s = switch (digit) {
            case 1 -> ONE;
            case 2 -> TWO;
            case 3 -> THREE;
            case 4 -> FOUR;
            case 5 -> FIVE;
            case 6 -> SIX;
            case 7 -> SEVEN;
            case 8 -> EIGHT;
            case 9 -> NINE;
            default -> throw new RuntimeException("failed");
        };

        return s.name();
    }

    private String convertDoubleLowerDigit(int digit) {

        e10_19 s = switch (digit) {
            case 10 -> TEN;
            case 11 -> ELEVEN;
            case 12 -> TWELVE;
            case 13 -> THIRTEEN;
            case 14 -> FOURTEEN;
            case 15 -> FIFTEEN;
            case 16 -> SIXTEEN;
            case 17 -> SEVENTEEN;
            case 18 -> EIGHTEEN;
            case 19 -> NINETEEN;
            default -> throw new RuntimeException("failed");
        };

        return s.name();
    }

    private String convertDoubleUpperDigit(int digit) {
        e20_90 s = switch (digit) {
            case 20 -> TWENTY;
            case 30 -> THIRTY;
            case 40 -> FORTY;
            case 50 -> FIFTY;
            case 60 -> SIXTY;
            case 70 -> SEVENTY;
            case 80 -> EIGHTY;
            case 90 -> NINETY;
            default -> throw new RuntimeException("failed");
        };

        return s.name();
    }

    private String convertTripleDigit(int digit) {


        e100_1000 s = switch (digit) {
            case 100 -> e100_1000.ONE_HUNDRED;
            case 200 -> e100_1000.TWO_HUNDRED;
            case 300 -> e100_1000.THREE_HUNDRED;
            case 400 -> e100_1000.FOUR_HUNDRED;
            case 500 -> e100_1000.FIVE_HUNDRED;
            case 600 -> e100_1000.SIX_HUNDRED;
            case 700 -> e100_1000.SEVEN_HUNDRED;
            case 800 -> e100_1000.EIGHT_HUNDRED;
            case 900 -> e100_1000.NINE_HUNDRED;
            case 1000 -> e100_1000.ONE_THOUSAND;
            default -> throw new RuntimeException("failed");
        };


        return s.name();
    }


    enum e1_9 {
        ONE,
        TWO,
        THREE,
        FOUR,
        FIVE,
        SIX,
        SEVEN,
        EIGHT,
        NINE
    }

    enum e10_19 {
        TEN,
        ELEVEN,
        TWELVE,
        THIRTEEN,
        FOURTEEN,
        FIFTEEN,
        SIXTEEN,
        SEVENTEEN,
        EIGHTEEN,
        NINETEEN
    }

    enum e20_90 {
        TWENTY,
        THIRTY,
        FORTY,
        FIFTY,
        SIXTY,
        SEVENTY,
        EIGHTY,
        NINETY,
    }

    enum e100_1000 {
        ONE_HUNDRED,
        TWO_HUNDRED,
        THREE_HUNDRED,
        FOUR_HUNDRED,
        FIVE_HUNDRED,
        SIX_HUNDRED,
        SEVEN_HUNDRED,
        EIGHT_HUNDRED,
        NINE_HUNDRED,
        ONE_THOUSAND
    }


}
