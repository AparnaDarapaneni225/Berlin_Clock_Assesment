package com.assessment;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class BerlinClockTest {

    @Test
    void shouldConvert125601() {
        assertEquals(
                "O\nRROO\nRROO\nYYRYYRYYRYY\nYOOO",
                BerlinClock.convert("12:56:01")
        );
    }

    @Test
    void shouldConvert000000() {
        assertEquals(
                "Y\nOOOO\nOOOO\nOOOOOOOOOOO\nOOOO",
                BerlinClock.convert("00:00:00")
        );
    }

    @Test
    void shouldConvert223245() {
        assertEquals(
                "O\nRRRR\nRROO\nYYRYYROOOOO\nYYOO",
                BerlinClock.convert("22:32:45")
        );
    }

    @Test
    void shouldConvert235958() {
        assertEquals(
                "Y\nRRRR\nRRRO\nYYRYYRYYRYY\nYYYY",
                BerlinClock.convert("23:59:58")
        );
    }

    @Test
    void shouldConvert000001() {
        assertEquals(
                "O\nOOOO\nOOOO\nOOOOOOOOOOO\nOOOO",
                BerlinClock.convert("00:00:01")
        );
    }

    @Test
    void shouldConvert010000() {
        assertEquals(
                "Y\nOOOO\nROOO\nOOOOOOOOOOO\nOOOO",
                BerlinClock.convert("01:00:00")
        );
    }

    @Test
    void shouldRejectInvalidTime() {
        assertThrows(IllegalArgumentException.class,
                () -> BerlinClock.convert("24:00:00"));

        assertThrows(IllegalArgumentException.class,
                () -> BerlinClock.convert("12:60:00"));

        assertThrows(IllegalArgumentException.class,
                () -> BerlinClock.convert("12:00:60"));

        assertThrows(IllegalArgumentException.class,
                () -> BerlinClock.convert("invalid"));
    }
}
