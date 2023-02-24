/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import static java.lang.Thread.sleep;
import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
/**
 *
 * @author sebas
 */
public class ProcesosE1 extends Thread{
    
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
    JLabel area7;
    JLabel area8;
    JLabel area9;
    JLabel area10;
    JLabel area11;
    JLabel area12;
    JLabel area13;
    
    Semaphore sem1;
    Semaphore sem2;
    Semaphore sem3;
    Semaphore sem4;
    Semaphore sem5;
    
    Semaphore intro;
    Semaphore creditos;
    Semaphore inicio;
    Semaphore cierre;
    Semaphore plottwist;
    
    long dia;
    Semaphore Int;
    Semaphore Cre;
    Semaphore Ini;
    Semaphore Cie;
    Semaphore PT;
    
    boolean procesado = false;
    
    Semaphore colitaE1;
    Semaphore colitaE2;
    Semaphore colitaE3;
    Semaphore colitaE4;
    Semaphore colitaE5;
    
    
    
    // Produccion Intro
    public ProcesosE1(int tipo,JLabel area1,Semaphore sem1, Semaphore intro,long dia,Semaphore Int,JLabel tiempo ){
        this.stop = true;
        this.area1 = area1;
        this.tipo=tipo;
        this.sem1 = sem1;
        this.intro = intro;
        this.dia=dia;
        this.Int = Int;
        this.area13=tiempo;
        
    }
    
    // Produccion Creditos
    public ProcesosE1(int tipo,Semaphore sem2,Semaphore creditos,JLabel area2,long dia,Semaphore Cre,JLabel tiempo ){
        this.stop = true;
        this.area2 = area2;
        this.tipo=tipo;
        this.sem2 = sem2;
        this.creditos = creditos;
        this.dia=dia;
        this.Cre=Cre;
        this.area13=tiempo;
    }
    
    // Produccion Inicio
    public ProcesosE1(int tipo,Semaphore sem3,JLabel area3,Semaphore inicio,long dia,Semaphore Ini,JLabel tiempo ){
       this.stop = true;
       this.area3 = area3;
       this.tipo=tipo;
       this.sem3 = sem3;
       this.inicio = inicio;
       this.dia=dia;
       this.Ini=Ini;
       this.area13=tiempo;
    }
     
    // Produccion Cierre
    public ProcesosE1(JLabel area4,int tipo,Semaphore sem4,Semaphore cierre,long dia,Semaphore Cie,JLabel tiempo ){
       this.stop = true;
       this.area4 = area4;
       this.tipo=tipo;
       this.sem4 = sem4;
       this.cierre = cierre;
       this.dia=dia;
       this.Cie=Cie;
       this.area13=tiempo;
    }
     
    // Produccion Plot Twist
    public ProcesosE1(int tipo,Semaphore sem5,Semaphore plottwist,long dia,Semaphore PT,JLabel tiempo,JLabel areaPT ){
       this.stop = true;
       this.areaPT = areaPT;
       this.tipo=tipo;
       this.sem5 = sem5;
       this.plottwist = plottwist;
       this.dia=dia;
       this.PT=PT;
       this.area13=tiempo;
    }
     
    public ProcesosE1(JLabel intro,JLabel creditos,JLabel inicio,JLabel cierre,JLabel plottwist, JLabel intro1,JLabel creditos2,JLabel inicio3,JLabel cierre4,JLabel plottwist5,JLabel ensamblador6,JLabel t7,int tipo,long dia,JLabel pm8,JLabel director9,JLabel tiempo ){
        this.stop = true;
        this.area1 = intro;
        this.area2 = creditos;
        this.area3 = inicio;
        this.area4 = cierre;
        this.areaPT = plottwist;
        this.area5 = intro1;
        this.area6 = creditos2;
        this.area7= inicio3;
        this.area8 = cierre4;
        this.area9 = ensamblador6;
        this.area10 = t7;
        this.tipo = tipo;
        this.dia = dia;
        this.area11 = pm8;
        this.area12=director9;
        this.area13=tiempo;
    }
    
    public ProcesosE1(Semaphore mutex4,Semaphore mutex3,Semaphore mutex2,Semaphore mutex1,long dia,int tipo,Semaphore sem1,Semaphore sem2,Semaphore sem3,Semaphore sem4,JLabel intros,JLabel creditos,JLabel inicios,JLabel cierres,JLabel plottwists,JLabel AreaE,JLabel AreaT,Semaphore intro,Semaphore credito,Semaphore inicio,Semaphore cierre,Semaphore plottwist,JLabel tiempo ){
        this.stop = true;
        this.dia = dia;
        this.tipo =tipo;
        this.sem1 = sem1;
        this.sem2 = sem2;
        this.sem3 = sem3;
        this.sem4 = sem4;
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
