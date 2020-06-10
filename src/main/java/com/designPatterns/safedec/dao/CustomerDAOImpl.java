/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.designPatterns.safedec.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import com.designPatterns.safedec.connectionpooling.ObjectPool;
import com.designPatterns.safedec.controls.ViewController;
import com.designPatterns.safedec.models.Customer;
import com.designPatterns.safedec.models.CustomerBuilder;
import com.designPatterns.safedec.models.Location;
import com.designPatterns.safedec.models.Section;
import com.designPatterns.safedec.models.MotionSensor;

/**
 *
 * @author Prashul Singh
 */
public class CustomerDAOImpl implements CustomerDAO{

private static final String CUSTOMER_ID               = "CUSTOMER_ID";
private static final String CUSTOMER_NAME             = "CUSTOMER_NAME";
private static final String EMAIL_ADDRESS             = "EMAIL_ADDRESS";
private static final String LICENSE_CODE              = "LICENSE_CODE";
private static final String MASTER_PASSWORD           = "MASTER_PASSWORD";
private static final String PHONE_NUMBER              = "PHONE_NUMBER";
private static final String PRIMARY_CONTACT_NUMBER    = "PRIMARY_CONTACT_NUMBER";
private static final String PROPERTY_ADDRESS          = "PROPERTY_ADDRESS";
private static final String SECONDARY_CONTACT_NUMBER  = "SECONDARY_CONTACT_NUMBER";
private static final String SECTION_ID                = "SECTION_ID";
private static final String MAP_LOCATION                       = "MAP_LOCATION";

private static final String FIND_BY_EMAIL_ADDRESS_QUERY  = "SELECT `customer`.`CUSTOMER_ID`,\n" +
"    `customer`.`CUSTOMER_NAME`,\n" +
"    `customer`.`EMAIL_ADDRESS`,\n" +
"    `customer`.`LICENSE_CODE`,\n" +
"    `customer`.`MASTER_PASSWORD`,\n" +
"    `customer`.`PHONE_NUMBER`,\n" +
"    `customer`.`PRIMARY_CONTACT_NUMBER`,\n" +
"    `customer`.`PROPERTY_ADDRESS`,\n" +
"    `customer`.`SECONDARY_CONTACT_NUMBER`\n" +
"FROM `customer` where EMAIL_ADDRESS = ?";

private static final String INSERT_INTO_USER = "INSERT INTO `safedec`.`customer`\n" +
"(`CUSTOMER_ID`,\n" +
"`CUSTOMER_NAME`,\n" +
"`EMAIL_ADDRESS`,\n" +
"`LICENSE_CODE`,\n" +
"`MASTER_PASSWORD`,\n" +
"`PHONE_NUMBER`,\n" +
"`PRIMARY_CONTACT_NUMBER`,\n" +
"`PROPERTY_ADDRESS`,\n" +
"`SECONDARY_CONTACT_NUMBER`)\n" +
"VALUES\n" + "(?,?,?,?,?,?,?,?,?)";

private static final String UPDATE_CUSTOMER ="UPDATE customer SET\n" +
"`CUSTOMER_NAME` = ?,\n" +
"`EMAIL_ADDRESS` = ?,\n" +
"`LICENSE_CODE` = ?,\n" +
"`MASTER_PASSWORD` = ?,\n" +
"`PHONE_NUMBER` = ?,\n" +
"`PRIMARY_CONTACT_NUMBER` = ?,\n" +
"`PROPERTY_ADDRESS` = ?,\n" +
"`SECONDARY_CONTACT_NUMBER` = ?\n" +
"WHERE `CUSTOMER_ID` = ?;";

 private String FIND_ALL_SECTION_IDS_BY_CUSTOMER_ID = "SELECT * FROM customer_section_relation where customer_Id=?";
   

