/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Implement;

import Domain.Employee;
import Domain.Product;
import Domain.Sales;
import confClass.ConCreation;
import confClass.ISequence;
import Domain.Sequence;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import oracle.jdbc.internal.OracleTypes;


/**
 *
 * @author NDAHIGEZE
 */
public class  ISale{
     //Method to record sells transactions details
         static Employee emp;
         //static DateGenerator dg;
         Sequence sq;
    //function to search all product available for sales
         //function to search product to be sold by description
      public static ObservableList<Sales> findAll(){
        Connection con=ConCreation.connect();
        ObservableList<Sales> list=FXCollections.observableArrayList();
        Sales sl=null;
            try{
                  String sql="select * from product where sold=?";
                  PreparedStatement st=con.prepareStatement(sql);
                  st.setString(1, "YES");
                  ResultSet rs=st.executeQuery();
                  while(rs.next()){
                    sl=new Sales();
                    sl.setCode(rs.getInt(1));
                    sl.setRecordDate(rs.getDate(2));
                    sl.setPName(rs.getString(3));
                    sl.setPDescription(rs.getString(4));
                    sl.setPUType(rs.getString(5));
                    sl.setPQuantity(rs.getDouble(6));
                    sl.setPriceUnit(rs.getDouble(7));
                    sl.setCostUnit(rs.getDouble(8));
                    sl.setSold(rs.getString(9));
                    sl.setSpriceUnity( "Rwf "+NumberFormat.getInstance(Locale.US).format(sl.getPriceUnit()));
                    sl.setScostUnity("RWF "+NumberFormat.getInstance(Locale.US).format(sl.getCostUnit()));
                    sl.setUnityTypeQuantity(NumberFormat.getInstance(Locale.US).format(sl.getPQuantity())+" "+sl.getPUType());
                    list.add(sl);
                  }
                  con.close();
            }catch(Exception ex){
               System.out.println(ex.getMessage()+"test");
            }
              return list;
    }     
    //function to search product to be sold by description
          public static Sales findToSale(String name,String description){
        Connection con=ConCreation.connect();
        Sales sl=null;
    try{
          String sql="select * from product where pname=? and description=? and sold=?";
          PreparedStatement st=con.prepareStatement(sql);
          st.setString(1, name);
          st.setString(2, description);
          st.setString(3, "YES");
          ResultSet rs=st.executeQuery();
          if(rs.next()){
            sl=new Sales();
            sl.setCode(rs.getInt(1));
            sl.setRecordDate(rs.getDate(2));
            sl.setPName(rs.getString(3));
            sl.setPDescription(rs.getString(4));
            sl.setPUType(rs.getString(5));
            sl.setPQuantity(rs.getDouble(6));
            sl.setPriceUnit(rs.getDouble(7));
            sl.setCostUnit(rs.getDouble(8));
            sl.setSold(rs.getString(9));
            sl.setSpriceUnity( "Rwf "+NumberFormat.getInstance(Locale.US).format(sl.getPriceUnit()));
            sl.setScostUnity("RWF "+NumberFormat.getInstance(Locale.US).format(sl.getCostUnit()));
            sl.setUnityTypeQuantity(NumberFormat.getInstance(Locale.US).format(sl.getPQuantity())+" "+sl.getPUType());
          }
          con.close();
    }catch(Exception ex){
       System.out.println(ex.getMessage());
    }
    return sl;
    }
    public String soldRecod(int eId,Sales sl){
        Connection con=ConCreation.connect();
         sq=ISequence.soldId();
    try{
       String sql="{call createsoldList(?,?,?,?,?,?,?,?,?)}";
        CallableStatement st=con.prepareCall(sql);
       st.setInt(1,sq.getSeqValue());
       st.setDate(2, sl.getRecordDate());
       st.setInt(3,eId);
        st.setString(4,sl.getPName() );
        st.setString(5, sl.getPDescription());
       st.setDouble(6,sl.getPQuantity());
       st.setString(7,sl.getPUType());
       st.setDouble(8,sl.getPriceUnit());
       st.setDouble(9, sl.getTotalPrice());
       st.executeQuery();
       con.close();
       return "Transaction recorded";
    }catch(Exception ex){
        return ex.getMessage();
    }
    }
    //function to record transactions 
    public void  recordTrasaction(){
      Connection con=ConCreation.connect();
      try{
         String sql="{call feIntoSoldList()}";
         CallableStatement st=con.prepareCall(sql);
         st.execute();
        System.out.println("done");
      }catch(Exception ex){
      System.out.println(ex.getMessage());
      }
    }
    //function to retrieve data to show in invoice
      public static List<Sales> ISoldList(){
            Connection con=ConCreation.connect();
            List<Sales> list=new ArrayList();
            Sales sl=null;
            try{
                 String sql="{call ISelesList(?)}";
                  CallableStatement st=con.prepareCall(sql);
                  st.registerOutParameter(1, OracleTypes.CURSOR);
                  st.executeQuery();
                  ResultSet rs=(ResultSet) st.getObject(1);
                  while(rs.next()){
                      sl=new Sales();
                      emp=new Employee();
                      sl.setCode(rs.getInt(1));
                      sl.setSoldDate(rs.getDate(2));
                      emp.setFirstName(rs.getString(3));
                      emp.setLastName(rs.getString(4));
                      sl.setEmployee(emp.getFirstName()+" "+emp.getLastName());
                      sl.setPName(rs.getString(5));
                      sl.setPDescription(rs.getString(6));
                      sl.setPQuantity(rs.getDouble(7));
                      sl.setPUType(rs.getString(8));
                      sl.setPriceUnit(rs.getDouble(9));
                      sl.setTotalPrice(rs.getDouble(10));
                      sl.setAmount(rs.getDouble(12));
                      sl.setVat(rs.getDouble(11));
                      sl.setSquanitySold(sl.getPUType()+" "+NumberFormat.getInstance(Locale.US).format(sl.getPQuantity()));
                      sl.setSnetPrice("RWf "+NumberFormat.getInstance(Locale.US).format(sl.getTotalPrice()));
                      sl.setSvat("RWF "+NumberFormat.getInstance(Locale.US).format(sl.getVat()));
                        sl.setSamount("RWF "+NumberFormat.getInstance(Locale.US).format(sl.getAmount()));
                      list.add(sl);
                  }
            }catch(Exception ex){
                  System.out.print(ex.getMessage());
            }
            return list;
            }
    
