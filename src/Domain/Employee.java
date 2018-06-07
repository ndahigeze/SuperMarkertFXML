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
public class Employee {
    private int id;
    private String firstName;
    private String lastName;
    private String  email;
    private String location;
    private int suspend;
    private String post;
    private String password;
    private String cPassword;
    private String userName;
    private Date hireDate;
    private Timestamp dateTime;
    private int privillage;
    private int logged;
    private String actionS;
    private int actionI;
    //Mutator
    public void setId(int id){
       this.id=id;
    }
    public void setFirstName(String firstName){
      this.firstName=firstName;
    }
    public void setLastName(String lastName){
      this.lastName=lastName;
    }
    public void setEmail(String email){
        this.email=email;
    }
    public void setLocation(String location){
      this.location=location;
    }
    public void setPost(String post){
      this.post=post;
    }
    public void setPassword(String password){
      this.password=password;
    }
    public void setCpassword(String cPassword){
      this.cPassword=cPassword;
    }
    public void setUserName(String userName){
        this.userName=userName;
    }
    public void setHireDate(Date hireDate){
      this.hireDate=hireDate;
    }
    public void setActionS(String actionS){
      this.actionS=actionS;
    }
    public void setActionI(int actionI){
      this.actionI=actionI;
     }
    //accessor
   ///=========================================================
    public int getId(){
      return id;
    }
    public String getFirstName(){
      return firstName;
    }
    public String getLastName(){
      return lastName;
    }
     public String getEmail(){
        return email;
    }
    public String getLocation(){
      return location;
    }
    public String getPost(){
      return post;
    }
    public String getPassword(){
      return password;
    }
    public String getCpassword(){
     return cPassword;
    }
    public String getUserName(){
        return userName;
    }
    public Date getHireDate(){
      return hireDate;
    }
    public String getActionS(){
       return actionS;
    }
    public int getActionI(){
       return actionI;
    }

    /**
     * @return the privillage
     */
    public int getPrivillage() {
        return privillage;
    }

    /**
     * @param privillage the privillage to set
     */
    public void setPrivillage(int privillage) {
        this.privillage = privillage;
    }

    /**
     * @return the suspend
     */
    public int getSuspend() {
        return suspend;
    }

    /**
     * @param suspend the suspend to set
     */
    public void setSuspend(int suspend) {
        this.suspend = suspend;
    }

    /**
     * @return the logged
     */
    public int getLogged() {
        return logged;
    }

    /**
     * @param logged the logged to set
     */
    public void setLogged(int logged) {
        this.logged = logged;
    }

}


