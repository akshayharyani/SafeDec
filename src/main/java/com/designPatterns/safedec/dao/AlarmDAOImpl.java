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
import com.designPatterns.safedec.models.FireSensor;
import com.designPatterns.safedec.models.Customer;
import com.designPatterns.safedec.models.Location;
import com.designPatterns.safedec.models.MotionSensor;
import com.designPatterns.safedec.models.Alarm;

/**
 *
 * @author Prashul Singh
 */
public class AlarmDAOImpl implements AlarmDAO {
    
private static final String SENSORID       = "sensorId";
private static final String AlARMID        = "alarmId";
private static final String CUSTOMERID       = "customerId";
private static final String OCCURANCE            = "Occurance";
private static final String MEMO            = "memo";
private static final String TABLENAME = "ALARMS";

private static final String INSERT_ALARMS = "INSERT INTO `"+TABLENAME+"` "
        + "(`"+CUSTOMERID+"`,"
        + " `"+SENSORID+"`,"
        + " `"+OCCURANCE+"`,"
        + " `"+MEMO+"`,"
        + " VALUES (?, ?, ?, ?);";


private static final String UPDATE_ALARMS = "UPDATE `"+TABLENAME+"` SET "
        + " `x1` = ?, `y1` = ?"
        + " WHERE (`"+SENSORID+"` = ?) and (`customerId` = ?";


private static final String DELETE_ALARMS = "DELETE from `customer_alarm_relation` where"
        + " `sectionId` = ? and "
        + " `sensorId` = ? and "
        + " `customerId` = ?";

private static final String GET_ALARMS_BY_CUSTOMER_ID = "select * from "+TABLENAME+" where customerID = ?";
private static final String GET_ALARMS_BY_SENSOR_ID = "select * from "+TABLENAME+" where customerID = ? and sensorId = ?";


    @Override
    public boolean create(Customer customer, Alarm alarm) {
        
        ObjectPool pool =  ViewController.getInstance().getConnectionPool();
       Connection conn = (Connection)pool.getObject();
       ResultSet rs = null;
       PreparedStatement  stmt = null;
       boolean flag = false;
       try
        {
            stmt = conn.prepareStatement(INSERT_ALARMS);
            stmt.setInt(1, alarm.getSensorId());
            stmt.setInt(1, customer.getCustomerId());
            stmt.setString(2, alarm.getOccuranceDate());
            stmt.setString(3, alarm.getMemo());
            stmt.execute();
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
    public boolean destroy(Customer customer, Alarm alarms) {
        boolean flag = false;
        return flag;
    }

    @Override
    public boolean edit(Customer customer, Alarm alarm ) {
        //TODO add impl;
        return true;
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
                alarm.setSensorId( rs.getInt(SENSORID) );  
                alarm.setAlarmId( rs.getInt(AlARMID) );
                alarm.setMemo(rs.getString(MEMO));
                alarm.setOccuranceDate(rs.getString(OCCURANCE));
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
    
    public List< Alarm > getAllAlarmsBySensorId( Customer customer, int sectionId )
    {
       ObjectPool pool =  ViewController.getInstance().getConnectionPool();
       Connection conn = (Connection)pool.getObject();
       ResultSet rs = null;
       PreparedStatement  stmt = null;
       boolean flag = false;
       List< Alarm > alarms = new ArrayList< Alarm >();
       try
        {
            stmt = conn.prepareStatement(GET_ALARMS_BY_SENSOR_ID);
            stmt.setInt(1, customer.getCustomerId());
            stmt.setInt(2, sectionId);
            rs = stmt.executeQuery();
            alarms = new ArrayList< Alarm >();
            while( rs.next() )
            {
                Alarm alarm = new Alarm();
                alarm.setSensorId( rs.getInt(SENSORID) );  
                alarm.setAlarmId( rs.getInt(AlARMID) );
                alarm.setMemo(rs.getString(MEMO));
                alarm.setOccuranceDate(rs.getString(OCCURANCE));
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
