/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;
import static java.lang.Thread.sleep;
import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;

/**
 *
 * @author andre
 */
public class ProdCierre extends Thread{
 
    public boolean stop;
    String Treadname;
    int tipo;
    JLabel area4;
    Semaphore sem4;
    Semaphore cierre;
    long dia;
    Semaphore Cie;
    JLabel area13;



    public ProdCierre(  JLabel area4,int tipo,Semaphore sem4,Semaphore cierre,long dia,Semaphore Cie,JLabel tiempo) {
        this.stop = true;
        this.area4 = area4;
        this.tipo=tipo;
        this.sem4 = sem4;
        this.cierre = cierre;
        this.dia=dia;
        this.Cie = Cie;
        this.area13=tiempo;
        
    }
    
    
}
