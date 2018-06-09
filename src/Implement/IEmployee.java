/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Implement;

import Domain.Employee;
import java.sql.Connection;
import confClass.Action;
import confClass.ConCreation;
import java.sql.CallableStatement;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import oracle.jdbc.OracleTypes;

/**
 *
 * @author NDAHIGEZE
 */
public class IEmployee {
    public String register(Employee e){
         Connection con=ConCreation.connect();
        Action act=new Action();
    try{
        String sql="insert into employee (firstname,lastname,hiredate,location,privillage,post,suspend)values(?,?,?,?,?,?,?)";
        CallableStatement st=con.prepareCall(sql);
        st.setString(1, e.getFirstName());
        st.setString(2, e.getLastName());
        st.setDate(3, e.getHireDate());
        st.setString(4, e.getLocation());
        st.setInt(5, e.getPrivillage());
        st.setString(6, e.getPost());
        st.setInt(7, e.getSuspend());
        st.execute();
      con.close();
        return "Employee is registered successfully";
    }catch(Exception ex){
        return ex.getMessage();
    }
    }
    
    public void CreateAccount(Employee e) {
        Connection con=ConCreation.connect();
   try{
        String sql="update employee set username=?,emailaddress=?,password=? where suspend=0 and id=?";
        PreparedStatement st=con.prepareStatement(sql);
        st.setString(1,e.getUserName());
        st.setString(2,e.getEmail());
        st.setString(3, e.getPassword());
        st.setInt(4,e.getId());
        st.execute();
        con.close();
        System.out.println("Account created successfull click on signin to log into your acount");
    }catch(Exception ex){
        System.out.print(ex.getMessage()+"hello");
    }
    }
    
    
    public static ObservableList< Employee> findAll(){
        Connection con=ConCreation.connect();
        ObservableList<Employee> list=FXCollections.observableArrayList();
         Employee emp=null;
    try{
        String sql="select * from employee where suspend=0";
        CallableStatement st=con.prepareCall(sql);
        ResultSet rs=st.executeQuery();
        while(rs.next()){
            emp=new Employee();
            emp.setId(rs.getInt(1));
            emp.setFirstName(rs.getString(2));
            emp.setLastName(rs.getString(3));
            emp.setLocation(rs.getString(4));
            emp.setEmail(rs.getString(5));
            emp.setUserName(rs.getString(6));
            emp.setHireDate(rs.getDate(7));
            emp.setPost(rs.getString(9));
            list.add(emp);
        }
        con.close();
    }catch(Exception ex){
        System.out.println(   ex.getMessage());
    }
    return list;
    }
    
    
    public static Employee findOne(int id){
       Connection con=ConCreation.connect();
       Employee emp=null;
    try{
        String sql="select * from employee where id=? and privillage=2";
        PreparedStatement st=con.prepareStatement(sql);
        st.setInt(1, id);
        ResultSet rs=st.executeQuery();
        if(rs.next()){
        emp=new Employee();
        emp.setId(rs.getInt(1));
        emp.setFirstName(rs.getString(2));
        emp.setLastName(rs.getString(3));
        emp.setHireDate(rs.getDate(7));
        emp.setLocation(rs.getString(4));
        emp.setEmail(rs.getString(5));
        emp.setUserName(rs.getString(6));
        emp.setPost(rs.getString(9));
        }
        con.close();
    }catch(Exception ex){
       System.out.println(ex.getMessage());
    }
    return emp;
    }
   //Find by  username and password
    
 public static Employee findByUsername(String username,String password){
       Connection con=ConCreation.connect();
    Employee emp=null;
    try{
        String sql="select * from employee where username=? and password=? and privillage=2";
        PreparedStatement st=con.prepareStatement(sql);
        st.setString(1, username);
        st.setString(2, password);
        ResultSet rs=st.executeQuery();
        if(rs.next()){
                emp=new Employee();
                emp.setId(rs.getInt(1));
                emp.setFirstName(rs.getString(2));
                emp.setLastName(rs.getString(3));
                emp.setUserName(rs.getString(4));
        }
        con.close();
    }catch(Exception ex){
       System.out.println(ex.getMessage());
    }
    return emp;
    }
 //mark employee as active when logged in;
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
 
 //find  to check same username
 public static Employee findByUsernameCheck(String username){
       Connection con=ConCreation.connect();
       Employee emp=null;
    try{
        String sql="select * from employee where username=? ";
        CallableStatement st=con.prepareCall(sql);
        st.setString(1, username); 
        ResultSet rs=st.executeQuery();
        if(rs.next()){
        emp=new Employee();
        emp.setId(rs.getInt(1));
        emp.setFirstName(rs.getString(2));
        emp.setLastName(rs.getString(3));
        emp.setUserName(rs.getString(4));
        }
        con.close();
    }catch(Exception ex){
       System.out.print(ex.getMessage());
    }
    return emp;
    }
    
    //find employee by date hire
     public static ObservableList<Employee> findByDateHired(Date dt){
        Connection con=ConCreation.connect();
        Employee emp=null;
        ObservableList<Employee> list=FXCollections.observableArrayList();
             try{
                    String sql="{call searchEmpbyDATE(?,?)}";
                    CallableStatement st=con.prepareCall(sql);
                    st.registerOutParameter(1,OracleTypes.CURSOR );
                    st.setDate(2, dt);
                    st.executeQuery();
                    ResultSet rs=(ResultSet)st.getObject(1);
                        while(rs.next()){
                                emp=new Employee();
                               emp.setId(rs.getInt(1));
                                emp.setFirstName(rs.getString(2));
                                emp.setLastName(rs.getString(3));
                                emp.setHireDate(rs.getDate(4));
                                emp.setLocation(rs.getString(5));
                                emp.setEmail(rs.getString(6));
                                emp.setUserName(rs.getString(7));
                                emp.setPost(rs.getString(8));
                                list.add(emp);
                        }
                   con.close();
                    }catch(Exception ex){
                       System.out.println(ex.getMessage());
                    }
             return list;
     }
   //
    
    public String update(Employee emp){
        Connection con=ConCreation.connect();
        try{
         String sql="{call modifyemp(?,?,?,?,?,?)}";
         CallableStatement st=con.prepareCall(sql);
         st.setString(1, emp.getFirstName());
         st.setString(2,emp.getLastName());
         st.setString(3, emp.getUserName());
         st.setString(4, emp.getLocation());
         st.setString(5, emp.getPost());
         st.setInt(6, emp.getId());
         st.executeQuery();
         con.close();
         return "Employee modified successfully";
     }catch(Exception ex){
         return ex.getMessage();
     }
    }
    
    public int delete(int id){
        int rowResult=0;
       Connection con=ConCreation.connect();
        try{
           String sql="{call delemp(?,?)}";
           CallableStatement st=con.prepareCall(sql);
           st.setInt(1, id);
           st.registerOutParameter(2, OracleTypes.INTEGER);
           st.executeQuery();
           rowResult=st.getInt(2);
           con.close();
           System.out.print( "deleted");
       }catch(Exception ex){
           System.out.print(ex.getMessage());
       }
        return rowResult;
    }
    
    
}
