package ru.netology.lombok;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RadioTest {
    @Test
    void shouldSetNewStationMin() {
        Radio radio=new Radio();
        radio.setCurrentStation(0);
        assertEquals(0, radio.getCurrentStation());
    }

    @Test
    void shouldSetNewStationMax() {
        Radio radio = new Radio();
        radio.setCurrentStation(9);

        int expected = 9;
        int actual = radio.getCurrentStation();
        assertEquals(expected, actual);
    }

    @Test
    void shouldSetNewStatOverLimit() {
        Radio radio = new Radio();
        radio.setCurrentStation(23534545);

        int expected = 0;
        int actual = radio.getCurrentStation();
        assertEquals(expected, actual);
    }

    @Test
    void shouldSetNewStatNegative() {
        Radio radio = new Radio();
        radio.setCurrentStation(-235);

        int expected = 0;
        int actual = radio.getCurrentStation();
        assertEquals(expected, actual);
    }

    @Test
    void shouldNextStatStartZero() {
        Radio radio = new Radio();
        radio.setCurrentStation(0); // важна последовательность выполнения методов
        radio.nextStation();

        int expected = 1;
        int actual = radio.getCurrentStation();
        assertEquals(expected, actual);
    }

    @Test
    void shouldNextStat() {
        Radio radio = new Radio();
        radio.setCurrentStation(5); // важна последовательность выполнения методов
        radio.nextStation();

        int expected = 6;
        int actual = radio.getCurrentStation();
        assertEquals(expected, actual);
    }

    @Test
    void shouldNextStatStartLast() {
        Radio radio = new Radio();
        radio.setCurrentStation(9); // важна последовательность выполнения методов
        radio.nextStation();

        int expected = 0;
        int actual = radio.getCurrentStation();
        assertEquals(expected, actual);
    }

    @Test
    void shouldPrevStatStartZero() {
        Radio radio = new Radio();
        radio.setCurrentStation(0);
        radio.prevStation();

        int expected = 9;
        int actual = radio.getCurrentStation();
        assertEquals(expected, actual);
    }

    @Test
    void shouldPrevStat() {
        Radio radio = new Radio();
        radio.setCurrentStation(6);
        radio.prevStation();

        int expected = 5;
        int actual = radio.getCurrentStation();
        assertEquals(expected, actual);
    }

    @Test
    void shouldPrevStatStartLast() {
        Radio radio = new Radio();
        radio.setCurrentStation(9);
        radio.prevStation();

        int expected = 8;
        int actual = radio.getCurrentStation();
        assertEquals(expected, actual);
    }

    @Test
    void shouldIncreaseVolume() {
        Radio radio = new Radio();
        radio.currentVolume(5);
        radio.increaseVolume();

        int expected = 6;
        int actual = radio.getCurrentVolume();
        assertEquals(expected, actual);
    }

    @Test
    void shouldIncreaseVolumeStartWMin() {
        Radio radio = new Radio();
        radio.currentVolume(0);
        radio.increaseVolume();

        int expected = 1;
        int actual = radio.getCurrentVolume();
        assertEquals(expected, actual);
    }

    @Test
    void shouldIncreaseVolumeStartWMax() {
        Radio radio = new Radio();
        radio.currentVolume(100);
        radio.increaseVolume();

        int expected = 100;
        int actual = radio.getCurrentVolume();
        assertEquals(expected, actual);
    }

    @Test
    void shouldIncreaseVolumeUnreal() {
        Radio radio = new Radio();
        radio.currentVolume(-11);
        radio.increaseVolume();

        int expected = 100;
        int actual = radio.getCurrentVolume();
        assertEquals(expected, actual);
    }

    @Test
    void shouldDecreaseVolume() {
        Radio radio = new Radio();
        radio.currentVolume(5);
        radio.decreaseVolume();

        int expected = 4;
        int actual = radio.getCurrentVolume();
        assertEquals(expected, actual);
    }

    @Test
    void shouldDecreaseVolumeStartWMin() {
        Radio radio = new Radio();
        radio.currentVolume(0);
        radio.decreaseVolume();

        int expected = 0;
        int actual = radio.getCurrentVolume();
        assertEquals(expected, actual);
    }

    @Test
    void shouldDecreaseVolumeStartWMax() {
        Radio radio = new Radio();
        radio.currentVolume(100);
        radio.decreaseVolume();

        int expected = 99;
        int actual = radio.getCurrentVolume();
        assertEquals(expected, actual);
    }

    @Test
    void shouldDecreaseVolumeUnreal() {
        Radio radio = new Radio();
        radio.currentVolume(120);
        radio.decreaseVolume();

        int expected = 0;
        int actual = radio.getCurrentVolume();
        assertEquals(expected, actual);
    }

}