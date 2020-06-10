/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.designPatterns.safedec.Views;

/**
 *
 * @author Prashul Singh
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.applet.AudioClip;
import java.awt.Point;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import com.designPatterns.safedec.business.SensorState;
import com.designPatterns.safedec.business.SensorStateOn;
import com.designPatterns.safedec.controls.ViewController;
import com.designPatterns.safedec.models.Sensor;

/**
 *
 * @author Prashul Singh
 */
public class SensorIcon extends JButton {
    
    private ImageIcon downIcon;
    private ImageIcon offIcon;
    private ImageIcon onIcon;
    private ImageIcon hotIcon;
    private AudioClip alertClip;
    private Point dragOffset;
    private SensorState currState;
    private Sensor sensor;

    public SensorIcon(long sensorId, ImageIcon downIcon, ImageIcon offIcon, ImageIcon onIcon, ImageIcon hotIcon, AudioClip alertClip,Sensor sensorInfo) {
        super(onIcon);
        this.downIcon = downIcon;
        this.offIcon = offIcon;
        this.onIcon = onIcon;
        this.hotIcon = hotIcon;
        this.alertClip = alertClip;
        this.dragOffset = new Point(0,0);
        this.currState = new SensorStateOn();
        this.sensor = sensorInfo;
    }
    
    public long getSensorId() {
        return this.sensor.getId();
    }

    public ImageIcon getDownIcon() {
        return downIcon;
    }
    
    public ImageIcon getOffIcon() {
        return offIcon;
    }
    
    public ImageIcon getOnIcon() {
        return onIcon;
    }

    public ImageIcon getHotIcon() {
        return hotIcon;
    }
    
    public AudioClip getAlertClip() {
        return alertClip;
    }
    
    public void sensorIconMouseDragged(java.awt.event.MouseEvent evt) {                                               
        // TODO add your handling code here:
        evt.getComponent().setLocation(evt.getComponent().getX() - dragOffset.x + evt.getX(), 
                evt.getComponent().getY() - dragOffset.y + evt.getY());
    }
    
    public void sensorIconMouseClicked(java.awt.event.MouseEvent evt) {                                               
        // TODO add your handling code here:
        // For demo purpose
        if (evt.getClickCount() == 2) {
            goNextState();
        }
    }
    public void sensorIconMousePressed(java.awt.event.MouseEvent evt) {                                               
        // TODO add your handling code here:
        dragOffset = evt.getPoint();
        evt.getComponent().getParent().setComponentZOrder(evt.getComponent(), 0);
    }
    
    public void sensorIconMouseReleased(java.awt.event.MouseEvent evt) {                                               
       // TODO add your handling code here:
        System.out.println("safedec.views.SensorIcon.sensorIconMouseReleased()");
        ViewController.getInstance().updateSensorScreenPos(sensor, evt.getComponent().getX(), evt.getComponent().getY());
    }
    
    public void changeState(SensorState state) {
        currState = state;
        currState.handleChange(this);
    }
    
    public void goNextState() {
        currState = currState.nextState();
        currState.handleChange(this);
    }
}
