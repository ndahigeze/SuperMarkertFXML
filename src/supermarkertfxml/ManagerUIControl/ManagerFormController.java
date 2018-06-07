/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supermarkertfxml.ManagerUIControl;

import Domain.Employee;
import Domain.Manager;
import Domain.Product;
import Domain.Sales;
import Implement.IEmployee;
import Implement.IManager;
import Implement.ISale;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import confClass.Converter;
import confClass.DateConverter;
import confClass.ISequence;
import confClass.Logged;
import Domain.Sequence;
import Implement.IProduct;
import com.jfoenix.controls.JFXRadioButton;
import java.net.URL;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import supermarkertfxml.loginUIControl.LoginUI;

/**
 * FXML Controller class
 *
 * @author NDAHIGEZE
 */
public class ManagerFormController implements Initializable {
     int maId;
     int empId;
     String pName;
     String pDescription;
     int pid;
    private double vat;
    private Converter c;
    private DateConverter dc;
    
    Sequence seq;
    DateConverter dg;
      Logged lg;
      //transactions
          @FXML
    private TableView<Sales> transactionList;
    @FXML private TableColumn<Sales, Integer> transactionNo;
    @FXML private TableColumn<Sales, Date> TransactionDate;
    @FXML private TableColumn<Sales, String> soldby;
    @FXML private TableColumn<Sales, String> ProductName;
    @FXML private TableColumn<Sales, String> ProductDescription;
    @FXML private TableColumn<Sales, String> QuantitySold;
    @FXML private TableColumn<Sales, String> Unitprice;
    @FXML private TableColumn<Sales, String> Netprice;
    @FXML private TableColumn<Sales, String> VAT;
    @FXML private TableColumn<Sales, String> Amount;
    @FXML
    private JFXButton rtBTN;
    @FXML private TableView<Sales> cashReceived;
    @FXML private TableColumn<Sales, Date> receivedDate;
    @FXML private TableColumn<Sales, String> AmountCash;
   @FXML
    private JFXButton searchTDTBTN;
    @FXML
    private JFXTextField stcTf;
    @FXML
    private JFXDatePicker trDateTf;
 @FXML
    private JFXDatePicker sadTf;
  @FXML
    private Label cashInfo;
  @FXML private Label transInfo;
      //end transactions
      //new code
       @FXML
    private JFXTextField searchP;
    @FXML
    private TextField pnTf;
    @FXML
    private TextField pdTf;
    @FXML
    private TextField qTf;
    @FXML
    private JFXRadioButton addRadio;
    @FXML
    private JFXRadioButton reduceRadio;
  @FXML
    private Label taxView;
    @FXML
    private TextField upTf;
    @FXML
    private TextField ucTf;
    @FXML
    private JFXButton reduceAddQuanity;
    @FXML
    private JFXButton addProductBTN;
   @FXML
    private JFXButton modifyProductBTN;
    @FXML
    private ToggleGroup AddReduceQuanity;
    @FXML
    //product list table
    private TableView<Product> productList;
    @FXML private TableColumn<Product,Integer> productId;
    @FXML private TableColumn<Product,String > productName;
    @FXML private TableColumn<Product, String> productDescription;
    @FXML  private TableColumn<Product, String> productQty;
    @FXML private TableColumn<Product, String> costUnity;
    @FXML private TableColumn<Product, String> priceUnity;
    @FXML private TableColumn<Product, Date> dateAdded;
    @FXML private TableColumn<Product, String> soldDecision;
    //end product list
    @FXML
    private JFXButton searchBydescription;
    @FXML
    private JFXTextField psdTf;
    @FXML
    private JFXTextField psnTf;
    @FXML
    private JFXButton searchPriceBTN;
    private JFXTextField searchPriceTf;
    @FXML
    private JFXComboBox<String> solddecComb;
    @FXML JFXComboBox<String> trcondComb;
    @FXML
    private JFXComboBox<String> unityTypecomb;
    @FXML
    private Label proInfoMessage;
    @FXML
    private JFXComboBox<String> psComb;
     @FXML
    private JFXButton refeshProductListBTN;
   //manager info table
    @FXML  private TableView<Manager> managerInfo;
    @FXML private TableColumn<Manager, Integer> mID;
    @FXML  private TableColumn<Manager, String> MFname;
    @FXML  private TableColumn<Manager, String> MLname;
    @FXML private TableColumn<Manager, String> MUsername;
    @FXML private TableColumn<Manager, String> MLocation;
    @FXML private TableColumn<Manager, String>MEmail;
    //end manager info table
    //Employee info table
    @FXML private TableView<Employee> employeesList;
    @FXML private TableColumn<Employee, Integer> empIdColumn;
    @FXML private TableColumn<Employee, String> empFnColumn;
    @FXML private TableColumn<Employee, String> emplnColumn;
    @FXML private TableColumn<Employee, String> empunColumn;
    @FXML private TableColumn<Employee, String> emplColumn;
    @FXML private TableColumn<Employee, String> EmpEcolumn;
    @FXML private TableColumn<Employee, String> emppColumn;
    @FXML private TableColumn<Employee, Date> EmplhdColumn;
    //Employee info table
       @FXML
      private JFXButton sbyHiredDateBTN;
      @FXML
      private JFXDatePicker searchEmplbyHiredDateTF;
    @FXML
    private TextField sByIdTf;
    @FXML
    private JFXButton searchEmpByIdBTN;
     @FXML
      private Label empConfrimation;
    @FXML
    private TextField empfnTf;
    @FXML
    private TextField emplnTf;
    @FXML
    private TextField emplTf;
    @FXML
    private TextField emppTf;
    @FXML
    private JFXButton modifyBTN;
    @FXML
    private JFXButton empregBTN;
    @FXML
    private JFXButton empsuspendBTN;
     @FXML
    private MenuItem logout;
    @FXML
    private MenuItem quit;
     @FXML
     private Label  passChangeConf;
    @FXML
    private Label modifyConfrimation;
     @FXML
    private JFXButton modifyAccount;
    @FXML
    private JFXTextField mfnTf;
    @FXML
    private JFXTextField mlnTf;
    @FXML
    private JFXTextField muTf;
    @FXML
    private JFXTextField meTf;
    @FXML
    private JFXTextField mlTf;
    @FXML
    private JFXPasswordField cPsswTf;
    @FXML
    private JFXPasswordField newPassTf;
    @FXML
    private JFXPasswordField cpassTf;
    @FXML
    private JFXButton changePTf;
    @FXML
    private ComboBox<?> qTCombBox;
    @FXML
    private ComboBox<?> soldcombBox;
    @FXML
    private RadioButton rQr;
    @FXML
    private ToggleGroup addRq;
    @FXML
    private RadioButton addQtr;
    @FXML
    private Button addorReduceBTN;
  @FXML
    private JFXButton setVatBTN;
    @FXML
    private JFXTextField vatTf;
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
       onStarts();
    }    
    private void viewLogginManager(){
       ObservableList<Manager> log=IManager.showActiveManager();
       maId=log.get(0).getId();
       mID.setCellValueFactory(new PropertyValueFactory<>("Id"));
       MFname.setCellValueFactory(new PropertyValueFactory<>("FirstName"));
       MLname.setCellValueFactory(new PropertyValueFactory<>("LastName"));
       MUsername.setCellValueFactory(new PropertyValueFactory<>("UserName"));
       MLocation.setCellValueFactory(new PropertyValueFactory<>("Location"));
       MEmail.setCellValueFactory(new PropertyValueFactory<>("Email"));
       managerInfo.setItems(log);
    }
    private void viewEmployeeList(){
      ObservableList<Employee> emp=IEmployee.findAll();
       empIdColumn.setCellValueFactory(new PropertyValueFactory<>("Id"));
       empFnColumn.setCellValueFactory(new PropertyValueFactory<>("FirstName"));
       emplnColumn.setCellValueFactory(new PropertyValueFactory<>("LastName"));
       empunColumn.setCellValueFactory(new PropertyValueFactory<>("UserName"));
       emplColumn.setCellValueFactory(new PropertyValueFactory<>("Location"));
       EmpEcolumn.setCellValueFactory(new PropertyValueFactory<>("Email"));
       emppColumn.setCellValueFactory(new PropertyValueFactory<>("Post"));
       EmplhdColumn.setCellValueFactory(new PropertyValueFactory<>("HireDate"));
       employeesList.setItems(emp);
    }
     @FXML
    void setVat(ActionEvent event) {
           Sales s=new Sales();
           ISale is=new ISale();
          c=new Converter();
          s.setVat(c.getDValue(vatTf.getText()));
          is.createTax(s);
    }
       @FXML
    void getManagerInfoList(MouseEvent event) {
          maId=managerInfo.getSelectionModel().getSelectedItem().getId();
          Manager ma=IManager.findManager(maId);
          mfnTf.setText(ma.getFirstName());
          mlnTf.setText(ma.getLastName());
          muTf.setText(ma.getUserName());
          meTf.setText(ma.getEmail());
          mlTf.setText(ma.getLocation());
    }
     @FXML
    void modifyAccount(ActionEvent event) {
        Manager ma=new Manager();
        IManager im=new IManager();
      
        ma.setFirstName(mfnTf.getText());
        ma.setLastName(mlnTf.getText());
        ma.setEmail(meTf.getText());
        ma.setLocation(mlTf.getText());
        ma.setUserName(muTf.getText());
        ma.setId(maId);
          if(checkBlank()){
              modifyConfrimation.setTextFill(Color.web("#e24a34"));
              modifyConfrimation.setText("Some field are left blank please fill them before submit");
          }else{
                modifyConfrimation.setTextFill(Color.web("#33b5e5"));
                modifyConfrimation.setText(im.accModify(ma));
                cleanAccModifyTFField();
          }
    }
     @FXML
    void changePassword(ActionEvent event) {
          Manager ma=new Manager();
          IManager im=new IManager();
          c=new Converter();
          int rowResult;
          ma.setPassword(c.md5(newPassTf.getText()));
          ma.setCpassword(c.md5(cpassTf.getText()));
          String currentPass=c.md5(cPsswTf.getText());
          if(ma.getPassword().equals(ma.getCpassword())){
             rowResult=im.chPass(currentPass, ma);
          }else{
             passChangeConf.setTextFill(Color.RED);
             passChangeConf.setText("Password not match");
             rowResult=0;
          }
          if(rowResult!=0){
              passChangeConf.setTextFill(Color.web("#33b5e5"));
              passChangeConf.setText("Password is changed succesfully");
              cleanPasswordTF();
          }else{
            passChangeConf.setTextFill(Color.RED);
             passChangeConf.setText("Password not changed, Check if the current password is correct");
          }
    }
     @FXML
    void employeeRegister(ActionEvent event) {
             Employee emp=new Employee();
             IEmployee iemp=new IEmployee();
             dg=new DateConverter();
            int Empprivillage=2;
            int suspend=0;
            emp.setPrivillage(Empprivillage);
            emp.setFirstName(empfnTf.getText());
            emp.setLastName(emplnTf.getText());
            emp.setLocation(emplTf.getText());
            emp.setPost(emppTf.getText());
            emp.setHireDate(dg.dateNow());
            emp.setSuspend(suspend);
            empConfrimation.setText(iemp.register(emp));
            viewEmployeeList();
    }
     @FXML
    void getEmpInfo(MouseEvent event) {
     empId=0;
     empId=employeesList.getSelectionModel().getSelectedItem().getId();
     Employee emp=IEmployee.findOne(empId);
     empfnTf.setText(emp.getFirstName());
     emplnTf.setText(emp.getLastName());
     emplTf.setText(emp.getLocation());
     emppTf.setText(emp.getPost());
    }
    
    @FXML
    void modifyEmployee(ActionEvent event) {
        Employee emp=new Employee();
        IEmployee iemp=new IEmployee();
        emp.setFirstName(empfnTf.getText());
        emp.setLastName(emplnTf.getText());
        emp.setLocation(emplTf.getText());
        emp.setPost(emppTf.getText());
        emp.setId(empId);
        empConfrimation.setText(iemp.update(emp));
        viewEmployeeList();
    }
     @FXML
    void suspendEmployee(ActionEvent event) {
      IEmployee iemp=new IEmployee();
      int res=iemp.delete(empId);
      if(res!=0){
          empConfrimation.setTextFill(Color.web("#e24a34"));
           empConfrimation.setText("Employee is deleted");
      }else{
             empConfrimation.setTextFill(Color.RED);
           empConfrimation.setText("Employee not deleteed try again");
      }
       viewEmployeeList(); 
    }
     @FXML
    void searchEmployeebyId(ActionEvent event) {
        c=new Converter(); 
        int id=c.getIValue(sByIdTf.getText());
        Employee iemp=IEmployee.findOne(id);
        ObservableList list=FXCollections.observableArrayList();
        if(iemp==null){
            empConfrimation.setTextFill(Color.web("#e24a34"));
            empConfrimation.setText("No Employee of this ID found");
        }else{
             empConfrimation.setTextFill(Color.web("#33b5e5"));
             empConfrimation.setText(null);
             list.add(iemp);
                empIdColumn.setCellValueFactory(new PropertyValueFactory<>("Id"));
                empFnColumn.setCellValueFactory(new PropertyValueFactory<>("FirstName"));
                emplnColumn.setCellValueFactory(new PropertyValueFactory<>("LastName"));
                empunColumn.setCellValueFactory(new PropertyValueFactory<>("UserName"));
                emplColumn.setCellValueFactory(new PropertyValueFactory<>("Location"));
                EmpEcolumn.setCellValueFactory(new PropertyValueFactory<>("Email"));
                emppColumn.setCellValueFactory(new PropertyValueFactory<>("Post"));
                EmplhdColumn.setCellValueFactory(new PropertyValueFactory<>("HireDate"));
                employeesList.setItems(list);
                sByIdTf.setText(null);
        }
    }
     @FXML
    void searchEmployeeByHiredDate(ActionEvent event) {
        LocalDate dt=searchEmplbyHiredDateTF.getValue();
        dc=new DateConverter();
       ObservableList<Employee> list=IEmployee.findByDateHired(dc.convertLocaDate(dt));
       if(list.isEmpty()){
            empConfrimation.setTextFill(Color.web("#e24a34"));
            empConfrimation.setText("No Employee hired at this date found");
       }else{
                empConfrimation.setTextFill(Color.web("#33b5e5"));
                empConfrimation.setText(null);
                empIdColumn.setCellValueFactory(new PropertyValueFactory<>("Id"));
                empFnColumn.setCellValueFactory(new PropertyValueFactory<>("FirstName"));
                emplnColumn.setCellValueFactory(new PropertyValueFactory<>("LastName"));
                empunColumn.setCellValueFactory(new PropertyValueFactory<>("UserName"));
                emplColumn.setCellValueFactory(new PropertyValueFactory<>("Location"));
                EmpEcolumn.setCellValueFactory(new PropertyValueFactory<>("Email"));
                emppColumn.setCellValueFactory(new PropertyValueFactory<>("Post"));
                EmplhdColumn.setCellValueFactory(new PropertyValueFactory<>("HireDate"));
                employeesList.setItems(list);
       }
       searchEmplbyHiredDateTF.setValue(null);
    }
    
    //product functions
        @FXML
    void addProduct(ActionEvent event) {
      if(!checkProductFied()){
        recordProduct();
      } else{
         proInfoMessage.setTextFill(Color.web("#ff8800"));
         proInfoMessage.setText("All fields are required");
      }
    }
    void recordProduct(){
        dc=new DateConverter();
      c=new Converter();
      Product pro=new Product();
      IProduct ipro=new IProduct();
     
      pro.setPName(pnTf.getText());
      pro.setPDescription(pdTf.getText());
      pro.setPQuantity(c.getDValue(qTf.getText()));
      pro.setPUType(unityTypecomb.getValue());
      pro.setRecordDate(dc.dateNow());
      pro.setCostUnit(c.getDValue(ucTf.getText()));
      pro.setPriceUnit(c.getDValue(upTf.getText()));
      pro.setSold( solddecComb.getValue());
     Product  pro2=IProduct.findByDescription(pro.getPName(),pro.getPDescription() );
     Double qty=pro.getPQuantity();
     if(pro2==null){
        
         proInfoMessage.setTextFill(Color.web("#0099cc"));
        proInfoMessage.setText(ipro.record(pro));
     }else{
      ipro.reduceAddQty("Add", pro);
      proInfoMessage.setTextFill(Color.web("#ff8800"));
      proInfoMessage.setText("There is Product Of the same Description only Quantity is Added");
     }
      viewProducts();
      clearProductFields();  
    }
    boolean checkProductFied(){
    return pnTf.getText().isEmpty()||
            pdTf.getText().isEmpty()||
            qTf.getText().isEmpty()||
            unityTypecomb.getValue().isEmpty()||
            ucTf.getText().isEmpty()||
            upTf.getText().isEmpty()||
            solddecComb.getValue().isEmpty();
    }
    @FXML
    void addReduceQuanity(ActionEvent event) {
          c=new Converter();
            String cond;
             if( addRadio.isSelected()){
               cond=addRadio.getText();
             }else{
             cond=reduceRadio.getText();
             }
             Product pro=new Product();
             pro.setPName(pName);
             pro.setPDescription(pDescription);
             pro.setPQuantity(c.getDValue(qTf.getText()));
             IProduct pro1=new IProduct();
             int resultRow=pro1.reduceAddQty(cond, pro);
             if(resultRow!=0){
                 proInfoMessage.setTextFill(Color.web("#0099cc"));
                  proInfoMessage.setText("Quantity changed successfully");
             }else{
                  proInfoMessage.setTextFill(Color.web("#cc0000"));
                  proInfoMessage.setText("Quanity is not changed");
             }
         clearProductFields();
    }

       @FXML
       void modifyProduct(ActionEvent event) {
           Product pro=new Product();
           IProduct ipro=new IProduct();
           c=new Converter();
                pro.setPName(pnTf.getText());
                pro.setPDescription(pdTf.getText());
                pro.setPQuantity(c.getDValue(qTf.getText()));
                pro.setPUType(unityTypecomb.getValue());
                pro.setCostUnit(c.getDValue(ucTf.getText()));
                pro.setPriceUnit(c.getDValue(upTf.getText()));
                pro.setSold( solddecComb.getValue());
               String msg=ipro.modifyProduct(pName, pDescription, pro);
                proInfoMessage.setText(msg);
                viewProducts();
                clearProductFields();
               
       }
       
      void viewProducts(){
                ObservableList<Product> list=IProduct.retrieve();
                productId.setCellValueFactory(new PropertyValueFactory<>("Code"));
                productName.setCellValueFactory(new PropertyValueFactory<>("PName"));
                productDescription.setCellValueFactory(new PropertyValueFactory<>("PDescription"));
                productQty.setCellValueFactory(new PropertyValueFactory<>("UnityTypeQuantity"));
                costUnity.setCellValueFactory(new PropertyValueFactory<>("ScostUnity"));
                priceUnity.setCellValueFactory(new PropertyValueFactory<>("SpriceUnity"));
                dateAdded.setCellValueFactory(new PropertyValueFactory<>("RecordDate"));
                soldDecision.setCellValueFactory(new PropertyValueFactory<>("Sold"));
                productList.setItems(list);
       }
       @FXML
    void refeshProductListBTN(ActionEvent event) {
      viewProducts();
      proInfoMessage.setTextFill(Color.web("#0099cc"));
       proInfoMessage.setText(null);
    }
    
     @FXML
    void getTableValue(MouseEvent event) {
            pid= productList.getSelectionModel().getSelectedItem().getCode();
             Product pro=IProduct.findByCode(pid);
             pName=pro.getPName();
             pDescription=pro.getPDescription();
             pnTf.setText(pro.getPName());
             pdTf.setText(pro.getPDescription());
             qTf.setText(pro.getPQuantity()+"");
             upTf.setText(pro.getPriceUnit()+"");
             ucTf.setText(pro.getCostUnit()+"");
    }
    
     @FXML
    void searbyProductByDescription(ActionEvent event) {
            Product pro=IProduct.findByDescription(psnTf.getText(), psdTf.getText());
           ObservableList list=FXCollections.observableArrayList();
           if(pro==null){
                proInfoMessage.setTextFill(Color.RED);
                proInfoMessage.setText("No product of  ''"+psnTf.getText()+" "+psdTf.getText()+"'' "+" Found");
           }else{
               list.add(pro);
                  productId.setCellValueFactory(new PropertyValueFactory<>("Code"));
                  productName.setCellValueFactory(new PropertyValueFactory<>("PName"));
                  productDescription.setCellValueFactory(new PropertyValueFactory<>("PDescription"));
                  productQty.setCellValueFactory(new PropertyValueFactory<>("UnityTypeQuantity"));
                  costUnity.setCellValueFactory(new PropertyValueFactory<>("ScostUnity"));
                  priceUnity.setCellValueFactory(new PropertyValueFactory<>("SpriceUnity"));
                  dateAdded.setCellValueFactory(new PropertyValueFactory<>("RecordDate"));
                  soldDecision.setCellValueFactory(new PropertyValueFactory<>("Sold"));
                  productList.setItems(list);
           }
         clearProductFields();
    }

    @FXML
    void searchByPrice(ActionEvent event) {
      c=new Converter();
      ObservableList<Product> list=IProduct.findByPrice(c.getDValue(searchP.getText()), psComb.getValue());
      if(list.isEmpty()){
                proInfoMessage.setTextFill(Color.RED);
                proInfoMessage.setText("No product of  : "+searchP.getText()+" Found ");
      }else{
                  productId.setCellValueFactory(new PropertyValueFactory<>("Code"));
                  productName.setCellValueFactory(new PropertyValueFactory<>("PName"));
                  productDescription.setCellValueFactory(new PropertyValueFactory<>("PDescription"));
                  productQty.setCellValueFactory(new PropertyValueFactory<>("UnityTypeQuantity"));
                  costUnity.setCellValueFactory(new PropertyValueFactory<>("ScostUnity"));
                  priceUnity.setCellValueFactory(new PropertyValueFactory<>("SpriceUnity"));
                  dateAdded.setCellValueFactory(new PropertyValueFactory<>("RecordDate"));
                  soldDecision.setCellValueFactory(new PropertyValueFactory<>("Sold"));
                  productList.setItems(list);
      }
        clearProductFields();
    }
  
     void ComboBoxAddItems(){
      unityTypecomb.getItems().addAll(
        "kg","L","unity","package"
      );
      solddecComb.getItems().addAll(
      "YES","NO"
      );
      psComb.getItems().addAll(
      "P < Input","P > Input","P = Input"
      );
      trcondComb.getItems().addAll(
      "Employee ID","Product Name"
      );
     }
    
    //end product functions
