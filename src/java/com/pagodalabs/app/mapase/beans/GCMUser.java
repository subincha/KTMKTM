/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pagodalabs.app.mapase.beans;

import java.util.Date;

/**
 *
 * @author Maharjan
 */
public class GCMUser {

    private int id;
    private String regId;
    private String profileId;
    private String userName;
    private String email;
    private Date createdAt;

    public GCMUser() {
    }

    public GCMUser(int id, String regId, String profileId, String userName, String email, Date createdAt) {
        this.id = id;
        this.regId = regId;
        this.profileId = profileId;
        this.userName = userName;
        this.email = email;
        this.createdAt = createdAt;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRegId() {
        return regId;
    }

    public void setRegId(String regId) {
        this.regId = regId;
    }

    public String getProfileId() {
        return profileId;
    }

    public void setProfileId(String profileId) {
        this.profileId = profileId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

}
