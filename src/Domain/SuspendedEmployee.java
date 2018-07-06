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
public class SuspendedEmployee extends Employee {
       private Date suspendedDate;

    /**
     * @return the suspendedDate
     */
    public Date getSuspendedDate() {
        return suspendedDate;
    }

    /**
     * @param suspendedDate the suspendedDate to set
     */
    public void setSuspendedDate(Date suspendedDate) {
        this.suspendedDate = suspendedDate;
    }
}
