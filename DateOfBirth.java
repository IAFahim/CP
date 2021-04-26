import java.io.*;
import java.util.*;

import static java.lang.Math.*;

public class DateOfBirth {
    private int day = 0;
    private int month = 0;
    private int year = 0;

    public DateOfBirth(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public void setYear(int year) {
        this.year = year;
    }
    // 10:05 PM Mon 04 2021 4/19/2021
}