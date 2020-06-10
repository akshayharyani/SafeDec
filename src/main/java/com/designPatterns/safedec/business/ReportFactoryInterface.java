/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.designPatterns.safedec.business;

import com.designPatterns.safedec.models.Sensor;
import java.util.List;
import com.designPatterns.safedec.models.Report;

/**
 *
 * @author akshayharyani
 */
public interface ReportFactoryInterface {
    Report generateRport(String reportType, List<Sensor> sensors);
}
