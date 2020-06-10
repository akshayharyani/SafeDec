/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.designPatterns.safedec.models;

import java.util.List;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author akshayharyani
 */
public class TextReport implements Report {
    
    private List<Sensor> sensors;
     private Document document;
    private PdfWriter writer;
    
    public TextReport(List<Sensor> sensors){
        this.sensors = sensors;
    }
            
    public void save(){
        try {
            addData();
        } catch (DocumentException ex) {
            Logger.getLogger(TextReport.class.getName()).log(Level.SEVERE, null, ex);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(TextReport.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void addData() throws DocumentException,  FileNotFoundException, DocumentException {
        document = new Document(PageSize.A4);
        writer = PdfWriter.getInstance(document, new FileOutputStream("./bill.pdf"));
        document.open();
        PdfPTable pdfTable = new PdfPTable(4);
        pdfTable.setHeaderRows(1);

        //adding table headers
        pdfTable.addCell("Sensor Id");    
        pdfTable.addCell("Sensor Type");    
        pdfTable.addCell("Section Id");    
        pdfTable.addCell("Price");    
        

        
        for(Sensor sensor : sensors){
            String type = "fire sensor";
            if (sensor instanceof MotionSensor){
                type = "motion sensor ";
                MotionSensor ms = (MotionSensor) sensor;
                if(ms.isIsCamera())
                    type += "(with camera)";
                else
                    type += "(without camera)";

            }
            
            pdfTable.addCell(String.valueOf(sensor.getId()));
            pdfTable.addCell(type);
            pdfTable.addCell(String.valueOf(sensor.getSectionId()));
            pdfTable.addCell(String.valueOf(sensor.getPrice()));

        }
  

        document.add(pdfTable);
        document.close();
    }
    
    
}
