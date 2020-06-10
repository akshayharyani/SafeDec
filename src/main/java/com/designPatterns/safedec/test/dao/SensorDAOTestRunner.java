/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.designPatterns.safedec.test.dao;

//import com.sun.javaws.Main;
import com.designPatterns.safedec.controls.ViewController;

/**
 *
 * @author Prashul Singh
 */
public class SensorDAOTestRunner {
    public static void main( String args[] )
    {
        SensorDAOTest sensorDAOTest =  new SensorDAOTest();
        sensorDAOTest.getAllSensorsBySection();
        //sensorDAOTest.getAllSensors();
        
        
    }
}
