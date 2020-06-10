/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.designPatterns.safedec.service;

import java.util.List;
import com.designPatterns.safedec.controls.ViewController;
import com.designPatterns.safedec.dao.AlarmDAO;
import com.designPatterns.safedec.dao.AlarmDAOImpl;
import com.designPatterns.safedec.dao.SensorDAO;
import com.designPatterns.safedec.dao.SensorDAOImpl;
import com.designPatterns.safedec.models.FireSensor;
import com.designPatterns.safedec.models.MotionSensor;
import com.designPatterns.safedec.models.Alarm;


public class DashBoardService {
    public void getAllMotionSensors()
    {
       
    }
    
    public List< Alarm > getAllAlarmSensors()
    {
        AlarmDAO alarmDAO = new AlarmDAOImpl();
        List< Alarm > alarms = alarmDAO.getAllAlarms(ViewController.getInstance().getLoggedInUser());
        return alarms;
        
    }
    
    public List< MotionSensor > getAllSensors()
    {
        SensorDAO sensorDAO =  new SensorDAOImpl();
        List< MotionSensor > sensors = sensorDAO.getAllSensors(ViewController.getInstance().getLoggedInUser());
        return sensors;
    }
}
