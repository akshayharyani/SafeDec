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
public class ActiveSystemState implements SystemState{


    public ActiveSystemState() {
        
    }
   
    @Override
    public void handleState() {
       //handle the Active state
       // ViewController.getInstance()
    }

    @Override
    public SystemState nextState() {
        return new ActiveSystemState();
    }
    
}
