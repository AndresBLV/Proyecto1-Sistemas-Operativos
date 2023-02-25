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
public class ProdIntro extends Thread{
    
    public boolean stop;
    String Treadname;
    int tipo;
    JLabel area1;
    Semaphore sem1;
    Semaphore intro;
    long dia;
    Semaphore Int;
    JLabel area13;



    public ProdIntro( int tipo,JLabel area1,Semaphore sem1, Semaphore intro,long dia,Semaphore Int,JLabel tiempo) {
        this.stop = true;
        this.area1 = area1;
        this.tipo=tipo;
        this.sem1 = sem1;
        this.intro = intro;
        this.dia=dia;
        this.Int = Int;
        this.area13=tiempo;
        
    }
}
    
