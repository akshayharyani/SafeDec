/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.designPatterns.safedec.Views;


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

/**
 *
 * @author akshayharyani
 */
public class BillingPanel extends javax.swing.JPanel {

    private Document document;
    private PdfWriter writer;
    private javax.swing.table.DefaultTableModel billingModel;
    
    /**
     * Creates new form BillingPanel
     */
    public BillingPanel() {
        initComponents();
        billingModel = (javax.swing.table.DefaultTableModel) billingTable.getModel();
        billingModel.addRow(new Object[]{"1","Fire sensor","02/02/2020","$20"});
    }

    public void openPdf() throws FileNotFoundException, DocumentException {
       
    }

    public void closePdf() {
        document.close();
    }

    public void addData() throws DocumentException,  FileNotFoundException, DocumentException {
        document = new Document(PageSize.A4);
        writer = PdfWriter.getInstance(document, new FileOutputStream("./bill.pdf"));
        document.open();
        PdfPTable pdfTable = new PdfPTable(4);
        pdfTable.setHeaderRows(1);

        //adding table headers
        for (int i = 0; i < billingTable.getColumnCount(); i++) {
            pdfTable.addCell(billingTable.getColumnName(i));    
        }
        //extracting data from the JTable and inserting it to PdfPTable
        for (int rows = 0; rows < billingTable.getRowCount(); rows++) {
            for (int cols = 0; cols < billingTable.getColumnCount(); cols++) {
                pdfTable.addCell(billingTable.getModel().getValueAt(rows, cols).toString());

            }
        }
  

        document.add(pdfTable);
//        document.add(new Paragraph("Hello World!"));
        document.close();
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
                "Sensor Id","Sensor Type", "Install Date", "Price"
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
                        .addGap(169, 169, 169)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(totalLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(costLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(saveButton))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 299, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(56, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(totalLabel)
                    .addComponent(costLabel)
                    .addComponent(saveButton))
                .addContainerGap(47, Short.MAX_VALUE))
        );

        saveButton.getAccessibleContext().setAccessibleName("Save to Pdf");
    }// </editor-fold>//GEN-END:initComponents

    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed
        try {
            openPdf();
            addData();
//            closePdf();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (DocumentException e) {
            e.printStackTrace();
        }
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
