/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.designPatterns.safedec.controls;

import java.util.logging.Level;
import java.util.logging.Logger;
import com.designPatterns.safedec.Views.MainView;
import com.designPatterns.safedec.connectionpooling.JDBCConnectionPool;
import com.designPatterns.safedec.connectionpooling.ObjectPool;
import com.designPatterns.safedec.models.Customer;
import com.designPatterns.safedec.models.Sensor;
import com.designPatterns.safedec.service.SensorService;
import com.designPatterns.safedec.Views.LoginView;
import com.designPatterns.safedec.Views.SignupView;

/**
 *
 * @author Prashul Singh
 */
public class ViewController {
    
   
   private static ViewController viewController;
   private LoginView loginView;
   private ObjectPool connectionPool;
   private Customer loggedInUser;
   private MainView mainView;
   private SignupView signupView;
   
   private ViewController()
   {
        connectionPool = new JDBCConnectionPool(
  "com.mysql.cj.jdbc.Driver", "jdbc:mysql://localhost:3306/safedec",
  "root", "akshay007");

       viewController = this;
       this.loginView = new LoginView();
       this.loginView.setVisible(true);
       System.out.println("safedec.controls.ViewController.<init>()" + this.loginView.getShape());
       
   }
   
   public static ViewController getInstance()
   {
       if( viewController == null )
           viewController = new ViewController();
       System.out.println("Get Instance is called ");
       return viewController;
   }

   public void launch()
   {
       this.loginView.setVisible(true);
     
       System.out.println("safedec.controls.ViewController.launch()");
   }
    public LoginView getLoginView() {
        return loginView;
    }

    public void setLoginView(LoginView loginView) {
        this.loginView = loginView;
    }

    public ObjectPool getConnectionPool() {
        return connectionPool;
    }

    public void setConnectionPool(ObjectPool connectionPool) {
        this.connectionPool = connectionPool;
    }
    
     public Customer getLoggedInUser() {
        return loggedInUser;
    }

    public void setLoggedInUser(Customer loggedInUser) {
        this.loggedInUser = loggedInUser;
    }
    
     public void login(Customer customer) {
         this.setLoggedInUser( customer );
        
        if (mainView == null) {
            mainView = new MainView();
        }
        if (loginView != null) {
            loginView.setVisible(false);
        }
        if (signupView != null) {
            signupView.setVisible(false);
        }
        mainView.setVisible(true);
        
//        this.sosafeServer.listen(ViewController.SOSAFE_SERVER_PORT_NUMBER);
//        Long maxSN = this.alarmInfoJpaController.getMaxSerialNumber();
//        if (maxSN != null) {
//            maxAlarmSerialNumber.set(maxSN);
//        }
//        Long maxID = this.sensorInfoJpaController.getMaxSensorId();
//        if (maxID != null) {
//            maxSensorId.set(maxID);
//        }
    }
    public void updateSensorScreenPos(Sensor sensorInfo, int screenPosX, int screenPosY) {
        String newPos = screenPosX + "," + screenPosY;
        SensorService service = new SensorService();
        if( service.updateSensorPosition(sensorInfo,screenPosX, screenPosY) )
        {
            System.out.println("safedec.controls.ViewController.updateSensorScreenPos()+-----------------------------"+ newPos);
          Logger.getLogger(ViewController.class.getName()).log(Level.INFO, null, "Sensor position updated");
        }
        else
             Logger.getLogger(ViewController.class.getName()).log(Level.SEVERE, null, "Error while updating sensor position");
    }
    
     
    public void signup(){
         if( signupView == null )
               signupView = new SignupView();
         signupView.setVisible(true);
         loginView.setVisible(false);
     }
}
