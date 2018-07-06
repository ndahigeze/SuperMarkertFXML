/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package confClass;

import Domain.Sequence;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author NDAHIGEZEc
 */
public class ISequence{
   
    public static Sequence managerValue(){
         Connection con=ConCreation.connect();
        Sequence seq=null;
    try{
       String sql="select add_manager.NEXTVAL from dual";
       PreparedStatement st = con.prepareStatement(sql);
       ResultSet rs = st.executeQuery();
       if(rs.next()){
           seq=new Sequence();
           seq.setSeqValue(rs.getInt(1));
       }
       con.close();
    }catch(Exception ex){
    
    }
        return seq;
    }
    
    
    
   public static Sequence employeeValue(){
          Connection con=ConCreation.connect();    
          Sequence seq=null;
    try{
       String sql="select add_employee.NEXTVAL from dual";
       PreparedStatement st = con.prepareStatement(sql);
       ResultSet rs = st.executeQuery();
       if(rs.next()){
           seq=new Sequence();
           seq.setSeqValue(rs.getInt(1));
       }
       con.close();
    }catch(Exception ex){
    
    }
        return seq;
    }
      
      public static Sequence actionId(){
          Connection con=ConCreation.connect();
          Sequence seq1=null;
          try{
          String sql="select add_action.nextVal from dual";
          PreparedStatement st=con.prepareStatement(sql);
          ResultSet rs=st.executeQuery();
          if(rs.next()){
              seq1=new Sequence();
              seq1.setSeqValue(rs.getInt(1));
          }
          con.close();
      }catch(Exception ex){
          ex.getMessage();
      }
          return seq1;
      }
      
      
     public static Sequence productId(){
         Connection con=ConCreation.connect();
         Sequence seq1=null;
          try{
          String sql="select add_product.nextVal from dual";
          PreparedStatement st=con.prepareStatement(sql);
          ResultSet rs=st.executeQuery();
          if(rs.next()){
              seq1=new Sequence();
              seq1.setSeqValue(rs.getInt(1));
          }
          con.close();
      }catch(Exception ex){
          ex.getMessage();
      }
          return seq1;
      }
        
        
        
      public static Sequence soldId(){
           Connection con=ConCreation.connect(); 
           Sequence seq1=null;
          try{
          String sql="select add_sold.nextVal from dual";
          PreparedStatement st=con.prepareStatement(sql);
          ResultSet rs=st.executeQuery();
          if(rs.next()){
              seq1=new Sequence();
              seq1.setSeqValue(rs.getInt(1));
          }
          con.close();
      }catch(Exception ex){
          ex.getMessage();
      }
          return seq1;
      }
      
      
}
