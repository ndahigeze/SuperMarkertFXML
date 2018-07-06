/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package suspermarketfxml.suspendedUIControl;

import Domain.Employee;
import Domain.SuspendedEmployee;
import Implement.IEmployee;
import Implement.ISuspendedEmployee;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import confClass.Converter;
import confClass.DateConverter;
import java.net.URL;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.paint.Color;

/**
 * FXML Controller class
 *
 * @author NDAHIGEZE
 */
public class SuspendedUIController implements Initializable {
    Converter c;
    DateConverter dc;
  //  suspendedlist table declaration
    @FXML private TableView<SuspendedEmployee> suspendedEmployeeList;
    @FXML private TableColumn<SuspendedEmployee, Integer> ID;
    @FXML   private TableColumn<SuspendedEmployee, String> firstName;
    @FXML  private TableColumn<SuspendedEmployee, String> lastName;
    @FXML private TableColumn<SuspendedEmployee, Date> hiredDate;
    @FXML  private TableColumn<SuspendedEmployee, String> location;
    @FXML  private TableColumn<SuspendedEmployee, String> password;
    @FXML private TableColumn<SuspendedEmployee, String> userName;
    @FXML    private TableColumn<SuspendedEmployee, String> emailAddress;
    @FXML  private TableColumn<SuspendedEmployee, String> post;
    @FXML   private TableColumn<SuspendedEmployee, Date> suspendedDate;
    //suspendedlist table declaration end;
    @FXML
    private JFXButton searchSuspend;
    @FXML
    private JFXTextField sid;
    @FXML
    private JFXDatePicker sDate;
    @FXML private Label info;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        onStart();
    }    
        private void onStart(){
              viewSuspendeEmployee();
        }
    @FXML
    private void searchSuspendedEmployee(ActionEvent event) {
       dc=new DateConverter();
       LocalDate dt=sDate.getValue();
          //c=new Converter();
          // int idi=c.getIValue(sid.getText());
          ObservableList<SuspendedEmployee> list=ISuspendedEmployee.searchBySDate(dc.convertLocaDate(dt));
         // list=ISuspendedEmployee.viewSuspended();
        if(list.isEmpty()){
             info.setTextFill(Color.RED);
             info.setText("There is no suspended Employee of  date: "+ dt);
        }else{
       ID.setCellValueFactory(new PropertyValueFactory<>("Id"));
       firstName.setCellValueFactory(new PropertyValueFactory<>("FirstName"));
       lastName.setCellValueFactory(new PropertyValueFactory<>("LastName"));
       userName.setCellValueFactory(new PropertyValueFactory<>("UserName"));
       location.setCellValueFactory(new PropertyValueFactory<>("Location"));
       emailAddress.setCellValueFactory(new PropertyValueFactory<>("Email"));
       post.setCellValueFactory(new PropertyValueFactory<>("Post"));
       hiredDate.setCellValueFactory(new PropertyValueFactory<>("HireDate"));
       suspendedDate.setCellValueFactory(new PropertyValueFactory<>("SuspendedDate"));
       suspendedEmployeeList .setItems(list);
        }
        sid.setText(null);
    }
    private void viewSuspendeEmployee(){
        ObservableList<SuspendedEmployee> list=ISuspendedEmployee.viewSuspended();
        if(list.isEmpty()){
           info.setText("There is no suspended Employee");
        }else{
       ID.setCellValueFactory(new PropertyValueFactory<>("Id"));
       firstName.setCellValueFactory(new PropertyValueFactory<>("FirstName"));
       lastName.setCellValueFactory(new PropertyValueFactory<>("LastName"));
       userName.setCellValueFactory(new PropertyValueFactory<>("UserName"));
       location.setCellValueFactory(new PropertyValueFactory<>("Location"));
       emailAddress.setCellValueFactory(new PropertyValueFactory<>("Email"));
       post.setCellValueFactory(new PropertyValueFactory<>("Post"));
       hiredDate.setCellValueFactory(new PropertyValueFactory<>("HireDate"));
       suspendedDate.setCellValueFactory(new PropertyValueFactory<>("SuspendedDate"));
       suspendedEmployeeList .setItems(list);
        }
        
    }
   
}