          public void tempRem(){
              Connection con=ConCreation.connect();
              try{
                  String sql="{call temprem}";
                  CallableStatement st=con.prepareCall(sql);
                  st.execute();
              }catch(Exception ex){
                  System.out.print(ex.getMessage());
              }
          }
 //redusing quanity after selling
    public String reduceQty(Sales sl){
        Connection con=ConCreation.connect();
        try{
           String sql="{call reduceqty(?,?,?)}";
           CallableStatement st=con.prepareCall(sql);
           st.setDouble(1,sl.getPQuantity());
           st.setString(2,sl.getPName());
           st.setString(3, sl.getPDescription());
           st.executeQuery();
           con.close();
            return "product modified succesfully";
       }catch(Exception ex){
           return ex.getMessage();
       }
    }
    
    //show the sales transactions 
  
    public static ObservableList<Sales> showSoldList(){
            Connection con=ConCreation.connect();
            ObservableList<Sales> list=FXCollections.observableArrayList();
            Sales sl=null;
            try{
                 String sql="{call showSelesList(?)}";
                  CallableStatement st=con.prepareCall(sql);
                  st.registerOutParameter(1, OracleTypes.CURSOR);
                  st.executeQuery();
                  ResultSet rs=(ResultSet) st.getObject(1);
                  while(rs.next()){
                     sl=new Sales();
                     emp=new Employee();
                      sl.setCode(rs.getInt(1));
                      sl.setSoldDate(rs.getDate(2));
                      emp.setFirstName(rs.getString(3));
                      emp.setLastName(rs.getString(4));
                      sl.setEmployee(emp.getFirstName()+" "+emp.getLastName());
                      sl.setPName(rs.getString(5));
                      sl.setPDescription(rs.getString(6));
                      sl.setPQuantity(rs.getDouble(7));
                      sl.setPUType(rs.getString(8));
                      sl.setPriceUnit(rs.getDouble(9));
                      sl.setTotalPrice(rs.getDouble(10));
                      sl.setAmount(rs.getDouble(12));
                      sl.setVat(rs.getDouble(11));
                      sl.setSquanitySold(sl.getPUType()+" "+NumberFormat.getInstance(Locale.US).format(sl.getPQuantity()));
                      sl.setSnetPrice("RWf "+NumberFormat.getInstance(Locale.US).format(sl.getTotalPrice()));
                      sl.setSvat("RWF "+NumberFormat.getInstance(Locale.US).format(sl.getVat()));
                        sl.setSamount("RWF "+NumberFormat.getInstance(Locale.US).format(sl.getAmount()));
                      list.add(sl);
                  }
            }catch(Exception ex){
                  System.out.print(ex.getMessage()+"test");
            }
            return list;
            }
    
