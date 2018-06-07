/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Implement;

import Domain.SuspendedEmployee;
import confClass.ConCreation;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import oracle.jdbc.OracleTypes;


/**
 *
 * @author NDAHIGEZE
 */
public class ISuspendedEmployee {
    //funciton to retrieve suspende employee
    public static ObservableList<SuspendedEmployee> viewSuspended(){
       Connection con=ConCreation.connect();
      ObservableList<SuspendedEmployee> list=FXCollections.observableArrayList();
      SuspendedEmployee emp=null;
      try{
          String sql="{call Susemployee(?)}";
          CallableStatement st=con.prepareCall(sql);
          st.registerOutParameter(1, OracleTypes.CURSOR);
          st.executeQuery();
          ResultSet rs=(ResultSet) st.getObject(1);
          while(rs.next()){
              emp=new SuspendedEmployee();
              emp.setId(rs.getInt(1));
              emp.setFirstName(rs.getString(2));
              emp.setLastName(rs.getString(3));
              emp.setHireDate(rs.getDate(4));
              emp.setLocation(rs.getString(5));
              emp.setEmail(rs.getString(8));
              emp.setUserName(rs.getString(7));
              emp.setPost(rs.getString(9));
              emp.setSuspendedDate(rs.getDate(10));
              list.add(emp);
          }
          con.close();
      }catch(Exception ex){
        System.out.println(ex.getMessage());
      }
      return list;
    }
    
    public static ObservableList<SuspendedEmployee> searchById(int id){
        Connection con=ConCreation.connect();
        ObservableList<SuspendedEmployee> list=FXCollections.observableArrayList();
       SuspendedEmployee emp=null;
       try{
             String sql="{call searchSEmpById(?,?)}";
          CallableStatement st=con.prepareCall(sql);
          st.registerOutParameter(1, OracleTypes.CURSOR);
          st.setInt(2, id);
          st.executeQuery();
          ResultSet rs=(ResultSet) st.getObject(1);
          while(rs.next()){
              emp=new SuspendedEmployee();
              emp.setId(rs.getInt(1));
              emp.setFirstName(rs.getString(2));
              emp.setLastName(rs.getString(3));
              emp.setHireDate(rs.getDate(4));
              emp.setLocation(rs.getString(5));
              emp.setEmail(rs.getString(8));
              emp.setUserName(rs.getString(7));
              emp.setPost(rs.getString(9));
              emp.setSuspendedDate(rs.getDate(10));
              list.add(emp);
          }
       }catch(Exception ex){
           System.out.print(ex.getMessage());
       }
       return list;
    }
    
    
    //function to search suspendeEmployee by date suspended;
    public static ObservableList<SuspendedEmployee> searchBySDate(Date dt){
        Connection con=ConCreation.connect();
        ObservableList<SuspendedEmployee> list=FXCollections.observableArrayList();
       SuspendedEmployee emp=null;
       try{
            String sql="{call searchSEmpBySuspandedDate(?,?)}";
            CallableStatement st=con.prepareCall(sql);
            st.registerOutParameter(1, OracleTypes.CURSOR);
            st.setDate(2, dt);
            st.executeQuery();
            ResultSet rs=(ResultSet) st.getObject(1);
            while(rs.next()){
                emp=new SuspendedEmployee();
                emp.setId(rs.getInt(1));
                emp.setFirstName(rs.getString(2));
                emp.setLastName(rs.getString(3));
                emp.setHireDate(rs.getDate(4));
                emp.setLocation(rs.getString(5));
                  emp.setUserName(rs.getString(7));
                emp.setEmail(rs.getString(8));
                emp.setPost(rs.getString(9));
                emp.setSuspendedDate(rs.getDate(10));
                 emp.getSuspendedDate();
            }
       }catch(Exception ex){
           System.out.println(ex.getMessage());
       }
       return list;
    }
}
