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
import com.designPatterns.safedec.models.Alarm;
import com.designPatterns.safedec.models.Customer;
import com.designPatterns.safedec.models.Location;
import com.designPatterns.safedec.models.MotionSensor;

/**
 *
 * @author Prashul Singh
 */
public class AlarmDAOImpl implements AlarmDAO {

    
private static final String SECTIONID       = "sectionId";
private static final String X1              = "x1";
private static final String Y1              = "y1";
private static final String AlARMID        = "alarmId";
private static final String IPADDRESS       = "ipAddress";
private static final String PORT            = "port";
private static final String COST            = "cost";

private static final String INSERT_ALARMS = "INSERT INTO `customer_alarm_relation` "
        + "(`sectionId`,"
        + " `x1`, `y1`,"
        + " `customerId`, `sensorId`,"
        + " `ipAddress`,"
        + " `port`,"
        + " `cost`)"
        + " VALUES (?, ?, ?, ?, ?, ?, ?, ?);";


private static final String UPDATE_ALARMS = "UPDATE `customer_alarm_relation` SET "
        + " `x1` = ?, `y1` = ?"
        + " WHERE (`sensorId` = ?) and (`customerId` = ?";


private static final String DELETE_ALARMS = "DELETE from `customer_alarm_relation` where"
        + " `sectionId` = ? and "
        + " `sensorId` = ? and "
        + " `customerId` = ?";

private static final String GET_ALARMS_BY_CUSTOMER_ID = "select * from customer_alarm_relation where customerID = ?";
private static final String GET_ALARMS_BY_SECTION_ID = "select * from customer_alarm_relation where customerID = ? and sectionId = ?";


    @Override
    public boolean create(Customer customer, Alarm alarm) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean destroy(Customer customer, Alarm alarms) {
        boolean flag = false;
        ObjectPool pool =  ViewController.getInstance().getConnectionPool();
//       Connection conn = (Connection)pool.getObject();
//       ResultSet rs = null;
//       PreparedStatement  stmt = null;
//       boolean flag = false;
//       try
//        {
//       for( Alarm alarm : alarms ){
//       
//            stmt = conn.prepareStatement(DELETE_ALARMS);
//            stmt.setInt(1, alarm.getSectionId());
//            stmt.setInt(2, alarm.getId());
//            stmt.setInt(3, ViewController.getInstance().getLoggedInUser().getCustomerId());
//            
//            stmt.addBatch();
//       }
//         stmt.executeBatch();
//         flag = true;
//        }
//       catch( SQLException e)
//        {
//           Logger.getLogger(CustomerDAOImpl.class.getName()).log(Level.SEVERE, null, e);
//           flag = false;
//        }
//        finally
//        {
//           try {
//               stmt.close();
//               pool.releaseObject(conn);
//           } catch (SQLException ex) {
//               Logger.getLogger(CustomerDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
//               flag = false;
//           }
//        }
    return flag;
    }

    @Override
    public boolean edit(Customer customer, Alarm alarm ) {
        System.out.println("safedec.dao.AlarmDAOImpl.edit()");
        ObjectPool pool =  ViewController.getInstance().getConnectionPool();
       Connection conn = (Connection)pool.getObject();
       ResultSet rs = null;
       PreparedStatement  stmt = null;
       boolean flag = false;
       try
        {
            stmt = conn.prepareStatement(UPDATE_ALARMS);
            stmt.setInt(1, alarm.getLoc().getX1());
            stmt.setInt(2, alarm.getLoc().getY1());
            stmt.setInt(3, alarm.getId());
            stmt.setInt(4, ViewController.getInstance().getLoggedInUser().getCustomerId());
            stmt.execute();
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
    return flag;
    }

    @Override
    public List<Alarm> getAllAlarms(Customer customer) {
       ObjectPool pool =  ViewController.getInstance().getConnectionPool();
       Connection conn = (Connection)pool.getObject();
       ResultSet rs = null;
       PreparedStatement  stmt = null;
       boolean flag = false;
       List< Alarm > alarms = new ArrayList< Alarm >();
       try
        {
            stmt = conn.prepareStatement(GET_ALARMS_BY_CUSTOMER_ID);
            stmt.setInt(1, customer.getCustomerId());
            rs = stmt.executeQuery();
            alarms = new ArrayList< Alarm >();
            while( rs.next() )
            {
                Alarm alarm = new Alarm();
                alarm.setSectionId( rs.getInt(SECTIONID) );  
                alarm.setLoc( new Location(rs.getInt(X1), rs.getInt(Y1) ) );
               alarm.setId( rs.getInt(AlARMID) );
                alarm.setIpAddress(rs.getString(IPADDRESS));
                alarm.setPrice(rs.getInt(COST));
                alarm.setPortNumber(rs.getInt(PORT));
                
                alarms.add( alarm );
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
    return alarms;
    }
    
    public List< Alarm > getAllAlarmsBySectionId( Customer customer, int sectionId )
    {
       ObjectPool pool =  ViewController.getInstance().getConnectionPool();
       Connection conn = (Connection)pool.getObject();
       ResultSet rs = null;
       PreparedStatement  stmt = null;
       boolean flag = false;
       List< Alarm > alarms = new ArrayList< Alarm >();
       try
        {
            stmt = conn.prepareStatement(GET_ALARMS_BY_SECTION_ID);
            stmt.setInt(1, customer.getCustomerId());
            stmt.setInt(2, sectionId);
            rs = stmt.executeQuery();
            alarms = new ArrayList< Alarm >();
            while( rs.next() )
            {
                Alarm alarm = new Alarm();
                alarm.setSectionId( rs.getInt(SECTIONID) );  
                alarm.setLoc( new Location(rs.getInt(X1),rs.getInt(Y1) ) );
                alarm.setPrice(0);
                alarm.setId( rs.getInt(AlARMID) );
                alarm.setIpAddress(rs.getString(IPADDRESS));
                alarm.setPrice(rs.getInt(COST));
                alarm.setPortNumber(rs.getInt(PORT));
                
                alarms.add( alarm );
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
    return alarms;
    }
    
}
