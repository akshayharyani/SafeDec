/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.designPatterns.safedec.business;

/**
 *
 * @author Prashul Singh
 */
public class BuildingSystem {
    SystemState state;
    
    public BuildingSystem( SystemState newState )
    {
        this.state = newState;
    }
    
    public void handleState()
    {
        this.state.handleState();
    }
    
    public void nextState()
    {
        this.state.nextState();
    }
    
}
