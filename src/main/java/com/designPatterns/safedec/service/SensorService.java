/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.designPatterns.safedec.service;

import java.util.ArrayList;
import java.util.List;
import javax.swing.text.View;
import com.designPatterns.safedec.controls.ViewController;
import com.designPatterns.safedec.dao.AlarmDAO;
import com.designPatterns.safedec.dao.AlarmDAOImpl;
import com.designPatterns.safedec.dao.SensorDAO;
import com.designPatterns.safedec.dao.SensorDAOImpl;
import com.designPatterns.safedec.models.FireSensor;
import com.designPatterns.safedec.models.Customer;
import com.designPatterns.safedec.models.Location;
import com.designPatterns.safedec.models.MotionSensor;
import com.designPatterns.safedec.models.Sensor;

/**
 *
 * @author Prashul Singh
 */
public class SensorService {
    public boolean updateSensorPosition( Sensor sensor, int x, int y )
    {
        Customer customer = ViewController.getInstance().getLoggedInUser();
        Location loc = new Location( x,y);
        sensor.setLoc(loc);
        System.out.println("safedec.service.SensorService.updateSensorPosition()" + sensor.getClass());
            SensorDAO sensorDAO = new SensorDAOImpl();

        if( sensor instanceof FireSensor )
        {
            return sensorDAO.editFireSensor(customer, (FireSensor) sensor );
        }
    return sensorDAO.editMotionSensor( customer, (MotionSensor) sensor );
    }
}
