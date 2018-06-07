/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domain;

import java.sql.Date;
import java.sql.Timestamp;

/**
 *
 * @author NDAHIGEZE
 */
public class Product {
    private int code;
    private Date rDate;
    private String pName;
    private String pUType;
    private String pDescription;
    private double pQuantity;
    private double pCostUnit;
    private double pTCost;
    private double totalPrice;
    private double pPriceUnit;
    private String unityTypeQuantity;
    private String squantity;
    private String spriceUnity;
    private String scostUnity;
     private String sold; 
    //Mutators
    
   public void setSold(String sold){
     this.sold=sold;
    }
    
    public void setCode(int code){
        this.code=code;
    }
    public void setPName(String pName){
    this.pName=pName;
    }
    public void setRecordDate(Date rDate){
     this.rDate=rDate;
    }
    public void setPDescription(String pDescription){
     this.pDescription=pDescription;
    }
    public void setPUType(String pUtype){
    this.pUType=pUtype;
    }
    public void setPQuantity(Double pQuantity){
    this.pQuantity=pQuantity;
    }
    public void setCostUnit(Double costUnit){
    this.pCostUnit=costUnit;
    }
    public void setTotalCost(Double pTCost){
    this.pTCost=pTCost;
    }
    public void setPriceUnit(Double priceUnit){
    this.pPriceUnit=priceUnit;
    }
    public void setTotalPrice(Double totalPrice){
        this.totalPrice=totalPrice;
    }
    
 //Accessors class   
    public int getCode(){
        return code;
    }
    public String getPName(){
    return pName;
    }
    public Date getRecordDate(){
     return rDate;
    }
    public String getPDescription(){
     return pDescription;
    }
    public String getPUType(){
     return pUType;
    }
    public double getPQuantity(){
     return pQuantity;
    }
    public double getCostUnit(){
     return pCostUnit;
    }
    public double getTotalCost(){
      return pTCost;
    }
    public double getPriceUnit(){
    return pPriceUnit;
    }
    public double getTotalPrice(){
        return totalPrice ;
    }
     
      public String getSold(){
      return sold;
    }
//strings 
    /**
     * @return the unityTypeQuantity
     */
    public String getUnityTypeQuantity() {
        return unityTypeQuantity;
    }

    /**
     * @param unityTypeQuantity the unityTypeQuantity to set
     */
    public void setUnityTypeQuantity(String unityTypeQuantity) {
        this.unityTypeQuantity = unityTypeQuantity;
    }
    /**
     * @return the spriceUnity
     */
    public String getSpriceUnity() {
        return spriceUnity;
    }

    /**
     * @param spriceUnity the spriceUnity to set
     */
    public void setSpriceUnity(String spriceUnity) {
        this.spriceUnity = spriceUnity;
    }

    /**
     * @return the scostUnity
     */
    public String getScostUnity() {
        return scostUnity;
    }

    /**
     * @param scostUnity the scostUnity to set
     */
    public void setScostUnity(String scostUnity) {
        this.scostUnity = scostUnity;
    }
}

