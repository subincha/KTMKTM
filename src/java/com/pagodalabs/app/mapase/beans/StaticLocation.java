/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pagodalabs.app.mapase.beans;

import java.io.Serializable;

/**
 *
 * @author Maharjan
 */
public class StaticLocation implements Serializable {
    private int id;
    private Double latitude;
    private Double longitude;
    private String nameOfPlace;

    public StaticLocation() {
    }

    public StaticLocation(int id, Double latitude, Double longitude, String nameOfPlace) {
        this.id = id;
        this.latitude = latitude;
        this.longitude = longitude;
        this.nameOfPlace = nameOfPlace;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
    
    
}
