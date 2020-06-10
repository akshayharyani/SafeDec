/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.designPatterns.safedec.test.dao;

import java.util.List;
import static org.junit.Assert.assertEquals;
import com.designPatterns.safedec.controls.ViewController;
import com.designPatterns.safedec.dao.SensorDAO;
import com.designPatterns.safedec.dao.SensorDAOImpl;
import com.designPatterns.safedec.models.Customer;
import com.designPatterns.safedec.models.Location;
import com.designPatterns.safedec.models.MotionSensor;

/**
 *
 * @author Prashul Singh
 */
public class SensorDAOTest {

    
    public void create() {
        System.out.println("safedec.test.dao.SensorDAOTest.create()");
        
        Customer customer = new Customer();
        customer.setCustomerId(1);
 
        int sensorId = 100;
        String ipAddress = "198.789.23.456";
        Location loc = new Location(100, 200);
        int portNumber  = 3456;
        int price = 300;
        int sectionId = 2;
        
        MotionSensor sensor = new MotionSensor();
        sensor.setId(sensorId);
        sensor.setIpAddress(ipAddress);
        sensor.setIsCamera(true);
        
        sensor.setLoc(loc);
        sensor.setPortNumber(portNumber);
        sensor.setPrice(price);
        sensor.setSectionId(sectionId);
        
        
       
        SensorDAO sensorDAO = new SensorDAOImpl();
        boolean flag = sensorDAO.create(customer,sensor);
        assertEquals(true, flag);
        
    }

    public boolean destroyTest(List<MotionSensor> sensor) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public boolean edit() {
          
            MotionSensor sensor = new MotionSensor();
             sensor.setId(1);
            Location loc = new Location(100,100);
            sensor.setLoc(loc);
            Customer customer = new Customer();
            customer.setCustomerId(1);
            
            SensorDAO sensorDAO = new SensorDAOImpl();
            boolean flag = sensorDAO.edit(customer, sensor);
            
    return flag;
            
    }
   
        
    public void getAllSensorsBySection()
    {
        Customer customer = new Customer();
        customer.setCustomerId(1);
        SensorDAO sensorDAO = new SensorDAOImpl();
        List<MotionSensor> allSensors = sensorDAO.getAllSensorsBySectionId(customer,1);
        for( MotionSensor sensor :  allSensors )
        {
            assertEquals(1, sensor.getId());
            assertEquals(1, sensor.getSectionId());
            //TODO Add more test cases
        }
    }
    public void getAllSensors() {
        System.out.println("safedec.test.dao.SensorDAOTest.getAllSensors()");
        Customer customer = new Customer();
        customer.setCustomerId(1);
        SensorDAO sensorDAO = new SensorDAOImpl();
        List<MotionSensor> allSensors = sensorDAO.getAllSensors(customer);
        assertEquals(1, allSensors.size());
        for( MotionSensor sensor :  allSensors )
        {
            assertEquals(1, sensor.getId());
            assertEquals(1, sensor.getSectionId());
            //TODO Add more test cases
        }
    }
    
}
