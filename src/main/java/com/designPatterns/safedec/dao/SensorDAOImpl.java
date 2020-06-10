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
import com.designPatterns.safedec.models.FireSensor;
import com.designPatterns.safedec.models.Location;
import com.designPatterns.safedec.models.MotionSensor;

/**
 *
 * @author Prashul Singh
 */
public class SensorDAOImpl implements SensorDAO{

private static final String SECTIONID       = "sectionId";
private static final String X1              = "x1";
private static final String Y1              = "y1";
private static final String SENSORID        = "sensorId";
private static final String IPADDRESS       = "ipAddress";
private static final String PORT            = "port";
private static final String COST            = "cost";
private static final String ISCAMERAENABLED = "iscameraEnabled";
private static final String TYPE = "sensorType";

private static final String ISNERT_MOTION_SENSOR = "INSERT INTO `customer_sensor_relation` "
        + "(`sectionId`,"
        + " `x1`,`y1`,"
        + " `customerId`, `sensorId`,"
        + " `ipAddress`,"
        + " `port`,"
        + " `cost`,"
        + " `type`,"
        + " `isCameraEnabled`)"
        + " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?);";


private static final String UPDATE_SENSORS_LOCATION = "UPDATE `customer_sensor_relation` SET "
        + " `x1` = ?,  `y1` = ?"
        + " WHERE (`sensorId` = ?) and (`customerId` = ?)";


private static final String DELETE_SENSORS = "DELETE from `customer_sensor_relation` where"
        + " `sectionId` = ? and "
        + " `sensorId` = ? and "
        + " `customerId` = ?";

private static final String GET_SENSORS_BY_CUSTOMER_ID = "select * from customer_sensor_relation where customerID = ?";
private static final String GET_SENSORS_BY_SECTION_ID = "select * from customer_sensor_relation where customerID = ? and sectionid = ?";

    @Override
    public boolean createMotionSensor(Customer customer, MotionSensor sensor) {
       ObjectPool pool =  ViewController.getInstance().getConnectionPool();
       Connection conn = (Connection)pool.getObject();
       ResultSet rs = null;
       PreparedStatement  stmt = null;
       boolean flag = false;
       try
        {
            stmt = conn.prepareStatement(ISNERT_MOTION_SENSOR);
            stmt.setInt(1, sensor.getSectionId());
            stmt.setInt(2, sensor.getLoc().getX1());
            stmt.setInt(3, sensor.getLoc().getY1());
            stmt.setInt(4, customer.getCustomerId());
            stmt.setInt(5, sensor.getId());
            stmt.setString(8, sensor.getIpAddress());
            stmt.setInt(7, sensor.getPortNumber());
            stmt.setInt(8, sensor.getPrice());
            stmt.setString(9, "Motion");
            stmt.setBoolean(10, sensor.isIsCamera());
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
               pool.releaseObject(conn);
           } catch (SQLException ex) {
               Logger.getLogger(CustomerDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
               flag = false;
           }
        }
    return flag;
    }

