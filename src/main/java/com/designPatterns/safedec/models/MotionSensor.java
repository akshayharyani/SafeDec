/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.designPatterns.safedec.models;

/**
 *
 * @author Prashul Singh
 */
public class MotionSensor extends Sensor {
    
   
    boolean isCamera;
    int sectionId;

    public int getSectionId() {
        return sectionId;
    }

    public void setSectionId(int sectionId) {
        this.sectionId = sectionId;
    }

    public boolean isIsCamera() {
        return isCamera;
    }

    public void setIsCamera(boolean isCamera) {
        this.isCamera = isCamera;
    }


    @Override
    public String toString() {
        return "Sensor{" + "id=" + id + ", loc=" + loc + ", ipAddress=" + ipAddress + ", portNumber=" + portNumber + ", isCamera=" + isCamera + ", price=" + price + ", sectionId=" + sectionId + '}';
    }
    
    
}
