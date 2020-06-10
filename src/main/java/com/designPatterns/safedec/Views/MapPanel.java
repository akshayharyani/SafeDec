/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.designPatterns.safedec.Views;

import java.awt.Insets;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import com.designPatterns.safedec.business.FlyweightSensorIconFactory;
import com.designPatterns.safedec.business.SensorState;
import com.designPatterns.safedec.business.SensorStateOff;
import com.designPatterns.safedec.business.SensorStateOn;
import com.designPatterns.safedec.controls.ViewController;
import com.designPatterns.safedec.dao.SensorDAO;
import com.designPatterns.safedec.dao.SensorDAOImpl;
import com.designPatterns.safedec.models.FireSensor;
import com.designPatterns.safedec.models.Location;
import com.designPatterns.safedec.models.MotionSensor;
import com.designPatterns.safedec.models.Sensor;
import com.designPatterns.safedec.service.MapService;
import java.awt.image.BufferedImage;
import java.io.InputStream;
import javax.imageio.ImageIO;

/**
 *
 * @author Prashul Singh
 */
public class MapPanel extends javax.swing.JPanel {

    /**
     * Creates new form MapView
     *
     */
    private int sectionId = 1;
    public MapPanel() {
        initComponents();
        updateComponents();
        updateTable();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        mainPanel = new javax.swing.JPanel();
        subMapPanel = new javax.swing.JPanel();
        sensorTableLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        sensorsTable = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        sectionDropdown = new javax.swing.JComboBox<>();
        addFireSensorButton = new javax.swing.JToggleButton();
        addSecuritySensor = new javax.swing.JButton();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(jTable1);

        mainPanel.setMaximumSize(new java.awt.Dimension(500, 500));
        mainPanel.setPreferredSize(new java.awt.Dimension(1260, 411));

        subMapPanel.setMaximumSize(new java.awt.Dimension(200, 200));
        subMapPanel.setName(""); // NOI18N
        subMapPanel.setOpaque(false);
        subMapPanel.setPreferredSize(new java.awt.Dimension(950, 470));

        javax.swing.GroupLayout subMapPanelLayout = new javax.swing.GroupLayout(subMapPanel);
        subMapPanel.setLayout(subMapPanelLayout);
        subMapPanelLayout.setHorizontalGroup(
            subMapPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 882, Short.MAX_VALUE)
        );
        subMapPanelLayout.setVerticalGroup(
            subMapPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 472, Short.MAX_VALUE)
        );

        sensorTableLabel.setText("Sensors");

        sensorsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object[][]{

            },
            new String [] {
                "Sensor Id", "Type","Pos"
            }
        ));
        jScrollPane1.setViewportView(sensorsTable);

        jLabel1.setText("Section");

        sectionDropdown.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Section 1", "Section 2", "Section 3", "Section 4" }));
        sectionDropdown.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sectionDropdownActionPerformed(evt);
            }
        });

        addFireSensorButton.setText("Add fire sensor");
        addFireSensorButton.setToolTipText("");
        addFireSensorButton.setActionCommand("Add sensor");
        addFireSensorButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addFireSensorButtonMouseClicked(evt);
            }
        });
        addFireSensorButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addFireSensorButtonActionPerformed(evt);
            }
        });

        addSecuritySensor.setText("Add Security Sensor");
        addSecuritySensor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addSecuritySensorActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(mainPanelLayout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(sectionDropdown, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(addFireSensorButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(addSecuritySensor))
                            .addGroup(mainPanelLayout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(subMapPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 882, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addComponent(sensorTableLabel)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainPanelLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(sectionDropdown, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addFireSensorButton)
                    .addComponent(addSecuritySensor))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(sensorTableLabel)
                .addGap(5, 5, 5)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addComponent(subMapPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 472, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(5, 5, 5))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 1063, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 546, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void sectionDropdownActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sectionDropdownActionPerformed
        // TODO add your handling code here:
        System.out.println("section dropdown ");
        sectionId = (((javax.swing.JComboBox) evt.getSource()).getSelectedIndex() + 1);
        subMapPanel.removeAll();
        subMapPanel.revalidate();
        subMapPanel.repaint();
        updateComponents();
        updateTable();
        revalidate();
        repaint();
    }//GEN-LAST:event_sectionDropdownActionPerformed

    private void addFireSensorButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addFireSensorButtonActionPerformed
        // TODO add your handling code here:
        String ipAddress = "198.789.23.456";
        Location loc = new Location(100, 200);
        int portNumber  = 3456;
        int price = 20;
        
        FireSensor sensor = new FireSensor();
        sensor.setIpAddress(ipAddress);
        
        sensor.setLoc(loc);
        sensor.setPortNumber(portNumber);
        sensor.setPrice(price);
        sensor.setSectionId(sectionId);
        
       
        SensorDAO sensorDAO = new SensorDAOImpl();
        boolean flag = sensorDAO.createFireSensor(ViewController.getInstance().getLoggedInUser(),sensor);
        allSensors.add(sensor);
        updateTable();
        createNewSensorIcon(sensor);
    }//GEN-LAST:event_addFireSensorButtonActionPerformed

    private void addSecuritySensorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addSecuritySensorActionPerformed
        // TODO add your handling code here:
         
        String ipAddress = "198.789.23.456";
        Location loc = new Location(100, 200);
        int portNumber  = 3456;
        int price = 10;
        
        MotionSensor sensor = new MotionSensor();
        sensor.setIpAddress(ipAddress);
        sensor.setIsCamera(true);
        
        sensor.setLoc(loc);
        sensor.setPortNumber(portNumber);
        sensor.setPrice(price);
        sensor.setSectionId(sectionId);
        
       
        SensorDAO sensorDAO = new SensorDAOImpl();
        boolean flag = sensorDAO.createMotionSensor(ViewController.getInstance().getLoggedInUser(),sensor);
        allSensors.add(sensor);
        updateTable();
        createNewSensorIcon(sensor);
        
    }//GEN-LAST:event_addSecuritySensorActionPerformed

    private void addFireSensorButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addFireSensorButtonMouseClicked
        // TODO add your handling code here:

    }//GEN-LAST:event_addFireSensorButtonMouseClicked

    private List< FireSensor > alarms;
    private List< MotionSensor> sensors;
    private List< Sensor > allSensors;
    Map< Long, SensorIcon > sensorIcons;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton addFireSensorButton;
    private javax.swing.JButton addSecuritySensor;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JComboBox<String> sectionDropdown;
    private javax.swing.JLabel sensorTableLabel;
    private javax.swing.JTable sensorsTable;
    private javax.swing.JPanel subMapPanel;
    // End of variables declaration//GEN-END:variables
