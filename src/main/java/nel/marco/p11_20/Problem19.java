package nel.marco.p11_20;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.concurrent.ExecutionException;

/*
You are given the following information, but you may prefer to do some research for yourself.

1 Jan 1900 was a Monday.
Thirty days has September,
April, June and November.
All the rest have thirty-one,
Saving February alone,
Which has twenty-eight, rain or shine.
And on leap years, twenty-nine.
A leap year occurs on any year evenly divisible by 4, but not on a century unless it is divisible by 400.
How many Sundays fell on the first of the month during the twentieth century (1 Jan 1901 to 31 Dec 2000)?

answer = 171

 */
public class Problem19 {


    public static void main(String args[]) {
        try {
            new Problem19();
        } catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();
        }
    }


    public Problem19() throws ExecutionException, InterruptedException {
        LocalDate start = LocalDate.of(1901, 1, 1);
        LocalDate end = LocalDate.of(2000, 12, 31);

        int sundaysFirstOfMonthCount = 0;

        while (!start.isAfter(end)) {
            start = start.plusDays(1);

            if (start.getDayOfMonth() == 1 && start.getDayOfWeek() == DayOfWeek.SUNDAY) {
                sundaysFirstOfMonthCount++;
            }
        }

        System.out.println(start);
        System.out.println(sundaysFirstOfMonthCount);
    }


}
