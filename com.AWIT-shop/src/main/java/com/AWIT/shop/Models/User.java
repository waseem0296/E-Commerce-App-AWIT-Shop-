package com.AWIT.shop.Models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.DynamicUpdate;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "User")
@Getter
@Setter
@DynamicUpdate
public class User implements Serializable {
    @Serial
    private static final long SerialVersionUID=1L;
 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 @Column(name = "id", nullable = false, unique = true)
 private Integer id;
   private  String name;
    private String mobileNumber;

    private String email;

    private String address;

    private String city;

    private String state;

    private String pincode;

    private String password;

    private String profileImage;

    private String role;

    private Boolean isEnable;

    private Boolean accountNonLocked;
    private Date lockTime;
    private Integer failedAttempt;

    public void setId(Integer id) {this.id = id;}
    public void setName(String name) {this.name = name;}
    public void setEmail(String email) {this.email = email;}
    public void setAddress(String address) {this.address = address;}
    public void setMobileNumber(String mobileNumber) {this.mobileNumber = mobileNumber;}
    public void setCity(String city) {this.city = city;}
    public void setAccountNonLocked(Boolean accountNonLocked) {this.accountNonLocked = accountNonLocked;}
    public void setIsEnable(Boolean enable) {isEnable = enable;}
    public void setFailedAttempt(Integer failedAttempt) {this.failedAttempt = failedAttempt;}
    public void setLockTime(Date lockTime) {this.lockTime = lockTime;}
    public void setState(String state) {this.state = state;}
    public void setPassword(String password) {this.password = password;}
    public void setPincode(String pincode) {this.pincode = pincode;}
    public void setProfileImage(String profileImage) {this.profileImage = profileImage;}
    public void setRole(String role) {this.role = role;}


    public Integer getId() {return id;}
    public String getName() {return name;}
    public String getEmail() {return email;}
    public String getAddress() {return address;}
    public Boolean getAccountNonLocked() {return accountNonLocked;}
    public String getCity() {return city;}
    public String getMobileNumber() {return mobileNumber;}
    public String getPincode() {return pincode;}
    public String getPassword() {return password;}
    public Boolean getIsEnable() {return isEnable;}
    public String getProfileImage() {return profileImage;}
    public String getRole() {return role;}
    public String getState() {return state;}
    public Date getLockTime() {return lockTime;}
    public Integer getFailedAttempt() {return failedAttempt;}
}

