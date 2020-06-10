/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.designPatterns.safedec.business;

import java.applet.Applet;
import java.applet.AudioClip;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import javax.swing.ImageIcon;
import com.designPatterns.safedec.models.MotionSensor;
import com.designPatterns.safedec.models.Sensor;
import com.designPatterns.safedec.Views.SensorIcon;

/**
 *
 * @author Prashul Singh
 */
public class FlyweightSensorIconFactory {

    private static final Map<String, ImageIcon> sensorImageIcons = new HashMap<>();
    private static final Map<String, AudioClip> sensorAudioClips = new HashMap<>();
    
    private static ImageIcon getImageIcon(String key) {
        if (!sensorImageIcons.containsKey(key)) {
            System.out.println("safedec.business.FlyweightSensorIconFactory.getImageIcon()" + key );
            URL url = FlyweightSensorIconFactory.class.getResource(key);
            ImageIcon icon = new ImageIcon(url);
            sensorImageIcons.put(key, icon);
        }
        return sensorImageIcons.get(key);
    }
    
    private static AudioClip getAudioClip(String key) {
        if (!sensorAudioClips.containsKey(key)) {
            URL url = FlyweightSensorIconFactory.class.getResource(key);
            AudioClip clip = Applet.newAudioClip(url);
            sensorAudioClips.put(key, clip);
        }
        return sensorAudioClips.get(key);
    }
    
    public static SensorIcon getSensorIcon(Sensor sensorInfo) {
        
        ImageIcon downIcon = null;
        ImageIcon offIcon = null;
        ImageIcon onIcon = null;
        ImageIcon hotIcon = null;
        AudioClip alertClip = null;

        if( sensorInfo instanceof MotionSensor )
        {       downIcon = getImageIcon("/safedec/res/FireAlarmDown.gif");
                offIcon = getImageIcon("/safedec/res/FireAlarmOff.gif");
                onIcon = getImageIcon("/safedec/res/FireAlarmOn.gif");
                hotIcon = getImageIcon("/safedec/res/FireAlarmAlert.gif");
                alertClip = getAudioClip("/safedec/res/FireAlarm.wav");
        }
        else {
                downIcon = getImageIcon("/safedec/res/SecurityAlarmDown.gif");
                offIcon = getImageIcon("/safedec/res/SecurityAlarmOff.gif");
                onIcon = getImageIcon("/safedec/res/SecurityAlarmOn.gif");
                hotIcon = getImageIcon("/safedec/res/SecurityAlarmAlert.gif");
                alertClip = getAudioClip("/safedec/res/SecurityAlarm.wav");
        }
        
        
        SensorIcon sensorIcon = new SensorIcon(sensorInfo.getId(), downIcon, offIcon, onIcon, hotIcon, alertClip,sensorInfo);
                
        sensorIcon.setRolloverEnabled(false);
        sensorIcon.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            @Override
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                sensorIcon.sensorIconMouseDragged(evt);
            }
        });
        sensorIcon.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                sensorIcon.sensorIconMouseClicked(evt);
            }
            @Override
            public void mousePressed(java.awt.event.MouseEvent evt) {
                sensorIcon.sensorIconMousePressed(evt);
            }

            @Override
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                sensorIcon.sensorIconMouseReleased(evt);
            }
        });
        return sensorIcon;
    }
}
