/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supermarkertfxml.EmployeeUIControl;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
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
    private TableView<?> AvailableProductTable;
    @FXML
    private TableColumn<?, ?> AProductNameColumn;
    @FXML
    private TableColumn<?, ?> AdescriptionColumn;
    @FXML
    private TableColumn<?, ?> AQTYColumn;
    @FXML
    private TableColumn<?, ?> APriceUnitColumn;
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
    private JFXTextField sepnameTf;
    @FXML
    private JFXTextField sepdTf;
    @FXML
    private JFXTextField soldQTYTf;
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

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void searchProduct(ActionEvent event) {
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
    
}