    ///search transaction by date recorded
    public static  ObservableList<Sales> searchByDate(Date dt){
        Connection con=ConCreation.connect();
          ObservableList<Sales> list=FXCollections.observableArrayList();
        Sales sl=null;
        try{
            String sql="{call searchbyTDATE(?,?)}";
            CallableStatement st=con.prepareCall(sql);
            st.registerOutParameter(1, OracleTypes.CURSOR);
            st.setDate(2,dt);
            st.executeQuery();
            ResultSet rs=(ResultSet) st.getObject(1);
              while(rs.next()){
                     emp=new Employee();
                     sl=new Sales();
                      sl.setCode(rs.getInt(1));
                      sl.setSoldDate(rs.getDate(2));
                      emp.setFirstName(rs.getString(3));
                      emp.setLastName(rs.getString(4));
                      sl.setEmployee(emp.getFirstName()+" "+emp.getLastName());
                      sl.setPName(rs.getString(5));
                      sl.setPDescription(rs.getString(6));
                      sl.setPQuantity(rs.getDouble(7));
                      sl.setPUType(rs.getString(8));
                      sl.setPriceUnit(rs.getDouble(9));
                      sl.setTotalPrice(rs.getDouble(10));
                      sl.setAmount(rs.getDouble(12));
                      sl.setVat(rs.getDouble(11));
                      sl.setSquanitySold(sl.getPUType()+" "+NumberFormat.getInstance(Locale.US).format(sl.getPQuantity()));
                      sl.setSnetPrice("RWf "+NumberFormat.getInstance(Locale.US).format(sl.getTotalPrice()));
                      sl.setSvat("RWF "+NumberFormat.getInstance(Locale.US).format(sl.getVat()));
                        sl.setSamount("RWF "+NumberFormat.getInstance(Locale.US).format(sl.getAmount()));
                      list.add(sl);
                  }
        }catch(Exception ex){
            System.out.print(ex.getMessage());
        }
        return list;
    }
  //search transaction by employee id;  
  public static ObservableList<Sales> searchT(int id){
            Connection con=ConCreation.connect();
           ObservableList<Sales> list=FXCollections.observableArrayList();
        Sales sl=null;
        try{
            String sql="{call transbyempId(?,?)}";
            CallableStatement st=con.prepareCall(sql);
            st.registerOutParameter(1, OracleTypes.CURSOR);
            st.setInt(2,id);
            st.executeQuery();
            ResultSet rs=(ResultSet) st.getObject(1);
            System.out.println("done");
              while(rs.next()){
                      emp=new Employee();
                      sl=new Sales();
                      sl.setCode(rs.getInt(1));
                      sl.setSoldDate(rs.getDate(2));
                      emp.setFirstName(rs.getString(3));
                      emp.setLastName(rs.getString(4));
                      sl.setEmployee(emp.getFirstName()+" "+emp.getLastName());
                      sl.setPName(rs.getString(5));
                      sl.setPDescription(rs.getString(6));
                      sl.setPQuantity(rs.getDouble(7));
                      sl.setPUType(rs.getString(8));
                      sl.setPriceUnit(rs.getDouble(9));
                      sl.setTotalPrice(rs.getDouble(10));
                      sl.setAmount(rs.getDouble(12));
                      sl.setVat(rs.getDouble(11));
                      sl.setSquanitySold(sl.getPUType()+" "+NumberFormat.getInstance(Locale.US).format(sl.getPQuantity()));
                      sl.setSnetPrice("RWf "+NumberFormat.getInstance(Locale.US).format(sl.getTotalPrice()));
                      sl.setSvat("RWF "+NumberFormat.getInstance(Locale.US).format(sl.getVat()));
                        sl.setSamount("RWF "+NumberFormat.getInstance(Locale.US).format(sl.getAmount()));
                      list.add(sl);
                  }
        }catch(Exception ex){
            System.out.print(ex.getMessage());
        }
        return list;
   }
    //search transaction by product name
          public static ObservableList<Sales> searchTbyProduct(String name){
            Connection con=ConCreation.connect();
          ObservableList<Sales> list=FXCollections.observableArrayList();
        Sales sl=null;
        try{
            String sql="{call transbypName(?,?)}";
            CallableStatement st=con.prepareCall(sql);
            st.registerOutParameter(1, OracleTypes.CURSOR);
            st.setString(2,name);
            st.executeQuery();
            ResultSet rs=(ResultSet) st.getObject(1);
              while(rs.next()){
                      emp=new Employee();
                       sl=new Sales();
                      sl.setCode(rs.getInt(1));
                      sl.setSoldDate(rs.getDate(2));
                      emp.setFirstName(rs.getString(3));
                      emp.setLastName(rs.getString(4));
                      sl.setEmployee(emp.getFirstName()+" "+emp.getLastName());
                      sl.setPName(rs.getString(5));
                      sl.setPDescription(rs.getString(6));
                      sl.setPQuantity(rs.getDouble(7));
                      sl.setPUType(rs.getString(8));
                      sl.setPriceUnit(rs.getDouble(9));
                      sl.setTotalPrice(rs.getDouble(10));
                      sl.setAmount(rs.getDouble(12));
                      sl.setVat(rs.getDouble(11));
                      sl.setSquanitySold(sl.getPUType()+" "+NumberFormat.getInstance(Locale.US).format(sl.getPQuantity()));
                      sl.setSnetPrice("RWf "+NumberFormat.getInstance(Locale.US).format(sl.getTotalPrice()));
                      sl.setSvat("RWF "+NumberFormat.getInstance(Locale.US).format(sl.getVat()));
                        sl.setSamount("RWF "+NumberFormat.getInstance(Locale.US).format(sl.getAmount()));
                      list.add(sl);
                  }
        }catch(Exception ex){
            System.out.print(ex.getMessage());
        }
        return list;
   }
   //record and increase cash received to day
   public int recordCash(Sales sl){
       int rowAf=0;
     Connection con=ConCreation.connect();
     try{
         String sql="{call recordcash(?,?,?)}";
         CallableStatement st=con.prepareCall(sql);
         st.registerOutParameter(1, OracleTypes.INTEGER);
         st.setDate(2, sl.getSoldDate());
         st.setDouble(3, sl.getTotalPrice());
         st.executeQuery();
         rowAf=st.getInt(1);
         System.out.println("done");
     }catch(Exception ex){
         System.out.print(ex.getMessage());
     }
     return rowAf;
   }
   