    public boolean insertCustomer(Customer customer) {
       ObjectPool pool =  ViewController.getInstance().getConnectionPool();
       Connection conn = (Connection)pool.getObject();
       ResultSet rs = null;
       PreparedStatement  stmt = null;
       boolean flag = false;

       try
        {
            stmt = conn.prepareStatement(INSERT_INTO_USER);
            stmt.setInt(1, customer.getCustomerId());
            stmt.setString(2, customer.getCustomerName());
            stmt.setString(3, customer.getEmailAddress());
            stmt.setString(4, customer.getLicenseCode());
            stmt.setString(5, customer.getMasterPassword());
            stmt.setString(6, customer.getPhoneNumber());
            stmt.setString(7, customer.getPrimaryContactNumber());
            stmt.setString(8, customer.getPropertyAddress());
            stmt.setString(9, customer.getSecondaryContactNumber());
            stmt.executeUpdate();
            flag = true;
        }
        catch( SQLException e)
        {
           Logger.getLogger(CustomerDAOImpl.class.getName()).log(Level.SEVERE, null, e);
        }
        finally
        {
           try {
               stmt.close();
//               conn.commit();
               pool.releaseObject(conn);
           } catch (SQLException ex) {
               Logger.getLogger(CustomerDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
               flag = false;
           }
        }
    return flag;
    }

    @Override
    public void removeCustomer(Customer customer) {
     // TODO 
    }

    
    
    /**
     * @param emailAddress
     * @return
     */
    @Override
    public Customer findCustomerByEmailId(String emailAddress) {
       ObjectPool pool =  ViewController.getInstance().getConnectionPool();
       Connection conn = (Connection)pool.getObject();
       ResultSet rs = null;
       PreparedStatement  stmt = null;
       Customer customer = null;
        try
        {
            stmt = conn.prepareStatement(FIND_BY_EMAIL_ADDRESS_QUERY);
            stmt.setString(1, emailAddress);
            
            rs = stmt.executeQuery();
            if( rs.next() )
            customer = new CustomerBuilder().setCustomerName(rs.getString(CUSTOMER_NAME)).setLicenseCode(rs.getString(LICENSE_CODE)).setMasterPassword(rs.getString(MASTER_PASSWORD)).setPhoneNumber(rs.getString(PHONE_NUMBER)).setPrimaryContactNumber(rs.getString(PRIMARY_CONTACT_NUMBER)).setPropertyAddress(rs.getString(PROPERTY_ADDRESS)).setSecondaryContactNumber(rs.getString(SECONDARY_CONTACT_NUMBER)).setEmaiAddress(rs.getString(EMAIL_ADDRESS)).setCustomerId(rs.getInt(CUSTOMER_ID)).build();    
        }
        catch( SQLException e)
        {
           Logger.getLogger(CustomerDAOImpl.class.getName()).log(Level.SEVERE, null, e);
        }
        finally
        {
           try {
               stmt.close();
               pool.releaseObject(conn);
           } catch (SQLException ex) {
               Logger.getLogger(CustomerDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
           }
        }
    return customer;
    }

    @Override
    public boolean updateCustomer(Customer customer ) {
       System.out.println("safedec.dao.CustomerDAOImpl.updateCustomer()");
        System.out.println(customer.toString() );
       ObjectPool pool =  ViewController.getInstance().getConnectionPool();
       Connection conn = (Connection)pool.getObject();
       ResultSet rs = null;
       PreparedStatement  stmt = null;
       boolean flag = false;
       try
        {
            stmt = conn.prepareStatement(UPDATE_CUSTOMER);
            stmt.setString(1, customer.getCustomerName() );
            stmt.setString(2, customer.getEmailAddress());
            stmt.setString(3, customer.getLicenseCode());
            stmt.setString(4, customer.getMasterPassword());
            stmt.setString(5, customer.getPhoneNumber());
            stmt.setString(6, customer.getPrimaryContactNumber());
            stmt.setString(7, customer.getPropertyAddress());
            stmt.setString(8, customer.getSecondaryContactNumber());
            stmt.setInt( 9, customer.getCustomerId());
            if( stmt.executeUpdate() > 0 )
                flag = true;
        }
        catch( SQLException e)
        {
           Logger.getLogger(CustomerDAOImpl.class.getName()).log(Level.SEVERE, null, e);
        }
        finally
        {
           try {
               stmt.close();
//               conn.commit();
               pool.releaseObject(conn);
           } catch (SQLException ex) {
               Logger.getLogger(CustomerDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
               flag = false;
           }
        }
    return flag;
    }

    /**
     *
     * @param customer
     * @return
     */
    @Override
    public List< Section> getAllSections(Customer customer) {
       ObjectPool pool =  ViewController.getInstance().getConnectionPool();
       Connection conn = (Connection)pool.getObject();
       ResultSet rs = null;
       List< Section > sections = null;
       PreparedStatement  stmt = null;
       boolean flag = false;
        try
        {
            stmt = conn.prepareStatement(FIND_ALL_SECTION_IDS_BY_CUSTOMER_ID);
            stmt.setInt(1, customer.getCustomerId());
            rs = stmt.executeQuery();
            sections = new ArrayList< Section >();
            while( rs.next() )
            {
                Section section = new Section(rs.getInt( SECTION_ID ), rs.getString(MAP_LOCATION));
                sections.add( section);
            }
            flag = true;
        }
        catch( SQLException e)
        {
           Logger.getLogger(CustomerDAOImpl.class.getName()).log(Level.SEVERE, null, e);
           flag = false;
        }
        finally
        {
           try {
               stmt.close();
               pool.releaseObject(conn);
           } catch (SQLException ex) {
               Logger.getLogger(CustomerDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
               flag = false;
           }
        }
    return sections;
    }


}
