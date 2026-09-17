package com.assessment;

/**
 * Berlin Clock kata solution.
 */
public final class BerlinClock {

    private BerlinClock() {
        // Utility class
    }

    public static String convert(String time) {
        if (time == null || !time.matches("\\d{2}:\\d{2}:\\d{2}")) {
            throw new IllegalArgumentException("Time must be in HH:mm:ss format");
        }

        int hour = Integer.parseInt(time.substring(0, 2));
        int minute = Integer.parseInt(time.substring(3, 5));
        int second = Integer.parseInt(time.substring(6, 8));

        if (hour < 0 || hour > 23 || minute < 0 || minute > 59 || second < 0 || second > 59) {
            throw new IllegalArgumentException("Invalid time: " + time);
        }

        String secondsRow = (second % 2 == 0) ? "Y" : "O";

        int fiveHourLights = hour / 5;
        String fiveHourRow = "R".repeat(fiveHourLights)
                + "O".repeat(4 - fiveHourLights);

        int oneHourLights = hour % 5;
        String oneHourRow = "R".repeat(oneHourLights)
                + "O".repeat(4 - oneHourLights);

        int fiveMinuteLights = minute / 5;
        StringBuilder fiveMinuteRow = new StringBuilder(11);

        for (int i = 0; i < 11; i++) {
            if (i < fiveMinuteLights) {
                // 3rd, 6th and 9th positions are red.
                fiveMinuteRow.append((i == 2 || i == 5 || i == 8) ? 'R' : 'Y');
            } else {
                fiveMinuteRow.append('O');
            }
        }

        int oneMinuteLights = minute % 5;
        String oneMinuteRow = "Y".repeat(oneMinuteLights)
                + "O".repeat(4 - oneMinuteLights);

        return String.join(
                "\n",
                secondsRow,
                fiveHourRow,
                oneHourRow,
                fiveMinuteRow.toString(),
                oneMinuteRow
        );
    }
}
