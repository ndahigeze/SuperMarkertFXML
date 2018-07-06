/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domain;

import java.sql.Date;

/**
 *
 * @author NDAHIGEZE
 */
public class Sales extends Product {
    private String squanitySold;
    private String svat;
    private String samount;
    private String snetPrice;
    private double amount;
    private double vat;
    Date soldDate;
    private String emp;
    public void setSoldDate(Date soldDate){
    this.soldDate=soldDate;
    }
    
    public void setEmployee(String emp){
    this.emp=emp;
    }
    public void setVat(double vat){
    this.vat=vat;
    }
    public Date getSoldDate(){
        return soldDate;
    }
    public String getEmployee(){
    return emp;
    }
    public double getVat(){
     return vat;
    }

    /**
     * @return the squanitySold
     */
    public String getSquanitySold() {
        return squanitySold;
    }

    /**
     * @param squanitySold the squanitySold to set
     */
    public void setSquanitySold(String squanitySold) {
        this.squanitySold = squanitySold;
    }

    /**
     * @return the svat
     */
    public String getSvat() {
        return svat;
    }

    /**
     * @param svat the svat to set
     */
    public void setSvat(String svat) {
        this.svat = svat;
    }

    /**
     * @return the samount
     */
    public String getSamount() {
        return samount;
    }

    /**
     * @param samount the samount to set
     */
    public void setSamount(String samount) {
        this.samount = samount;
    }

    /**
     * @return the snetPrice
     */
    public String getSnetPrice() {
        return snetPrice;
    }

    /**
     * @param snetPrice the snetPrice to set
     */
    public void setSnetPrice(String snetPrice) {
        this.snetPrice = snetPrice;
    }

    /**
     * @return the amount
     */
    public double getAmount() {
        return amount;
    }

    /**
     * @param amount the amount to set
     */
    public void setAmount(double amount) {
        this.amount = amount;
    }
    
    
}
