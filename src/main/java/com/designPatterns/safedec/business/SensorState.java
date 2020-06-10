/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.designPatterns.safedec.business;

import com.designPatterns.safedec.Views.SensorIcon;

/**
 *
 * @author Prashul Singh
 */
public interface SensorState {
    void handleChange(SensorIcon sensor);
    SensorState nextState();
}