//transaction functons
      @FXML
    void searchTransactionByDate(ActionEvent event) {
       dc=new DateConverter();
       LocalDate dt=trDateTf.getValue();
       ObservableList<Sales> sl=ISale.searchByDate(dc.convertLocaDate(dt));
       if(sl.isEmpty()){
           transInfo.setText("No Transaction recorded on : "+trDateTf.getValue());
       }else{
                 transactionNo.setCellValueFactory(new PropertyValueFactory<>("Code"));
                TransactionDate.setCellValueFactory(new PropertyValueFactory<>("SoldDate"));
                soldby.setCellValueFactory(new PropertyValueFactory<>("Employee"));
                ProductName.setCellValueFactory(new PropertyValueFactory<>("PName"));
                ProductDescription.setCellValueFactory(new PropertyValueFactory<>("PDescription"));
                QuantitySold.setCellValueFactory(new PropertyValueFactory<>("SquanitySold"));
                Unitprice.setCellValueFactory(new PropertyValueFactory<>("PriceUnit"));
                Netprice.setCellValueFactory(new PropertyValueFactory<>("SnetPrice"));
               VAT.setCellValueFactory(new PropertyValueFactory<>("Svat"));
               Amount.setCellValueFactory(new PropertyValueFactory<>("Samount"));
               transactionList.setItems(sl);
                transInfo.setText(null);
       }
          trDateTf.setValue(null);
    }
    @FXML
    void searchUserCondition(ActionEvent event) {
         int in=trcondComb.getSelectionModel().getSelectedIndex();
        c=new Converter();
         ObservableList<Sales> sl;
         if(in==0){
             sl=ISale.searchT(c.getIValue(  stcTf.getText()));
         }else{
             sl=ISale.searchTbyProduct(stcTf.getText());
         }
         if(sl.isEmpty()){
              cashInfo.setText("There is no cash records of : "+stcTf.getText()+" Found");
         }else{
              transactionNo.setCellValueFactory(new PropertyValueFactory<>("Code"));
            TransactionDate.setCellValueFactory(new PropertyValueFactory<>("SoldDate"));
            soldby.setCellValueFactory(new PropertyValueFactory<>("Employee"));
            ProductName.setCellValueFactory(new PropertyValueFactory<>("PName"));
            ProductDescription.setCellValueFactory(new PropertyValueFactory<>("PDescription"));
            QuantitySold.setCellValueFactory(new PropertyValueFactory<>("SquanitySold"));
            Unitprice.setCellValueFactory(new PropertyValueFactory<>("PriceUnit"));
            Netprice.setCellValueFactory(new PropertyValueFactory<>("SnetPrice"));
             VAT.setCellValueFactory(new PropertyValueFactory<>("Svat"));
             Amount.setCellValueFactory(new PropertyValueFactory<>("Samount"));
             transactionList.setItems(sl);
         }
         stcTf.setText(null);
    }
      @FXML
    void refreshTransactionTable(ActionEvent event) {
       viewTransaction();
    }
     @FXML
    void refreshCashTransactionTable(ActionEvent event) {
         viewCashReceived();
    }
 @FXML
    void searchCashByDate(ActionEvent event) {
        dc=new DateConverter();
        LocalDate  dt=sadTf.getValue();
        Sales sl=new Sales();
       ObservableList<Sales> isl=ISale.showCashByDate(dc.convertLocaDate(dt));
       if(isl.isEmpty()){
           cashInfo.setText("There is no cash records made on : "+sadTf.getValue());
       }else{
       receivedDate.setCellValueFactory(new PropertyValueFactory<>("SoldDate"));
       AmountCash.setCellValueFactory(new PropertyValueFactory<>("Samount"));
       cashReceived.setItems(isl);
       }
       sadTf.setValue(null);
    }
    private void viewCashReceived(){
       Sales sl=new Sales();
       ObservableList<Sales> isl=ISale.showCash();
       receivedDate.setCellValueFactory(new PropertyValueFactory<>("SoldDate"));
       AmountCash.setCellValueFactory(new PropertyValueFactory<>("Samount"));
       cashReceived.setItems(isl);
    }
    private void viewTransaction(){
      ObservableList<Sales> sl=ISale.showSoldList();
      transactionNo.setCellValueFactory(new PropertyValueFactory<>("Code"));
      TransactionDate.setCellValueFactory(new PropertyValueFactory<>("SoldDate"));
      soldby.setCellValueFactory(new PropertyValueFactory<>("Employee"));
      ProductName.setCellValueFactory(new PropertyValueFactory<>("PName"));
      ProductDescription.setCellValueFactory(new PropertyValueFactory<>("PDescription"));
      QuantitySold.setCellValueFactory(new PropertyValueFactory<>("SquanitySold"));
      Unitprice.setCellValueFactory(new PropertyValueFactory<>("PriceUnit"));
      Netprice.setCellValueFactory(new PropertyValueFactory<>("SnetPrice"));
       VAT.setCellValueFactory(new PropertyValueFactory<>("Svat"));
       Amount.setCellValueFactory(new PropertyValueFactory<>("Samount"));
       transactionList.setItems(sl);
    }
     //end transaction functions
    @FXML
    void refreshEmployeeList(ActionEvent event) {
           viewEmployeeList();
    }
     @FXML
    void logout(ActionEvent event) throws Exception {
        c=new Converter();
        IManager ma=new IManager();
        int id=maId;
        ma.logout(id);
         new LoginUI().start(new Stage());
                 ManagerUI.close();
         
    }
     @FXML
    void quit(ActionEvent event) throws Exception {
                 ManagerUI.close();
    }
   void showVat(){
    IProduct ipr=new IProduct(); 
    taxView.setText( "Rwf  "+ipr.showVat());
   }
    private boolean checkBlank(){
        return mfnTf.getText().isEmpty()||mlnTf.getText().isEmpty()||meTf.getText().isEmpty()||mlTf.getText().isEmpty()||muTf.getText().isEmpty();
    }
    private void showVAT(){
     ISale is=new ISale();
     vat=is.showTax();
     System.out.print(vat);
    }
    private void cleanAccModifyTFField(){
        mfnTf.setText(null);
        mlnTf.setText(null);
        mlTf.setText(null);
        meTf.setText(null);
        muTf.setText(null);
    }
    private void cleanPasswordTF(){
      newPassTf.setText(null);
      cpassTf.setText(null);
      cPsswTf.setText(null);
    }
    void clearProductFields(){
      searchP.setText(null);
      psnTf.setText(null);
      psdTf.setText(null);
      pnTf.setText(null);
      pdTf.setText(null);
      qTf.setText(null);
      upTf.setText(null);
      ucTf.setText(null);
   } 
      private void onStarts(){
        viewLogginManager();
        viewEmployeeList();
        showVAT();
        viewProducts();
        ComboBoxAddItems();
        showVat();
         viewCashReceived();
         viewTransaction();
    }
}