package ru.netology.lombok;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data

public class Radio {
    private int currentStation;
    private int currentVolume;
    private int minStation;
    private int quantityStations = 10;
    //private int maxStation = calcMaxStation();
    private int minVolume;
    private int maxVolume = 100;

    public int calcMaxStation() {
        if (quantityStations > 0) {
            return quantityStations - 1;
        } else
            return 0;
    }

    //for Station
    public void setCurrentStation(int currentStation) {
        if (currentStation < minStation) {
            return;
        }
        if (currentStation > calcMaxStation()) {
            return;
        }
        this.currentStation = currentStation;
    }

    public void nextStation() {
        if (currentStation < calcMaxStation()) {
            currentStation++;
        } else {
            currentStation = minStation;
        }
    }

    public void prevStation() {
        if (currentStation > minStation) {
            currentStation = currentStation - 1;
        } else {
            currentStation = calcMaxStation();
        }
    }

    //for Volume
    public void currentVolume(int currentVolume) {
        this.currentVolume = currentVolume;
    }

    public void increaseVolume() {
        if (currentVolume < maxVolume & currentVolume >= minVolume) {
            currentVolume++;
        } else {
            currentVolume = maxVolume;
        }
    }

    public void decreaseVolume() {
        if (currentVolume <= maxVolume & currentVolume > minVolume) {
            currentVolume = currentVolume - 1;
        } else {
            currentVolume = minVolume;
        }
    }

}
