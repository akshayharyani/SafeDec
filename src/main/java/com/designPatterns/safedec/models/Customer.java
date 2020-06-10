/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.designPatterns.safedec.models;

import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author Prashul Singh
* 
*/
public class Customer {

    private String customerName;
    private String licenseCode;
    private String masterPassword;
    private String phoneNumber;
    private String primaryContactNumber;
    private String propertyAddress;
    private String secondaryContactNumber;
    private int     customerId;
    private String  emailAddress;
    private List< Section > sectionId;
    
    public Customer() {
    }

   
    public Customer(int customerId, String emailAddress, String customerName, String masterPassword, String phoneNumber, String primaryContactNumber, String propertyAddress, String secondaryContactNumber) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.masterPassword = masterPassword;
        this.phoneNumber = phoneNumber;
        this.primaryContactNumber = primaryContactNumber;
        this.propertyAddress = propertyAddress;
        this.emailAddress = emailAddress;
        this.secondaryContactNumber = secondaryContactNumber;
        this.sectionId = new ArrayList< Section >();
    }

    public Customer(int customerId, String emailAddress) {
       //TODO
    }

    public List<Section> getSectionId() {
        return sectionId;
    }

    public void setSectionId(List<Section> sectionId) {
        this.sectionId = sectionId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getLicenseCode() {
        return licenseCode;
    }

    public void setLicenseCode(String licenseCode) {
        this.licenseCode = licenseCode;
    }

    public String getMasterPassword() {
        return masterPassword;
    }

    public void setMasterPassword(String masterPassword) {
        this.masterPassword = masterPassword;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPrimaryContactNumber() {
        return primaryContactNumber;
    }

    public void setPrimaryContactNumber(String primaryContactNumber) {
        this.primaryContactNumber = primaryContactNumber;
    }

    public String getPropertyAddress() {
        return propertyAddress;
    }

    public void setPropertyAddress(String propertyAddress) {
        this.propertyAddress = propertyAddress;
    }

    public String getSecondaryContactNumber() {
        return secondaryContactNumber;
    }

    public void setSecondaryContactNumber(String secondaryContactNumber) {
        this.secondaryContactNumber = secondaryContactNumber;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    @Override
    public String toString() {
        return "Customer{" + "customerName=" + customerName + ", licenseCode=" + licenseCode + ", masterPassword=" + masterPassword + ", phoneNumber=" + phoneNumber + ", primaryContactNumber=" + primaryContactNumber + ", propertyAddress=" + propertyAddress + ", secondaryContactNumber=" + secondaryContactNumber + ", customerId=" + customerId + ", emailAddress=" + emailAddress + '}';
    }
    
    
    
}
