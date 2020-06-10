/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.designPatterns.safedec.models;

/**
 *
 * @author akshayharyani
 */
public class Alarm {
    
    int alarmId;
    String memo;
    String occuranceDate;
    int sensorId;

    public int getAlarmId() {
        return alarmId;
    }

    public void setAlarmId(int alarmId) {
        this.alarmId = alarmId;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public String getOccuranceDate() {
        return occuranceDate;
    }

    public void setOccuranceDate(String occuranceDate) {
        this.occuranceDate = occuranceDate;
    }

    public int getSensorId() {
        return sensorId;
    }

    public void setSensorId(int sensorId) {
        this.sensorId = sensorId;
    }
    
    
    
}
