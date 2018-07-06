/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package confClass;

import java.sql.Date;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 *
 * @author NDAHIGEZE
 */
public class DateConverter {
    private Date dt;
    private String stringDt;
    public Date dateNow(){
         LocalDate localDate=LocalDate.now();
          dt=Date.valueOf(localDate);
         return dt;
    }
    
    public Date stringToDate(String stringDt){
        Date dte=null;
        try{
              SimpleDateFormat format1 = new SimpleDateFormat("dd-MM-yyyy");
             java.util.Date date=format1.parse(stringDt);           
             dte=new Date(date.getTime());  
        }catch(Exception ex){
            ex.getMessage();
        }
     return dte;      
}
    public String dateToString(Date dt){
         SimpleDateFormat format1 = new SimpleDateFormat("dd/MM/yyyy");  
       stringDt=format1.format(dt);
        return stringDt;
    }
    
    public Timestamp dateTimeNow(){
     LocalDateTime localTime=LocalDateTime.now();
    Timestamp ts=Timestamp.valueOf(localTime);   
    return ts;
    }
    public Date convertLocaDate(LocalDate dt){
        Date sqlDate=Date.valueOf(dt);
        return sqlDate;
    }
}