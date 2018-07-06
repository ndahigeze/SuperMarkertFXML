/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Implement;

import Domain.Manager;
import confClass.ConCreation;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import oracle.jdbc.OracleTypes;
/**
 *
 * @author NDAHIGEZE
 */
public class IManager{
    public void register(Manager ma){
        Connection con=ConCreation.connect();
       try{
          String sql="insert into Employee (firstname,lastname,location,emailaddress,username,hiredate,password,post,loggedin,privillage,suspend)values(?,?,?,?,?,?,?,?,?,?,?)";
          PreparedStatement st=con.prepareStatement(sql);   
         st.setString(1, ma.getFirstName());
         st.setString(2, ma.getLastName());
         st.setString(3,ma.getLocation());
         st.setString(4,ma.getEmail());
         st.setString(5, ma.getUserName());
         st.setDate(6,ma.getHireDate());
         st.setString(7, ma.getPassword());
         st.setString(8, ma.getPost());
         st.setInt(9, ma.getLogged());
         st.setInt(10, ma.getPrivillage());
         st.setInt(11, ma.getSuspend());
         st.execute();
         con.close();
         System.out.println("Account is succefull created click on signin to log into your account");
       }catch(Exception ex){
          System.out.println(ex.getMessage()+"You can not create acount Ask manager");
       }
    }
    
    public static Manager login(String userName,String password ){
         Connection con=ConCreation.connect();
         Manager ma=null;
        try{
        String sql="select * from employee where password=? and username=? and privillage=1";
        PreparedStatement st=con.prepareStatement(sql);
        st.setString(1, password);
        st.setString(2, userName);
        st.executeQuery();
        ResultSet rs=st.executeQuery();
        if(rs.next()){
               ma=new Manager();
               ma.setId(rs.getInt(1));
               ma.setFirstName(rs.getString(2));
               ma.setLastName(rs.getString(3));
               ma.setUserName(rs.getString(4));
               ma.setEmail(rs.getString(5));
               ma.setLocation(rs.getString(6));
        }
        System.out.print("managerRetrived");
        con.close();
    }catch(Exception ex){
        System.out.println(ex.getMessage());
    }
        return ma;
    }
    //function to show logged in 
    public static ObservableList<Manager> showActiveManager(){
      Connection con=ConCreation.connect();
      ObservableList<Manager> list=FXCollections.observableArrayList();
      Manager ma=null;
      try{
          String sql="select * from employee where privillage=1 and loggedin=1";
          PreparedStatement st=con.prepareStatement(sql);
          ResultSet rs=st.executeQuery();
          while(rs.next()){
               ma=new Manager();
               ma.setId(rs.getInt(1));
               ma.setFirstName(rs.getString(2));
               ma.setLastName(rs.getString(3));
               ma.setLocation(rs.getString(4));
               ma.setEmail(rs.getString(5));
               ma.setUserName(rs.getString(6));
               list.add(ma);
          }
      }catch(Exception ex){
       System.out.println(ex.getMessage());   
      }
      return list;
    }
    //make logged in
    public void MakeActive(int id){
      Connection con=ConCreation.connect();
        try{
            String sql="update employee set loggedin=1 where id=?";
            PreparedStatement st=con.prepareStatement(sql);
            st.setInt(1, id);
            st.execute();
            System.out.println("done logged");
      }catch(Exception ex){
        System.out.print(ex.getMessage()+"loggen");
      }
    }
    //function to logout manager
    public void logout(int id){
      Connection con=ConCreation.connect();
      try{
          String sql="update employee set loggedin=0 where id=?";
          PreparedStatement st=con.prepareStatement(sql);
          st.setInt(1, id);
          st.execute();
      }catch(Exception ex){
          System.out.println(ex.getMessage());
      }
    }
     public static Manager findManager(int idi){
         Connection con=ConCreation.connect();
         Manager ma=null;
    try{
        String sql="{call searchmanager(?,?)} ";
        CallableStatement st=con.prepareCall(sql);
        st.registerOutParameter(1, OracleTypes.CURSOR);
        st.setInt(2,idi);
        st.executeQuery();
        ResultSet rs=(ResultSet) st.getObject(1);
        if(rs.next()){
        ma=new Manager();
               ma.setId(rs.getInt(1));
               ma.setFirstName(rs.getString(2));
               ma.setLastName(rs.getString(3));
               ma.setEmail(rs.getString(4));
               ma.setLocation(rs.getString(5));
               ma.setUserName(rs.getString(7));
        }
        con.close();
    }catch(Exception ex){
       System.out.println(ex.getMessage());
    }
    return ma;
    }
     
     public int checkActiveManager(){
           Connection con=ConCreation.connect();
           Manager ma=null;
           int result=0;
            try{
                String sql="select * from employee where privillage=1";
                PreparedStatement st=con.prepareStatement(sql);
               ResultSet rs=st.executeQuery();
               if(rs.next()){
                ma=new Manager();
                result=rs.getInt(1);
               }
                
            }catch(Exception ex){
                System.out.println(ex.getMessage());
            }
            return result;
     }
     
     public String accModify(Manager ma){
         int row=0;
              Connection con=ConCreation.connect();
         try{
         String sql="call modifymanager(?,?,?,?,?,?) ";
         CallableStatement st=con.prepareCall(sql);
         st.setString(1, ma.getFirstName());
         st.setString(2,ma.getLastName());
         st.setString(3,ma.getEmail());
         st.setString(4,ma.getLocation());
         st.setString(5,ma.getUserName());
         st.setInt(6, ma.getId());
         row=st.executeUpdate();
         con.close();
         return "Your Account is modifyied  login again to see the change";
      }catch(Exception ex){
          return ex.getMessage()+"Please try again";
      }
     }
     
     
     
     ///function to change password
     public int chPass(String pass,Manager ma){
       Connection con=ConCreation.connect();
         int rowAf=0;
       try{
           String sql=" begin  chpass(?,?,?); end ; ";
          CallableStatement st=con.prepareCall(sql);
         // st.registerOutParameter(1,Types.INTEGER);
          st.setString(1, ma.getPassword());
          st.setString(2, pass);
          st.registerOutParameter(3, OracleTypes.INTEGER);
          st.execute();
          rowAf=st.getInt(3);
       }catch(Exception ex){
           System.out.println(ex.getMessage());
       }
       return rowAf;
     }
}
