/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.designPatterns.safedec.test.dao;

import com.designPatterns.safedec.dao.AlarmDAO;
import com.designPatterns.safedec.dao.AlarmDAOImpl;
import com.designPatterns.safedec.models.Alarm;
import com.designPatterns.safedec.models.Customer;
import com.designPatterns.safedec.models.Location;
import com.designPatterns.safedec.models.MotionSensor;
import static org.junit.Assert.assertEquals;

/**
 *
 * @author akshayharyani
 */
public class AlarmDaoTest {
        
    public void create() {
        System.out.println("safedec.test.dao.AlarmDaoTest.create()");
        
        Customer customer = new Customer();
        customer.setCustomerId(123456);
 
        int sensorId = 1;
        String occurance = "02/02/2020";
        String memo = "Fire alarm memo";
        
        Alarm alarm = new Alarm();
        alarm.setSensorId(sensorId);
        alarm.setOccuranceDate(occurance);
        alarm.setMemo(memo);

        
        AlarmDAO alarmDao = new AlarmDAOImpl();
        boolean flag = alarmDao.create(customer,alarm);
        assertEquals(true, flag);
        
    }

}
