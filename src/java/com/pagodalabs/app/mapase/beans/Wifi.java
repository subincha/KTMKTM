package com.pagodalabs.app.mapase.beans;

import java.io.Serializable;

public class Wifi implements Serializable {

    private int id;
    private String profileId;
    private String nameOfUser;
    private Double latitude;
    private Double longitude;
    private String nameOfPlace;
    private int status;
    private String time;
    private String wifiUserName;
    private String wifiPassword;
    private String nameOfWifiPlace;

    public Wifi() {
        super();
    }

    public Wifi(int id, String profileId, String nameOfUser, Double latitude, Double longitude, String nameOfPlace, int status, String time, String wifiUserName, String wifiPassword, String nameOfWifiPlace) {
        this.id = id;
        this.profileId = profileId;
        this.nameOfUser = nameOfUser;
        this.latitude = latitude;
        this.longitude = longitude;
        this.nameOfPlace = nameOfPlace;
        this.status = status;
        this.time = time;
        this.wifiUserName = wifiUserName;
        this.wifiPassword = wifiPassword;
        this.nameOfWifiPlace = nameOfWifiPlace;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProfileId() {
        return profileId;
    }

    public void setProfileId(String profileId) {
        this.profileId = profileId;
    }

    public String getNameOfUser() {
        return nameOfUser;
    }

    public void setNameOfUser(String nameOfUser) {
        this.nameOfUser = nameOfUser;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public String getNameOfPlace() {
        return nameOfPlace;
    }

    public void setNameOfPlace(String nameOfPlace) {
        this.nameOfPlace = nameOfPlace;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getWifiUserName() {
        return wifiUserName;
    }

    public void setWifiUserName(String wifiUserName) {
        this.wifiUserName = wifiUserName;
    }

    public String getWifiPassword() {
        return wifiPassword;
    }

    public void setWifiPassword(String wifiPassword) {
        this.wifiPassword = wifiPassword;
    }

    public String getNameOfWifiPlace() {
        return nameOfWifiPlace;
    }

    public void setNameOfWifiPlace(String nameOfWifiPlace) {
        this.nameOfWifiPlace = nameOfWifiPlace;
    }
}
