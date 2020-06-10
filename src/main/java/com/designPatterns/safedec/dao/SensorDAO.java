/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.designPatterns.safedec.dao;

import java.util.List;
import com.designPatterns.safedec.models.Customer;
import com.designPatterns.safedec.models.FireSensor;
import com.designPatterns.safedec.models.MotionSensor;
import com.designPatterns.safedec.models.Sensor;

/**
 *
 * @author Prashul Singh
 */
public interface SensorDAO {
    public boolean createMotionSensor( Customer customer, MotionSensor sensor );
    public boolean createFireSensor( Customer customer, FireSensor sensor );
    public boolean destroy(MotionSensor sensor );
    public boolean editMotionSensor( Customer customer, MotionSensor sensor );
    public boolean editFireSensor( Customer customer, FireSensor sensor );
    public List< Sensor > getAllSensors( Customer customer);
    public List<MotionSensor> getAllSensorsBySectionId(Customer customer, int sectionId);
}
