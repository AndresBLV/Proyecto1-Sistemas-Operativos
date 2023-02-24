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
public class ProdCre extends Thread{
    
    boolean stop;
    String Treadname;
    int tipo;
    JLabel area2;
    Semaphore sem2;
    Semaphore creditos;
    long dia;
    Semaphore Cre;
    JLabel area13;

    public ProdCre( int tipo,Semaphore sem2,Semaphore creditos,JLabel area2,long dia,Semaphore Cre,JLabel tiempo) {
        this.stop = true;
        this.area2 = area2;
        this.tipo=tipo;
        this.sem2 = sem2;
        this.creditos = creditos;
        this.dia=dia;
        this.Cre=Cre;
        this.area13=tiempo;
    }
    public void StopToggle(){
        this.stop=!this.stop;
    }
    
    @Override
    public void run(){
        
    }
    
    synchronized void cuenta() throws InterruptedException{
        
    }
    
}
