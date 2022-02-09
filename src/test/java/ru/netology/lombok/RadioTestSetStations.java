package ru.netology.lombok;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RadioTestSetStations {

    @Test
    void shouldSetNewStatMin() {
        Radio radio = new Radio(0,0,0,50,0,100);
        radio.setCurrentStation(0);
        assertEquals(0, radio.getCurrentStation());
    }

    @Test
    void shouldSetNewStatMax() {
        Radio radio = new Radio(0,0,0,50,0,100);
        radio.setCurrentStation(49);

        int expected = 49;
        int actual = radio.getCurrentStation();
        assertEquals(expected, actual);
    }

    @Test
    void shouldSetNewStationOverLimit() {
        Radio radio = new Radio(0,0,0,50,0,100);
        radio.setCurrentStation(23534545);

        int expected = 0;
        int actual = radio.getCurrentStation();
        assertEquals(expected, actual);
    }

    @Test
    void shouldSetNewStationNegative() {
        Radio radio = new Radio(0,0,0,50,0,100);
        radio.setCurrentStation(-235);

        int expected = 0;
        int actual = radio.getCurrentStation();
        assertEquals(expected, actual);
    }

    @Test
    void shouldNextStationStartZero() {
        Radio radio = new Radio(0,0,0,50,0,100);
        radio.setCurrentStation(0); // важна последовательность выполнения методов
        radio.nextStation();

        int expected = 1;
        int actual = radio.getCurrentStation();
        assertEquals(expected, actual);
    }

    @Test
    void shouldNextStation() {
        Radio radio = new Radio(0,0,0,50,0,100);
        radio.setCurrentStation(25); // важна последовательность выполнения методов
        radio.nextStation();

        int expected = 26;
        int actual = radio.getCurrentStation();
        assertEquals(expected, actual);
    }

    @Test
    void shouldNextStationStartLast() {
        Radio radio = new Radio(0,0,0,50,0,100);
        radio.setCurrentStation(49); // важна последовательность выполнения методов
        radio.nextStation();

        int expected = 0;
        int actual = radio.getCurrentStation();
        assertEquals(expected, actual);
    }

    @Test
    void shouldPrevStationStartZero() {
        Radio radio = new Radio(0,0,0,50,0,100);
        radio.setCurrentStation(0);
        radio.prevStation();

        int expected = 49;
        int actual = radio.getCurrentStation();
        assertEquals(expected, actual);
    }

    @Test
    void shouldPrevStation() {
        Radio radio = new Radio(0,0,0,50,0,100);
        radio.setCurrentStation(26);
        radio.prevStation();

        int expected = 25;
        int actual = radio.getCurrentStation();
        assertEquals(expected, actual);
    }

    @Test
    void shouldPrevStationStartLast() {
        Radio radio = new Radio(0,0,0,50,0,100);
        radio.setCurrentStation(49);
        radio.prevStation();

        int expected = 48;
        int actual = radio.getCurrentStation();
        assertEquals(expected, actual);
    }

    //RadioTestSetStationZero {
    @Test
    void shouldSetNewStationsMin() {
        Radio radio = new Radio(0,0,0,0,0,100);
        radio.setCurrentStation(1);
        assertEquals(0, radio.getCurrentStation());
    }


    // RadioTestSetStationOne {

    @Test
    void shouldSetNewStation() {
        Radio radio = new Radio(0,0,0,1,0,100);
        radio.setCurrentStation(1);
        assertEquals(0, radio.getCurrentStation());
    }
}
