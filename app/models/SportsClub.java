package models;

import java.io.Serializable;

public class SportsClub implements Serializable {
    private String nameOfClub;
    private String city;

    public String getNameOfClub() {
        return nameOfClub;
    }

    public void setNameOfClub(String nameOfClub) {
        this.nameOfClub = nameOfClub;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public SportsClub(){}

    public SportsClub(String nameOfClub, String city) {
        this.nameOfClub = nameOfClub;
        this.city = city;
    }

    @Override
    public String toString() {
        return "Name Of Club = " + nameOfClub + ", City = " + city;
    }
}

