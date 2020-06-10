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
public class Alarm extends Sensor{
    
    int sectionId;

  
    public int getSectionId() {
        return sectionId;
    }

    public void setSectionId(int sectionId) {
        this.sectionId = sectionId;
    }

    @Override
    public String toString() {
        return "Alarm{" + "id=" + id + ", loc=" + loc + ", ipAddress=" + ipAddress + ", portNumber=" + portNumber + ", price=" + price + ", sectionId=" + sectionId + '}';
    }
    
}
