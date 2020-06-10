/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.designPatterns.safedec.service;

import com.designPatterns.safedec.models.Customer;

/**
 *
 * @author Prashul Singh
 */
public interface UserAdminService {
    boolean login(String name, String password);
    void logoff();
    void signup();
    boolean createUser(Customer customer);
    boolean editUser(Customer customer);
}
