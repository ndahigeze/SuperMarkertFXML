/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supermarkertfxml.EmployeeUIControl;

import Domain.Sales;
import Implement.ISale;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import java.awt.Color;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import supermarkertfxml.loginUIControl.LoginUI;

/**
 * FXML Controller class
 *
 * @author NDAHIGEZE
 */
public class EmployeeFormController implements Initializable {

    @FXML
    private TextField spdTf;
    @FXML
    private TextField sPnameTf;
    @FXML
    private JFXButton searchProductBTN;
    @FXML
    private Label vatLabel;
    @FXML
    private TableView<Sales> AvailableProductTable;
    @FXML
    private TableColumn<Sales, String> AProductNameColumn;
    @FXML
    private TableColumn<Sales, String> AdescriptionColumn;
    @FXML
    private TableColumn<Sales, String> AQTYColumn;
    @FXML
    private TableColumn<Sales, String> APriceUnitColumn;
    @FXML
    private Label totalPayAmountLable;
    @FXML
    private TableView<?> CurrentTransactionTable;
    @FXML
    private TableColumn<?, ?> CproductNameColumn;
    @FXML
    private TableColumn<?, ?> CDescriptionColumn;
    @FXML
    private TableColumn<?, ?> CqtyColumn;
    @FXML
    private TableColumn<?, ?> CnetAmountColumn;
    @FXML
    private TableColumn<?, ?> CVATcolumn;
    @FXML
    private TableColumn<?, ?> CTotalAmountColumn;
    @FXML
    private TextField sepnameTf;
    @FXML
    private TextField soldQTYTf;
    @FXML
    private Label priceabel;
    @FXML
    private JFXButton calculatePriceBTN;
    @FXML
    private JFXButton recordBTN;
    @FXML
    private JFXButton canselBTN;
    @FXML
    private JFXButton showInvoiceBTN;
    @FXML
    private TextField sDtTf;
    @FXML
    private TextField sntTf;
    @FXML
    private JFXDatePicker stdTf;
    @FXML
    private JFXButton searchTransaction;
    @FXML
    private TableView<?> transactionTable;
    @FXML
    private TableColumn<?, ?> tpNameColumn;
    @FXML
    private TableColumn<?, ?> TDescriptionColumn;
    @FXML
    private TableColumn<?, ?> sqtyColumn;
    @FXML
    private TableColumn<?, ?> tpriceColumn;
    @FXML
    private TableColumn<?, ?> tNetAmountColumn;
    @FXML
    private TableColumn<?, ?> tVATColumn;
    @FXML
    private TableColumn<?, ?> tTotalAmountColumn;
    @FXML
    private MenuItem logout;
    @FXML
    private MenuItem exit;
    @FXML
    private Label searchResult;
    @FXML
    private JFXButton refreshAvailbaleBTN;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        onStart();
    }    

    @FXML
    private void searchProduct(ActionEvent event) {
        sPnameTf.getText();
        spdTf.getText();
        if(sPnameTf.getText().isEmpty()||spdTf.getText().isEmpty()){
            searchResult.setText("Product Not Found");
        }else{
            Sales sl=ISale.findToSale(sPnameTf.getText(), spdTf.getText());
            ObservableList<Sales> list=FXCollections.observableArrayList();
            list.add(sl);
            AProductNameColumn.setCellValueFactory(new PropertyValueFactory<>("PName"));
            AdescriptionColumn.setCellValueFactory(new PropertyValueFactory<>("PDescription"));
            AQTYColumn.setCellValueFactory(new PropertyValueFactory<>("UnityTypeQuantity"));
            APriceUnitColumn.setCellValueFactory(new PropertyValueFactory<>("SpriceUnity"));
            AvailableProductTable.setItems(list);

        }
        sPnameTf.setText(null);
        spdTf.setText(null);
    }


    @FXML
    private void calculatePrice(ActionEvent event) {
    }

    @FXML
    private void recordTransaction(ActionEvent event) {
    }

    @FXML
    private void canselTransaction(ActionEvent event) {
    }

    @FXML
    private void showInvoice(ActionEvent event) {
    }

    @FXML
    private void searchTransaction(ActionEvent event) {
    }

    @FXML
    private void viewProductInfo(MouseEvent event) {
    }

    @FXML
    private void logout(ActionEvent event) throws Exception {
        new LoginUI().start(new Stage());
        EmployeeUI.close();
    }

    @FXML
    private void quit(ActionEvent event) {
        EmployeeUI.close();
    }
    void showVAT(){
        List<Sales> list=ISale.showTax();
        if(!list.isEmpty()){
            list.forEach((s)->{
                vatLabel.setText("RWF "+s.getVat()+" %");
        });
        }
    }
    void viewProducts(){

         ObservableList<Sales> list=ISale.findAll();
         AProductNameColumn.setCellValueFactory(new PropertyValueFactory<>("PName"));
         AdescriptionColumn.setCellValueFactory(new PropertyValueFactory<>("PDescription"));
         AQTYColumn.setCellValueFactory(new PropertyValueFactory<>("UnityTypeQuantity"));
         APriceUnitColumn.setCellValueFactory(new PropertyValueFactory<>("SpriceUnity"));
         AvailableProductTable.setItems(list);
        
    }
    void onStart(){
        showVAT();
        viewProducts();
    }

    @FXML
    private void refreshAvailbale(ActionEvent event) {
        viewProducts();
    }
}
