/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package confClass;
import java.util.Formatter;
import java.util.Locale;

/**
 *
 * @author NDAHIGEZE
 */
public class SuperMarket {

    /**
     * @param args the command line arguments
     */
  
    public static void main(String[] args)throws Exception {
        double sb=10000;
        double st=1200;
        Formatter formatter = new Formatter(Locale.US);
     String n=formatter.format( " %,.2f", sb).toString();
     String n2=formatter.format("%,.2f", st).toString();
     System.out.println(n+" "+n2);
    }
    
}
