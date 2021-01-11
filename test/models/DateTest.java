package models;

import org.junit.Test;

import static org.junit.Assert.*;

public class DateTest {

    Date date = new Date(2, 4, 2020);

    @Test
    public void getDay() {
        assertEquals(2, date.getDay());
    }

    @Test
    public void setDay() {
        int day = 5;
        date.setDay(day);
        assertEquals(day, date.getDay());
    }

    @Test
    public void getMonth() {
        assertEquals(4, date.getMonth());
    }

    @Test
    public void setMonth() {
        int month = 11;
        date.setMonth(month);
        assertEquals(month, date.getMonth());
    }

    @Test
    public void getYear() {
        assertEquals(2020, date.getYear());
    }

    @Test
    public void setYear() {
        int year = 2019;
        date.setYear(year);
        assertEquals(year, date.getYear());
    }

    @Test
    public void testToString() {
        assertEquals("2/4/2020", date.toString());
    }
}