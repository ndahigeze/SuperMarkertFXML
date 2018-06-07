/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package confClass;

import Domain.Sequence;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import oracle.jdbc.OracleTypes;

/**
 *
 * @author NDAHIGEZE
 */
public  class  Action{
   static  DateConverter dtg;
   static Sequence seq;
    public String managerAction(String actionS){
         Connection con=ConCreation.connect();
        dtg  =new DateConverter();
        seq=ISequence.actionId();
     try{
         String sql="{call createmanageraction(?,?,?,?)}";
        CallableStatement st=con.prepareCall(sql);
        st.setInt(1, seq.getSeqValue());
        st.setDate(2, dtg.dateNow());
        st.setTimestamp( 3,dtg.dateTimeNow());
        st.setString(4,actionS);
        st.execute();
        con.close();
        return "action recorded";
     }catch(Exception ex){
     return ex.getMessage();
     }
    }
    
    //function to retrieve manager Actions
    public static Action retrieve(){
         Connection con=ConCreation.connect();
        Action act=null; 
       try{
           String sql="{call manaction(?)}";
           CallableStatement st=con.prepareCall(sql);
           st.registerOutParameter(1, OracleTypes.CURSOR);
           st.executeQuery();
           ResultSet rs=(ResultSet) st.getObject(1);
         if(rs.next()){
             act=new Action();
         }
         con.close();
       }catch(Exception ex){
           System.out.print( ex.getMessage());
           
       }
      return act;
    }
   
}