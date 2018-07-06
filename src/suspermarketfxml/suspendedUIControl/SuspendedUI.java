package suspermarketfxml.suspendedUIControl;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author NDAHIGEZE
 */
public class SuspendedUI extends Application{
   
   private  static Stage  suspended;
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/supermarketfxml/FXMLfiles/suspendedUI.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        suspended=stage;
    }
    public static void close(){
       suspended.close();
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
