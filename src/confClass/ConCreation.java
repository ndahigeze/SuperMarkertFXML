/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package confClass;

//import static confClass.PubVariables.CFORNAME;
import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author NDAHIGEZE
 */
public class ConCreation {
   static final String PASSWD="";
   static final String DRIVER="com.mysql.jdbc.Driver";
   static final String USER="root";
   static final String COND="jdbc:mysql://localhost/supermarket";
    static Connection con;
   public static Connection connect(){
    try{
        Class.forName(DRIVER);
         con=DriverManager.getConnection(COND,USER,PASSWD);
    }catch(Exception ex){
        System.out.println(ex.getMessage());
    }
    return con;
   }
}
