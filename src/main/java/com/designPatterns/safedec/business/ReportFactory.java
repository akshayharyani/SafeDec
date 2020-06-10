/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.designPatterns.safedec.business;

import com.designPatterns.safedec.models.Sensor;
import com.designPatterns.safedec.models.TextReport;
import java.util.List;
import com.designPatterns.safedec.models.Report;

/**
 *
 * @author akshayharyani
 */
public class ReportFactory implements ReportFactoryInterface {

    @Override
    public Report generateRport(String reportType, List<Sensor> sensors) {
        Report report = null;
         if(reportType.toLowerCase().equals("text")){
            report = new TextReport(sensors);
        }
        return report;
    }
    
    
    
}
