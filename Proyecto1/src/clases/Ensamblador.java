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
public class Ensamblador extends Thread{
   
    public boolean stop;
    String Treadname;
    int tipo;
    
    JLabel area1;
    JLabel area2;
    JLabel area3;
    JLabel area4;
    JLabel areaPT;
    JLabel area5;
    JLabel area6;
    JLabel area13;
    
    public Semaphore sem1;
    public Semaphore sem2;
    public Semaphore sem3;
    public Semaphore sem4;
    public Semaphore sem5;
    
    Semaphore intro;
    Semaphore creditos;
    Semaphore inicio;
    Semaphore cierre;
    Semaphore plottwist;
    
    long dia;
    boolean procesado = false;
    
    Semaphore colitaE1;
    Semaphore colitaE2;
    Semaphore colitaE3;
    Semaphore colitaE4;
    Semaphore colitaE5;
    
    public Ensamblador(Semaphore mutex5, Semaphore mutex4,Semaphore mutex3,Semaphore mutex2,Semaphore mutex1,long dia,int tipo,Semaphore sem1,Semaphore sem2,Semaphore sem3,Semaphore sem4,Semaphore sem5, JLabel intros,JLabel creditos,JLabel inicios,JLabel cierres,JLabel plottwists,JLabel AreaE,JLabel AreaT,Semaphore intro,Semaphore credito,Semaphore inicio,Semaphore cierre,Semaphore plottwist,JLabel tiempo ) {
        this.stop = true;
        this.dia = dia;
        this.tipo =tipo;
        this.sem1 = sem1;
        this.sem2 = sem2;
        this.sem3 = sem3;
        this.sem4 = sem4;
        this.sem5 = sem5;
        this.area1 = inicios;
        this.area2 = creditos;
        this.area3 = inicios;
        this.area4 = cierres;
        this.areaPT = plottwists;
        this.area5 = AreaE;
        this.area6 = AreaT;
        this.intro = intro;
        this.creditos = credito;
        this.inicio = inicio;
        this.cierre = cierre;
        this.plottwist = plottwist;
        this.colitaE1 = mutex1;
        this.colitaE2 = mutex2;
        this.colitaE3 = mutex3;
        this.colitaE4 = mutex4;
        this.colitaE5 = mutex5;
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