    @Override
    public boolean createFireSensor(Customer customer, FireSensor sensor) {
       ObjectPool pool =  ViewController.getInstance().getConnectionPool();
       Connection conn = (Connection)pool.getObject();
       ResultSet rs = null;
       PreparedStatement  stmt = null;
       boolean flag = false;
       try
        {
            stmt = conn.prepareStatement(ISNERT_MOTION_SENSOR);
            stmt.setInt(1, sensor.getSectionId());
            stmt.setInt(2, sensor.getLoc().getX1());
            stmt.setInt(3, sensor.getLoc().getY1());
            stmt.setInt(4, customer.getCustomerId());
            stmt.setInt(5, sensor.getId());
            stmt.setString(8, sensor.getIpAddress());
            stmt.setInt(7, sensor.getPortNumber());
            stmt.setInt(8, sensor.getPrice());
            stmt.setString(9, "Fire");
            stmt.setBoolean(10, false);
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
               pool.releaseObject(conn);
           } catch (SQLException ex) {
               Logger.getLogger(CustomerDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
               flag = false;
           }
        }
    return flag;
    }
    @Override
    public boolean destroy(MotionSensor sensors) {
        boolean flag = false;
//     ObjectPool pool =  ViewController.getInstance().getConnectionPool();
//       Connection conn = (Connection)pool.getObject();
//       ResultSet rs = null;
//       PreparedStatement  stmt = null;
//       boolean flag = false;
//       try
//        {
//       for( MotionSensor sensor : sensors ){
//       
//            stmt = conn.prepareStatement(DELETE_SENSORS);
//            stmt.setInt(1, sensor.getSectionId());
//            stmt.setInt(2, sensor.getId());
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
    public boolean editMotionSensor( Customer customer, MotionSensor sensor) {
       ObjectPool pool =  ViewController.getInstance().getConnectionPool();
       Connection conn = (Connection)pool.getObject();
       ResultSet rs = null;
       PreparedStatement  stmt = null;
       boolean flag = false;
       try
        {
            stmt = conn.prepareStatement(UPDATE_SENSORS_LOCATION);
            stmt.setInt(1, sensor.getLoc().getX1());
            stmt.setInt(2, sensor.getLoc().getY1());
            stmt.setInt(3, sensor.getId());
            stmt.setInt(4, customer.getCustomerId());
            boolean execute = stmt.execute();
            System.out.println("safedec.dao.SensorDAOImpl.edit()" + sensor.getId() + " " + sensor.getLoc().getX1() + " " + sensor.getLoc().getY1() );
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
    public boolean editFireSensor( Customer customer, FireSensor sensor) {
       ObjectPool pool =  ViewController.getInstance().getConnectionPool();
       Connection conn = (Connection)pool.getObject();
       ResultSet rs = null;
       PreparedStatement  stmt = null;
       boolean flag = false;
       try
        {
            stmt = conn.prepareStatement(UPDATE_SENSORS_LOCATION);
            stmt.setInt(1, sensor.getLoc().getX1());
            stmt.setInt(2, sensor.getLoc().getY1());
            stmt.setInt(3, sensor.getId());
            stmt.setInt(4, customer.getCustomerId());
            boolean execute = stmt.execute();
            System.out.println("safedec.dao.SensorDAOImpl.edit()" + sensor.getId() + " " + sensor.getLoc().getX1() + " " + sensor.getLoc().getY1() );
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
    public List<MotionSensor> getAllSensors(Customer customer) {
     ObjectPool pool =  ViewController.getInstance().getConnectionPool();
       Connection conn = (Connection)pool.getObject();
       ResultSet rs = null;
       PreparedStatement  stmt = null;
       boolean flag = false;
       List< MotionSensor > sensors = new ArrayList< MotionSensor >();
       try
        {
            stmt = conn.prepareStatement(GET_SENSORS_BY_CUSTOMER_ID);
            stmt.setInt(1, customer.getCustomerId());
            rs = stmt.executeQuery();
            sensors = new ArrayList< MotionSensor >();
            while( rs.next() )
            {
                MotionSensor sensor = new MotionSensor();
                sensor.setSectionId( rs.getInt(SECTIONID) );  
                sensor.setLoc( new Location(rs.getInt(X1),rs.getInt(Y1) ) );
                sensor.setPrice(0);
                sensor.setId( rs.getInt(SENSORID) );
                sensor.setIpAddress(rs.getString(IPADDRESS));
                sensor.setIsCamera(rs.getBoolean(ISCAMERAENABLED));
                sensor.setPrice(rs.getInt(COST));
                sensor.setPortNumber(rs.getInt(PORT));
                
                sensors.add( sensor );
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
    return sensors;
    }
    public List<MotionSensor> getAllSensorsBySectionId(Customer customer, int sectionId) {
     ObjectPool pool =  ViewController.getInstance().getConnectionPool();
       Connection conn = (Connection)pool.getObject();
       ResultSet rs = null;
       PreparedStatement  stmt = null;
       boolean flag = false;
       List< MotionSensor > sensors = new ArrayList< MotionSensor >();
       try
        {
            stmt = conn.prepareStatement(GET_SENSORS_BY_SECTION_ID);
            stmt.setInt(1, customer.getCustomerId());
            stmt.setInt(2, sectionId);
            rs = stmt.executeQuery();
            sensors = new ArrayList< MotionSensor >();
            while( rs.next() )
            {
                MotionSensor sensor = new MotionSensor();
                sensor.setSectionId( rs.getInt(SECTIONID) );  
                sensor.setLoc( new Location(rs.getInt(X1),rs.getInt(Y1) ) );
                sensor.setPrice(0);
                sensor.setId( rs.getInt(SENSORID) );
                sensor.setIpAddress(rs.getString(IPADDRESS));
                sensor.setIsCamera(rs.getBoolean(ISCAMERAENABLED));
                sensor.setPrice(rs.getInt(COST));
                sensor.setPortNumber(rs.getInt(PORT));
                
                sensors.add( sensor );
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
    return sensors;
    }
}
