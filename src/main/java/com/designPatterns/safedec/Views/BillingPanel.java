/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.designPatterns.safedec.Views;


import com.designPatterns.safedec.models.MotionSensor;
import com.designPatterns.safedec.models.Sensor;
import com.designPatterns.safedec.service.BillingService;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.GrayColor;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author akshayharyani
 */
public class BillingPanel extends javax.swing.JPanel {

    private Document document;
    private PdfWriter writer;
    private javax.swing.table.DefaultTableModel billingModel;
    private BillingService billingService;

    /**
     * Creates new form BillingPanel
     */
    public BillingPanel() {
        billingService = new BillingService();
        initComponents();
        updateTable();
        updateCostLabel();
    }

    public void updateCostLabel(){
        costLabel.setText(String.valueOf(billingService.getTotalAmount()));
    }
    
    public void updateTable(){
        billingModel = (javax.swing.table.DefaultTableModel) billingTable.getModel();

        List<Sensor> allSensors = billingService.getAllSensors();
        for( Sensor sensor : allSensors ){
            String type = "fire sensor";
            if (sensor instanceof MotionSensor){
                type = "motion sensor ";
                MotionSensor ms = (MotionSensor) sensor;
                if(ms.isIsCamera())
                    type += "(with camera)";
                else
                    type += "(without camera)";

            }
                    
            Object[]  tableRow = new Object[8];
            tableRow[0]= sensor.getId();
            tableRow[1]= type;
            tableRow[2]= sensor.getSectionId();
            tableRow[3]= sensor.getPrice();
            billingModel.addRow(tableRow);
        }
    }
   
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        billingTable = new javax.swing.JTable();
        totalLabel = new javax.swing.JLabel();
        costLabel = new javax.swing.JLabel();
        saveButton = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(500, 500));

        jLabel1.setText("Billing");
        jLabel1.setFocusCycleRoot(true);

        billingTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
            },
            new String [] {
                "Sensor Id","Sensor Type", "Section Id", "Price"
            }
        ));
        billingTable.setSize(new java.awt.Dimension(300, 300));
        jScrollPane1.setViewportView(billingTable);

        totalLabel.setText("Total Bill: ");

        costLabel.setText("$$");

        saveButton.setText("Save  to PDF");
        saveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(230, 230, 230)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(totalLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(costLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(saveButton))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 423, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(43, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(totalLabel)
                    .addComponent(costLabel)
                    .addComponent(saveButton))
                .addContainerGap(193, Short.MAX_VALUE))
        );

        saveButton.getAccessibleContext().setAccessibleName("Save to Pdf");
    }// </editor-fold>//GEN-END:initComponents

    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed
        billingService.createReport();
        JOptionPane.showMessageDialog(null, "PDF file for bill generated.");
    }//GEN-LAST:event_saveButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable billingTable;
    private javax.swing.JLabel costLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton saveButton;
    private javax.swing.JLabel totalLabel;
    // End of variables declaration//GEN-END:variables
}
