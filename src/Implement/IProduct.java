/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Implement;

import Domain.Product;
import confClass.Action;
import confClass.ConCreation;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.NumberFormat;
import java.util.Locale;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import oracle.jdbc.OracleTypes;

/**
 *
 * @author NDAHIGEZE
 */
public class IProduct {
    Action act=new Action();
   public String record(Product pro){
         Connection con=ConCreation.connect();
        try{ 
            String sql="insert into product (dateRecorded,pname,description,quantity_Type,quantity,unitPrice,unitCost,sold)values(?,?,?,?,?,?,?,?)";
            CallableStatement st=con.prepareCall(sql);
            st.setDate(1,pro.getRecordDate());
            st.setString(2,pro.getPName());
            st.setString(3,pro.getPDescription());
            st.setString(4, pro.getPUType());
            st.setDouble(5,pro.getPQuantity());
            st.setDouble(6, pro.getPriceUnit());
            st.setDouble(7, pro.getCostUnit());
            st.setString(8, pro.getSold());
            st.execute();
            return "Product recorder successfully";
        }catch(Exception ex){
           return ex.getMessage();
        }
    }
    
    public static ObservableList<Product> retrieve(){
        Connection con=ConCreation.connect();
        ObservableList list=FXCollections.observableArrayList();
        Product pr=null;
      try{
          String sql="select * from product";
          PreparedStatement st=con.prepareCall(sql);
          st.executeQuery();
          ResultSet rs=st.executeQuery();
          while(rs.next()){
            pr=new Product();
            pr.setCode(rs.getInt(1));
            pr.setRecordDate(rs.getDate(2));
            pr.setPName(rs.getString(3));
            pr.setPDescription(rs.getString(4));
            pr.setPUType(rs.getString(5));
            pr.setPQuantity(rs.getDouble(6));
            pr.setPriceUnit(rs.getDouble(7));
            pr.setCostUnit(rs.getDouble(8));
            pr.setSold(rs.getString(9));
           pr.setSpriceUnity( "Rwf "+NumberFormat.getInstance(Locale.US).format(pr.getPriceUnit()));
            pr.setScostUnity("RWF "+NumberFormat.getInstance(Locale.US).format(pr.getCostUnit()));
            pr.setUnityTypeQuantity(NumberFormat.getInstance(Locale.US).format(pr.getPQuantity())+" "+pr.getPUType());
            list.add(pr);
          }
      }catch(Exception ex){
      System.out.println(ex.getMessage());
      }
      return list;
    }
    
    public static Product findByDescription(String name,String description){
        Connection con=ConCreation.connect();
        Product pr=null;
    try{
          String sql="select * from where pname=? and pdescription=?";
          PreparedStatement st=con.prepareCall(sql);
          st.setString(2, name);
          st.setString(3, description);
          ResultSet rs=st.executeQuery();
          if(rs.next()){
            pr=new Product();
            pr.setCode(rs.getInt(1));
            pr.setRecordDate(rs.getDate(2));
            pr.setPName(rs.getString(3));
            pr.setPDescription(rs.getString(4));
            pr.setPUType(rs.getString(5));
            pr.setPQuantity(rs.getDouble(6));
            pr.setPriceUnit(rs.getDouble(7));
            pr.setCostUnit(rs.getDouble(8));
            pr.setSold(rs.getString(9));
           pr.setSpriceUnity( "Rwf "+NumberFormat.getInstance(Locale.US).format(pr.getPriceUnit()));
            pr.setScostUnity("RWF "+NumberFormat.getInstance(Locale.US).format(pr.getCostUnit()));
            pr.setUnityTypeQuantity(NumberFormat.getInstance(Locale.US).format(pr.getPQuantity())+" "+pr.getPUType());
          }
          con.close();
    }catch(Exception ex){
       System.out.println(ex.getMessage());
    }
    return pr;
    }
    
   //searching product by code
    public static Product findByCode(int code){
          Connection con=ConCreation.connect();
        Product pr=null;
    try{
          String sql="{call showProductById(?,?)}";
          CallableStatement st=con.prepareCall(sql);
          st.registerOutParameter(1,OracleTypes.CURSOR);
          st.setInt(2, code);
          st.executeQuery();
          ResultSet rs=(ResultSet) st.getObject(1);
          if(rs.next()){
             pr=new Product();
             pr.setCode(rs.getInt(1));
             pr.setPName(rs.getString(2));
             pr.setPDescription(rs.getString(3));
             pr.setPQuantity(rs.getDouble(4));
             pr.setPUType(rs.getString(5));
             pr.setCostUnit(rs.getDouble(6));
             pr.setPriceUnit(rs.getDouble(7));
             pr.setSold(rs.getString(9));
             pr.setRecordDate(rs.getDate(8));
             pr.setSpriceUnity( "Rwf "+NumberFormat.getInstance(Locale.US).format(pr.getPriceUnit()));
            pr.setScostUnity("RWF "+NumberFormat.getInstance(Locale.US).format(pr.getCostUnit()));
            pr.setUnityTypeQuantity(NumberFormat.getInstance(Locale.US).format(pr.getPQuantity())+" "+pr.getPUType());
          }
          con.close();
    }catch(Exception ex){
       System.out.println(ex.getMessage());
    }
    return pr;
    }
    