//


    private void updateComponents() {
        subMapPanel.setLayout(null);
        System.out.println("safedec.views.MapView.updateComponents()");
        URL url = getClass().getResource("/BuildingA.jpg");
        ImageIcon imageIcon = new ImageIcon(url);
        JLabel mapPicLabel = new javax.swing.JLabel(imageIcon);
        subMapPanel.add(mapPicLabel);
        Insets insets = subMapPanel.getInsets();
        System.out.println( mapPicLabel.getIcon().getIconWidth() + " " + mapPicLabel.getIcon().getIconHeight());
        mapPicLabel.setBounds(insets.left, insets.top, mapPicLabel.getIcon().getIconWidth(), mapPicLabel.getIcon().getIconHeight());
        
        MapService service = new MapService();
        allSensors = new ArrayList< Sensor >();
        allSensors.addAll(service.getAllSensorsBySection(sectionId));

       sensorIcons = new HashMap<>();

       refreshSensorIcons();
    }
    
     private void refreshSensorIcons()
     {      
        Set<Integer> exsitingSensorIds = new HashSet<>();
        
        for (Sensor sensor : allSensors) {
            // Record all existing sensor ids for deleting missing sensors
            exsitingSensorIds.add(sensor.getId());
            // Donot add duplicated sensor icons
            if (sensorIcons.containsKey(sensor.getId())) {
                continue;
            }
            
            createNewSensorIcon(sensor);
           
        }
     }
     
     public void createNewSensorIcon(Sensor sensor){
            SensorIcon newSensor = FlyweightSensorIconFactory.getSensorIcon(sensor);
            subMapPanel.add(newSensor);
            sensorIcons.put(newSensor.getSensorId(), newSensor);
            Insets insets = subMapPanel.getInsets();
            int ScreenPosX = insets.left + newSensor.getIcon().getIconWidth();
            int ScreenPosY = insets.top;
            int width = newSensor.getIcon().getIconWidth();
            int height = newSensor.getIcon().getIconHeight();
            ScreenPosX = sensor.getLoc().getX1();
            ScreenPosY = sensor.getLoc().getY1();
            newSensor.setBounds(ScreenPosX, ScreenPosY, width, height);
            SensorState newState = new SensorStateOn();

            newSensor.changeState(newState);

     }
     
     public void goActiveState() {
        SensorState newState = new SensorStateOn();
        for (Long sensorId: sensorIcons.keySet()) {
            sensorIcons.get(sensorId).changeState(newState);
        }
    }
    
    private void updateTable( ) {
        javax.swing.table.DefaultTableModel sensorModel = (javax.swing.table.DefaultTableModel) sensorsTable.getModel();
        sensorModel.setRowCount(0);
        for( Sensor sensor : allSensors )
        {
            Object[]  tableRow = new Object[8];
            tableRow[0]= sensor.getId();
            if( sensor instanceof MotionSensor )
                tableRow[1] = "MotionSensor";
            else
                tableRow[1] = "FireSensor";
            tableRow[2]= sensor.getLoc().getX1()+","+sensor.getLoc().getY1();
            
             sensorModel.addRow(tableRow);
        }
       
    }

     
}
