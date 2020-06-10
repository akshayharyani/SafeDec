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
public class Section {
    int sectionId;
    String mapLocation;

    public Section(int sectionId, String mapLocation) {
        this.sectionId = sectionId;
        this.mapLocation = mapLocation;
    }

    public int getSectionId() {
        return sectionId;
    }

    public void setSectionId(int sectionId) {
        this.sectionId = sectionId;
    }

    public String getMapLocation() {
        return mapLocation;
    }

    public void setMapLocation(String mapLocation) {
        this.mapLocation = mapLocation;
    }
    
}
