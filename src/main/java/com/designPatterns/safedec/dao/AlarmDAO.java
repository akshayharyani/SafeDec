/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.designPatterns.safedec.dao;

import java.util.List;
import com.designPatterns.safedec.models.Alarm;
import com.designPatterns.safedec.models.Customer;
import com.designPatterns.safedec.models.MotionSensor;

/**
 *
 * @author Prashul Singh
 */
public interface AlarmDAO {

    /**
     *
     * @param alarm
     * @return
     */
    public boolean create( Customer customer, Alarm alarm );
    public boolean destroy( Customer customer, Alarm alarm );
    public boolean edit( Customer customer, Alarm alarm );
    public List< Alarm > getAllAlarms( Customer customer );
    public List< Alarm > getAllAlarmsBySectionId( Customer customer, int sectionId );
}
