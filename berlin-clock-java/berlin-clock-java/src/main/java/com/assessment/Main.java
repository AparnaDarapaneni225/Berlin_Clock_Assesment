package com.assessment;

public class Main {
    public static void main(String[] args) {
        String[] examples = {
                "12:56:01",
                "00:00:00",
                "22:32:45"
        };

        for (String time : examples) {
            System.out.println(time + " ->");
            System.out.println(BerlinClock.convert(time));
            System.out.println();
        }
    }
}
