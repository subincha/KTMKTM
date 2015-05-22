/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pagodalabs.app.mapase.beans;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author Maharjan
 */
public class User implements Serializable {
    private int id;
    private String userId;
    private String userName;
    private String firstName;
    private String middleName;
    private String lastName;
    private String email;
    private String location;
    private String birthday;
    private String fbLink;
    private String ipAddress;
    private String gcmRegId;
    private Date createdAt;

    public User() {
    }

    public User(int id, String userId, String userName, String firstName, String middleName, String lastName, String email, String location, String birthday, String fbLink, String gcmRegId, Date createdAt) {
        this.id = id;
        this.userId = userId;
        this.userName = userName;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.email = email;
        this.location = location;
        this.birthday = birthday;
        this.fbLink = fbLink;
    }
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    
    
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getFbLink() {
        return fbLink;
    }

    public void setFbLink(String fbLink) {
        this.fbLink = fbLink;
    }
    
     public String getIpAddress() {
		return ipAddress;
	}

	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}

    public String getGcmRegId() {
        return gcmRegId;
    }

    public void setGcmRegId(String gcmRegId) {
        this.gcmRegId = gcmRegId;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

        
            
    @Override
    public String toString() {
        return "Users{" + "userId=" + userId + ", userName=" + userName + ", firstName=" + firstName + ", middleName=" + middleName + ", lastName=" + lastName + ", email=" + email + ", location=" + location + ", birthday=" + birthday + ", fbLink=" + fbLink + '}';
    }
    
    
    
}
