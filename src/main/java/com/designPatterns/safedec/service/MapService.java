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
import com.designPatterns.safedec.models.Alarm;
import com.designPatterns.safedec.models.FireSensor;
import com.designPatterns.safedec.models.MotionSensor;
import com.designPatterns.safedec.models.Sensor;

/**
 *
 * @author Prashul Singh
 */
public class MapService {
    public List< Alarm > getAllAlarmsBySection(int sectionId){
        AlarmDAO alarmDAO = new AlarmDAOImpl();
        List< Alarm > alarms = alarmDAO.getAllAlarms(ViewController.getInstance().getLoggedInUser());
        return alarms;
        
    }
    
    public List< Sensor > getAllSensorsBySection(int sectionId)
    {
        SensorDAO sensorDAO =  new SensorDAOImpl();
        List< Sensor > sensors = sensorDAO.getAllSensorsBySectionId(ViewController.getInstance().getLoggedInUser(), sectionId);
        return sensors;
    }

    
}
