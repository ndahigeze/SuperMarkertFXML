/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supermarkertfxml.EmployeeUIControl;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author NDAHIGEZE
 */
public class EmployeeUI extends Application {
    static Stage application;
     @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/supermarketfxml/FXMLfiles/EmployeeForm.fxml"));
        
        Scene scene = new Scene(root);
        application=stage;
        stage.setScene(scene);
        stage.show();
    }
   static void close(){
    application.close();
   }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
