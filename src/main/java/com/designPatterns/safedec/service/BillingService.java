/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.designPatterns.safedec.service;

import com.designPatterns.safedec.business.ReportFactory;
import com.designPatterns.safedec.controls.ViewController;
import com.designPatterns.safedec.dao.SensorDAO;
import com.designPatterns.safedec.dao.SensorDAOImpl;
import com.designPatterns.safedec.models.Report;
import com.designPatterns.safedec.models.Sensor;
import java.util.List;

/**
 *
 * @author akshayharyani
 */
public class BillingService {
    
    public List<Sensor> getAllSensors(){
        SensorDAO sensorDAO =  new SensorDAOImpl();
        List< Sensor > sensors = sensorDAO.getAllSensors(ViewController.getInstance().getLoggedInUser());
        return sensors;
    }
    
    public int getTotalAmount(){
        int total = 0;
        SensorDAO sensorDAO =  new SensorDAOImpl();
        List< Sensor > sensors = sensorDAO.getAllSensors(ViewController.getInstance().getLoggedInUser());
        for(Sensor sensor: sensors){
            total += sensor.getPrice();
        }
        return total;
    }
    
    public void createReport(){
        SensorDAO sensorDAO =  new SensorDAOImpl();
        ReportFactory reportFactory = new ReportFactory();
        Report report = reportFactory.generateRport("Text", sensorDAO.getAllSensors(ViewController.getInstance().getLoggedInUser()));
        report.save();
    }
    
}
