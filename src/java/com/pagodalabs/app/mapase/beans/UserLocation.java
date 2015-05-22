package com.pagodalabs.app.mapase.beans;

import java.io.Serializable;

public class UserLocation implements Serializable {

    private int id;
    private String profileId;
    private String nameOfUser;
    private Double latitude;
    private Double longitude;
    private String nameOfPlace;
    private int status;
    private String time;
    private String label;

    public UserLocation() {
        super();
    }

    public UserLocation(int id, String profileId, String nameOfUser, Double latitude, Double longitude, String nameOfPlace, int status, String time, String label) {
        this.id = id;
        this.profileId = profileId;
        this.nameOfUser = nameOfUser;
        this.latitude = latitude;
        this.longitude = longitude;
        this.nameOfPlace = nameOfPlace;
        this.status = status;
        this.time = time;
        this.label = label;
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

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }
    
    

}
