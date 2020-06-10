/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.designPatterns.safedec.service;

import com.designPatterns.safedec.controls.ViewController;
import com.designPatterns.safedec.dao.CustomerDAO;
import com.designPatterns.safedec.dao.CustomerDAOImpl;
import com.designPatterns.safedec.models.Customer;

/**
 *
 * @author Prashul Singh
 */
public class UserAdminServiceImpl implements UserAdminService{

    @Override
    public boolean login(String email, String password) {
        System.out.println("safedec.service.UserAdminServiceImpl.login()"+ email + " " + password);
        CustomerDAO customerDAO = new CustomerDAOImpl();
        Customer customerInfo = customerDAO.findCustomerByEmailId(email);
        if( !customerInfo.getMasterPassword().equals(password))
            return false;
        ViewController.getInstance().login(customerInfo);
    return true;
    }

    @Override
    public void logoff() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void signup() {
        ViewController.getInstance().signup();
    }

    @Override
    public boolean createUser(Customer customer) {
        CustomerDAO customerDAO = new CustomerDAOImpl();
        if( customerDAO.insertCustomer(customer) )
            return true;
    return false;
    }

    @Override
    public boolean editUser(Customer customer) {
         CustomerDAO customerDAO = new CustomerDAOImpl();
         boolean isUpdateSuccessfull = customerDAO.updateCustomer(customer);
         if( isUpdateSuccessfull )
             ViewController.getInstance().setLoggedInUser(customer);
         return isUpdateSuccessfull;
    }
    
}
