/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supermarkertfxml.createAccountUIControl;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author NDAHIGEZE
 */
public class CreateAccountUI extends Application {
    private static Stage application;
      @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/supermarketfxml/FXMLfiles/CreateAccount.fxml"));
        
        Scene scene = new Scene(root);
        application=stage;    
        stage.setScene(scene);
        stage.show();
    }
    public static void close(){
    application.close();
    }
      public static void main(String[] args) {
        launch(args);
    }
}