   //function to show the cash received
   public static ObservableList<Sales> showCash(){
   Connection con=ConCreation.connect();
   ObservableList<Sales> list=FXCollections.observableArrayList();
   Sales sl=null;
   try{
       String sql="{call showCash(?)}";
       CallableStatement st=con.prepareCall(sql);
       st.registerOutParameter(1, OracleTypes.CURSOR);
       st.executeQuery();
       ResultSet rs=(ResultSet) st.getObject(1);
       while(rs.next()){
           sl=new Sales();
           sl.setSoldDate(rs.getDate(1));
           sl.setTotalPrice(rs.getDouble(2));
           System.out.println(sl.getSoldDate());
           sl.setSamount("RWF "+NumberFormat.getInstance(Locale.US).format(sl.getTotalPrice()));
           list.add(sl);
       }
   }catch(Exception ex){
       System.out.println(ex.getMessage());
   }
   return list;
   }
   
   
   //function to show the cash received by date
   public static  ObservableList<Sales> showCashByDate(Date date){
   Connection con=ConCreation.connect();
   ObservableList<Sales> list=FXCollections.observableArrayList();
   Sales sl=null;
   try{
       String sql="{call showcashbydate(?,?)}";
       CallableStatement st=con.prepareCall(sql);
       st.registerOutParameter(1, OracleTypes.CURSOR);
       st.setDate(2,date);
       st.executeQuery();
       ResultSet rs=(ResultSet) st.getObject(1);
       while(rs.next()){
           sl=new Sales();
           sl.setSoldDate(rs.getDate(1));
           sl.setTotalPrice(rs.getDouble(2));
            sl.setSamount("RWF "+NumberFormat.getInstance(Locale.US).format(sl.getTotalPrice()));
           list.add(sl);
       }
   }catch(Exception ex){
       System.out.println(ex.getMessage());
   }
   return list;
   }
   
 //function to set the tax  
  public String createTax(Sales s){
       Connection con=ConCreation.connect();
       try{
         String sql="insert into vat (vat_amaunt) values(?)";
         PreparedStatement st=con.prepareStatement(sql);
         st.setDouble(1, s.getVat());
         st.execute();
         con.close();
         return "VAT is set succesfully";
    }catch(Exception ex){
        return "VAT not change do to "+ex.getMessage();
    }
   }
   //function to change the tax
  public String updateTax(Sales s){
   Connection con=ConCreation.connect();
   try{
       String sql="update vat set vat_amaunt=?";
       PreparedStatement st=con.prepareStatement(sql);
       st.setDouble(1,s.getVat());
       st.execute();
       return "Vat is changed successfully";
   }catch(Exception ex){
       return "VAT not set do to "+ex.getMessage();
   }
  }
   public static List<Sales> showTax(){
   Connection con=ConCreation.connect();
   List<Sales> list=new ArrayList();
   Sales s=null;
   double vat=0;
   try{
       String sql="select * from vat";
       PreparedStatement st=con.prepareStatement(sql);
       ResultSet rs=st.executeQuery();
       while(rs.next()){
           s=new Sales();
           s.setVat(rs.getDouble(2));
           list.add(s);
       }
       System.out.print("Tax retrieved");
   }catch(Exception ex){
       System.out.print(ex.getMessage());
   }
   return list;
   }
}
