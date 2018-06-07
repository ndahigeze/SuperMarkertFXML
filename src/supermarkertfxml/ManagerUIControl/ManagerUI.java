/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supermarkertfxml.ManagerUIControl;

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
public class ManagerUI extends Application {
   static Stage quitvar;
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/supermarketfxml/FXMLfiles/ManagerForm.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        quitvar=stage;
    }
     public static void close(){
       quitvar.close();
     }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
      
}
