/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.designPatterns.safedec.models;

/**
 *
 * @author Prashul Singh
 */
public class CustomerBuilder {
    private String customerName;
    private String licenseCode;
    private String masterPassword;
    private String phoneNumber;
    private String primaryContactNumber;
    private String propertyAddress;
    private String secondaryContactNumber;
    private String emailAddress;
    private int customerId;

    public CustomerBuilder setCustomerId(int customerId) {
        this.customerId = customerId;
        return this;
    }

    public CustomerBuilder setCustomerName(String customerName) {
        this.customerName = customerName;
        return this;
    }

    public CustomerBuilder setLicenseCode(String licenseCode) {
        this.licenseCode = licenseCode;
        return this;
    }

    public CustomerBuilder setMasterPassword(String masterPassword) {
        this.masterPassword = masterPassword;
        return this;
    }

    public CustomerBuilder setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }

    public CustomerBuilder setPrimaryContactNumber(String primaryContactNumber) {
        this.primaryContactNumber = primaryContactNumber;
        return this;
    }

    public CustomerBuilder setPropertyAddress(String propertyAddress) {
        this.propertyAddress = propertyAddress;
        return this;
    }

    public CustomerBuilder setSecondaryContactNumber(String secondaryContactNumber) {
        this.secondaryContactNumber = secondaryContactNumber;
        return this;
    }

    public CustomerBuilder setEmaiAddress(String emailAddress) {
        this.emailAddress = emailAddress;
        return this;
    }
    
    public Customer build()
    {
        return new Customer(customerId, emailAddress,customerName, masterPassword, phoneNumber, primaryContactNumber, propertyAddress,secondaryContactNumber);
    }
   
}
