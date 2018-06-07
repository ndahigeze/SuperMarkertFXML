/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supermarkertfxml.createAccountUIControl;

import Domain.Employee;
import Domain.Manager;
import Domain.Sequence;
import Implement.IEmployee;
import Implement.IManager;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import confClass.Converter;
import confClass.DateConverter;
import confClass.ISequence;
import confClass.Logged;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import supermarkertfxml.loginUIControl.LoginUI;

/**
 * FXML Controller class
 *
 * @author NDAHIGEZE
 */
public class CreateAccountController implements Initializable {
Logged lg;
Converter c;
DateConverter dc;
Sequence seq;
//-===============
   @FXML
    private Label maInfiAlerts;
@FXML
    private Label empInfiAlerts;
    @FXML
    private JFXButton McreateAcountBTN;
    @FXML
    private JFXButton msignIn;
    @FXML
    private JFXTextField mfnTf;
    @FXML
    private JFXTextField mlbTf;
    @FXML
    private JFXTextField munTf;
    @FXML
    private JFXTextField meTf;
    @FXML
    private JFXTextField mlTF;
    @FXML
    private JFXPasswordField mpTf;
    @FXML
    private JFXPasswordField mcpTf;
    @FXML
    private JFXButton empCeateAccountBTN;
    @FXML
    private JFXButton empSignInBTN;
    @FXML
    private JFXTextField empidTf;
    @FXML
    private JFXTextField empunTf;
    @FXML
    private JFXTextField empeTf;
    @FXML
    private JFXPasswordField emppTf;
    @FXML
    private JFXPasswordField empcpTf;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void managerCreateAccount(ActionEvent event) {
    if(!checkMaf()){
        setManagerAcount();
    }else{
             maInfiAlerts.setTextFill(Color.RED);
            maInfiAlerts.setText("Please fill the blank fields");
    }
         clean();
    }

    @FXML
    private void managerSignIn(ActionEvent event) throws Exception {
          new LoginUI().start(new Stage());
               CreateAccountUI.close();  
    }
   boolean usernamePWordCheck(String username,int id){
        Employee iemp=IEmployee.findByUsernameCheck(username);
        Employee iemp2=IEmployee.findOne(id);
        return iemp==null &&iemp2!=null;
   }
    @FXML
    private void empCreateAccount(ActionEvent event) {
    if(!checkEMPTF()){
        setEmployeeAccount();
    }else{
        empInfiAlerts.setTextFill(Color.RED);
        empInfiAlerts.setText("Please fill the blank field");
    }
        clean();
    }

    void clean(){
      empunTf.setText(null);
      empidTf.setText(null);
      empunTf.setText(null);
      empeTf.setText(null); 
      emppTf.setText(null);  
      empcpTf .setText(null);  
      mfnTf.setText(null);
      mlbTf.setText(null);       
      munTf.setText(null);
      meTf.setText(null);
      mlTF.setText(null);
      mpTf.setText(null); 
      mcpTf .setText(null);       
    }
    boolean checkMaf(){
    if(
            mfnTf.getText().isEmpty()||
            mlbTf.getText().isEmpty()||
            munTf.getText().isEmpty()||
            meTf.getText().isEmpty()||
            mlTF.getText().isEmpty()||
            mpTf.getText().isEmpty()||
            mcpTf .getText().isEmpty()
            )
    {
      return true;
    }else{
    return false;
    } 
    }
    boolean checkEMPTF(){
    return
      empunTf.getText().isEmpty()||
      empidTf.getText().isEmpty()||
      empunTf.getText().isEmpty()||
      empeTf.getText().isEmpty()||
      emppTf.getText().isEmpty()||
      empcpTf .getText().isEmpty(); 
    }
    public void setEmployeeAccount(){
               lg=new Logged();
       c=new Converter();
       if(usernamePWordCheck(empunTf.getText(),c.getIValue(empidTf.getText()))){
            Employee emp=new Employee();
            IEmployee iemp=new IEmployee();
            emp.setUserName(empunTf.getText());
            emp.setId(c.getIValue(empidTf.getText()));
            emp.setEmail(empeTf.getText());
            emp.setPassword(c.md5(emppTf.getText()));
                    if(lg.passConfirmation(c.md5(emppTf.getText()), c.md5(empcpTf.getText()))){
                        iemp.CreateAccount(emp);
                            empInfiAlerts.setTextFill(Color.web("#0099cc"));
                        empInfiAlerts.setText("Acount created successfully");
                    }else{
                           maInfiAlerts.setTextFill(Color.RED);
                        empInfiAlerts.setText("Password not match");
                    }
       }else{
             empInfiAlerts.setTextFill(Color.RED);
             empInfiAlerts.setText("Check if ID Is correct or if USERNAME is not already used");  
       }
    }
    
    public void setManagerAcount(){
        lg=new Logged();
       c=new Converter();
       dc=new DateConverter();
        Manager ma=new Manager();
        IManager ima=new IManager();
         int result=ima.checkActiveManager();
        if(result!=0){
             maInfiAlerts.setTextFill(Color.web("#ff8800"));
            maInfiAlerts.setText("There is another current  Manager please sign in to change");
        }else{
        ma.setFirstName(mfnTf.getText());
        ma.setLastName(mlbTf.getText());
        ma.setUserName(munTf.getText());
        ma.setEmail(meTf.getText());
        ma.setLocation(mlTF.getText());
        ma.setSuspend(0);
        ma.setLogged(0);
        ma.setPrivillage(1);
        ma.setPost("Manager");
        ma.setHireDate(dc.dateNow());
        if(lg.passConfirmation(c.md5(mpTf.getText()), c.md5(mcpTf.getText()))){
            ma.setPassword(c.md5(mcpTf.getText()));
            ima.register(ma);
            maInfiAlerts.setTextFill(Color.web("#0099cc"));
            maInfiAlerts.setText("Account created Successfully Sign in");
        }else{
            maInfiAlerts.setTextFill(Color.web("#ff8800"));
            maInfiAlerts.setText("Password not match");
        }
        }
    }
    @FXML
    private void empSignIn(ActionEvent event) throws Exception {
        new LoginUI().start(new Stage());
        CreateAccountUI.close();
    }
    
}
