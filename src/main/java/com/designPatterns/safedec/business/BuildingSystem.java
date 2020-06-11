/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.designPatterns.safedec.business;

import com.designPatterns.safedec.Views.SensorIcon;
import com.designPatterns.safedec.models.Sensor;
import com.designPatterns.safedec.service.MapService;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Prashul Singh
 */
public class BuildingSystem {
    SystemState state;
    
    public BuildingSystem( SystemState newState ){
        this.state = newState;
    }
    
    public void handleState(){
        this.state.handleState();
    }
    
    public void nextState(){
        this.state.nextState();
        updateAllSensors();
    }
    
    public void updateAllSensors(){
        SensorState iconState;
        
        if(this.state instanceof ActiveSystemState){
            iconState = new SensorStateOn();
        }else{
            iconState = new SensorStateOff();
        }
        
        List<Sensor> allSensors = new ArrayList< Sensor >();
        MapService service = new MapService();
        
        for(int i=1; i<=4; i++){
            allSensors.addAll(service.getAllSensorsBySection(i));
        }
        
//        for(Sensor sensor: allSensors){
//            SensorIcon icon = FlyweightSensorIconFactory.getSensorIcon(sensor);
//            icon.changeState(iconState);
//        }
    }
    
}
