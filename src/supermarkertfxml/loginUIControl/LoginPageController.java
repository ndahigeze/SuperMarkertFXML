/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supermarkertfxml.loginUIControl;

import supermarkertfxml.ManagerUIControl.ManagerUI;
import supermarkertfxml.EmployeeUIControl.EmployeeUI;
import Domain.Employee;
import Domain.Manager;
import Implement.IEmployee;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import confClass.Logged;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.stage.Stage;
import Implement.IManager;
import confClass.Converter;
import javafx.scene.control.Label;
import supermarkertfxml.createAccountUIControl.CreateAccountUI;

/**
 * FXML Controller class
 *
 * @author NDAHIGEZE
 */
public class LoginPageController implements Initializable {
    
    /**
     * Initializes the controller class.
     */
    private Converter c;
    @FXML
    private Label PFailMessage;
      @FXML
    private JFXTextField userNameTf;

    @FXML
    private JFXPasswordField passwordTf;

      @FXML
    private JFXButton malBTN;

    @FXML
    private JFXButton emLogin;

    @FXML
    private JFXButton createAcc;

    @FXML
    void createAccount(ActionEvent event) throws Exception {
               new CreateAccountUI().start(new Stage());
               LoginUI.close();
    }

    @FXML
    void loginAsEmployee(ActionEvent event) throws Exception {
        c=new Converter();    
        Logged lg=new Logged();
        String username=userNameTf.getText();
        String password=c.md5(passwordTf.getText());
        IEmployee iemp=new IEmployee();
        Employee emp=IEmployee.findByUsername(username, password);
        if(emp==null){
             PFailMessage.setText("Wrong credatial please try Again");
        }else{
            int id=emp.getId();
            iemp.MakeActive(id);
            new EmployeeUI().start(new Stage());
            LoginUI.close();
        }   
    }

    @FXML
    void loginAsManager(ActionEvent event) throws Exception {
        c=new Converter();
           Logged lg=new Logged();
          String userName=userNameTf.getText();
         String password=c.md5(passwordTf.getText());
         IManager ima=new IManager();
         Manager ma=IManager.login(userName, password);
         if(ma==null){
             PFailMessage.setText("Wrong credential please try Again");
         } else { 
             int id=ma.getId();
             ima.MakeActive(id);
                 new ManagerUI().start(new Stage());
                 LoginUI.close();
      } 
        
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