    public static ObservableList<Product> findByPrice(Double price,String sign){
       Connection con=ConCreation.connect();
        ObservableList list=FXCollections.observableArrayList();
     Product pr=null;
     String sql;
     try{
         switch (sign) {
             case "P < Input":
                 sql="{call  showprobylessprice(?,?)} ";
                 break;
             case "P > Input":
                 sql="{call showprobygreaterprice(?,?)} ";
                 break;
             default:
                 sql="{call showprobyequalprice(?,?)}";
                 break;
         }
          CallableStatement st=con.prepareCall(sql);
          st.registerOutParameter(1,OracleTypes.CURSOR);
          st.setDouble(2, price);
          st.executeQuery();
          ResultSet rs=(ResultSet) st.getObject(1);
          while(rs.next()){ 
             pr=new Product();
             pr.setCode(rs.getInt(1));
            pr.setPName(rs.getString(2));
            pr.setPDescription(rs.getString(3));
            pr.setPQuantity(rs.getDouble(4));
            pr.setPUType(rs.getString(5));
            pr.setCostUnit(rs.getDouble(6));
            pr.setPriceUnit(rs.getDouble(7));
            pr.setRecordDate(rs.getDate(8));
            pr.setSold(rs.getString(9));
            pr.setSpriceUnity( "Rwf "+NumberFormat.getInstance(Locale.US).format(pr.getPriceUnit()));
            pr.setScostUnity("RWF "+NumberFormat.getInstance(Locale.US).format(pr.getCostUnit()));
            pr.setUnityTypeQuantity(NumberFormat.getInstance(Locale.US).format(pr.getPQuantity())+" "+pr.getPUType());
            list.add(pr);
          }
          con.close();
     }catch(Exception ex){
         System.out.println(ex.getMessage());
     }
     return list;
    }
    
 public int reduceAddQty(String condition,Product pro){
     Connection con=ConCreation.connect();
     int row=0;
     try{
          String sql="{call reduceAdd(?,?,?,?,?)}";
          CallableStatement st=con.prepareCall(sql);
          st.setString(1, pro.getPName());
          st.setString(2, pro.getPDescription());
          st.setDouble(3, pro.getPQuantity());
          st.setString(4,condition);
          st.registerOutParameter(5, OracleTypes.INTEGER);
          st.execute();
          row=st.getInt(5);
          String msg=act.managerAction("reduced:" +pro.getPQuantity()+" of " + pro.getPDescription() +" "+pro.getPName());
          con.close();
          System.out.print("quantity added");
    }catch(Exception ex){
          System.out.println(ex.getMessage());
            }
     return row;
    }
    
    public String modifyProduct(String name,String description,Product pro){
       Connection con=ConCreation.connect();
        try{
           String sql="{call modifypro(?,?,?,?,?,?,?,?,?)}";
           CallableStatement st=con.prepareCall(sql);
           st.setString(1,pro.getPName() );
           st.setString(2,pro.getPDescription());
           st.setDouble(3, pro.getPQuantity());
           st.setString(4, pro.getPUType());
           st.setDouble(5,pro.getCostUnit());
           st.setDouble(6, pro.getPriceUnit());
           st.setString(7, name);
           st.setString(8,description);
            st.setString(9,pro.getSold());
           st.execute();
           String msg=act.managerAction("Changed descriptions of  product:   "+ pro.getPName() +" "+pro.getPDescription());
           con.close();
           return "product modified succesfully";
       }catch(Exception ex){
           return ex.getMessage();
       }
    } 
    //function to show vat;
    public double showVat(){
         Connection con=ConCreation.connect();
        Product pro=null;
        double vat=0;
       try{
           String sql="{call  showVat(?)}";
           CallableStatement st=con.prepareCall(sql);
           st.registerOutParameter(1, OracleTypes.DOUBLE);
           st.execute();
           vat=st.getDouble(1);
       }catch(Exception ex){
           System.out.print(ex.getMessage());
       }
       return vat;
    }
}



