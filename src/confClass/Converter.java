/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package confClass;

import java.security.MessageDigest;

/**
 *
 * @author NDAHIGEZE
 */
public class Converter {
     private int iValue;
     private double dValue;
    public int getIValue(String value){
        try{
            iValue=Integer.parseInt(value);
        }catch(NumberFormatException ex){
            System.out.println(ex.getMessage());
        }
    return iValue;
    }
    public double getDValue(String value){
           try{
            dValue=Double.parseDouble(value);
        }catch(NumberFormatException ex){
            System.out.println(ex.getMessage());
        }
        return dValue;
    }
    //password Encryption 
    public String md5(String c){
       try{
           MessageDigest dg= MessageDigest.getInstance("MD5");
           dg.update((c).getBytes("UTF8"));
           String str=new String(dg.digest());
           return str;
       }catch(Exception ex){
           return ex.getMessage();
       }
    }
    
}
